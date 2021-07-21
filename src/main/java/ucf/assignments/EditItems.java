package ucf.assignments;
/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Veronica Martucci
 */

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

public class EditItems {

    public void removeItem(TableView<AddItems> itemsTableView){
        //remove selected item from the list
        itemsTableView.getItems().removeAll(itemsTableView.getSelectionModel().getSelectedItem());
    }

    public void editValue(TableColumn<AddItems, String> itemsValueColumn){
        //allow user to click on value in the list and change it
        itemsValueColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public void editName(TableColumn<AddItems, String> itemsNameColumn){
        //allow user to click on name in list and change it
        itemsNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public void editSerialNumber(TableColumn<AddItems, String> itemsSNumberColumn){
        //allow user to click on serial number and change it
        itemsSNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }
}

