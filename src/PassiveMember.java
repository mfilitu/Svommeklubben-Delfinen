public class PassiveMember extends Member {
    Subscription subscription;
    public PassiveMember(String name, int age, boolean status, Subscription subscription) {
        super(name, age, status);
        this.subscription=subscription;
    }
    public double getSubscription(){
        return subscription;
    }
}
