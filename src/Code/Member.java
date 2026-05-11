package Code;

public class Member {
    private final String name;
    private final int age;
    private double account;
    private double fee;

    public Member(String name, int age, double fee) {
        this.name = name;
        this.age = age;
        this.account = -fee;
        this.fee = fee;
    }

    public boolean isSeniorMember() {
        return age >= 18;
    }

    public boolean isJuniorMember() {
        return age < 18;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getFee() {
        return fee;
    }

    protected void setFee(double fee) {
        this.fee = fee;
    }

    protected double getAccount(){
        return account;
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

    @Override
    public String toString() {
        return String.format("| Navn:%s | Alder: %s | Type %s | Betalt: %s | Saldo: %.2f kr.|",
                name, age, getClass().getSimpleName(), isPaid() ? "Ja" : "Nej",getAccountBalance());
    }
}