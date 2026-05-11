package Code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws InvalidAgeException {

        Register register = new Register();
        PaymentStatus paymentStatus = new PaymentStatus(register);
        Boolean running = true;

        Scanner scanner = new Scanner(System.in);

        while (running) {
            printMenu();
            while (!scanner.hasNextInt()) {
                System.out.println("Indtast et tal:");
                scanner.next();
            }
            int input = scanner.nextInt();


            switch (input) {
                case 1:
                    System.out.println("1 = active, 2 = passive");
                    int memberType = scanner.nextInt();

                    switch (memberType) {
                        case 1:
                            //aktive
                            System.out.println("Navn:");
                            scanner.nextLine();
                            String name = scanner.nextLine();
                            System.out.println("Alder:");

                            int age = scanner.nextInt();

                            createMember(age, register, name);

                            System.out.println(name + " er blevet oprettet som medlem!");

                            break;
                        case 2:
                            //aktive
                            System.out.println("Navn:");
                            scanner.nextLine();
                            String name_p = scanner.nextLine();
                            System.out.println("Alder:");

                            int age_p = scanner.nextInt();

                            createPassiveMember(age_p, register, name_p);

                            System.out.println(name_p + " er blevet oprettet som medlem!");
                    }

                    break;
                case 2:
                    System.out.println("\nListe af alle medlemmer:");
                    System.out.println(register);
                    break;
                case 3:
                    System.out.println();
                    System.out.println("--------------------------------------");
                    System.out.println("1. Vis forventet kontigent");
                    System.out.println("2. Vis missing payment");
                    //System.out.println("3. ");
                    System.out.println("--------------------------------------");
                    int payment_menu = scanner.nextInt();
                    switch (payment_menu) {
                        case 1:
                            System.out.println(paymentStatus.getRevenue());
                            break;
                        case 2:
                            System.out.println(paymentStatus.getMissingPayment());
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Indtast Navn på medlem for at vise Info:");
                    scanner.nextLine();
                    break;
            }
        }
    }

    private static void createMember(int age, Register register, String name) {
        Scanner scanner = new Scanner(System.in);

        // Note: 1-17 = junior. 18-99 = senior. 0 og 100+ = InvalidAgeException
        if (age >= 18 && age <= 100) {
            Member seniorMember = new SeniorMember(name, age);
            register.addMember(seniorMember);
            System.out.println("Betal med det samme? 1 = ja, 2 = nej.");
            int pay = scanner.nextInt();
            switch (pay) {
                case 1:
                    seniorMember.pay();
                    break;
                case 2:
                    break;
            }
        } else if (age > 0 && age < 18) {
            Member juniorMember = new JuniorMember(name, age);
            register.addMember(juniorMember);
            System.out.println("Betal med det samme? 1 = ja, 2 = nej.");
            int pay = scanner.nextInt();
            switch (pay) {
                case 1:
                    juniorMember.pay();
                    break;
                case 2:
                    break;
            }
        } else {
            throw new InvalidAgeException("Personen er for ung/gammel");
        }

    }

    private static void createPassiveMember(int age, Register register, String name) {
        Member member = new PassiveMember(name, age);
        register.addMember(member);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Betal med det samme? 1 = ja, 2 = nej.");
        int pay = scanner.nextInt();
        switch (pay) {
            case 1:
                member.pay();
                break;
            case 2:
                break;
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("Menu:");
        System.out.println("1. Opret medlem");
        System.out.println("2. Vis liste af alle medlemer");
        System.out.println("3. Kontigent overblik");
        System.out.println("4. Vis MedlemsInfo");
        System.out.println("--------------------------------------");
    }
}
