package W3;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;

public class Contact {
    private LinkedList<String> cont = new LinkedList<String>();
    private Scanner scan = new Scanner(System.in);

    //Display the whole Contact List
    void disp() {
        Collections.sort(cont);

        System.out.printf("%15s %15s %15s %15s %15s %15s%n", "Name", "Position",
                "Company", "Phone Number",
                "Email", "Address");
        for (String i : cont) {
            for ( String k : i.split("<>") ) {
                System.out.printf("%16s", k);
            }
            System.out.print("\n");
        }
    }

    //Create new contact by a Name
    void newcont(String inname) {
        cont.add(inname);
    }

    //Update contact through a name
    void updcont(String inname) {
        for (int i = 0; i < cont.size(); i++) {
            if ( cont.get(i).startsWith(inname)) {
                //Change name
                System.out.print("Enter Name (Press Enter to skip) : ");
                String a = scan.nextLine();
                if (!(a.equals("")) ) {
                    cont.set(i, a);
                }
                //Change Position
                System.out.print("Enter Position (Press Enter to skip) : ");
                cont.set(i, cont.get(i) + "<>" + scan.nextLine() );
                //ChangeCompany
                System.out.print("Enter Company (Press Enter to skip) : ");
                cont.set(i, cont.get(i) + "<>" + scan.nextLine() );
                //Change Phone Number
                System.out.print("Enter Phone number (Press Enter to skip) : ");
                cont.set(i, cont.get(i) + "<>" + scan.nextLine() );
                //Change Email
                System.out.print("Enter email (Press Enter to skip) : ");
                cont.set(i, cont.get(i) + "<>" + scan.nextLine() );
                //Change Address
                System.out.print("Enter Address (Press Enter to skip) : ");
                cont.set(i, cont.get(i) + "<>" + scan.nextLine() );
            }
        }
    }

    //Delete contact through name, Asking again for double-checked
    void delcont(String inname) {
        for (int i = 0; i < cont.size(); i++) {
            if (cont.get(i).startsWith(inname)) {
                System.out.printf("%15s %15s %15s %15s %15s %15s%n", "Name", "Position",
                        "Company", "Phone Number",
                        "Email", "Address");
                for ( String k : cont.get(i).split("<>") ) {
                    System.out.printf("%16s", k);
                }
                System.out.print("\nAfter deleting it can not be restored.\n Do you want to delete ?\n1.Y\n2.N");
                String in = scan.nextLine().toLowerCase();
                if ( in == "1") {
                    cont.remove(i);
                }
            }
        }
    }

    //Search contact through a string
    void search(String input) {
        int found = 0;

        for (String i : cont) {
            if ( i.contains(input) ) {
                System.out.printf("%15s %15s %15s %15s %15s %15s", "Name", "Position",
                        "Company", "Phone Number",
                        "Email", "Address");

                for ( String k : i.split("<>") ) {
                    System.out.printf("%16s", k);
                }
                System.out.print("\n");
                found++;
            }
        }
        if (found == 0) {
            System.out.println("Information not found");
        }
    }

    //Display list sort by an input field
    void dispBy(String input) {
        int ord = 0;

        //Determine the oder of field
        switch ( input.toLowerCase() ) {
            case "name":
                ord = 0;
                break;
            case "position":
                ord = 1;
                break;
            case "company":
                ord = 2;
                break;
            case "phone number":
                ord = 3;
                break;
            case "email":
                ord = 4;
                break;
            case "address":
                ord = 5;
                break;
        }

        //Take each contact
        for ( int i = 0; i < cont.size(); i++ ) {
            int id = i;         //Get the order

            //Compare to each contact
            for ( int k = i; k < cont.size(); k++) {
                //Point to the field
                String a = cont.get(id).split("<>")[ord],
                        b = cont.get(k).split("<>")[ord];

                //Check each character
                for (int h = 0; h < a.length(); h++) {
                    if ( a.charAt(h) < b.charAt(h) ) {
                        break;
                    }
                    if ( a.charAt(h) > b.charAt(h) ) {
                        id = k;
                        break;
                    }
                }
            }
            String rpl = cont.get(i);
            cont.set(i, cont.get(id));
            cont.set(id, rpl);
        }

        //Print result
        System.out.printf("%15s %15s %15s %15s %15s %15s", "Name", "Position",
                "Company", "Phone Number",
                "Email", "Address");
        for (String i : cont) {
            for ( String k : i.split("<>") ) {
                System.out.printf("%16s", k);
            }
            System.out.print("\n");
        }
    }

    void test(String input) {
        if (input == "1") {
            System.out.print("Enter something: ");
            System.out.printf("The input is: %s", scan.nextLine());
        }
    }

}
