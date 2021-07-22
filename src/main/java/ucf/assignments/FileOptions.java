package ucf.assignments;
/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Veronica Martucci
 */
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FileOptions {
   FileChooser fc = new FileChooser();
   private final Desktop desktop = Desktop.getDesktop();

   public void saveFile(TableView<AddItems> itemsTableView){
      //create file chooser to save a file
      fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("TSV", "*.txt"));
      fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML", "*.html"));
      fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON", "*.json"));
      File file = fc.showSaveDialog(null);

      String filePath = file.getAbsolutePath();

      FileChooser.ExtensionFilter fileSaveOption = fc.getSelectedExtensionFilter();
      //if TSV is selected call saveAsTSV()
      saveAsJSON(itemsTableView);
      //else if HTML is selected call saveAsHTML()
      //else if JSON is selected call saveAsJSON()
   }

  /* public void readTableViewData(TableView<AddItems> itemsTableView){
      AddItems items =  new AddItems();
      for(int i = 0; i < itemsTableView.getItems().size();i++){
         items = itemsTableView.getItems().get(i);

      }
   }*/

   public void saveAsTSV(TableView<AddItems> itemsTableView) throws IOException {
      //save as a TSV file
/*
      FileWriter fileWriter = new FileWriter("*.txt");
      PrintWriter printWriter = new PrintWriter(fileWriter);
      printWriter.println("Value\tSerial Number\tName");

      for(int i = 0; i < itemsTableView.getItems().size(); i++){
         printWriter.print()
      }
*/


   }

   public void saveAsHTML(){
      //save as an HTML file

   }

   public void saveAsJSON(TableView<AddItems> itemsTableView){
      //save as a JSON file
      JsonArray array = new JsonArray();
      JsonArray tableItems = new JsonArray();
      for(int i=0; i<itemsTableView.getItems().size(); i++){
         JsonObject item = new JsonObject();
         ObservableList<AddItems> info = itemsTableView.getItems();
         item.addProperty("Value", info.get(i).getValue());
         item.addProperty("SerialNumber", info.get(i).getSerialNumber());
         item.addProperty("Name", info.get(i).getName());
         tableItems.add(item);
      }
      array.add(tableItems);

   }

   public void openFile() throws IOException {
      //create a file chooser to open a file
      File selectedFile = fc.showOpenDialog(null);

      if(selectedFile != null){
         desktop.open(selectedFile);
      }
   }
}
