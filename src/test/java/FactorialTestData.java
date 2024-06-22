import org.testng.annotations.DataProvider;

public class FactorialTestData {
    @DataProvider(name = "positiveParameters")
    public static Integer[][] positiveParameters() {
        return new Integer[][]{
                {1, 1},
                {0, 1},
                {12, 479001600}
        };
    }

    @DataProvider(name = "negativeParameters")
    public static Integer[][] negativeParameters() {
        return new Integer[][]{
                {-1},
                {13}
        };
    }
}
