package Code;


public class Main {
    public static void main(String[] args) {
        Register register = new Register();
        PaymentStatus paymentStatus = new PaymentStatus(register);
        ActiveMember bo = new SeniorMember("Bo", 17);
        ActiveMember bob = new JuniorMember("Bob", 1);
        PassiveMember bobby = new PassiveMember("Bobby", 55);


        register.addMember(bo);
        register.addMember(bob);
        register.addMember(bobby);

        bo.pay();
        System.out.println(bo.isPaid());
        bob.pay();
        //bobby.pay();
        System.out.println(bo.getFee());

        System.out.println(paymentStatus.getRevenue());
        System.out.println(paymentStatus.getMissingPayment());
        paymentStatus.savePaidToFile();
        paymentStatus.saveUnpaidToFile();



    }
}