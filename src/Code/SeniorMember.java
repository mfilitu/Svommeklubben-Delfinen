package Code;

public class SeniorMember extends ActiveMember {

    public SeniorMember(String name, int age) {
        super(name, age, age >= 60 ? 1600 * 0.75 : 1600);

    }

}