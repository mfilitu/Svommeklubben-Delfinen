public class PassiveMember extends Member {
    Subscriptions subscription;
    private boolean status = false;
    public PassiveMember(String name, int age, boolean status, Subscriptions subscription) {
        super(name, age);
        this.subscription=subscription;
    }
    public Subscriptions getSubscription(){
        return subscription;
    }
}
