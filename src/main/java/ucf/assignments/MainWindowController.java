package ucf.assignments;
/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Veronica Martucci
 */

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class MainWindowController {

    public TextField nameTextField;
    public TextField sNumberTextField;
    public TextField valueTextField;
    public TextField searchDisplay;
    public TableView itemsTableView;
    public TableColumn itemsValueColumn;
    public TableColumn itemsSNumberColumn;
    public TableColumn itemsNameColumn;
    public MenuBar menuBar;
    public Menu fileOption;
    public Menu helpOption;
    public MenuItem openMenuItem;
    public MenuItem saveAsMenuItem;

    public void searchButtonClicked(ActionEvent actionEvent) {
        //call methods from SearchItem class
    }

    public void addItemButtonClicked(ActionEvent actionEvent) {
        //call addNewItem() from EditItem class
    }

    public void deleteItemButtonClicked(ActionEvent actionEvent) {
        //call removeItem() from EditItem class
    }

    public void fileMenuButtonCLicked(){
        //create filechooser
        //if open... is clicked call openFile() from FileOptions class
        //else if saveAll.. is clicked call saveFile() from FileOptions class

    }

    public void helpMenuButtonClicked(){
        //create a pop up window to show app directions
    }
}
