package Code;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Register register = new Register();
        ActiveMember bo = new SeniorMember("Bo", 17);
        ActiveMember bob = new JuniorMember("Bob", 1);
        ActiveMember bobby = new SeniorMember("Bobby", 55);
        ActiveMember iben = new SeniorMember("iben", 55);
        ActiveMember oscar = new SeniorMember("oscar", 55);


        Result bo_res = new Result(bo, SwimmingDiscipline.BackCrawl, 1000);
        Result bob_res = new Result(bob, SwimmingDiscipline.BackCrawl, 2000);
        Result bobby_res = new Result(bobby, SwimmingDiscipline.BackCrawl, 3000);
        Result iben_res = new Result(iben, SwimmingDiscipline.BackCrawl, 4000);
        Result oscar_res = new Result(oscar, SwimmingDiscipline.BackCrawl, 5000);


        ResultList list = new ResultList();

        list.addResult(bo_res);
        list.addResult(bob_res);
        list.addResult(bobby_res);
        list.addResult(iben_res);
        list.addResult(oscar_res);



        for (Result resultLists1 : list.getTopFive(SwimmingDiscipline.BackCrawl)) {
            System.out.println(resultLists1);
        }

        Tournament tournament = new Tournament("Tournament 1", "15/02-2022", "15:50", SwimmingDiscipline.BackCrawl);

        tournament.addCompetitors(list);

        System.out.println(tournament.getCompetitors());
        System.out.println(tournament);

        tournament.addResultTimes();

        System.out.println(tournament.getResults());

    }
}