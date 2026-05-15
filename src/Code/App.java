package Code;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Code.SwimmingDiscipline;

public class App {
    public static void main(String[] args) throws InvalidAgeException {

        Register register = new Register();
        ResultList resultList = new ResultList();
        Boolean running = true;

        List<Tournament> Tlist = new ArrayList<>();

        Team JuniorTeam = new Team("Delfin Ungerne", new Trainer("Jakob Janot"));
        Team SeniorTeam = new Team("Delfinerne", new Trainer("Cay"));

        PaymentStatus paymentStatus = new PaymentStatus(register);


        register.addMembersFromFile();

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
                            try {
                                System.out.println("Navn:");
                                scanner.nextLine();
                                String name = scanner.nextLine();
                                System.out.println("Alder:");
                                int age = scanner.nextInt();
                                if (age < 0 || age > 100) {
                                    throw new InvalidAgeException("Ugyldig alder");
                                }
                                createMember(age, register, name);
                                paymentStatus.saveUnpaidToFile();
                                paymentStatus.savePaidToFile();
                                register.updateFile();
                                System.out.println(name + " er blevet oprettet som medlem!");

                            } catch (InvalidAgeException e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case 2:
                            try {
                                System.out.println("Navn:");
                                scanner.nextLine();
                                String name_p = scanner.nextLine();
                                System.out.println("Alder:");
                                int age_p = scanner.nextInt();

                                if (age_p < 0 || age_p > 100) {
                                    throw new InvalidAgeException("Ugyldig Alder");
                                }
                                createPassiveMember(age_p, register, name_p);
                                paymentStatus.saveUnpaidToFile();
                                paymentStatus.savePaidToFile();
                                register.updateFile();
                                System.out.println(name_p + " er blevet oprettet som medlem!");

                            } catch (InvalidAgeException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                    }
                    break;

                case 2:
                    System.out.println("\nListe af alle medlemmer:");
                    System.out.println(register);
                    break;

                case 3:
                    System.out.println("--------------------------------------");
                    System.out.println("1. Vis forventet kontingent");
                    System.out.println("2. Vis missing payment");
                    System.out.println("3. betal manglende kontingent");
                    System.out.println("--------------------------------------");
                    int payment_menu = scanner.nextInt();
                    switch (payment_menu) {
                        case 1:
                            System.out.println(paymentStatus.getRevenue());
                            break;
                        case 2:
                            System.out.println(paymentStatus.getMissingPayment());
                            break;
                        case 3:
                            System.out.println("Indtast medlemsnavn");
                            scanner.next();
                            String payment_name = scanner.nextLine();
                            paymentStatus.getMissingMember(payment_name);
                            paymentStatus.saveUnpaidToFile();
                            paymentStatus.savePaidToFile();
                            break;
                    }
                    break;

                case 4:
                    System.out.println("Indtast Navn på medlem for at vise Info:");
                    scanner.nextLine();
                    String membername = scanner.nextLine();
                    showMemberInfo(register, membername, resultList, JuniorTeam, SeniorTeam);
                    break;
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
                case 6:
                    System.out.println("Indtast medlemsnavn:");
                    scanner.nextLine();
                    String teamMemberName = scanner.nextLine();

                    Member foundMember = findMemberByName(register, teamMemberName);

                    if (foundMember == null) {
                        System.out.println("Medlem ikke fundet.");
                        break;
                    }

                    if (!(foundMember instanceof ActiveMember)) {
                        System.out.println("Passive medlemmer kan ikke tilføjes til hold.");
                        break;
                    }

                    System.out.println("vælg et hold");
                    System.out.println("1. " + JuniorTeam.getTeamName());
                    System.out.println("2. " + SeniorTeam.getTeamName());

                    int teamChoice = scanner.nextInt();

                    switch (teamChoice) {

                        case 1:

                            if (foundMember.getAge() >= 18) {
                                System.out.println("Senior medlemmer kan ikke tilføjes til et juniorhold.");
                                break;
                            }
                            JuniorTeam.addToTeam((ActiveMember) foundMember);
                            System.out.println(foundMember.getName() + " blev tilføjet til " + JuniorTeam.getTeamName());

                            break;


                        case 2:

                            if (foundMember.getAge() < 18) {
                                System.out.println("Junior medlemmer kan ikke tilføjes til et senior hold.");
                                break;
                            }
                            SeniorTeam.addToTeam((ActiveMember) foundMember);
                            System.out.println(foundMember.getName() + " blev tilføjet til " + SeniorTeam.getTeamName());
                            break;

                        default:
                            System.out.println("ugyldigt holdvalg.");
                    }
                    break;
                case 7:
                    boolean tournamentLogic = true;
                    while (tournamentLogic) {
                        // TODO tournament
                        System.out.println("--------------------------------------");
                        System.out.println("1. Opret en tunering");
                        System.out.println("2. Tilføj medlemmer til turnering");
                        System.out.println("3. Indtast resultater");
                        System.out.println("4. Vis resultater");
                        System.out.println("0. Tilbage");
                        System.out.println("--------------------------------------");

                        int valg = scanner.nextInt();
                        scanner.nextLine();

                        switch (valg) {
                            case 1:
                                System.out.println("""
                                        Hvilken disciplin????
                                        1 Crawl
                                        2 BreastStroke
                                        3 BackCrawl
                                        4 Butterfly
                                        """);

                                int choice1 = scanner.nextInt();
                                scanner.nextLine();

                                SwimmingDiscipline discipline;

                                switch (choice1) {
                                    case 1 -> discipline = SwimmingDiscipline.Crawl;
                                    case 2 -> discipline = SwimmingDiscipline.BreastStroke;
                                    case 3 -> discipline = SwimmingDiscipline.BackCrawl;
                                    case 4 -> discipline = SwimmingDiscipline.Butterfly;
                                    default -> {
                                        System.out.println("Ugyldigt valg");
                                        return;
                                    }
                                }

                                System.out.println("Navn:");
                                String name = scanner.nextLine();

                                System.out.println("Dato:");
                                String date = scanner.nextLine();

                                System.out.println("Tid:");
                                String time = scanner.nextLine();

                                Tournament tournament = new Tournament(name, date, time, discipline);
                                Tlist.add(tournament);
                                break;
                            case 2:
                                System.out.println("Liste af turneringer:\n");
                                for (Tournament tournament_print : Tlist) {
                                    System.out.println(tournament_print.getName() + "\n");
                                }
                                System.out.println("Skriv navnet på turneringen:");

                                String tname = scanner.nextLine();
                                for (Tournament tournament1 : Tlist) {
                                    if (tournament1.getName().equalsIgnoreCase(tname)) {
                                        tournament1.addCompetitors(resultList);
                                    }
                                }
                                break;

                            case 3:
                                System.out.println("Liste af turneringer:\n");
                                for (Tournament tournament_print : Tlist) {
                                    System.out.println(tournament_print.getName() + "\n");
                                }
                                System.out.println("Skriv navnet på turneringen:");
                                String tournamentName = scanner.nextLine();
                                for (Tournament tournament2 : Tlist) {
                                    if (tournament2.getName().equalsIgnoreCase(tournamentName)) {
                                        tournament2.addResultTimes();
                                    }
                                }
                                break;
                            case 4:
                                // TODO sort
                                System.out.println("Liste af turneringer:\n");
                                for (Tournament tournament_print : Tlist) {
                                    System.out.println(tournament_print.getName() + "\n");
                                }
                                System.out.println("Skriv navnet på turneringen:");
                                String tournamentName1 = scanner.nextLine();
                                for (Tournament tournament2 : Tlist) {
                                    if (tournament2.getName().equalsIgnoreCase(tournamentName1)) {
                                        System.out.println(tournament2.getResults());
                                    }
                                }
                                break;
                            case 0:
                                tournamentLogic = false;
                        }


                    }


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
                            break;
                        }
                    }

                    if (!aPartOfTeam) {
                        for (ActiveMember AcSeMembers : seniorTeam.getMembers()) {
                            if (AcSeMembers.equals(member)) {
                                System.out.println("Hold:" + seniorTeam.getTeamName());
                                System.out.println("Træner: " + seniorTeam.getTrainer().getTrainerName());
                                aPartOfTeam = true;
                            }
                        }

                    }
                    if (!aPartOfTeam) {
                        System.out.println("Medlem er ikke tilknyttet et hold");
                    } else {
                        System.out.println("Passive medlemmer kan ikke tilknyttes et hold");
                    }
                    System.out.println("----------Resultater----------");

                    List<Result> memberResults = resultList.getAllResults().stream().filter(result -> result.getMember().equals(member)).collect(Collectors.toList());
                    if (memberResults.isEmpty()) {
                        System.out.println("Dette medlem har ikke nogle resultater");
                        for (Result result : memberResults) {
                            System.out.println("Disciplin: " + result.getDiscipline() + " Tid: " + result.getTime() + " Millisekunder");
                        }
                    }
                    return;
                }
            }
        }
    }

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
            case 1:
                return SwimmingDiscipline.Crawl;
            case 2:
                return SwimmingDiscipline.BreastStroke;

            case 3:
                return SwimmingDiscipline.BackCrawl;
            case 4:
                return SwimmingDiscipline.Butterfly;
            default:
                return null;
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
        System.out.println("7. Turneringer");
        System.out.println("--------------------------------------");
    }
}






