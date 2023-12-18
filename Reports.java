import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class Reports extends store {

        public static void printRecords() throws InputMismatchException {
                try (Scanner input = new Scanner(Paths.get("items.txt"))) {
                        // Prints the header for our outputfiles
                        System.out.println(" --------------------------------------------------------");
                        System.out.println("|Item id|Description|Price |Quantity|Quantity Sold|Total|");
                        System.out.println("|-------|-----------|------|--------|-------------|-----|");

                        // Keep reading our file until it has data
                        // Prints out our data numbers of % are used to match the space above in the
                        // header so that a nice table can be presented

                        while (input.hasNext()) {
                                System.out.printf("|%06d |%10s | %5d|%8d|%13d| %4d| %n",input.nextInt(), input.next(), input.nextInt(), input.nextInt(),input.nextInt(),input.nextInt());
                        }

                System.out.println(" ------------------------------------------------------- ");

                }catch (IOException ioe){
                        ioe.getStackTrace();
                }
        }

// prints all the records in items.txt file
        public static void printReport() throws InputMismatchException {

                // Opens files and start scanning it
                try (Scanner input = new Scanner(Paths.get("transactions.txt"))) {
                        // Prints the header for our outputfiles
                        System.out.println(" ----------------------------------------------------------------------------------------- ");
                        System.out.println("|Date        |Item id|Description|Price |Quantity Remaining|Quantity sold|Total|Reason    |");
                        System.out.println("|------------|-------|-----------|------|------------------|-------------|-----|----------|");

                        // Keep reading our file until it has data
                        while (input.hasNext()) {
                        System.out.printf("|%12s| %5d |%10s | %5d|%18d|%13d|%5d|%10s|  %n",input.next(),input.nextInt(), input.next(), input.nextInt(), input.nextInt(),input.nextInt(),input.nextInt(),input.next());
                        }
                System.out.println(" ----------------------------------------------------------------------------------------- ");

                }catch (IOException ioe){
                        ioe.getStackTrace();
                }
        }
}