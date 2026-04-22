package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage {
    public MyAccount(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//div[@id='content']/h2[1]")
    WebElement msgHeading;
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement lnkLogout;
    public boolean isMyAccountPageExists(){
        try {
            return msgHeading.isDisplayed();
        }
        catch(Exception e){
            return  false;
        }
    }
    public void clickLogout(){
        lnkLogout.click();
    }
}
