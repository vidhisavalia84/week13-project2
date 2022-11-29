package desktop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class DesktopTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setupBrowser() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductArrangeInAlphabeticalOrder()throws InterruptedException{
        //1.1 Mouse hover on Desktops Tab.and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));

        //1.2 Click on “Show All Desktops”
        Thread.sleep(2000);
clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
        //1.3 Select Sort By position "Name: Z to A"//select[@id='input-sort']//option[3]
      selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Name (Z - A)");
        //1.4 Verify the Product will arrange in Descending order.
       // verifyMessage("");
    }

@Test
public void verifyProductAddedToShoppingCartSuccessfully()throws InterruptedException{
//2.1 Mouse hover on Desktops Tab. and click
mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
    //2.2 Click on “Show All Desktops”
clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
    //2.3 Select Sort By position "Name: A to Z"
    Thread.sleep(2000);
    selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Name (A - Z)");

selectOptionsByContainText(By.xpath("//a[contains(text(),'HP LP3065')]"),"HP LP3065");
    //2.5 Verify the Text "HP LP3065"
verifyMessage("HP LP3065",getTextFromElement(By.xpath("//h1[contains(text(),'HP LP3065')]")));
    //2.6 Select Delivery Date "2022-11-30"
//clickOnElement(By.xpath("//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/span[1]/button[1]/i[1]"));
    String year = "2022";
    String month = "November";
    String date = "30";
    Thread.sleep(2000);
    // opens the date picker
    clickOnElement(By.xpath("//button[@class = 'btn btn-default']/i[@class='fa fa-calendar']"));

    while (true) {
        String monthYear = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[2]")).getText();
// Nov 2022
        String arr[] = monthYear.split(" ");
        String mon = arr[0];
        String yer = arr[1];

        if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
            break;
        } else {
            clickOnElement(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[3]"));
        }
    }
    //Select Date
    List<WebElement> allDates = driver.findElements(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[5]/td[3]"));
    for (WebElement dt : allDates) {
        if (dt.getText().equalsIgnoreCase(date)) {
            dt.click();
            break;
        }
    }
    //2.7.Enter Qty "1” using Select class.
clearText(By.xpath("//input[@id='input-quantity']"));
sendTextToElement(By.xpath("//input[@id='input-quantity']"),"1");
    //2.8 Click on “Add to Cart” button
clickOnElement(By.xpath("//button[@id='button-cart']"));
    //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
    Thread.sleep(3000);
//verifyMessage("Success: You have added HP LP3065 to your shopping cart!",getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
    //2.10 Click on link “shopping cart” display into success message
clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
    //2.11 Verify the text "Shopping Cart"
    Thread.sleep(3000);
verifyMessage("Shopping Cart  (1.00kg)",getTextFromElement(By.xpath("//h1[contains(text(),' (1.00kg)')]")));
    //2.12 Verify the Product name "HP LP3065"
    Thread.sleep(3000);
verifyMessage("HP LP3065",getTextFromElement(By.cssSelector("div.container:nth-child(4) div.row div.col-sm-12 div.table-responsive table.table.table-bordered tbody:nth-child(2) tr:nth-child(1) td.text-left:nth-child(2) > a:nth-child(1)")));
    //2.13 Verify the Delivery Date "2022-11-30"

    //2.14 Verify the Model "Product21"
    Thread.sleep(3000);
verifyMessage("Product 21",getTextFromElement(By.cssSelector("div.container:nth-child(4) div.row div.col-sm-12 div.table-responsive table.table.table-bordered tbody:nth-child(2) tr:nth-child(1) > td.text-left:nth-child(3)")));
    //2.15 Verify the Todat "£74.73"
    Thread.sleep(3000);
    verifyMessage("$122.00",getTextFromElement(By.xpath("//tbody/tr[1]/td[6]")));
}










    @After
    public void tearDown(){
        closeBrowser();
    }

}
