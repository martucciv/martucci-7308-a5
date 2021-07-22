package ucf.assignments;
/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Veronica Martucci
 */
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SortItems {

    public void sortByValue(TableView<AddItems> itemsTableView, TableColumn<AddItems, String> itemsValueColumn){
        //sort the list by value
        itemsTableView.getSortOrder().add(itemsValueColumn);
    }

    public void sortBySerialNumber(TableView<AddItems> itemsTableView, TableColumn<AddItems, String> itemsSNumberColumn){
        //sort the list by serialnumber
        itemsTableView.getSortOrder().add(itemsSNumberColumn);

    }

    public void sortByName(TableView<AddItems> itemsTableView, TableColumn<AddItems, String> itemsNameColumn){
        //sort the list by name
        itemsTableView.getSortOrder().add(itemsNameColumn);
    }

}
