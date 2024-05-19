import static lib.Helpers.*;

import java.util.ArrayList;
import java.util.Scanner;

import static constants.FillTables.*;
import static lib.Prompt.*;
import manager.Manager;
import manager.SuperUser;
import model.Card;
import model.City;
import model.Faculty;
import model.Field;
import model.Member;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Member mbr2 = new Member(2, "TUPAC", "SHAKUR", "23/09/1992", "tup@gmail.com", "nbe456098", 20212332, 2, 2, 2, 2, true);
        
        SuperUser root = new SuperUser(mbr2);

        root.setSession_start();
        System.out.println("\n\t\t\t\t\t\t\t\t\tRoot session start: " + root.getSession_start());

        ArrayList<Faculty> facs = fillFaculties();
        root.addCities(fillCities(facs));
        ArrayList<Member> baseMembers = fillMembers();
        root.addMembers(baseMembers);
        root.addCards(fillCards());


        //printFieldByFaculty(root, "ENSA");

        // int choice = promptForMenu(scan);
        // processChoice(choice, scan, baseMembers, root);
        //printSingleMember(root, root.getMember(0), root.getId() - 1);

       // root.addMember(member);
        //printAnyList(root.getMembers(), root);
        root.setSession_end();
        System.out.println("\n\t\t\t\t\t\t\t\t\tRoot session start: " + root.getSession_end());

        scan.close();

    }

    public static int promptForMenu(Scanner scanner) {
        System.out.println("\n\t\t\t\t\t\t\t\t\t===========================\n\n" +
                "\t\t\t\t\t\t\t\t\t\s  Welcome to ACEMANAGER\n"
                + "\t\t\t\t\t\t\t\t\s  An association membership management\n\n" +
                "\t\t\t\t\t\t\t\t\t===========================\n");
        while(true) {
            System.out.print(
                "\n\t\t\t\t\t\t\t\t\tWhat would you like to do?\n\n\t\t\t\t\t\t\t\t\t1. List Members\n\t\t\t\t\t\t\t\t\t2. Add a new member\n\t\t\t\t\t\t\t\t\t3. Update a member\n\t\t\t\t\t\t\t\t\t4. Delete a member\n\t\t\t\t\t\t\t\t\t5. Exit\n\t\t\t\t\t\t\t\t\tPlease choose an option: ");
            if(!scanner.hasNextInt()) {
                scanner.next();
                continue;
            }
            int choice = scanner.nextInt();
            if(choice <= 0 || choice > 5) continue;
            return choice; 
        }  
    }

    public static void processChoice(int choice, Scanner scan, ArrayList<?> list, Manager manager) {
        switch (choice) {
            case 1:
                printAnyList(list, manager);
                break;
            case 2:
                scan.nextLine();
                Member newMember = createMember(scan);
                manager.addMember(newMember);
                printAnyList(manager.getMembers(), manager);
            case 3:
                scan.nextLine();
            default:
                break;
        }
    }

    public static Member createMember(Scanner scan) {
        String fname = promptForFirstName(scan);
        String lname = promptForLastName(scan);
        String passport = promptForPassport(scan);
        int matAmci = promptForMatAmci(scan);
        String birthDate = promptForBirthDate(scan);
        String email = promptForEmail(scan);
        boolean isMember = promptForMemberStatus(scan);

        Member member = new Member(0, fname, lname, birthDate, email, passport, matAmci, 2, 2, 2, 2, isMember);

        return member;
    }

    public static Field createField(Scanner scan) {
        String abbr = promptForFieldAbbr(scan);
        String name = promptForFieldName(scan);
        String certificate = promptForCertificate(scan);
        int duration = promptForDuration(scan);

        return new Field(1, abbr, name, certificate, duration);
    }

    public static Card createCard(Scanner scan) {
        String cin = promptForCin(scan);
        String reason = promptForReason(scan);
        String obtDate = promptForObtentionDate(scan);
        String expDate = promptForExpirationDate(scan);
        int pin = promptForPin(scan);

        return new Card(1, 1, 1, cin, reason, obtDate, expDate, pin);
    }

    public static City createCity(Scanner scan) {
        String name = promptForCityName(scan);
        String region = promptForRegion(scan);

        return new City(1, name, region, fillFaculties());
    }

}