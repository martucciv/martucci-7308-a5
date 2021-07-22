package ucf.assignments;
/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Veronica Martucci
 */
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortItemsTest {

    SortItems si = new SortItems();

    TableView<AddItems> itemsTableView;
    TableColumn<AddItems, String> itemsValueColumn;
    TableColumn<AddItems, String> itemsNameColumn;
    TableColumn<AddItems, String> itemsSNumberColumn;

    @Test
    void sortByValue() {

        si.sortByValue(itemsTableView, itemsValueColumn);
    }

    @Test
    void sortByName() {

        si.sortByName(itemsTableView, itemsNameColumn);

    }

    @Test
    void sortBySerialNumber() {

        si.sortBySerialNumber(itemsTableView, itemsSNumberColumn);
    }
}