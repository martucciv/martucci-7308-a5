package ucf.assignments;
/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Veronica Martucci
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

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
    @FXML public Menu fileOption;
    @FXML public Menu helpOption;
    @FXML public MenuItem openMenuItem;
    @FXML public MenuItem saveAsMenuItem;
    @FXML public MenuItem aboutMenuItem;
    @FXML public Menu sortMenu;
    @FXML public MenuItem byValueMenuItem;
    @FXML public MenuItem bySerialNumberMenuItem;
    @FXML public MenuItem byNameMenuItem;

    FileOptions fOption = new FileOptions();
    private final ObservableList<AddItems> item = FXCollections.observableArrayList();
    private final FilteredList<AddItems> filteredData = new FilteredList<>(item, b -> true);

    @Override
    public void initialize(URL url, ResourceBundle rd){

        //if open... in menu is clicked call openButtonClicked()
        openMenuItem.setOnAction(event -> openButtonCLicked());

        //if saveAs... in menu is clicked call saveAllButtonClicked()
        saveAsMenuItem.setOnAction(event -> saveAllButtonClicked());

        //if about in help is clicked
        aboutMenuItem.setOnAction(event -> {
            try {
                helpMenuButtonClicked();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        //if By Value is clicked from Sort menu
        byValueMenuItem.setOnAction(event -> sortByValue());
        //if By Serial Number is clicked from Sort menu
        bySerialNumberMenuItem.setOnAction(event -> sortBySerialNumber());
        //if By name is clicked from Sort menu
        byNameMenuItem.setOnAction(event -> sortByName());

        //set tableview
        itemsValueColumn.setCellValueFactory(new PropertyValueFactory<>("Value"));
        itemsSNumberColumn.setCellValueFactory(new PropertyValueFactory<>("SerialNumber"));
        itemsNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        itemsTableView.setItems(item);

        //allow tableview to be editable
        EditItems ei = new EditItems();
        itemsTableView.setEditable(true);
        //allow value column to be edited
        ei.editValue(itemsValueColumn);
        //allow serial number to be edited
        ei.editSerialNumber(itemsSNumberColumn);
        //allow name to be edited
        ei.editName(itemsNameColumn);
    }

    @FXML
    public void searchButtonClicked() {

        //call methods from SearchItem class
        searchDisplay.textProperty().addListener((observable, oldValue, newValue) -> filteredData.setPredicate(AddItems -> {
           //if text is empty display all items
            if(newValue == null || newValue.isEmpty()){
                return true;
            }

            //Change string to lower case
            String lowerCase = newValue.toLowerCase();

            SearchItem search = new SearchItem();

            //search value column
            if(AddItems.getValue().toLowerCase().contains(lowerCase)){
                return search.searchByValue();
            }
            //else search serial number column
            else if(AddItems.getSerialNumber().toLowerCase().contains(lowerCase)){
                return search.searchBySerialNumber();
            }
            //else search name column
            else if(AddItems.getName().toLowerCase().contains(lowerCase)){
                return search.searchByName();
            }
            //if theres no match
            else{
                return false;
            }
        }));

        //wrap filtered list into a sorted list
        SortedList<AddItems> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(itemsTableView.comparatorProperty());
        itemsTableView.setItems(sortedData);
    }

    @FXML
    public void addItemButtonClicked() throws IOException {
        //call AddItem class
        AddItems ai = new AddItems(valueTextField.getText(), sNumberTextField.getText(), nameTextField.getText());

        //check that item isn't already in the table, then add item
        if(!itemsTableView.getItems().contains(ai)){
            itemsTableView.getItems().add(ai);
        }
       else{
            //create a pop up window to show error
            //if item is already in table, display error scene
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("itemErrorDisplay.fxml")));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
        //clear text fields
        valueTextField.clear();
        sNumberTextField.clear();
        nameTextField.clear();
    }

    @FXML
    public void deleteItemButtonClicked() {
        //delete selected item from list
        EditItems ei = new EditItems();
        ei.removeItem(itemsTableView);
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
        fOption.saveFile(itemsTableView);
    }

    public void helpMenuButtonClicked() throws IOException {
        //create a pop up window to show app directions
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("helpMenu.fxml")));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


    public void valueEditChange(TableColumn.CellEditEvent<AddItems, String> addItemsStringCellEditEvent) {
        //allow value column to be editable
        AddItems valueSelected = itemsTableView.getSelectionModel().getSelectedItem();
        valueSelected.setValue(addItemsStringCellEditEvent.getNewValue());
    }

    public void serialNumberEditChange(TableColumn.CellEditEvent<AddItems, String> addItemsStringCellEditEvent) {
        //allow serial number column to be editable
        AddItems sNumberSelected = itemsTableView.getSelectionModel().getSelectedItem();
        sNumberSelected.setSerialNumber(addItemsStringCellEditEvent.getNewValue());
    }

    public void nameEditChange(TableColumn.CellEditEvent<AddItems, String> addItemsStringCellEditEvent) {
        //allow name column to be editable
        AddItems nameSelected = itemsTableView.getSelectionModel().getSelectedItem();
        nameSelected.setName(addItemsStringCellEditEvent.getNewValue());
    }

    public void sortByValue(){
        //call sortByValue() from SortItems class
        SortItems si = new SortItems();
        si.sortByValue(itemsTableView, itemsValueColumn);
    }

    public void sortBySerialNumber(){
        //call sortBySerialNumber() from SortItems class
        SortItems si = new SortItems();
        si.sortBySerialNumber(itemsTableView, itemsSNumberColumn);
    }

    public void sortByName(){
        //call SortByName() from SortItems class
        SortItems si = new SortItems();
        si.sortByName(itemsTableView, itemsNameColumn);
    }
}
