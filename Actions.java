import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.util.*;

public class Actions extends store {
    //add record method
    static String itemFile="items.txt";
    static String tempFile = "temp11.txt";
    static String transactionFile="transactions.txt";
    static String error="Invalid input, please try again.";
    public static void addRecord() {

        // opens the file and read it so that current id can be stored
        int ID = 0;
        int total = 0;
        try (Scanner rf = new Scanner(Paths.get(itemFile))) {

            while (rf.hasNext()) {
                int itemID = rf.nextInt(); // Item ID
                String description = rf.next(); // Description
                int unitPrice = rf.nextInt(); // Unit Price
                int quantity = rf.nextInt(); // Quantity
                int quantitySold = rf.nextInt();//Quantity Sold
                total = rf.nextInt();//Total
                ID = itemID;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        // appends the file and add new line at the end
        try {
            PrintWriter out = new PrintWriter(file(itemFile));
            Scanner newRecord = new Scanner(System.in);
            //Inputs into file
            System.out.printf("%s%n-->", "Enter description, unit price, quantity.");

            while (newRecord.hasNext()) {
                try {
                    //saves inputs to variables
                    String description = newRecord.next();
                    int unitPrice = newRecord.nextInt();
                    int quantity = newRecord.nextInt();
                    int quantitySold = 0;
                    total = quantity * unitPrice;
                    Formatter x = new Formatter(out);

                    x.format("%d %s %d %d %d %d %n", ++ID, description, unitPrice, quantity, quantitySold, total);

                    // appends the transactions file to add entry in transactions.txt whenever a record is added in items.txt
                    try {
                        PrintWriter PW_ACTIVITY = new PrintWriter(file(transactionFile));

                        // action completed to at log to file
                        String added = "++Added";
                        quantitySold = 0;

                        String formattedDate = date();
                        // finds current date of the local system, store it to a variable to save to transactions.txt

                        PW_ACTIVITY.printf("%s %d %s %d %d %d %d %s %n", formattedDate, ID, description, unitPrice, quantity, quantitySold,
                                total, added);
                        PW_ACTIVITY.close();

                    } catch (NoSuchElementException elementException) {
                        System.err.println(error);
                    }
                } catch (NoSuchElementException elementException) {
                    System.err.println(error);
                    newRecord.nextLine();
                }
                break;
            }
            //close file
            out.close();
            //prints the records stored in items.txt by accessings reports class
            Reports.printRecords();
        } catch (SecurityException | IOException | FormatterClosedException e) {
            e.printStackTrace();
        }
    }

    //delete record method
    public static void deleteRecord() {
        
        int deleteTerm = 0;

        //prints the records stored in items.txt by accessings reports class
        Reports.printRecords();

        //creates temp file

        File oldFile = new File(itemFile);
        File newFile = new File(tempFile);
        String description = " ";
        int unitPrice = 0;
        int quantity = 0;
        int quantitySold = 0;
        int total = 0;

        try {
            PrintWriter pw = new PrintWriter(file(tempFile));
            Scanner x = new Scanner(new File(itemFile));

            //enter ID for item to be removed
            System.out.println("Enter the ID: \n");
            Scanner input = new Scanner(System.in);
            deleteTerm = input.nextInt();

            //checks values in file matches ID entered by user
            while (x.hasNext()) {
                int recordID = x.nextInt();
                description = x.next();
                unitPrice = x.nextInt();
                quantity = x.nextInt();
                quantitySold = x.nextInt();
                total = x.nextInt();

                if (recordID == deleteTerm) {
                    // appends the transaction file to add entry in transactions.txt whenever a record is deleted in items.txt
                    try {
                        PrintWriter out = new PrintWriter(file(transactionFile));
                        // variable to store the action performed
                        String deleted = "--Deleted";
                        String formattedDate = date();

                        out.printf("%s %d %s %d %d %d %d %s %n", formattedDate, recordID, description, unitPrice, quantity, quantitySold, total, deleted);
                        out.close();

                    } catch (NoSuchElementException elementException) {
                        System.err.println(error);
                    }
                } else {
                    pw.printf("%d %s %d %d %d %d %n", recordID, description, unitPrice, quantity, quantitySold, total);
                }
            }
            x.close();

            pw.flush();
            pw.close();

            oldFile.delete();
            File dump = new File(itemFile);
            newFile.renameTo(dump);

            Reports.printRecords();

        } catch (SecurityException | IOException | FormatterClosedException e) {
            e.printStackTrace();
            System.out.println("Error message");
        }
    }

    public static void editRecords() {

        int editTerm = 0;
        int newQuantity = -1;
        int newTotal = 0;
        int newQuantitySold = 0;

        Reports.printRecords();

        // temporary file to transfer records from items.txt

        File oldFile = new File(itemFile);
        File newFile = new File(tempFile);
        String description = " ";
        int unitPrice = 0;
        int quantity = 0;
        int quantitySold = 0;
        int total = 0;

        // open file and start appending it.
        try {
            PrintWriter pw = new PrintWriter(file(tempFile));

            // ask for user input to edit the record in the file
            Scanner x = new Scanner(new File(itemFile));

            System.out.println("Enter the Record Number you want to change: \n");
            Scanner input = new Scanner(System.in);
            editTerm = input.nextInt();
            Scanner newInput = new Scanner(System.in);

            while (newQuantity < 0) {
                System.out.println("Enter new quantity: \n");
                newQuantity = newInput.nextInt();
            }

            while (x.hasNext()) {
                int recordID = x.nextInt();
                description = x.next();
                unitPrice = x.nextInt();
                quantity = x.nextInt();
                quantitySold = x.nextInt();
                total = x.nextInt();
                newTotal = unitPrice * newQuantity;
                newQuantitySold = quantity - newQuantity + quantitySold;

                // checks the id if it matches updates the record in temporary file
                if (recordID == editTerm) {
                    // updated the record with details provided above in items.txt file
                    pw.printf("%d %s %d %d %d %d %n", recordID, description, unitPrice, newQuantity, newQuantitySold, newTotal);

                    // appends the activities file to add entry in transactions.txt whenever a
                    // record is edited in items.txt
                    try {
                        PrintWriter out = new PrintWriter(file(transactionFile));
                        // variable to store the action performed
                        String updated = "->Updated";
                        // local time of the system which later add to the transactions.txt
                        String formattedDate = date();

                        out.printf("%s %d %s %d %d %d %d %s %n", formattedDate, recordID, description, unitPrice, newQuantity, newQuantitySold, newTotal, updated);
                        out.close();

                    } catch (NoSuchElementException elementException) {
                        System.err.println(error);
                    }

                } else {
                    pw.printf("%d %s %d %d %d %d %n", recordID, description, unitPrice, quantity, quantitySold, total);
                }
            }
            x.close();

            pw.flush();
            pw.close();

            // deletes the old items.txt file
            oldFile.delete();
            File dump = new File(itemFile);
            // creates a new items.txt file and transfer all the data from temporary to
            // items.txt file
            newFile.renameTo(dump);

            Reports.printReport();

        } catch (SecurityException | IOException | FormatterClosedException e) {
            e.printStackTrace();
            System.out.println("Error message");
        }
    }

    private static String date() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }
    private static FileWriter file(String filename) throws IOException {
        FileWriter output = new FileWriter(filename, true);
        return output;
    }
}