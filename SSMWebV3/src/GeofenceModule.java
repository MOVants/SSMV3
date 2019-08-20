
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;

public class GeofenceModule extends StringValues{
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/marvin/git/SSMV3/SSMWebV3/libs/chromeDriver/chromedriver");
		driver.get("http://172.16.0.133:8000/satellite/user/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void login() {
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

