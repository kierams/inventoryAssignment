package com.example.assignmentgui2;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.net.URL;
import java.util.ResourceBundle;

public class Item {

    /// STEP 4.10
    /*@Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            table_Records();
        } catch (Exception e) {
 TODO Auto-generated catch block
            e.printStackTrace();      }
    }
    */

    private final StringProperty id;
    private final StringProperty description;
    private final StringProperty price;
    private final StringProperty quantity;
    private final StringProperty quantitySold;
    private final StringProperty total;

    public Item(){
        id = new SimpleStringProperty(this, "id");
        description = new SimpleStringProperty(this, "description");
        price = new SimpleStringProperty(this, "price");
        quantity = new SimpleStringProperty(this, "quantity");
        quantitySold = new SimpleStringProperty(this, "quantitySold");
        total = new SimpleStringProperty(this, "total");
    }




    // the method reads id from files and stores
    public void setId(String newId) { id.set(newId); }
    // the id stored is returned to be displayed in table columns by using
    //following method
    public StringProperty idProperty() { return id; }
    // all these following methods works same as methods explained above
    public void setDescription(String newDescription){description.set(newDescription);}
    public StringProperty descriptionProperty() { return description; }
    public void setPrice(String newPrice){price.set(newPrice);}
    public StringProperty priceProperty() { return price; }/////
    public void setQuantity(String newQuantity) { quantity.set(newQuantity); }
    public StringProperty quantityProperty() { return quantity; }
    public void setQuantitySold(String newQuantitySold) { quantitySold.set(newQuantitySold); }
    public StringProperty quantitySoldProperty() {return quantitySold; }

    public void setTotal(String newTotal) { total.set(newTotal); }
    public StringProperty totalProperty() {return total;}



    }//}
    /*
/// STEP 4.10
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            table_Records();
        } catch (Exception e) {
// TODO Auto-generated catch block
            e.printStackTrace();      }
        }*/

