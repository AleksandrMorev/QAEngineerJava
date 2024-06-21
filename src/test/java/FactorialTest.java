import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class FactorialTest {
    @Test(description = "Позитивный тест с аргументом 5")
    public void factorialPositiveTest(){
        Assert.assertEquals(Factorial.factorial(5),120);
    }
    @Test(description = "Проверка работы метода при нулевом аргументе")
    public void factorialZeroTest(){
        Assert.assertEquals(1, Factorial.factorial(0));
    }
    @Test(description = "Проверка работы метода при аргументе единице")
    public void factorialOneTest(){
        Assert.assertEquals(1, Factorial.factorial(1));
    }
    @Test(description = "Проверка работы метода при отрицательном аргументе -1")
    public void factorialNegativeTest(){
        Assert.assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-1));
    }
    @Test(description = "Проверка работы метода при аргументе, дающем результат больше диапазона значений int")
    public void factorialBigResultTest(){
        Assert.assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(13));
    }
}

