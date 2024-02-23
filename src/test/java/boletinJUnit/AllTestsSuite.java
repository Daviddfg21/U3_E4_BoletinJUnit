package boletinJUnit;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("Suite de Pruebas")
@SelectClasses({
    BoaTest.class,
    FridgeTest.class,
    OperadorAritmeticoTest.class,
    PilaTest.class,
    SubscripcionTest.class,
    AccountTest.class
})
public class AllTestsSuite {
}

