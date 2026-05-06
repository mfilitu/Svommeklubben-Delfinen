public class PassiveMember extends Member {
    private double fee;

    public PassiveMember(String name, int age) {
        super(name, age);
        this.fee = 500;

    }

    public double getFee() {
        return fee;
    }


}
