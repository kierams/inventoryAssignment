/**
 * Sample Skeleton for 'hello-view.fxml' Controller Class
 */

package com.example.assignmentgui2;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class HelloController implements Initializable {
    //private TableView<Item> table_Records;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            table_Records();
        } catch (Exception e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private TableView<Item>table_Records;

    @FXML // fx:id="columnDate"
    private TableColumn<? ,?> columnDate; // Value injected by FXMLLoader

    @FXML // fx:id="columnDescription"
    private TableColumn<Item, String> columnDescription; // Value injected by FXMLLoader

    @FXML // fx:id="columnDescription1"
    private TableColumn<?, ?> columnDescription1; // Value injected by FXMLLoader

    @FXML // fx:id="columnId"
    private TableColumn<Item, String> columnId; // Value injected by FXMLLoader

    @FXML // fx:id="columnId1"
    private TableColumn<?, ?> columnId1; // Value injected by FXMLLoader

    @FXML // fx:id="columnPrice"
    private TableColumn<Item, String> columnPrice; // Value injected by FXMLLoader

    @FXML // fx:id="columnPrice1"
    private TableColumn<?, ?> columnPrice1; // Value injected by FXMLLoader

    @FXML // fx:id="columnQuantity"
    private TableColumn<Item, String> columnQuantity; // Value injected by FXMLLoader

    @FXML // fx:id="columnQuantityRemaining1"
    private TableColumn<?, ?> columnQuantityRemaining1; // Value injected by FXMLLoader

    @FXML // fx:id="columnQuantitySold"
    private TableColumn<Item, String> columnQuantitySold; // Value injected by FXMLLoader

    @FXML // fx:id="columnQuantitySold1"
    private TableColumn<?, ?> columnQuantitySold1; // Value injected by FXMLLoader

    @FXML // fx:id="columnReason"
    private TableColumn<?, ?> columnReason; // Value injected by FXMLLoader

    @FXML // fx:id="columnTotal"
    private TableColumn<Item, String> columnTotal; // Value injected by FXMLLoader

    @FXML // fx:id="columnTotal1"
    private TableColumn<?, ?> columnTotal1; // Value injected by FXMLLoader

    //@FXML
    //private TableView<Item> itemTable;

    //@FXML
    //private TableView<Item> reportTable;

    @FXML // fx:id="tltAddDescription"
    private Label tltAddDescription; // Value injected by FXMLLoader

    @FXML // fx:id="tltAddItem"
    private Label tltAddItem; // Value injected by FXMLLoader

    @FXML // fx:id="tltAddQuantity"
    private Label tltAddQuantity; // Value injected by FXMLLoader

    @FXML // fx:id="tltAddprice"
    private Label tltAddprice; // Value injected by FXMLLoader

    @FXML // fx:id="tltDeleteRecord"
    private Label tltDeleteRecord; // Value injected by FXMLLoader

    @FXML // fx:id="tltIdDelete"
    private Label tltIdDelete; // Value injected by FXMLLoader

    @FXML // fx:id="tltIdUpdate"
    private Label tltIdUpdate; // Value injected by FXMLLoader

    @FXML // fx:id="tltQuantityUpdate"
    private Label tltQuantityUpdate; // Value injected by FXMLLoader

    @FXML // fx:id="tltUpdateItem"
    private Label tltUpdateItem; // Value injected by FXMLLoader

    @FXML // fx:id="txtAddDescription"
    private TextField txtAddDescription; // Value injected by FXMLLoader

    @FXML // fx:id="txtAddPrice"
    private TextField txtAddPrice; // Value injected by FXMLLoader

    @FXML // fx:id="txtAddQuantity"
    private TextField txtAddQuantity; // Value injected by FXMLLoader

    @FXML // fx:id="txtDeleteId"
    private TextField txtDeleteId; // Value injected by FXMLLoader

    @FXML // fx:id="txtIdUpdate"
    private TextField txtIdUpdate; // Value injected by FXMLLoader

    @FXML // fx:id="txtQuantityUpdate"
    private TextField txtQuantityUpdate; // Value injected by FXMLLoader

    @FXML // fx:id="welcomeText"
    private Label welcomeText; // Value injected by FXMLLoader

    @FXML
    void addRecord(ActionEvent event) {
        //String studentID, firstName, lastName, marks;

        /*String description = txtAddDescription.getText();
        int quantity = Integer.valueOf(txtAddQuantity.getText());
        int price = Integer.valueOf(txtAddPrice.getText());
        int ID = 0;
        int total = 0;
        int quantitySold = 0;
        total=quantity*price;*/
        String description = txtAddDescription.getText();
        String quantity = txtAddQuantity.getText();
        String price = txtAddPrice.getText();
        //String ID = "0";
        String total = "0";
        String quantitySold = "0";
        int quanNum=Integer.valueOf(quantity);
        int priceNum=Integer.valueOf(price);
        total=String.valueOf(quanNum*priceNum);

        int ID=0;
        try (Scanner rf = new Scanner(Paths.get("items.txt")))
        {
            /*while (rf.hasNext()) {
                int recordID = rf.nextInt(); // ID
                rf.next(); // description
                rf.nextInt(); // price
                rf.nextInt(); // quantity
                rf.nextInt();
                rf.nextInt(); // total
                ID = recordID;*/
            while (rf.hasNext()) {
                int recordID = rf.nextInt(); // ID
                rf.next(); // description
                rf.next(); // price
                rf.next(); // quantity
                rf.next();
                rf.next(); // total
                ID = recordID;

            }
            rf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            FileWriter output = new FileWriter("items.txt", true);
            PrintWriter out = new PrintWriter(output);
            //out.format("%05d %s %d %d %d %d %n", ++ID, description, price, quantity, quantitySold, total);
            out.format("%05d %s %s %s %s %s %n", ++ID, description, price, quantity, quantitySold, total);

            out.close();
            output.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Inventory System");
            alert.setHeaderText("Add New Item In Inventory System");
            alert.setContentText("New Item Added!");
            alert.showAndWait();

            txtAddDescription.setText("");
            txtAddQuantity.setText("");
            txtAddPrice.setText("");
        }catch(Exception e) {
            e.printStackTrace();
    }}

    //@FXML
    //private TableView<Item> table;
    @FXML
    public void table_Records() {
        ObservableList<Item>items = FXCollections.observableArrayList();

        try {
            FileReader input = new FileReader("items.txt");
            BufferedReader br = new BufferedReader(input);
            String data[];
            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                data = currentLine.split(" ");
                System.out.println("current line="+currentLine);
                Item it = new Item();
                it.setId(data[0]);
                it.setDescription(data[1]);
                it.setPrice(data[2]);
                it.setQuantity(data[3]);
                it.setQuantitySold(data[4]);
                it.setTotal(data[5]);
                System.out.println("data array="+data[0]);
                System.out.println("data array="+data[1]);
                System.out.println("data array="+data[2]);
                System.out.println("data array="+data[3]);
                System.out.println("data array="+data[4]);
                System.out.println("data array="+data[5]);

                items.add(it);
                System.out.println("it="+it);}

            table_Records.setItems(items);
            columnId.setCellValueFactory(f -> f.getValue().idProperty());
            System.out.println("id"+columnId);
            columnDescription.setCellValueFactory(f -> f.getValue().descriptionProperty());
            columnPrice.setCellValueFactory(f -> f.getValue().priceProperty());
            columnQuantity.setCellValueFactory(f -> f.getValue().quantityProperty());
            columnQuantitySold.setCellValueFactory(f -> f.getValue().quantitySoldProperty());
            columnTotal.setCellValueFactory(f -> f.getValue().totalProperty());

            input.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
/*
                Item it = new Item();
                it.setId(data[0]);
                it.setDescription(data[1]);
                it.setPrice(data[2]);
                it.setQuantity(data[3]);
                it.setQuantitySold(data[4]);
                it.setTotal(data[5]);
                items.add(it);
            }


            //TableView<Item> table_Records;
            table_Records.setItems(items);
            columnId.setCellValueFactory(f -> f.getValue().idProperty());
            columnDescription.setCellValueFactory(f -> f.getValue().descriptionProperty());
            columnPrice.setCellValueFactory(f -> f.getValue().priceProperty());
            columnQuantity.setCellValueFactory(f -> f.getValue().quantityProperty());
            columnQuantitySold.setCellValueFactory(f -> f.getValue().quantitySoldProperty());
            columnTotal.setCellValueFactory(f -> f.getValue().totalProperty());

                input.close();
            }catch (NoSuchElementException | IllegalStateException e) {
                e.printStackTrace();
            //} catch (FileNotFoundException e) {
            //throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/

    @FXML
    void close(ActionEvent event) {

    }

    @FXML
    void itemDelete(ActionEvent event) {

        String filepath = "items.txt";
        String tempFile = "temp1.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);

        //taking a string and storing as integer
        int id = Integer.parseInt(txtDeleteId.getText());

        try {
            FileWriter fw = new FileWriter(tempFile, true);
            PrintWriter pw = new PrintWriter(fw);
            Scanner x = new Scanner(new File(filepath));
            while (x.hasNext()) {
                int recordID = x.nextInt();
                String description = x.next();
                /*int price = x.nextInt();
                int quantity = x.nextInt();
                int quantitySold= x.nextInt();
                int total= x.nextInt();*/
                String price = x.next();
                String quantity = x.next();
                String quantitySold= x.next();
                String total= x.next();
                //quantitySold=quantity-newQuantity+quantitySold;
                //total=newQuantity*price;
                if (recordID == id) {
                    } else {
                    /*pw.printf("%05d %s %d %d %d %d %n", recordID, description, price, quantity, quantitySold, total*/
                    pw.printf("%05d %s %s %s %s %s %n", recordID, description, price, quantity, quantitySold, total);
                }
            }
            x.close();
            pw.flush();
            pw.close();

            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Inventory System");
            alert.setHeaderText("Delete Inventory System");
            alert.setContentText("Inventory System deleted!");
            alert.showAndWait();

            table_Records();
            txtDeleteId.setText("");
        } catch (SecurityException | IOException | FormatterClosedException e) {
            e.printStackTrace();
            System.out.println("Error message");
        }
    }

    @FXML
    void updateItem(ActionEvent event) {
        String filepath = "items.txt";
        String tempFile = "temp1.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);

        //taking a string and storing as integer
        int id = Integer.parseInt(txtIdUpdate.getText());
//taking new marks from user
        /*int newQuantity = Integer.valueOf(txtQuantityUpdate.getText());*/
        String newQuantity = txtQuantityUpdate.getText();

        try {
            FileWriter fw = new FileWriter(tempFile, true);
            PrintWriter pw = new PrintWriter(fw);
            Scanner x = new Scanner(new File(filepath));
            while (x.hasNext()) {
                int recordID = x.nextInt();
                String description = x.next();

                /*
                int price = x.nextInt();
                int quantity = x.nextInt();
                int quantitySold= x.nextInt();
                int total= x.nextInt();
                quantitySold=quantity-newQuantity+quantitySold;
                total=newQuantity*price;
                */

                String price = x.next();
                String quantity = x.next();
                String quantitySold= x.next();
                String total= x.next();
                quantitySold=String.valueOf(Integer.valueOf(quantity)-Integer.valueOf(newQuantity)+Integer.valueOf(quantitySold));
                total=String.valueOf(Integer.valueOf(newQuantity)*Integer.valueOf(price));
                /*if (recordID == id) {
                    pw.printf("%05d %s %d %d %d %d %n", recordID, description, price, newQuantity, quantitySold, total);
                } else {
                    pw.printf("%05d %s %d %d %d %d %n", recordID, description, price, quantity, quantitySold, total);*/
                if (recordID == id) {
                    pw.printf("%05d %s %s %s %s %s %n", recordID, description, price, newQuantity, quantitySold, total);
                } else {
                    pw.printf("%05d %s %s %s %s %s %n", recordID, description, price, quantity, quantitySold, total);
                }
            }
            x.close();
            pw.flush();
            pw.close();

            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Inventory System");
            alert.setHeaderText("Update Inventory System");
            alert.setContentText("Inventory System Updated!");
            alert.showAndWait();

            table_Records();
            txtIdUpdate.setText("");
            txtQuantityUpdate.setText("");
        } catch (SecurityException | IOException | FormatterClosedException e) {
            e.printStackTrace();
            System.out.println("Error message");
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert columnDate != null : "fx:id=\"columnDate\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert columnDescription != null : "fx:id=\"columnDescription\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert columnDescription1 != null : "fx:id=\"columnDescription1\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert columnId != null : "fx:id=\"columnId\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert columnId1 != null : "fx:id=\"columnId1\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert columnPrice != null : "fx:id=\"columnPrice\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert columnPrice1 != null : "fx:id=\"columnPrice1\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert columnQuantity != null : "fx:id=\"columnQuantity\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert columnQuantityRemaining1 != null : "fx:id=\"columnQuantityRemaining1\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert columnQuantitySold != null : "fx:id=\"columnQuantitySold\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert columnQuantitySold1 != null : "fx:id=\"columnQuantitySold1\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert columnReason != null : "fx:id=\"columnReason\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert columnTotal != null : "fx:id=\"columnTotal\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert columnTotal1 != null : "fx:id=\"columnTotal1\" was not injected: check your FXML file 'hello-view.fxml'.";
        //assert itemTable != null : "fx:id=\"itemTable\" was not injected: check your FXML file 'hello-view.fxml'.";
        //assert reportTable != null : "fx:id=\"reportTable\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert tltAddDescription != null : "fx:id=\"tltAddDescription\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert tltAddItem != null : "fx:id=\"tltAddItem\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert tltAddQuantity != null : "fx:id=\"tltAddQuantity\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert tltAddprice != null : "fx:id=\"tltAddprice\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert tltDeleteRecord != null : "fx:id=\"tltDeleteRecord\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert tltIdDelete != null : "fx:id=\"tltIdDelete\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert tltIdUpdate != null : "fx:id=\"tltIdUpdate\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert tltQuantityUpdate != null : "fx:id=\"tltQuantityUpdate\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert tltUpdateItem != null : "fx:id=\"tltUpdateItem\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtAddDescription != null : "fx:id=\"txtAddDescription\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtAddPrice != null : "fx:id=\"txtAddPrice\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtAddQuantity != null : "fx:id=\"txtAddQuantity\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtDeleteId != null : "fx:id=\"txtDeleteId\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtIdUpdate != null : "fx:id=\"txtIdUpdate\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtQuantityUpdate != null : "fx:id=\"txtQuantityUpdate\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert welcomeText != null : "fx:id=\"welcomeText\" was not injected: check your FXML file 'hello-view.fxml'.";

    }

}
