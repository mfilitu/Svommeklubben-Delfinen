public class JuniorMember extends ActiveMember {
    private final double fee;
    private double account = 0;

    public JuniorMember(String name, int age) {
        super(name, age);
        this.fee = 1000;
        this.account = -fee;
    }

    public double getFee() {
        return fee;
    }

    public void pay() {
        account += fee;
    }

    public double getAccountBalance() {
        return account;
    }

    public boolean isPaid() {
        if (account >= 0) {
            return true;
        } else return false;
    }

    public void addFee() {
        account -= fee;
    }
}


