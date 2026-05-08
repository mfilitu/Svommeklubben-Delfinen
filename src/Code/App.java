package Code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws InvalidAgeException {

        Register register = new Register();
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
                    System.out.println("Navn:");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.println("Alder:");

                    int age = scanner.nextInt();

                    createMember(age, register, name);

                    System.out.println(name + " er blevet oprettet som medlem!");
                    break;
                case 2:
                    System.out.println("\nListe af alle medlemmer:");
                    System.out.println(register);
                    break;
            }
        }
    }

    private static void createMember(int age, Register register, String name) {
        // Note: 1-17 = junior. 18-99 = senior. 0 og 100+ = InvalidAgeException
        if (age >= 18 && age <= 100) {
            register.addMember(new SeniorMember(name, age));
        } else if (age > 0 && age < 18) {
            register.addMember(new JuniorMember(name, age));
        } else {
            throw new InvalidAgeException("Personen er for ung/gammel");
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("Menu:");
        System.out.println("1. Opret medlem");
        System.out.println("2. Vis liste af alle medlemer");
        System.out.println("3. ");
        System.out.println("--------------------------------------");
    }
}
