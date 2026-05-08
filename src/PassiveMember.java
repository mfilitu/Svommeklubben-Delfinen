public class PassiveMember extends Member {
    private double fee;
    private double account = 0;

    public PassiveMember(String name, int age) {
        super(name, age);
        this.fee = 500;
        this.account = -fee;

    }

    public double getFee() {
        return fee;
    }

    public void pay(){
        account += fee;
    }

    public boolean isPaid(){
        if (account > 0){
            return true;
        } else return false;
    }

    public void addFee(){
        account -= fee;

    }

}
