package Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tournament {
    private String name;
    private String date;
    private String time;
    private List<Member> competitors;
    private List<ResultList> results;
    private SwimmingDiscipline sd;
    private ResultList tourResult;

    public Tournament(String name, String date, String time, SwimmingDiscipline sd) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.competitors = new ArrayList<>();
        this.sd = sd;
        this.tourResult = new ResultList();
    }

    public void addCompetitor(Member competitor) {
        competitors.add(competitor);
    }

    public void addResult(String result) {
        //results.add(result);
    }

    public void addTimes(){
        Scanner scanner = new Scanner(System.in);
        for (Member member : competitors){
            System.out.println(member.getName());
            int time = scanner.nextInt();
            Result result = new Result(member, sd, time);
            tourResult.addResult(result);
        }
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public List<Member> getCompetitors() {
        return competitors;
    }

    public List<ResultList> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "Tournament{" + "name: " + name + '\'' + ", date: " + date + '\'' + ", time: " + time + '\'' + ", competitors: " + competitors + ", results: " + results + '}';
    }
}
