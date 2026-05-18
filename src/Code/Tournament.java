package Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tournament {
    private String name;
    private String date;
    private String time;
    private List<Member> competitors;
    private SwimmingDiscipline swimmingDiscipline;
    private ResultList tourResult;

    public Tournament(String name, String date, String time, SwimmingDiscipline swimmingDiscipline) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.competitors = new ArrayList<>();
        this.swimmingDiscipline = swimmingDiscipline;
        this.tourResult = new ResultList();
    }

    public void addCompetitors(ResultList res) {
        List<Result> ListofResults = res.getTopFive(swimmingDiscipline);
        for (Result result : ListofResults) {
            competitors.add(result.getMember());
        }

    }

    public void addResultTimes() {
        Scanner scanner = new Scanner(System.in);
        for (Member member : competitors) {
            System.out.println(member.getName());
            int time = scanner.nextInt();
            Result result = new Result(member, swimmingDiscipline, time);
            tourResult.addResult(result);
        }

    }

    public String getName() {
        return name;
    }

    public void showTournamentInfo() {
        System.out.println("\n------------- STÆVNE INFO -------------");
        System.out.println("Navn: " + name);
        System.out.println("Dato: " + date);
        System.out.println("Tidspunkt: " + time);
        System.out.println("Disciplin: " + swimmingDiscipline);

        System.out.println("\n------------- Deltagere -------------");
        if (!competitors.isEmpty()) {
            for (Member competitor : competitors) {
                System.out.println("Nanv: " + competitor.getName() + " Alder: " + competitor.getAge());
            }
        } else {
            System.out.println("Ingen deltagere endnu.");
        }
    }

    public List<Result> getResults() {
        List<Result> filtered = new ArrayList<>();

        for (Result r : tourResult.getAllResults()) {
            filtered.add(r);
        }
        filtered.sort(new ResultTimeComparator());

        return filtered.subList(0, Math.min(5, filtered.size()));
    }

    public void showResults() {
        List<Result> results = getResults();

        System.out.println("\n---------- RESULTATER ----------");

        if (results.isEmpty()) {
            System.out.println("Ingen resultater endnu.");
        } else {
            int placement = 1;
            for (Result result : results) {
                System.out.printf("%d %s | %s | %s ms\n", placement, result.getMember().getName(), result.getDiscipline(), result.getTime());
                placement++;
            }
        }


    }

    @Override
    public String toString() {
        return "Tournament{" + "name: " + name + '\'' + ", date: " + date + '\'' + ", time: " + time + '\'' + ", competitors: " + competitors + ", results: " + tourResult + '}';
    }
}
