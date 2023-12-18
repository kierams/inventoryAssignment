import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class store {
    private static Scanner x;

    public static void main(String[] args)  {

        int userinput=Menu.menu();
        while(userinput !=5){

            if (userinput>5 || userinput<1) {
                System.out.println("This doesn't appear to be a valid option...!");
            }
            if (userinput == 1) {
                Actions.addRecord();
            }
            else if (userinput == 2) {
                Actions.editRecords();
            }
            else if (userinput == 3) {
                Actions.deleteRecord();
            }
            else if (userinput == 4) {
                Reports.printReport();
            }
            userinput=Menu.menu();

        }
        System.out.println("Thank you");
    }
}
