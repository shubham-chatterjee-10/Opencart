package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;//log4j
import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    public Logger logger;
    public Properties p;
    @BeforeClass
    @Parameters({"os","browser"})
    public void setup(String os,String br) throws IOException {
        //loading config.properties file
        FileReader file=new FileReader("./src/test/resources/config.properties");
        p=new Properties();
        p.load(file);

        logger= LogManager.getLogger(this.getClass());
        switch (br.toLowerCase()){
            case "chrome": driver=new ChromeDriver();
                            break;
            case "edge":driver=new EdgeDriver();
                        break;
            case "firefox":driver=new FirefoxDriver();
                            break;
            default: System.out.println("Invalid Browser name.");
                        return;
        }

        driver.manage().deleteAllCookies();//-->Delete  all cookies
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("appUrl"));
        driver.manage().window().maximize();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();

    }

    public  String randomeString(){
        String genertedString = RandomStringUtils.randomAlphabetic(5);
        return genertedString;
    }
    public  String randomeNumbers(){
        String genertedNumber =RandomStringUtils.randomNumeric(10);
        return genertedNumber;
    }
    public String randomeAlphaNumeric(){
        String genertedString =RandomStringUtils.randomAlphabetic(4);
        String genertedNumber =RandomStringUtils.randomNumeric(3);
        return(genertedString+"@"+genertedNumber);
    }
}
