import java.util.ArrayList;

public class Register {
    private ArrayList<Member> memberList;

    public Register() {
        memberList = new ArrayList<>();

    }

    public void addMember(Member member) {
        memberList.add(member);
    }


    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    @Override
    public String toString() {
        String test = "";
        for (Member member : memberList) {
            test += member.toString() + "\n";
        }
        return test;
    }

    public void AddFeeToAllMembers(){
        for (Member member : memberList){
            if (member instanceof PassiveMember){
                ((PassiveMember) member).addFee();
            }

        }
    }
}