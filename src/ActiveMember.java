public class ActiveMember extends Member {
    private double fee;

    public ActiveMember(String name, int age) {
        super(name, age);
        this.fee = 0;
    }

    public double getFee() {
        return fee;
    }


}
