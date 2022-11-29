package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
public static WebDriver driver;
String baseUrl;

public void openBrowser(String baseUrl){
    System.setProperty("wedriver.chrome.driver","drivers/chromedriver.exe");
    driver=new ChromeDriver();
    driver.get(baseUrl);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}

public void closeBrowser(){
    driver.close();
}

}
