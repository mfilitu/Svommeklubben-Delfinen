
package Code;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws InvalidAgeException {

        Register register = new Register();
        ResultList resultList = new ResultList();
        Boolean running = true;

        Team JuniorTeam = new Team("Delfin Ungerne", new Trainer("Jakob Janot"));
        Team SeniorTeam = new Team("Delfinerne", new Trainer("Cay"));

        PaymentStatus paymentStatus = new PaymentStatus(register);

        register.addMembersFromFile();

        ResultList resultList = new ResultList();

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
                    int memerType = scanner.nextInt();

                    switch (memerType) {
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
                            System.out.println("Navn:");
                            scanner.nextLine();
                            String name_p = scanner.nextLine();
                            System.out.println("Alder:");
                            int age_p = scanner.nextInt();
                            createPassiveMember(age_p, register, name_p);
                            System.out.println(name_p + " er blevet oprettet som medlem!");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("\nListe af alle medlemmer:");
                    System.out.println(register);
                    break;

                case 3:
                    System.out.println("--------------------------------------");
                    System.out.println("1. Vis forventet kontigent");
                    System.out.println("2. Vis missing payment");
                    System.out.println("--------------------------------------");
                    int payment_menu = scanner.nextInt();
                    switch (payment_menu) {
                        case 1:
                            System.out.println(paymentStatus.getRevenue());
                            paymentStatus.savePaidToFile();
                            break;
                        case 2:
                            System.out.println(paymentStatus.getMissingPayment());
                            paymentStatus.saveUnpaidToFile();
                            break;
                    }
                    break;

                case 4:
                    System.out.println("Indtast Navn på medlem for at vise Info:");
                    scanner.nextLine();
                    String membername = scanner.nextLine();
                    showMemberInfo(register, membername, resultList, JuniorTeam, SeniorTeam);


                case 5:
                    System.out.println("RESULTATER");
                    System.out.println("1. Tilføj tid til medlem");
                    System.out.println("2. Vis top 5 tider pr disciplin");

                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.println("Indtast medlemsnavn:");
                            String memberName = scanner.nextLine();

                            Member member = findMemberByName(register, memberName);
                            if (member == null) {
                                System.out.println("Medlem ikke fundet.");
                                break;
                            }

                            SwimmingDiscipline discipline = chooseDiscipline(scanner);
                            if (discipline == null) {
                                System.out.println("Ugyldig disciplin.");
                                break;
                            }

                            System.out.println("Indtast tid i millisekunder:");
                            int timeMs = scanner.nextInt();

                            resultList.addResult(new Result(member, discipline, timeMs));
                            System.out.println("Tid gemt!");
                            break;

                        case 2:
                            for (SwimmingDiscipline d : SwimmingDiscipline.values()) {
                                System.out.println("\nTOP 5 - " + d);
                                for (Result r : resultList.getTopFive(d)) {
                                    System.out.println(r);
                                }
                            }
                            break;
                    }
                    break;
            }
        }
    }

    private static void showMemberInfo(Register register, String name, ResultList resultList, Team juniorTeam, Team seniorTeam) {
        for (Member member : register.getMemberList()) {
            if (member.getName().equalsIgnoreCase(name)) {
                System.out.println("\n--------Medlemsinfo--------");
                System.out.println(member.toString());

                if (member instanceof ActiveMember) {
                    boolean aPartOfTeam = false;
                    for (ActiveMember AJrMembers : juniorTeam.getMembers()) {
                        if (AJrMembers.equals(member)) {
                            System.out.println("Hold:" + juniorTeam.getTeamName());
                            System.out.println("Træner: " + juniorTeam.getTrainer().getTrainerName());
                            aPartOfTeam = true;
                            break;}}

                    if (!aPartOfTeam) {
                        for (ActiveMember AcSeMembers : seniorTeam.getMembers()) {
                            if (AcSeMembers.equals(member)) {
                                System.out.println("Hold:" + seniorTeam.getTeamName());
                                System.out.println("Træner: " + seniorTeam.getTrainer().getTrainerName());
                                aPartOfTeam = true;}}

                    } if (!aPartOfTeam) {
                        System.out.println("Medlem er ikke tilknyttet et hold");
                    } else {
                        System.out.println("Passive medlemmer kan ikke tilknyttes et hold");}
                    System.out.println("----------Resultater----------");

                    List<Result> memberResults = resultList.getAllResults().stream().filter
                            (result -> result.getMember().equals(member)) .collect(Collectors.toList());
                    if (memberResults.isEmpty()){
                        System.out.println("Denne member har ikke nogle resultater");
                        for (Result result : memberResults){
                            System.out.println("Disciplin: "+result.getDiscipline()+" Tid: "+result.getTime()+" Millisekunder");}}
                return; }}System.out.println("Medlem ikke Fundet");
    }}

    private static Member findMemberByName(Register register, String name) {
        for (Member member : register.getMemberList()) {
            if (member.getName().equalsIgnoreCase(name.trim())) {
                return member;
            }
        }
        return null;
    }


    private static SwimmingDiscipline chooseDiscipline(Scanner scanner) {
        System.out.println("Vælg disciplin:");
        System.out.println("1 = Crawl");
        System.out.println("2 = BreastStroke");
        System.out.println("3 = BackCrawl");
        System.out.println("4 = Butterfly");

        int input = scanner.nextInt();
        switch (input) {
            case 1: return SwimmingDiscipline.Crawl;
            case 2: return SwimmingDiscipline.BreastStroke;

            case 3: return SwimmingDiscipline.BackCrawl;
            case 4: return SwimmingDiscipline.Butterfly;
            default: return null;
        }
    }

    private static void createMember(int age, Register register, String name) {
        Scanner scanner = new Scanner(System.in);

        if (age >= 18 && age <= 100) {
            Member seniorMember = new SeniorMember(name, age);
            register.addMember(seniorMember);
            System.out.println("Betal med det samme? 1 = ja, 2 = nej.");
            if (scanner.nextInt() == 1) seniorMember.pay();
        } else if (age > 0 && age < 18) {
            Member juniorMember = new JuniorMember(name, age);
            register.addMember(juniorMember);
            System.out.println("Betal med det samme? 1 = ja, 2 = nej.");
            if (scanner.nextInt() == 1) juniorMember.pay();
        } else {
            throw new InvalidAgeException("Personen er for ung/gammel");
        }
    }

    private static void createPassiveMember(int age, Register register, String name) {
        Member member = new PassiveMember(name, age);
        register.addMember(member);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Betal med det samme? 1 = ja, 2 = nej.");
        if (scanner.nextInt() == 1) member.pay();
    }

    private static void printMenu() {
        System.out.println("--------------------------------------");
        System.out.println("Menu:");
        System.out.println("1. Opret medlem");
        System.out.println("2. Vis liste af alle medlemmer");
        System.out.println("3. Kontigent overblik");
        System.out.println("4. Vis MedlemsInfo");
        System.out.println("5. Resultater");
        System.out.println("6. Tilføj medlem til hold");
        System.out.println("--------------------------------------");
    }
}






