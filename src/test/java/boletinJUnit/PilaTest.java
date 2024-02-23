package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PilaTest {

    @Test
    void testPush() {
        Pila pila = new Pila();
        pila.push(5);
        assertFalse(pila.isEmpty());
        assertEquals(5, pila.top());
    }

    @Test
    void testPushConNumeroMenorQue2() {
        Pila pila = new Pila();
        pila.push(1);
        assertTrue(pila.isEmpty());
    }

    @Test
    void testPushConNumeroMayorQue20() {
        Pila pila = new Pila();
        pila.push(25);
        assertTrue(pila.isEmpty());
    }

    @Test
    void testPop() {
        Pila pila = new Pila();
        pila.push(8);
        Integer resultado = pila.pop();
        assertEquals(8, resultado);
        assertTrue(pila.isEmpty());
    }

    @Test
    void testPopConPilaVacia() {
        Pila pila = new Pila();
        assertNull(pila.pop());
        assertTrue(pila.isEmpty());
    }

    @Test
    void testTop() {
        Pila pila = new Pila();
        pila.push(3);
        assertEquals(3, pila.top());
        assertFalse(pila.isEmpty());
    }

    @Test
    void testTopConPilaVacia() {
        Pila pila = new Pila();
        assertNull(pila.top());
        assertTrue(pila.isEmpty());
    }

    @Test
    void testIsEmpty() {
        Pila pila = new Pila();
        assertTrue(pila.isEmpty());
        pila.push(7);
        assertFalse(pila.isEmpty());
    }
}

