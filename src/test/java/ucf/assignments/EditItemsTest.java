package ucf.assignments;
/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Veronica Martucci
 */
import javafx.scene.control.TableColumn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditItemsTest {


    @Test
    void editValueTest_valueIsEditable() {
        EditItems ei = new EditItems();
        TableColumn<AddItems, String> itemsValueColumn = null;

        assert false;
        ei.editValue(itemsValueColumn);
    }

    @Test
    void editNameTest() {
        EditItems ei = new EditItems();
        TableColumn<AddItems, String> itemsSNumberColumn = null;

        assert false;
        ei.editSerialNumber(itemsSNumberColumn);
    }

    @Test
    void editSerialNumberTest() {
        EditItems ei = new EditItems();
        TableColumn<AddItems, String> itemsNameColumn = null;

        assert false;
        ei.editName(itemsNameColumn);
    }
}