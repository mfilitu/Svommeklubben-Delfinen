package Code;

public class ActiveMember extends Member {
    private double fee;
    private double account = 0;

    public ActiveMember(String name, int age) {
        super(name, age);
        this.fee = 0;
    }

    public double getFee() {
        return fee;
    }

    public void pay(){
        account += fee;
    }

    public double getAccountBalance() {
        return account;
    }

    public boolean isPaid(){
        if (account >= 0){
            return true;
        } else return false;
    }

    public void addFee(){
        account -= fee;
    }

}