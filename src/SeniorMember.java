public class SeniorMember extends ActiveMember{
    private double fee;
    public SeniorMember(String name, int age){
        super(name, age);
        if (age>=60){
            this.fee=1600*0.25;
        }else this.fee=1600;
    }
}
