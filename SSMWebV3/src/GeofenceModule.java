
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class GeofenceModule extends StringValues{
	private WebDriver driver;
	Properties prop = new Properties();


	public void setBrowserConfig() throws Exception{
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir") + "/configuration.properties");
		prop.load(fi);
		System.setProperty(prop.getProperty("whatBrowser"), prop.getProperty("wheresChrome"));
	}

	@Before
	public void setUp() throws Exception {
		setBrowserConfig();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void login() {
		loginUser();
	}

	private void loginUser() {
		driver.findElement(By.xpath(btnAuthLogin)).click();
		driver.findElement(By.id(usernameField)).sendKeys(prop.getProperty("rightUsername"));
		driver.findElement(By.id(passwordField)).sendKeys(prop.getProperty("rightPassword"));
		driver.findElement(By.xpath(btnLogin)).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}

