import org.testng.annotations.DataProvider;

public class TestMTSBYPayFrameData {
    @DataProvider(name = "MainPagePaySectionPlaceholdersForIds", parallel = true)
    public static Object[][] ProvideMainPagePaySectionPlaceholdersForIds() {
        return new String[][]{
                {"connection-phone", "Номер телефона"},
                {"connection-sum", "Сумма"},
                {"connection-email", "E-mail для отправки чека"},
                {"internet-phone", "Номер абонента"},
                {"internet-sum", "Сумма"},
                {"internet-email", "E-mail для отправки чека"},
                {"score-instalment", "Номер счета на 44"},
                {"instalment-sum", "Сумма"},
                {"instalment-email", "E-mail для отправки чека"},
                {"score-arrears", "Номер счета на 2073"},
                {"arrears-sum", "Сумма"},
                {"arrears-email", "E-mail для отправки чека"},

        };
    }

    @DataProvider(name = "PhoneAndSumForPayFrameTextFieldsTest")
    public static Object[][] ProvidePhoneAndSum() {
        return new String[][]{
                {"297777777", "100.00"}
        };
    }
    @DataProvider(name = "PayFrameLabelsForFormcontrolnames", parallel = true)
    public static Object[][] ProvideLabelsForFormcontrolnames() {
        return new String[][]{
                {"Номер карты", "\"creditCard\""},
                {"Срок действия", "\"expirationDate\""},
                {"CVC", "\"cvc\""},
                {"Имя держателя (как на карте)", "\"holder\""}
        };
    }
    @DataProvider(name = "PayFramePaySystems", parallel = true)
    public static Object[][] ProvidePaySystemNames() {
        return new String[][]{
                {"mastercard", "1"},
                {"visa", "2"},
                {"belkart", "3"},
                {"maestro&mir", "4"}
        };
    }
}

