import java.util.ArrayList;

public class Register {
    private ArrayList<Member> memberList;

    public Register() {
        memberList = new ArrayList<>();

    }

    public void createMember(String name, int age) {
        Member member = new Member(name, age);
        memberList.add(member);
    }

    }



