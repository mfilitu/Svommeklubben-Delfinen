public class Main {
    public static void main(String[] args) {
        Register register = new Register();
        ActiveMember bo = new SeniorMember("Bo", 17);
        ActiveMember bob = new ActiveMember("Bob", 1);
        PassiveMember bobby = new PassiveMember("Bobby", 55);


        register.addMember(bo);
        register.addMember(bob);
        register.addMember(bobby);
        System.out.println(bo.getFee());
        //System.out.println(bo.toString());
        //System.out.println(bob.toString());

      //  System.out.println(register);




    }
}
