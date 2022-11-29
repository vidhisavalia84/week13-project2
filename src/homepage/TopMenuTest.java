package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setupBrowser() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
//clickOnElement(By.xpath("//body/div[1]/nav[1]/div[2]"));
//selectOptionsByContainText(By.xpath("//body/div[1]/nav[1]/div[2]"),menu);
        clickOnElement(By.linkText(menu));
    }

    @Test
    public void verifyUserSholdNavigateToDesktopPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));

        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show All Desktops");
        //1.3 Verify the text ‘Desktops’
        verifyMessage("Desktops", getTextFromElement(By.xpath("//div[@id='content']/h2")));
    }
@Test
    public void verifyUserShouldNavigateToLaptopAndNoteBooksPageSuccessfully(){
     //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
    //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
selectMenu("Show All Laptops & Notebooks");
    //2.3 Verify the text ‘Laptops & Notebooks’
    verifyMessage("Laptops & Notebooks",getTextFromElement(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]")));
    //3.
}
@Test
  public void verifyUserShouldNavigateToComponantsPageSuccessfully(){
        //3.1 Mouse hover on “Components” Tab and click
mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]"));
    //3.2 call selectMenu method and pass the menu = “Show All Components”
selectMenu("Show All Components");
    //3.3 Verify the text ‘Components
    verifyMessage("Components",getTextFromElement(By.xpath("//h2[contains(text(),'Components')]")));
}
@After
    public void tearDown(){
        closeBrowser();
}

}