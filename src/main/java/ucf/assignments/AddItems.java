package ucf.assignments;
/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Veronica Martucci
 */
import javafx.beans.property.SimpleStringProperty;

public class AddItems {
    public final SimpleStringProperty value;
    public final SimpleStringProperty serialNumber;
    public final SimpleStringProperty itemName;

    public AddItems(String val, String sNumber, String name){
        this.value = new SimpleStringProperty(val);
        this.serialNumber = new SimpleStringProperty(sNumber);
        this.itemName = new SimpleStringProperty(name);
    }

    public String getValue(){
        //get value item from user
        return value.get();
    }

    public void setValue(String val){
        //set value
        value.set(val);
    }

    public String getSerialNumber(){
        //get serial number
        return serialNumber.get();
    }

    public void setSerialNumber(String sNumber){
        //set serial number
        serialNumber.set(sNumber);
    }

    public String getName(){
        //get name
        return itemName.get();
    }

    public void setName(String name){
        //set name
        itemName.set(name);
    }
}

