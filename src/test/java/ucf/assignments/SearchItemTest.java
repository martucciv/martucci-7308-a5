package ucf.assignments;
/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Veronica Martucci
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SearchItemTest {

    @Test
    void searchByValue() {
        SearchItem si = new SearchItem();

        boolean actual = si.searchByValue();
        assertTrue(actual);
    }

    @Test
    void searchByNameTest() {
        SearchItem si = new SearchItem();

        boolean actual = si.searchByName();
        assertTrue(actual);
    }

    @Test
    void searchBySerialNumberTest() {
        SearchItem si = new SearchItem();

        boolean actual = si.searchBySerialNumber();
        assertTrue(actual);
    }
}