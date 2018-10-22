
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import org.openqa.selenium.*;

public class DriversModule extends StringValues{
	private WebDriver driver;
	private String baseUrl;
	
	
	  @Before
	  public void setUp() throws Exception {
//		  System.setProperty("webdriver.gecko.driver","/home/marvin/Documents/Selinium/geckodriver"); 
//	    driver = new FirefoxDriver();
		  System.setProperty("webdriver.chrome.driver", "/home/marvin/Documents/Selinium/chromedriver");
		  driver = new ChromeDriver();
		  baseUrl = "http://172.16.0.133:8000";
		  driver.manage().window().maximize();
		  driver.get(baseUrl + "/satellite/user/login");
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
	  @Test
	  public void loginTest() throws Exception {
		loginUser();
		System.out.println("Login - Test Pass");
	  } 
	
	@Test
	  public void createDriverTest() throws Exception {
		loginUser();
		driverManagement();
		Thread.sleep(1000);
		clickCreateDriverBtn();
		Thread.sleep(1000);
		setDriverDetails();
		saveDriver();
		Thread.sleep(1000);
		System.out.println("pass");
		
	  }
	

	private void loginUser() {
		  driver.findElement(By.xpath(btnAuthLogin)).click();
		  driver.findElement(By.id(usernameField)).sendKeys(authusername);
		  driver.findElement(By.id(passwordField)).sendKeys(authpass);
		  driver.findElement(By.xpath(btnLogin)).click();
	}
	
	private void driverManagement() {
		driver.findElement(By.xpath(driverManagementBtn)).click();
	}
	
	private void clickCreateDriverBtn() {
		driver.findElement(By.xpath(createDriverBtn)).click();
	}
	
	private void setDriverDetails() {
		driver.findElement(By.id(firstNameField)).sendKeys(RandomStringUtils.randomNumeric(6));
		driver.findElement(By.id(middleNameField)).sendKeys(RandomStringUtils.randomNumeric(6));
		driver.findElement(By.id(LastNameField)).sendKeys(RandomStringUtils.randomNumeric(6));
		driver.findElement(By.id(contactNumberField)).sendKeys(RandomStringUtils.randomNumeric(6));
		driver.findElement(By.id(emailField)).sendKeys(RandomStringUtils.randomNumeric(4)+"@"+RandomStringUtils.randomNumeric(3)+".com");
		driver.findElement(By.id(genderDrpdwn)).click();
		new Select(driver.findElement(By.id(genderDrpdwn))).selectByVisibleText("Female");
		driver.findElement(By.id(licenseNumberField)).sendKeys(RandomStringUtils.randomNumeric(8));
		driver.findElement(By.id(addressField)).sendKeys(RandomStringUtils.randomNumeric(6));
		driver.findElement(By.id(licenseExpiryDateField)).sendKeys(RandomStringUtils.randomNumeric(8));
		driver.findElement(By.id(dateOfBirthField)).sendKeys(RandomStringUtils.randomNumeric(8));
		driver.findElement(By.xpath(savedDriverBtn)).click();
			
	}
	
	private void saveDriver() {
		
		
	}

	
	
	
	
	
	@After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }
}

