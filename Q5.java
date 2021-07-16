package W3;
import java.util.Scanner;

public class Q5 {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        Contact con = new Contact();
        String in;

        do {
            System.out.print("Enter the number stand beofore to do the command.\n\n");
            System.out.print("What do you want?\n1.Display contacts by name\n2.Create new contact\n3.Update a contact\n4.Delete a contact\n5.Search the contact by words\n6.Display contacts by a field\n0.Exit\n");

            //Get User option
            in = scan.nextLine();

            //Switch to call methods
            switch (in) {
                case "1":
                    con.disp();
                    break;
                case "2":
                    System.out.print("Enter new name to create: ");
                    con.newcont(scan.nextLine());
                    break;
                case "3":
                    System.out.print("Enter name of person you want to update: ");
                    con.updcont(scan.nextLine());
                    break;
                case "4":
                    System.out.print("Enter name of person you want to delete contact: ");
                    con.delcont(scan.nextLine());
                    break;
                case "5":
                    System.out.print("Enter information you want to search: ");
                    con.search(scan.nextLine());
                    break;
                case "6":
                    System.out.print("Enter field you want to sort by: ");
                    con.dispBy(scan.nextLine());
                    break;
            }

            //Ask to exit
            System.out.print("Continue?\n1.Y\n2.N\n");
            if ( scan.nextLine() == "1" ) {
                break;
            } else {
                in = "0";
                break;
            }
        }
        while ( !(in == "0") );
    }

}
