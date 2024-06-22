import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class FactorialTest extends Assert{
    @Test(description = "Позитивный тест с аргументом 5", groups = "Smoke")
    public void factorialSmokePositiveTest(){
        assertEquals(Factorial.factorial(5),120);
    }

    @Test(dataProvider = "positiveParameters", dataProviderClass = FactorialTestData.class,
            description = "Параметры из позитивного класса эквивалентности", groups = "sanity")
    public void factorialFullPositiveTest(int input, int expected){
        assertEquals(expected, Factorial.factorial(input));
    }

    @Test(dataProvider = "negativeParameters", dataProviderClass = FactorialTestData.class,
            description = "Параметры из негативного класса эквивалентности",
            expectedExceptions = IllegalArgumentException.class, groups = "sanity")
    public void factorialFullNegativeTest(int input){
        Factorial.factorial(input);
    }

    /*
    //Отдельно оформленные негативные тесты
    @Test(description = "Проверка работы метода при отрицательном аргументе -1")
    public void factorialNegativeTest(){
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-1));
    }
    @Test(description = "Проверка работы метода при аргументе, дающем результат больше диапазона значений int")
    public void factorialBigResultTest(){
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(13));
    }
    */

}

