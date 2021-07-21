package ucf.assignments;
/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Veronica Martucci
 */
import javafx.beans.property.SimpleStringProperty;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;

class AddItemsTest {

    public final SimpleStringProperty value;
    public final SimpleStringProperty serialNumber;
    public final SimpleStringProperty itemName;

    public AddItemsTest(String val, String sNumber, String name){
        this.value = new SimpleStringProperty(val);
        this.serialNumber = new SimpleStringProperty(sNumber);
        this.itemName = new SimpleStringProperty(name);
    }

    @Test
    public void testValueGetter_getsValue(String val, String sNumber, String name) throws NoSuchFieldException, IllegalAccessException {
        //given
        AddItems ai = new AddItems(val, sNumber, name);
        Field field = ai.getClass().getDeclaredField("Value");
        field.set(ai, "$3.00");

        //when
        String actual = ai.getValue();
        //then
        assertEquals("$3.00", actual, "$3.00");
    }

    @Test
    public void testValueSetter_setsValue(String val, String sNumber, String name) throws NoSuchFieldException, IllegalAccessException {
        //given
        AddItems ai = new AddItems(val, sNumber, name);
        //when
        ai.setValue("$3.00");
        //then
        Field field = ai.getClass().getDeclaredField("Value");
        field.setAccessible(true);
        assertEquals(field.get(ai), true, "$3.00");
    }

    @Test
    public void testSerialNumberGetter_getsSerialNumber(String val, String sNumber, String name) throws NoSuchFieldException, IllegalAccessException {
        //given
        AddItems ai = new AddItems(val, sNumber, name);
        Field field = ai.getClass().getDeclaredField("SerialNumber");
        field.set(ai, "AV4RU63M96");

        //when
        String actual = ai.getValue();
        //then
        assertEquals("AV4RU63M96", actual, "AV4RU63M96");
    }

    @Test
    public void testSerialNumberSetter(String val, String sNumber, String name) throws NoSuchFieldException, IllegalAccessException {
        //given
        AddItems ai = new AddItems(val, sNumber, name);
        //when
        ai.setValue("AV4RU63M96");
        //then
        Field field = ai.getClass().getDeclaredField("SerialNumber");
        field.setAccessible(true);
        assertEquals(field.get(ai), true, "AV4RU63M96");
    }

    @Test
    public void testNameGetter_getsName(String val, String sNumber, String name) throws NoSuchFieldException, IllegalAccessException {
        //given
        AddItems ai = new AddItems(val, sNumber, name);
        Field field = ai.getClass().getDeclaredField("name");
        field.set(ai, "book");

        //when
        String actual = ai.getValue();
        //then
        assertEquals("book", actual, "book");
    }

    @Test
    public void testNameSetter(String val, String sNumber, String name) throws NoSuchFieldException, IllegalAccessException {
        //given
        AddItems ai = new AddItems(val, sNumber, name);
        //when
        ai.setValue("book");
        //then
        Field field = ai.getClass().getDeclaredField("name");
        field.setAccessible(true);
        assertEquals(field.get(ai), true, "book");
    }
}