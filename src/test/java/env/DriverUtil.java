package env;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.ErrorHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.tools.sjavac.Log;

import cucumber.api.Scenario;

@SuppressWarnings("unused")
public class DriverUtil {
    public static long DEFAULT_WAIT = 20;
    protected static WebDriver driver=null;
    static String currentPath = System.getProperty("user.dir");
    static Properties prop = new Properties();
    static DesiredCapabilities capability=null;
    
    public static DesiredCapabilities getCapability(InputStream input) {
    	DesiredCapabilities capability = new DesiredCapabilities();
    	try {
    		prop.load(input);
    		if(prop.containsKey("app")) {
    			String appName = prop.getProperty("app");
    			if(!appName.contains("sauce-storage")) {
    				String appPath = currentPath+"/src/main/java/appUnderTest/"+appName;
    				prop.setProperty("app", appPath);
    			}
    		}
    		
    		Enumeration<Object> enuKeys = prop.keys();
    		while (enuKeys.hasMoreElements()) {
    			String key = (String) enuKeys.nextElement();
    			String value = prop.getProperty(key);
    			capability.setCapability(key, value);
    		}
    		
    		input.close();
    	}
    	
    	catch(Exception e) {
    		e.printStackTrace();
			System.exit(0);
    	}
    	
    	return capability;
    }
    

	public static WebDriver getDriver() {
		if (driver != null) {
			return driver;
		}
		
		String enviroment = "desktop";
		String platform = "";
		String config = System.getProperty("config", "");
		
		if(!config.isEmpty())
		{
			try{
				enviroment = config.split("_")[0].toLowerCase();
				platform = config.split("_")[1].toLowerCase();
				InputStream input = new FileInputStream(currentPath+"/src/main/java/browserConfigs/"+config+".properties");
				capability = getCapability(input);
			}
			catch(Exception e){
				System.out.println("\nException : File not present or Invalid config file name "+config+".properties");
				System.out.println("Config file format should be : enviroment_platform_device.properties");
				System.out.println("\nE.g : local_android_nexus5.properties");
				System.out.println("E.g : local_ios_iphone6.properties");
				System.out.println("E.g : browserstack_android_nexus5.properties");
				System.out.println("E.g : saucelab_windows7_chrome.properties");
				System.exit(0);
			}
		}
		
		switch(enviroment){			 					 
			case "desktop": DesiredCapabilities capabilities = null;
							capabilities = DesiredCapabilities.chrome();
					        capabilities.setJavascriptEnabled(true);
					        capabilities.setCapability("takesScreenshot", true);
					        driver = chooseDriver(capabilities);
					        driver.manage().timeouts().setScriptTimeout(DEFAULT_WAIT, TimeUnit.SECONDS);
					        driver.manage().window().maximize();
					        break;
			
			default : 	System.out.println("\nException : Invalid platform "+enviroment);
						System.exit(0);
		}
        
        return driver;
    }

    
    private static WebDriver chooseDriver(DesiredCapabilities capabilities) {
		String preferredDriver = System.getProperty("browser", "chrome");
		boolean headless = System.getProperty("headless", "false").equals("true");
		switch (preferredDriver.toLowerCase()) {
		
			case "edge":
				try {
					driver = new EdgeDriver();
				}
				
				catch(Exception e) {
					System.out.println(e.getMessage());
					System.exit(0);
				}
				
				return driver;
				
			case "chrome":
				System.setProperty("webdriver.chrome.driver", currentPath+"\\src\\test\\resources\\driver\\chromedriver.exe");
				final ChromeOptions chromeOptions = new ChromeOptions();
				if (headless) {
					chromeOptions.addArguments("--headless");
					Log.info("Running on headless chrome...");
				}
				
				capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				try{
					driver = new ChromeDriver(capabilities);
					ErrorHandler handler = new ErrorHandler();
					handler.setIncludeServerErrors(false);
					//driver.setErrorHandler(handler);
				}
				
				catch(Exception e) {
					System.out.println(e.getMessage());
					System.exit(0);
				}
				
				return driver;
				
			default:
				FirefoxOptions options = new FirefoxOptions();
				if (headless) {
					options.addArguments("-headless", "-safe-mode");
				}
				
				capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
				try {
					driver = new FirefoxDriver(capabilities);
				}
				
				catch(Exception e) {
					System.out.println(e.getMessage());
					System.exit(0);
				}
				
				return driver;
			}
    }

    public static WebElement waitAndGetElementByCssSelector(WebDriver driver, String selector, int seconds) {
        By selection = By.cssSelector(selector);
        return (new WebDriverWait(driver, seconds)).until(
                ExpectedConditions.visibilityOfElementLocated(selection));
    }

	public static void closeDriver() {
		if (driver != null) {
			try {
				driver.close();
				driver.quit();
			} 
			
			catch (NoSuchMethodError nsme) {
			} 
			
			catch (NoSuchSessionException nsse) {
			} 
			
			catch (SessionNotCreatedException snce) {
				
			}
			driver = null;
		}
	}
	
	public void SNAP(Scenario scenario, String description_string) throws IOException {
	      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	      scenario.write(description_string);
	      scenario.embed(Files.readAllBytes(screenshot.toPath()), "image/png");
	      System.out.println("snap...");
	}
}
