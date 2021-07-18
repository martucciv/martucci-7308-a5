package ucf.assignments;
/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Veronica Martucci
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class MainWindowController implements Initializable{

    @FXML public TextField nameTextField;
    @FXML public TextField sNumberTextField;
    @FXML public TextField valueTextField;
    @FXML public TextField searchDisplay;
    @FXML public TableView<AddItems> itemsTableView;
    @FXML public TableColumn<AddItems, String> itemsValueColumn;
    @FXML public TableColumn<AddItems, String> itemsSNumberColumn;
    @FXML public TableColumn<AddItems, String> itemsNameColumn;
    @FXML public MenuBar menuBar;
    @FXML  public Menu fileOption;
    @FXML  public Menu helpOption;
    @FXML public MenuItem openMenuItem;
    @FXML public MenuItem saveAsMenuItem;
    @FXML public MenuItem aboutMenuItem;

    FileOptions fOption = new FileOptions();

    @Override
    public void initialize(URL url, ResourceBundle rd){

        //if open... in menu is clicked call openButtonClicked()
        openMenuItem.setOnAction(event -> openButtonCLicked());

        //if saveAs... in menu is clicked call saveAllButtonClicked()
        saveAsMenuItem.setOnAction(event -> saveAllButtonClicked());

        //set tableview
        itemsValueColumn.setCellValueFactory(new PropertyValueFactory<>("Value"));
        itemsSNumberColumn.setCellValueFactory(new PropertyValueFactory<>("SerialNumber"));
        itemsNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        itemsTableView.setItems(item);

        //allow value column to be edited
        itemsTableView.setEditable(true);
        itemsValueColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        //allow serial number to be edited
        itemsSNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        //allow name to be edited
        itemsNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    @FXML
    public void searchButtonClicked(ActionEvent actionEvent) {
        //call methods from SearchItem class

    }

    private final ObservableList<AddItems> item = FXCollections.observableArrayList();
   // TableView<EditItems> table = new TableView<>();

    @FXML
    public void addItemButtonClicked(ActionEvent actionEvent) {
        //call AddItem class
        AddItems ai = new AddItems(valueTextField.getText(), sNumberTextField.getText(), nameTextField.getText());
        itemsTableView.getItems().add(ai);
        valueTextField.clear();
        sNumberTextField.clear();
        nameTextField.clear();
    }

    @FXML
    public void deleteItemButtonClicked(ActionEvent actionEvent) {
        //delete selected item from list
        itemsTableView.getItems().removeAll(itemsTableView.getSelectionModel().getSelectedItem());
    }

    public void openButtonCLicked(){
        //call openFile() from FileOptions class

        try{
            fOption.openFile();
        }
        catch(IOException e){
            System.out.println("cannot open file");
        }
    }

    public void saveAllButtonClicked(){
        //call saveFile() from FileOptions class
        fOption.saveFile();
    }

    public void helpMenuButtonClicked(){
        //create a pop up window to show app directions
    }


    public void valueEditChange(TableColumn.CellEditEvent<AddItems, String> addItemsStringCellEditEvent) {
        AddItems valueSelected = itemsTableView.getSelectionModel().getSelectedItem();
        valueSelected.setValue(addItemsStringCellEditEvent.getNewValue());
    }

    public void serialNumberEditChange(TableColumn.CellEditEvent<AddItems, String> addItemsStringCellEditEvent) {
        AddItems sNumberSelected = itemsTableView.getSelectionModel().getSelectedItem();
        sNumberSelected.setSerialNumber(addItemsStringCellEditEvent.getNewValue());
    }

    public void nameEditChange(TableColumn.CellEditEvent<AddItems, String> addItemsStringCellEditEvent) {
        AddItems nameSelected = itemsTableView.getSelectionModel().getSelectedItem();
        nameSelected.setName(addItemsStringCellEditEvent.getNewValue());
    }
}
