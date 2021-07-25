package ucf.assignments;

import javafx.scene.control.TableView;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileOptionsTest {

    FileOptions fo = new FileOptions();

    TableView<AddItems> itemsTableView;
    File file;

    @Test
    void saveAsTSVTest() throws IOException {
        fo.saveAsTSV(file,itemsTableView);
    }

    @Test
    void saveAsHTMLTest() throws IOException {
        fo.saveAsHTML(file, itemsTableView);
    }

    @Test
    void saveAsJSONTest() {
        fo.saveAsJSON(itemsTableView);
    }

    @Test
    void openFileTest() throws IOException {
        fo.openFile();
    }
}