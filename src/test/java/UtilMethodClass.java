import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UtilMethodClass {
    public static void saveBrowserLogsToFile(WebDriver driver, String filepath) {
        LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();
        if (!allLogRows.isEmpty()) {
            File destination = new File(filepath);
            try {
                FileUtils.writeLines(destination, allLogRows);
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }

    public static void makeScreenshot (WebDriver driver, String fileName){
        File temp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("target/TestFailureScreenshots/" + fileName + ".jpg");
        try{
            FileUtils.copyFile(temp,destination);
        } catch (IOException exc){
            exc.printStackTrace();
        }
    }
}
