public class PassiveMember extends Member {
    private double subscription;
    private boolean status = false;
    public PassiveMember(String name, int age, boolean status, double subscription) {
        super(name, age);
        this.subscription=subscription;
    }
    public double getSubscription(){
        return subscription;
    }
}
