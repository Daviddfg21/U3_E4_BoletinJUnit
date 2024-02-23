package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class OperadorAritmeticoTest {

    @Test
    void testSuma() {
        int resultado = OperadorAritmetico.suma(5, 3);
        assertEquals(8, resultado);
    }

    @Test
    void testDivision() throws Exception {
        int resultado = OperadorAritmetico.division(8, 2);
        assertEquals(4, resultado);
    }

    @Test
    void testDivisionPorCero() {
        assertThrows(Exception.class, () -> {
            OperadorAritmetico.division(5, 0);
        });
    }
}

