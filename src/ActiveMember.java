public class ActiveMember extends Member {
    Subscription subscription;

    public ActiveMember(String name, int age) {
        super(name, age);
        this.subscription=subscription;
    }
    
    public Subscription getSubscription(){
        return subscription;
    }

}
