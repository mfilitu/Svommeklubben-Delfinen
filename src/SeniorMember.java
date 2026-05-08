public class SeniorMember extends ActiveMember {
    private double fee = 1600;
    private double account = 0;

    public SeniorMember(String name, int age) {
        super(name, age);
        if (age >= 60) {
            this.fee = fee * 0.75;
        }
        this.account = -fee;
    }
    public double getFee() {
        return fee;
    }
    public void pay() {
        account += fee;
    }

    public boolean ispaid() {
        if (account > 0) {
            return true;
        } else {
            return false;
        }
    }
    public void addFee(){
        account -= fee;
    }
}


