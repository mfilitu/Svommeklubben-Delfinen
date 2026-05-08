package Code;

public class SeniorMember extends ActiveMember {

    public SeniorMember(String name, int age) {
        super(name, age, 1600);
        if (age >= 60) {
            this.fee = fee * 0.75;
        }
        this.account = -fee;
    }

}