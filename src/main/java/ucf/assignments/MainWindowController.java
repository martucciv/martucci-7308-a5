package ucf.assignments;
/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Veronica Martucci
 */
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable{

    @FXML public TextField nameTextField;
    @FXML public TextField sNumberTextField;
    @FXML public TextField valueTextField;
    @FXML public TextField searchDisplay;
    @FXML public TableView itemsTableView;
    @FXML public TableColumn itemsValueColumn;
    @FXML public TableColumn itemsSNumberColumn;
    @FXML public TableColumn itemsNameColumn;
    @FXML public MenuBar menuBar;
    @FXML  public Menu fileOption;
    @FXML  public Menu helpOption;
    @FXML public MenuItem openMenuItem;
    @FXML public MenuItem saveAsMenuItem;
    @FXML public MenuItem aboutMenuItem;
    @FXML public MenuItem quitMenuItem;

    FileOptions fOption = new FileOptions();

    @Override
    public void initialize(URL url, ResourceBundle rd){

        //if open... is clicked call openButtonClicked()
        openMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                openButtonCLicked();
            }
        });

        //if saveAs... is clicked call saveAllButtonClicked()
        saveAsMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                saveAllButtonClicked();
            }
        });

        //if quit is clicked call quitButtonClicked()
        quitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                quitButtonClicked();
            }
        });
    }

    @FXML
    public void searchButtonClicked(ActionEvent actionEvent) {
        //call methods from SearchItem class
    }

    @FXML
    public void addItemButtonClicked(ActionEvent actionEvent) {
        //call addNewItem() from EditItem class
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


    public void quitButtonClicked(){
        //call quitApp() from FileOptions class
        FileOptions fOption = new FileOptions();

    }

    public void helpMenuButtonClicked(){
        //create a pop up window to show app directions
    }
}
