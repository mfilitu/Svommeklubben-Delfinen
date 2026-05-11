package Code;


public class Main {
    public static void main(String[] args) {
        Register register = new Register();
        ActiveMember bo = new SeniorMember("Bo", 17);
        ActiveMember bob = new JuniorMember("Bob", 1);
        PassiveMember bobby = new PassiveMember("Bobby", 55);



        register.addMember(bob);
        register.addMember(bobby);
        System.out.println(bo.getFee());


        Result bo_res = new Result(bo, SwimmingDiscipline.BackCrawl, 1000);

        ResultList list = new ResultList();

        //list.addResult


    }
}