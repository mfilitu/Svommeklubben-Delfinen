import java.util.ArrayList;

public class Register {
    private ArrayList<Member> memberList;
    private Team juniorTeam;
    private Team seniorTeam;


    public Register() {
        memberList = new ArrayList<>();
        juniorTeam = new Team("Juniorhold");
        seniorTeam = new Team("Seniorhold");
    }

    public void createMember(String name, int age, boolean status) {
        Member member = new Member(name, age, status);
        memberList.add(member);
    }


    public void addToTeam(Member member) {
        if (member.getAge() < 18) {
            juniorTeam.addMember(member);
        } else {
            seniorTeam.addMember(member);
        }
    }
}



