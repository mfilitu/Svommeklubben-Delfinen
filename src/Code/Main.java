package Code;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
       Register register = new Register();
        ActiveMember bo = new SeniorMember("Bo", 17);
        ActiveMember bob = new JuniorMember("Bob", 1);
        PassiveMember bobby = new PassiveMember("Bobby", 55);




        Result bo_res = new Result(bo, SwimmingDiscipline.BackCrawl, 1000);



        ResultList list = new ResultList();

        ArrayList<ResultList> resultLists = new ArrayList<>();
        list.addResult(new Result(bo, SwimmingDiscipline.BackCrawl, 1000));
        list.addResult(new Result(bo, SwimmingDiscipline.BackCrawl, 900));
        list.addResult(new Result(bo, SwimmingDiscipline.BackCrawl, 1100));


        for (Result resultLists1 : list.getTopFive(SwimmingDiscipline.BackCrawl)) {
            System.out.println(resultLists1);
        }






    }
}