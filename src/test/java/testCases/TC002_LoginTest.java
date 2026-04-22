package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;


public class TC002_LoginTest extends BaseClass {
    @Test
    public void verify_login() {
        logger.info("**starting TC002_LoginTest**");
        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            LoginPage lp = new LoginPage(driver);
            lp.setEmail(p.getProperty("email"));
            lp.setPassword(p.getProperty("password"));
            lp.clickLogin();

            MyAccount macc = new MyAccount(driver);
            boolean target = macc.isMyAccountPageExists();
            Assert.assertTrue(target);

        }
        catch(Exception e){
            Assert.fail();
        }
        logger.info("Finished TC002");
    }
}
