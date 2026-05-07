public class JuniorMember extends ActiveMember{
    private double fee= 1000;
    public JuniorMember(String name, int age){
        super(name,age);
        if (18 < age){
            this.fee=1000;
        }
    }
    public double getFee(){
        return fee;
    }
}
