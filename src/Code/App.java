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
                case 4:
                    System.out.println("Indtast Navn på medlem for at vise Info:");
                    scanner.nextLine();
                    String membername = scanner.nextLine();
                    showMemberInfo(register, membername, resultList, JuniorTeam, SeniorTeam);
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

    private static void createPassiveMember(int age, Register register, String name) {
        register.addMember(new PassiveMember(name, age));
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("Menu:");
        System.out.println("1. Opret medlem");
        System.out.println("2. Vis liste af alle medlemer");
        System.out.println("3. ");
        System.out.println("4. Vis MedlemsInfo");
        System.out.println();
        System.out.println("--------------------------------------");
    }
}
