package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNoteBooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setupBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));
        //1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        //1.4 Verify the Product price will arrange in High to Low order.
    }
@Test
public void verifythatUserPlaceOrderSuccessfully()throws InterruptedException {
    //2.1 Mouse hover on Laptops & Notebooks Tab.and click
    mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
    //2.2 Click on “Show All Laptops & Notebooks”
    clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));
    //2.3 Select Sort By "Price (High > Low)"
    selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
    //Select Product “MacBook”
    clickOnElement(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[4]/div[1]/div[2]/div[1]/h4[1]/a[1]"));
    //2.5 Verify the text “MacBook”
    Thread.sleep(3000);
    verifyMessage("MacBook", getTextFromElement(By.xpath("//h1[contains(text(),'MacBook')]")));
    //2.6 Click on ‘Add To Cart’ button
    clickOnElement(By.xpath("//button[@id='button-cart']"));
    //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
    Thread.sleep(2000);
verifyMessage("You have added MacBook to your shopping cart!\n"+"×",getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
    //2.8 Click on link “shopping cart” display into success message
    clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
//2.9 Verify the text "Shopping Cart"
    verifyMessage("Shopping Cart  (0.00kg)", getTextFromElement(By.xpath("//h1[contains(text(),' (0.00kg)')]")));
    //2.10 Verify the Product name "MacBook
    Thread.sleep(2000);
    verifyMessage("MacBook", getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")));
    //2.11 Change Quantity "2"
    clearText(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"));
    sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"), "2");
    //2.12 Click on “Update” Tab
    clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]/i[1]"));
    //2.13 Verify the message “Success: You have modified your shopping cart!”
    Thread.sleep(2000);
    verifyMessage("Success: You have modified your shopping cart!\n"+"×",getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
//verifyMessage(" Success: You have modified your shopping cart!",getTextFromElement(By.xpath("//body/div[@id='checkout-cart']/div[1]")));
    //2.14 Verify the Total £737
    Thread.sleep(2000);
    verifyMessage("$1,204.00", getTextFromElement(By.xpath("//tbody/tr[1]/td[6]")));
    //2.15 Click on “Checkout” button
    clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
    //2.16 Verify the text “Checkout”
    verifyMessage("Checkout", getTextFromElement(By.xpath("//h1[contains(text(),'Checkout')]")));
    //2.17 Verify the Text “New Customer”
    Thread.sleep(1000);
    verifyMessage("New Customer", getTextFromElement(By.xpath("//h2[contains(text(),'New Customer')]")));
    //2.18 Click on “Guest Checkout” radio button
    clickOnElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]/input[1]"));
    //2.19 Click on “Continue” tab
    clickOnElement(By.xpath("//input[@id='button-account']"));
    //2.20 Fill the mandatory fields
    Thread.sleep(2000);
    sendTextToElement(By.id("input-payment-firstname"), "Krishna");
    sendTextToElement(By.id("input-payment-lastname"), "vara");
    sendTextToElement(By.id("input-payment-email"), "vara@gmail.com");
    sendTextToElement(By.id("input-payment-telephone"), "07912345678");
    sendTextToElement(By.id("input-payment-company"), "Prime");
    sendTextToElement(By.id("input-payment-address-1"), "Primetesting123");
    sendTextToElement(By.id("input-payment-city"), "Delhi");
    sendTextToElement(By.id("input-payment-postcode"), "DEL 0LK");
    sendTextToElement(By.id("input-payment-postcode"), "DEL 0LK");
    selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-country']"), "Antarctica");
    selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-zone']"), "Berkshire");
//2.21 Click on “Continue” Button
    clickOnElement(By.xpath("//input[@id='button-guest']"));
    //2.22 Add Comments About your order into text area
    sendTextToElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/p[2]/textarea[1]"), "Please send another option");
    //2.23 Check the Terms & Conditions check box
    clickOnElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/input[1]"));
    //2.24 Click on “Continue” button
    clickOnElement(By.xpath("//input[@id='button-payment-method']"));
    Thread.sleep(2000);
    //2.25 Verify the message “Warning: Payment method required!”

    verifyMessage("Warning: Payment method required!\n"+"×", getTextFromElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")));
}
    @After
    public void tearDown() {
        closeBrowser();


    }
}