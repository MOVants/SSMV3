import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import org.openqa.selenium.*;

public class VehicleGroupModule extends StringValues{
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
	  public void createVehicleGroupTest() throws Exception {
		loginUser();
		clickVehicleGroupTab();
		cLickCreateBtn();
		setVehicleGroupInfo();
		String getgroupName = driver.findElement(By.id(vehicleGroupNameField)).getText();
		saveVehicleGroup();
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains(getgroupName)) {
			System.out.println("Create Vehicle Group test = Passed!");
		}else {
			System.out.println("Create Vehicle Group test = Failed!");
		} 
	}

	@Test
	public void missingVehicleGroupNameTest() throws Exception {
		loginUser();
		clickVehicleGroupTab();
		cLickCreateBtn();
		setVehicleGroupInfo();
		driver.findElement(By.id(vehicleGroupNameField)).clear();
		saveVehicleGroup();
		String str = driver.findElement(By.id(getNotifError)).getText();
		if (str.contains("This field is required."))
		{
			System.out.println("Missing Vehicle Group Name - Test Passed!");
		} else {
			System.out.println("Missing Vehicle Group Name - Test Failed!");
		}
	}

	@Test
	public void missingVehicleGroupDescTest() throws Exception {
		loginUser();
		clickVehicleGroupTab();
		cLickCreateBtn();
		setVehicleGroupInfo();
		String groupName = driver.findElement(By.id(vehicleGroupNameField)).getText();
		driver.findElement(By.id(vehicleGroupDescField)).clear();
		saveVehicleGroup();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains(groupName)){	    
			System.out.println("Missing Vehicle Group Description - Test Passed!");
		}else {
			System.out.println("Missing Vehicle Group Description - Test Failed!");
		}
	}
	@Test
	public void ModMissingVehicleGroupNameTest() throws Exception {
		loginUser();
		clickVehicleGroupTab();
		selectEditVehicleGroup();
		Thread.sleep(1000);
		driver.findElement(By.id(vehicleGroupNameField)).clear();
		saveVehicleGroup();
		Thread.sleep(1000);
		if (driver.getPageSource().contains("required.")) {
			System.out.println("Modify Vehicle Group Name  - Test Passed!");
		}else {
			System.out.println("Modify Vehicle Group Name - Test Failed!");
		} 
	}

	@Test
	public void ModmissingVehicleGroupDecsTest() throws Exception {
		loginUser();
		clickVehicleGroupTab();
		selectEditVehicleGroup ();
		Thread.sleep(1000);
		driver.findElement(By.id(vehicleGroupDescField)).clear();
		String groupName = driver.findElement(By.id(vehicleGroupDescField)).getText();
		saveVehicleGroup();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains(groupName)) {
			System.out.println("Modify Vehicle Group Name  - Test Passed!");
		}else {
			System.out.println("Modify Vehicle Group Name - Test Failed!");
		} 
	}


	@Test
	public void modifyVehicleGroupNameTest() throws Exception {
		loginUser();
		clickVehicleGroupTab();
		selectEditVehicleGroup ();
		Thread.sleep(1000);
		driver.findElement(By.id(vehicleGroupNameField)).clear();
		driver.findElement(By.id(vehicleGroupNameField)).sendKeys(RandomStringUtils.randomNumeric(6));
		String groupName = driver.findElement(By.id(vehicleGroupNameField)).getText();
		saveVehicleGroup();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains(groupName)) {
			System.out.println("Missing Vehicle Group Test - Passed!");
		} else{
			System.out.println("Missing Vehicle Group Test - Failed!");
		}
	}

	@Test
	public void modifyVehicleGroupDecsTest() throws Exception {
		loginUser();
		clickVehicleGroupTab();
		selectEditVehicleGroup ();
		Thread.sleep(1000);
		String groupName = driver.findElement(By.id(vehicleGroupNameField)).getText();
		driver.findElement(By.id(vehicleGroupDescField)).clear();
		driver.findElement(By.id(vehicleGroupDescField)).sendKeys(RandomStringUtils.randomNumeric(30));
		saveVehicleGroup();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains(groupName)) {
			System.out.println("Missing Vehicle Group description Test - Passed!");
		} else{
			System.out.println("Missing Vehicle Group description Test - Failed!");
		}
	}

	private void selectEditVehicleGroup () throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(editVehicleGroupBtn)).click();
	}


	private void clickVehicleGroupTab() {
		driver.findElement(By.xpath(vehicleGroupManagementBtn)).click();
	}

	private void cLickCreateBtn()throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(createBtn)).click();

	}
	private void setVehicleGroupInfo() {
		driver.findElement(By.id(vehicleGroupNameField)).sendKeys(RandomStringUtils.randomAlphanumeric(6));
		driver.findElement(By.id(vehicleGroupDescField)).sendKeys(RandomStringUtils.randomAlphanumeric(30));
	}

	private void loginUser() {
		driver.findElement(By.xpath(btnAuthLogin)).click();
		driver.findElement(By.id(usernameField)).sendKeys(prop.getProperty("rightUsername"));
		driver.findElement(By.id(passwordField)).sendKeys(prop.getProperty("rightPassword"));
		driver.findElement(By.xpath(btnLogin)).click();
	}

	private void saveVehicleGroup()  {
		driver.findElement(By.xpath(saveBtn)).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();

	}
}
