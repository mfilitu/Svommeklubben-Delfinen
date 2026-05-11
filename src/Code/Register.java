package Code;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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

    public void updateFile() {

        File file = new File("memberList.csv");

        try (PrintWriter writer = new PrintWriter(file)) {

            for (Member member : memberList) {

                writer.println(
                        member.getName() + ", " + member.getAge() + ", " + member.isPaid()
                );
            }

        } catch (FileNotFoundException e) {
            System.out.println("Kunne ikke opdatere filen.");
        }
    }

    public void addMembersFromFile() {
        File file = new File("memberlist.csv");

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                String[] data = line.split(",");

                String name = data[0].trim();
                int age = Integer.parseInt(data[1].trim());
                boolean paid = Boolean.parseBoolean(data[2].trim());

                ActiveMember member;

                if (age < 18) {
                    member = new JuniorMember(name, age);
                } else {
                    member = new SeniorMember(name, age);
                }

                addMember(member);
                if (paid){
                    member.pay();
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Filen findes ikke!");
        }
    }

    @Override
    public String toString() {
        String test = "";
        for (Member member : memberList) {
            test += member.toString() + "\n";
        }
        return test;
    }

    public void AddFeeToAllMembers() {
        for (Member member : memberList) {
            if (member instanceof PassiveMember) {
                ((PassiveMember) member).addFee();
            }
            if (member instanceof SeniorMember) {
                ((SeniorMember) member).addFee();
            }
            if (member instanceof JuniorMember) {
                ((JuniorMember) member).addFee();
            }

        }
    }
}