
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
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
	  }
	
	
	
	
	private void loginUser() {
		  driver.findElement(By.xpath(btnAuthLogin)).click();
		  driver.findElement(By.id(usernameField)).sendKeys(authusername);
		  driver.findElement(By.id(passwordField)).sendKeys(authpass);
		  driver.findElement(By.xpath(btnLogin)).click();
	}
	
	@After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }
}

