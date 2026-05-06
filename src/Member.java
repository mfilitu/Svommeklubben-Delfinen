public class Member {
    private final String name;
    private final int age;
    private boolean status = true;

    public Member(String name, int age, boolean status){
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public boolean isSeniorMember(){
        return age >= 18;
    }

    public boolean isJuniorMember(){
        return age < 18;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public boolean getStatus(){
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Navn: %s\nAlder: %s\nStatus: %s", name, age, status);
    }
}
