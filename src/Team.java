import java.util.ArrayList;

    public class Team {
        private String name;
        private ArrayList<Member> members;

        public Team(String name) {
            this.name = name;
            members = new ArrayList<>();
        }

        public void addMember(Member member) {
            members.add(member);
        }


        public String toString() {
            return String.format ("%s - %s", name, members);
        }
    }

}
