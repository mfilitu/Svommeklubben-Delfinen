package Code;

import java.util.ArrayList;

public class Team {

    private String teamName;
    private Trainer trainer;


    private ArrayList<ActiveMember> members;

    public Team(String name, Trainer trainer) {
        this.teamName = name;
        this.trainer = trainer;
        members = new ArrayList<>();
    }

    public void addToTeam(ActiveMember member) {
            members.add(member);
    }
    public ArrayList<ActiveMember> getMembers() {
        return members;
    }
    public Trainer getTrainer(){
        return trainer;
    }



    public String toString() {
        return String.format("Navn: %s\nmembers: %s", teamName, members);
    }

}