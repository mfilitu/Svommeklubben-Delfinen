public class ActiveMember extends Member {
    Subscriptions subscription;
    public ActiveMember(String name, int age, boolean status, Subscriptions subscription) {
        super(name, age);
        this.subscription=subscription;
    }
    public Subscriptions getSubscription(){
        return subscription;
    }
}
