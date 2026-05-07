public class JuniorMember extends ActiveMember {
    private final double fee;

    public JuniorMember(String name, int age) {
        super(name, age);
        this.fee = 1000;

    }

    public double getFee() {
        return fee;
    }
}
