package Code;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PaymentStatus {
    private ArrayList<Member> memberList;

    public PaymentStatus(Register register) {
        memberList = register.getMemberList();
    }

    public double getRevenue() {
        double totalRevenue = 0;

        for (Member member : memberList) {
            if (member.isPaid()) {
                totalRevenue += member.getFee();
            }

        }

        return totalRevenue;
    }

    public double getMissingPayment() {
        double missingPayment = 0;
        for (Member member : memberList) {
            if (!member.isPaid()) {
                missingPayment -= member.getFee();
            }
        }
        return missingPayment;
    }

    public void savePaidToFile() {
        try {
            FileWriter writer = new FileWriter("paidMembers.csv");

            for (Member member : memberList) {
                if (member.isPaid()) {
                    writer.write(member.getName() + ", " + member.getFee() + "\n");
                }
            }

            writer.close();
            System.out.println("Betalte medlemmer gemt til fil.");

        } catch (IOException e) {
            System.out.println("Fejl ved skrivning til fil.");
        }


    }

    public void saveUnpaidToFile() {
        try {
            FileWriter writer = new FileWriter("unpaidMembers.csv");

            for (Member member : memberList) {
                if (!member.isPaid()) {
                    writer.write(member.getName() + ", " + -member.getFee() + "\n");
                }
            }

            writer.close();
            System.out.println("Ubetalte medlemmer gemt til fil.");

        } catch (IOException e) {
            System.out.println("Fejl ved skrivning til fil.");
        }


    }
}


