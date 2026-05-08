public class Member {
    private final String name;
    private final int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
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


    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", name, age, isJuniorMember(), isSeniorMember());
    }
}