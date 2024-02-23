package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

class SubscripcionTest {

    @Test
    void testPrecioPorMes() {
        Subscripcion subscripcion = new Subscripcion(1200, 12);
        assertThat(subscripcion.precioPorMes(), is(closeTo(100.0, 0.01)));
    }

    @Test
    void testCancel() {
        Subscripcion subscripcion = new Subscripcion(1200, 12);
        subscripcion.cancel();
        assertThat(subscripcion.precioPorMes(), is(equalTo(0.0)));
    }

    @Test
    void testPrecioPorMesConPeriodoCero() {
        Subscripcion subscripcion = new Subscripcion(1200, 0);
        assertThat(subscripcion.precioPorMes(), is(equalTo(0.0)));
    }

    @Test
    void testPrecioPorMesConPrecioCero() {
        Subscripcion subscripcion = new Subscripcion(0, 12);
        assertThat(subscripcion.precioPorMes(), is(equalTo(0.0)));
    }
}

