public class ActiveMember extends Member {
    Subscriptions subscription;
    public ActiveMember(String name, int age, boolean status, Subscriptions subscription) {
        super(name, age, status);
        this.subscription=subscription;
    }
    public double getSubscription(){
        return subscription;
    }
}
