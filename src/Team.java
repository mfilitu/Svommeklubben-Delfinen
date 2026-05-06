import java.util.ArrayList;

public class Team {

    private String name;
    private ArrayList<Member> juniorMembers;
    private ArrayList<Member> seniorMembers;

    public Team(String name) {
        this.name = name;
        juniorMembers = new ArrayList<>();
        seniorMembers = new ArrayList<>();
    }

    public void addToTeam(Member member) {
        if (member.getAge() < 18) {
            juniorMembers.add(member);
        } else {
            seniorMembers.add(member);
        }
    }

    public String toString() {
        return String.format("Navn: %s\nJuniorhold: %s\nSeniorhold: %s", name, juniorMembers, seniorMembers);
    }

}


