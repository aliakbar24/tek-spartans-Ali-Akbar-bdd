package tek.bdd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import javax.swing.plaf.metal.MetalLookAndFeel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tek.bdd.browsers.BaseBrowser;
import tek.bdd.browsers.ChromeBrowser;
import tek.bdd.browsers.EdgeBrowser;
import tek.bdd.browsers.FireFoxBrowser;

public abstract class BaseSetup {
    private static final Logger LOGGER = LogManager.getLogger(BaseSetup.class);
    //Encapsulating driver instance
    private static WebDriver driver;
    private final Properties properties;

    //Find the full path to file
    //FileInputStream to read the file
    //Properties and load the FileInputStream to the properties.
    public BaseSetup() {
        //System.getProperty("user.dir") return the locator of your project
        try {
            String configFilePath = System.getProperty("user.dir") +
                    "/src/test/resources/configs/dev-config.properties";
            LOGGER.info("Reading Config file" + configFilePath);
            File file = new File(configFilePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException ex) {
            LOGGER.error("Error reading config file", ex);
            throw new RuntimeException("Something is wrong with Config file", ex);
        }
    }

    public void setupBrowser() {
        //To open Chrome browser in headless mode
        String browserType = properties.getProperty("ui.browser");
        boolean isHeadless = Boolean.parseBoolean(properties.getProperty("ui.browser.headless"));
        LOGGER.info("Running on browser {} and isHeadless {}", browserType, isHeadless);

        BaseBrowser browser;

        if(browserType.equalsIgnoreCase("chrome"))
            browser = new ChromeBrowser();
        else if (browserType.equalsIgnoreCase("edge"))
            browser = new EdgeBrowser();
        else if (browserType.equalsIgnoreCase("firefox"))
            browser = new FireFoxBrowser();
        else
            throw new RuntimeException("Wrong browser type choose between chrome, firefox or edge");


    driver = browser.openBrowser(isHeadless);

//        if(browserType.equalsIgnoreCase("chrome")) {
//            ChromeOptions options = new ChromeOptions();
//            if (isHeadless)
//                options.addArguments("--headless");
//            driver = new ChromeDriver(options);
//        }else if (browserType.equalsIgnoreCase("edge")) {
//            EdgeOptions options = new EdgeOptions();
//            if (isHeadless) options.addArguments("--headless");
//            driver = new EdgeDriver(options);
//        } else if (browserType.equalsIgnoreCase("firefox")) {
//            FirefoxOptions options = new FirefoxOptions();
//            if (isHeadless)
//                options.addArguments("--headless");
//            driver = new FirefoxDriver();
//        }else {
//            throw new RuntimeException("Wrong browser type choose between chrome, firefox, or edge");
//        }




        String url = properties.getProperty("ui.url");
        LOGGER.debug("Using URL{}", url);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    public void quitBrowser() {
        //null check before quitting
        if (driver != null) {
            driver.quit();
        }
    }

    //Giving read-only indirect access to driver.
    //Restrict setting new driver instance
    public WebDriver getDriver() {
        return driver;
    }
}

