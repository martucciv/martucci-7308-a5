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
import java.io.*;

public class FileOptions {
   FileChooser fc = new FileChooser();
   private final Desktop desktop = Desktop.getDesktop();

   public void saveFile(TableView<AddItems> itemsTableView,javafx.stage.Window window ) throws IOException {
      //create file chooser to save a file
      fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("TSV", "*.txt"));
      fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML", "*.html"));
      fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON", "*.json"));
      File file = fc.showSaveDialog(window);

      String filePath = file.getAbsolutePath();
      FileChooser.ExtensionFilter fileSaveOption = fc.getSelectedExtensionFilter();

      //if TSV is selected call saveAsTSV()
      if(fileSaveOption.getDescription().equals("TSV")){
         saveAsTSV(file, itemsTableView);
      }
      //else if HTML is selected call saveAsHTML()
      else if(fileSaveOption.getDescription().equals("HTML")){
         saveAsHTML(file,  itemsTableView);
      }
      //else call saveAsJSON()
      else{
         saveAsJSON( itemsTableView);
      }
   }

   public void saveAsTSV(File file, TableView<AddItems> itemsTableView) throws IOException {
      //save as a TSV file
      FileOutputStream fos = new FileOutputStream(file);
      PrintStream ps = new PrintStream(fos);

      ps.println("Value\tSerial Number\tName");
      for (AddItems item : itemsTableView.getItems()) {
         ps.println(item.getValue()+ "\t" +item.getSerialNumber() +"\t" +item.getName());
      }
      ps.close();
   }

   public void saveAsHTML(File file, TableView<AddItems> itemsTableView) throws IOException {
      //save as an HTML file
      FileOutputStream fos = new FileOutputStream(file);
      PrintStream ps = new PrintStream(fos);

      ps.println("<html lang=\"en\">");
      for (AddItems item : itemsTableView.getItems()) {
          //  ps.println("<p> </p>");
            ps.println(item.getValue()+ "\t" +item.getSerialNumber() +"\t" +item.getName());
      }
      ps.println("</html>");

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
