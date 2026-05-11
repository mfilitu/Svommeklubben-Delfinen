package Tests;

import Code.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentStatusTest {

    @Test
    void getRevenue() {
        Register register = new Register();
        PaymentStatus paymentStatus = new PaymentStatus(register);
        ActiveMember bo = new SeniorMember("Bo", 17);
        ActiveMember bob = new JuniorMember("Bob", 1);

        register.addMember(bo);
        register.addMember(bob);

        bo.pay();

        assertEquals(1600, paymentStatus.getRevenue());
    }

    @Test
    void getMissingPayment() {
        Register register = new Register();
        PaymentStatus paymentStatus = new PaymentStatus(register);
        ActiveMember bo = new SeniorMember("Bo", 17);
        ActiveMember bob = new JuniorMember("Bob", 1);

        register.addMember(bo);
        register.addMember(bob);

        bo.pay();

        assertEquals(-1000, paymentStatus.getMissingPayment());
    }

    @Test
    void savePaidToFile() {
        Register register = new Register();
        PaymentStatus paymentStatus = new PaymentStatus(register);
        ActiveMember bo = new SeniorMember("Bo", 17);
        ActiveMember bob = new JuniorMember("Bob", 1);

        register.addMember(bo);
        register.addMember(bob);

        bo.pay();

        paymentStatus.savePaidToFile();

        File file = new File("paidMembers.csv");
        System.out.println("Er filen læsbar? " + file.canRead());
        String line = "";
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                line += scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("filen findes ikke!");
        }
        

        assertEquals("Bo, 1600.0", line);
    }

    @Test
    void saveUnpaidToFile() {
        Register register = new Register();
        PaymentStatus paymentStatus = new PaymentStatus(register);
        ActiveMember bo = new SeniorMember("Bo", 17);
        ActiveMember bob = new JuniorMember("Bob", 1);

        register.addMember(bo);
        register.addMember(bob);

        bo.pay();

        paymentStatus.saveUnpaidToFile();

        File file = new File("unpaidMembers.csv");
        System.out.println("Er filen læsbar? " + file.canRead());
        String line = "";
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                line += scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("filen findes ikke!");
        }

        assertEquals("Bob, -1000.0", line);
    }
}