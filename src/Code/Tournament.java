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
        List<Result> ListogResults = res.getTopFive(swimmingDiscipline);
        for (Result result : ListogResults){
            competitors.add(result.getMember());
        }

    }

    public void addResultTimes(){
        Scanner scanner = new Scanner(System.in);
        for (Member member : competitors){
            System.out.println(member.getName());
            int time = scanner.nextInt();
            Result result = new Result(member, swimmingDiscipline, time);
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

    public ResultList getResults() {
        return tourResult;
    }

    @Override
    public String toString() {
        return "Tournament{" + "name: " + name + '\'' + ", date: " + date + '\'' + ", time: " + time + '\'' + ", competitors: " + competitors + ", results: " + tourResult + '}';
    }
}
