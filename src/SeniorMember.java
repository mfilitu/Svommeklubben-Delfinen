public class SeniorMember extends ActiveMember {
    private double fee = 1600;

    public SeniorMember(String name, int age) {
        super(name, age);
        if (age >= 60) {
            this.fee = fee * 0.75;
        }
    }
    public double getFee(){
        return fee;
    }
}


