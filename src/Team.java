import java.util.ArrayList;

public class Team {

    private String teamName;
    private ArrayList<ActiveMember> members;

    public Team(String name) {
        this.teamName = name;
        members = new ArrayList<>();
    }

    public void addToTeam(ActiveMember member) {
            members.add(member);
    }

    public String toString() {
        return String.format("Navn: %s\nmembers: %s", teamName, members);
    }

}