import java.util.Scanner;

public class Menu extends store {
    public static int menu() {
        Scanner input = new Scanner(System.in);

        System.out.println("-------------------------------------------------------");
        System.out.println("I N V E N T O R Y    M A N A G E M E N T    S Y S T E M");
        System.out.println("-------------------------------------------------------");
        System.out.println("1. ADD NEW ITEM");
        System.out.println("2. UPDATE QUANTITY OF EXISTING ITEM");
        System.out.println("3. REMOVE ITEM");
        System.out.println("4. VIEW DAILY TRANSACTION REPORT");
        System.out.println("---------------------------------");
        System.out.println("5. Exit");

        System.out.print("\nEnter a choice and Press ENTER to continue[1-5]:");
        int userinput = input.nextInt();
        return userinput;
    }}
