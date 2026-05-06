public class ActiveMember extends Member {
    double subscription;
    public ActiveMember(String name, int age, boolean status, double subscription) {
        super(name, age, status);
        this.subscription=subscription;
    }
    public double getSubscription(){
        return subscription;
    }
}
