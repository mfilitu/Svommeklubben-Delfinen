package Code;

import java.util.ArrayList;

public class Team {

    private String teamName;
    private ArrayList<ActiveMember> juniorMembers;
    private ArrayList<ActiveMember> seniorMembers;

    public Team(String name) {
        this.teamName = name;
        juniorMembers = new ArrayList<>();
        seniorMembers = new ArrayList<>();
    }

    public void addToTeam(ActiveMember member) {
        if (member.getAge() < 18) {
            juniorMembers.add(member);
        } else {
            seniorMembers.add(member);
        }
    }

    public String toString() {
        return String.format("Navn: %s\nJuniorhold: %s\nSeniorhold: %s", teamName, juniorMembers, seniorMembers);
    }

}