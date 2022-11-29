package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MyAccountTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setupBrowser() {

        openBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String options) {
        clickOnElement(By.linkText(options));
    }

    @Test
    public void verifythatUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Register
        selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”.
        verifyMessage("Register Account", getTextFromElement(By.xpath("//h1[contains(text(),'Register Account')]")));
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //Call the method “selectMyAccountOptions” method and pass the parameter
        //“Login
        selectMyAccountOptions("Login");
        //Verify the text “Returning Customer”.
        verifyMessage("Returning Customer", getTextFromElement(By.xpath("//h2[contains(text(),'Returning Customer')]")));
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {

        //3.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Register”
        selectMyAccountOptions("Register");
        //3.3 Enter First Name
        sendTextToElement(By.id("input-firstname"), "Krish");
//3.4 Enter Last Name
        sendTextToElement(By.id("input-lastname"), "Kara");
        //3.5 Enter Email
        sendTextToElement(By.id("input-email"), "Krish@gmail.com");
        //3.6 Enter Telephone
        sendTextToElement(By.id("input-telephone"), "07912365478");
        //3.7 Enter Password
        sendTextToElement(By.id("input-password"), "Krish123");
        //3.8 Enter Password Confirm
        sendTextToElement(By.id("input-confirm"), "Krish123");
        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/label[1]"));
        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));
        //3.11 Click on Continue button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]"));
        //3.12 Verify the message “Your Account Has Been Created
        Thread.sleep(2000);
        verifyMessage("Your Account Has Been Created!", getTextFromElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]")));
        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //3.14 Clickr on My Account Link.
        clickOnElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[1]"));
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Logout
        selectMyAccountOptions("Logout");
//clickOnElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[13]"));
        //3.16 Verify the text “Account Logout”
        Thread.sleep(2000);
        verifyMessage("Account Logout", getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]")));
        //3.17 Click on Continue button

        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }

    @Test
    public void verifyThatUsershouldLoginAndLogoutSuccessfully()throws InterruptedException {
        //4.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Login”
        selectMyAccountOptions("Login");
        //4.3 Enter Email address
        sendTextToElement(By.id("input-email"), "Krish@gmail.com");
        //4.4 Enter Last Name

        //4.5 Enter Password
        sendTextToElement(By.id("input-password"), "Krish123");
        //4.6 Click on Login button
        clickOnElement(By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]"));
        //4.7 Verify text “My Account
        Thread.sleep(2000);
        verifyMessage("My Account", getTextFromElement(By.xpath("//h2[contains(text(),'My Account')]")));
        //4.8 Clickr on My Account Link.
        clickOnElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[1]"));
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Logout”
        Thread.sleep(2000);
        selectMyAccountOptions("Logout");
        //4.10 Verify the text “Account Logout
        verifyMessage("Account Logout", getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]")));
        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}