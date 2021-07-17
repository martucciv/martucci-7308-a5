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
    @FXML public TableColumn itemsValueColumn;
    @FXML public TableColumn itemsSNumberColumn;
    @FXML public TableColumn itemsNameColumn;
    @FXML public MenuBar menuBar;
    @FXML  public Menu fileOption;
    @FXML  public Menu helpOption;
    @FXML public MenuItem openMenuItem;
    @FXML public MenuItem saveAsMenuItem;
    @FXML public MenuItem aboutMenuItem;

    FileOptions fOption = new FileOptions();

    @Override
    public void initialize(URL url, ResourceBundle rd){

        //if open... is clicked call openButtonClicked()
        openMenuItem.setOnAction(event -> openButtonCLicked());

        //if saveAs... is clicked call saveAllButtonClicked()
        saveAsMenuItem.setOnAction(event -> saveAllButtonClicked());
    }

    @FXML
    public void searchButtonClicked(ActionEvent actionEvent) {
        //call methods from SearchItem class

    }

    private final ObservableList<AddItems> item = FXCollections.observableArrayList();
   // TableView<EditItems> table = new TableView<>();

    @FXML
    public void addItemButtonClicked(ActionEvent actionEvent) {
        //call addNewItem() from EditItem class

        item.add(new AddItems(valueTextField.getText(),sNumberTextField.getText(), nameTextField.getText()));
        valueTextField.clear();
        sNumberTextField.clear();
        nameTextField.clear();
    }

    @FXML
    public void deleteItemButtonClicked(ActionEvent actionEvent) {
        //call removeItem() from EditItem class
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


}
