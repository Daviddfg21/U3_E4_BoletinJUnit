package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class FridgeTest {

    @ParameterizedTest
    @CsvSource({
            "articulo1, true",
            "articulo2, true",
            "articulo3, false"
    })
    void testPut(String articulo, boolean esperado) {
        Fridge fridge = new Fridge();
        assertEquals(esperado, fridge.put(articulo));
    }

    @ParameterizedTest
    @ValueSource(strings = {"articulo1", "articulo2", "articulo3"})
    void testContains(String articulo) {
        Fridge fridge = new Fridge();
        fridge.put("articulo1");
        fridge.put("articulo2");
        assertTrue(fridge.contains(articulo));
    }

    @ParameterizedTest
    @CsvSource({
            "articulo1, true",
            "articulo2, true",
            "articulo3, NoSuchItemException"
    })
    void testTake(String articulo, String excepcionEsperada) {
        Fridge fridge = new Fridge();
        fridge.put("articulo1");
        fridge.put("articulo2");

        if (excepcionEsperada.equals("NoSuchItemException")) {
            assertThrows(NoSuchItemException.class, () -> fridge.take(articulo));
        } else {
            assertDoesNotThrow(() -> fridge.take(articulo));
        }
    }
}
