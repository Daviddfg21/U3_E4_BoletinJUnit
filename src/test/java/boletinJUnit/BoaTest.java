package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BoaTest {

	@ParameterizedTest
	@CsvSource({"boaEspañola, 8, ratones, true",
	            "boaNoSaludable, 15, conejos, false",
	            "boaLímite, 5, ratones, true",
	            "boaLímite2, 20, conejos, false"})
	void testIsHealthy(String name, int length, String favoriteFood, boolean expected) {
	    Boa boa = new Boa(name, length, favoriteFood);
	    assertEquals(expected, boa.isHealthy());
	}

	@ParameterizedTest
	@CsvSource({"boaEnForma, 8, 10, true",
	            "boaNoEnForma, 12, 10, false",
	            "boaLímite, 5, 5, true",
	            "boaLímite2, 20, 15, false"})
	void testFitsInCage(String name, int length, int cageLength, boolean expected) {
	    Boa boa = new Boa(name, length, "comidaVariada");
	    assertEquals(expected, boa.fitsInCage(cageLength));
	}

}

