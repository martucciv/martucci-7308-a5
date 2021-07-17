package ucf.assignments;
/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Veronica Martucci
 */
import javafx.stage.FileChooser;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FileOptions {
   FileChooser fc = new FileChooser();
   private final Desktop desktop = Desktop.getDesktop();

   public void saveFile(){
      //create file chooser to save a file
      fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("TSV", "*.*"));
      fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML", "*.*"));
      fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON", "*.*"));
      fc.showSaveDialog(null);
      //if TSV is selected call saveAsTSV()
      //else if HTML is selected call saveAsHTML()
      //else if JSON is selected call saveAsJSON()
   }

   public void saveAsTSV(){
      //save as a TSV file

   }

   public void saveAsHTML(){
      //save as an HTML file
   }

   public void saveAsJSON(){
      //save as a JSON file
   }

   public void openFile() throws IOException {
      //create a file chooser to open a file
      File selectedFile = fc.showOpenDialog(null);

      if(selectedFile != null){
         desktop.open(selectedFile);
      }
   }
}
