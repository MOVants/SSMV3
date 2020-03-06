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
	String groupName;
	String groupDesc;
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void createVehicleGroupTest() throws Exception {
		loginUser();
		clickVehicleGroupTab();
		cLickCreateBtn();
		Thread.sleep(1000);
		setVehicleGroupInfo();
		getVehiclegroupData();
		Thread.sleep(500);
		saveVehicleGroup();
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains(groupName)) {
			System.out.println("Create Vehicle Group test = Passed!");
		}else {
			System.out.println("Create Vehicle Group test = Failed!");
		} 
	}

	@Test
	public void missingVehicleGroupNameTest() throws Exception {
		loginUser();
		clickVehicleGroupTab();
		Thread.sleep(500);
		cLickCreateBtn();
		setVehicleGroupInfo();
		driver.findElement(By.id(vehicleGroupNameField)).clear();
		Thread.sleep(500);
		saveVehicleGroup();
		Thread.sleep(500);
		if (driver.getPageSource().contains(missinfieldError))
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
		Thread.sleep(500);
		cLickCreateBtn();
		Thread.sleep(500);
		setVehicleGroupInfo();
		Thread.sleep(500);
		driver.findElement(By.id(vehicleGroupDescField)).clear();
		getVehiclegroupData();
		Thread.sleep(500);
		saveVehicleGroup();
		Thread.sleep(500);
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
		Thread.sleep(500);
		selectEditVehicleGroup();
		Thread.sleep(500);
		driver.findElement(By.id(vehicleGroupNameField)).clear();
		saveVehicleGroup();
		Thread.sleep(500);
		if (driver.getPageSource().contains(missinfieldError)) {
			System.out.println("Modify Vehicle Group Name  - Test Passed!");
		}else {
			System.out.println("Modify Vehicle Group Name - Test Failed!");
		} 
	}

	@Test
	public void ModmissingVehicleGroupDecsTest() throws Exception {
		loginUser();
		clickVehicleGroupTab();
		Thread.sleep(500);
		selectEditVehicleGroup ();
		Thread.sleep(500);
		driver.findElement(By.id(vehicleGroupDescField)).clear();
		getVehiclegroupData();;
		saveVehicleGroup();
		Thread.sleep(500);
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
		Thread.sleep(500);
		selectEditVehicleGroup();
		Thread.sleep(500);
		driver.findElement(By.id(vehicleGroupNameField)).clear();
		driver.findElement(By.id(vehicleGroupNameField)).sendKeys(randomAlphaNumChar10);
		getVehiclegroupData();
		saveVehicleGroup();
		Thread.sleep(500);
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
		Thread.sleep(500);
		selectEditVehicleGroup ();
		Thread.sleep(500);
		getVehiclegroupData();
		driver.findElement(By.id(vehicleGroupDescField)).clear();
		driver.findElement(By.id(vehicleGroupDescField)).sendKeys(randomAlphaNumChar30);
		saveVehicleGroup();
		Thread.sleep(500);
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains(groupName)) {
			System.out.println("Missing Vehicle Group description Test - Passed!");
		} else{
			System.out.println("Missing Vehicle Group description Test - Failed!");
		}
	}

	private void selectEditVehicleGroup () throws Exception {
		driver.findElement(By.xpath(editVehicleGroupBtn)).click();
	}

	private void getVehiclegroupData() {
		groupName = driver.findElement(By.id(vehicleGroupNameField)).getText();
		groupDesc = driver.findElement(By.id(vehicleGroupDescField)).getText();
	}


	private void clickVehicleGroupTab() {
		driver.findElement(By.xpath(vehicleGroupManagementBtn)).click();
	}

	private void cLickCreateBtn()throws Exception {
		Thread.sleep(500);
		driver.findElement(By.xpath(createBtn)).click();

	}
	private void setVehicleGroupInfo() {
		driver.findElement(By.id(vehicleGroupNameField)).sendKeys(randomAlphaNumChar10);
		driver.findElement(By.id(vehicleGroupDescField)).sendKeys(randomAlphaNumChar30);
	}

	private void loginUser() {
		driver.findElement(By.xpath(btnAuthLogin)).click();
		driver.findElement(By.id(usernameField)).sendKeys(prop.getProperty("rightUsername"));
		driver.findElement(By.id(passwordField)).sendKeys(prop.getProperty("rightPassword"));
		driver.findElement(By.xpath(btnLogin)).click();
	}

	private void saveVehicleGroup()  {
		driver.findElement(By.id(saveBtn)).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();

	}
}
