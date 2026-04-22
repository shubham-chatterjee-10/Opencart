package testCases;


import org.testng.Assert;

import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;

import pageObjects.HomePage;
import testBase.BaseClass;


public class TC001_AccountRegistrationTest extends BaseClass {

    @Test
    public void verify_account_registration() {
        logger.info("Starting testcase");
        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("we clicked on my account");
            hp.clickRegister();
            logger.info("we clicked on Registration");

            AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
            logger.info("Providing Customer details");
            regpage.setFirstName(randomeString().toUpperCase());//randomeString().toUpperCase()
            regpage.setLastName(randomeString().toUpperCase());
            regpage.setEmail(randomeString() + "@gmail.com");
            regpage.setTelephone(randomeNumbers());
            String password = randomeAlphaNumeric();
            regpage.setPassword(password);
            regpage.setConfirmPassword(password);
            regpage.setPrivacyPolicy();
            regpage.clickContinue();
            logger.info("Validating expected message");
            String confmsg = regpage.getConfirmationMsg();
            if(confmsg.equals("Your Account Has Been Created!")){
                Assert.assertTrue(true);
            }
            else{
                logger.error("Test failed..");
                logger.debug("Debug logs..");
                Assert.assertTrue(false);
            }
//            Assert.assertEquals(confmsg, "Your Account Has Been Created!");
        }
        catch(Exception e){

            Assert.fail();
        }
        logger.info("Finished TC001");
    }

}
