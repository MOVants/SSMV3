
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class VehiclesModule extends StringValues {
	private WebDriver driver;
	static String browser;
	static String whoUser;

	public void setBrowser() {
		
		whoUser = "marvin";

		browser = "Chrome";

	}
	public void browserConfig () {

		if (browser.contains("Firefox")) {

			if (whoUser.contains("marvin")) {
				System.setProperty("webdriver.gecko.driver","/home/marvin/git/SSMV3/SSMWebV3/libs/geckoDriver/geckodriver");
			} if (whoUser.contains("altair")) {
				System.setProperty("webdriver.gecko.driver","C:\\Users\\altair\\git\\SSMV3\\SSMWebV3\\libs\\geckoDriver\\geckodriver"); 
			}

			driver = new FirefoxDriver();
		} if (browser.contains("Chrome")) {
			if (whoUser.contains("marvin")) {
				System.setProperty("webdriver.chrome.driver", "/home/marvin/git/SSMV3/SSMWebV3/libs/chromeDriver/chromedriver");
			}if (whoUser.contains("altair")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\altair\\git\\SSMV3\\SSMWebV3\\libs\\chromeDriver\\chromedriver");
			}
		}
		driver = new ChromeDriver();
	}

	@Before
	public void setUp() throws Exception {
		setBrowser();
		browserConfig();
		driver.get("http://172.16.0.133:8000/satellite/user/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void loginUerTest() {
		//	  driver.get(baseUrl + "/satellite/user/login");
		loginUser();
		System.out.println("Login test = Passed!");
	}

	@Test
	public void createVehicleTest() throws Exception{
		loginUser();
		vehiclesManagement();
		Thread.sleep(1000);
		createVehicle();
		setvehivleInformation();
		setGPSInfo();
		setFuelTankCalibration();
		assignVehicleGroups();
		saveVehicle();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains("successfully")){
			System.out.println("Create Vehicle = Test Passed!");
		} else {
			System.out.println("Create Vehicle = Test Failed!");
		}
	}

	@Test
	public void missingVehiclePlateNoTest() throws Exception {
		loginUser();
		vehiclesManagement();
		Thread.sleep(1000);
		createVehicle();
		setvehivleInformation();
		driver.findElement(By.id(vehiclePlateField)).clear();
		setGPSInfo();
		setFuelTankCalibration();
		assignVehicleGroups();
		saveVehicle();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		if(driver.getPageSource().contains("This field is required."))
		{
			System.out.println("Create Vehicle with missing Plate number test = Passed!");
		} else {
			System.out.println("Create Vehicle with missing Plate number test = Failed!");
		}
	}


	@Test
	public void missingVehicleVINChasisNo() throws Exception{
		//	  driver.get(baseUrl + "/satellite/user/login");
		loginUser();
		vehiclesManagement();
		Thread.sleep(1000);
		createVehicle();
		setvehivleInformation();
		driver.findElement(By.id(vehiclechassisNumberField)).clear();
		setGPSInfo();
		setFuelTankCalibration();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		assignVehicleGroups();
		saveVehicle();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		if(driver.getPageSource().contains("This field is required."))
		{
			System.out.println("Create Vehicle with missing VIN/Chasis No = Test Passed!");
		} else {
			System.out.println("Create Vehicle with missing VIN/Chasis No = Test Failed!");
		}
	}

	@Test
	public void missingVehicleMilage() throws Exception {
		//	  driver.get(baseUrl + "/satellite/user/login");
		loginUser();
		vehiclesManagement();
		Thread.sleep(1000);
		createVehicle();
		setvehivleInformation();
		driver.findElement(By.id(vehicleMilageField)).clear();
		setGPSInfo();
		setFuelTankCalibration();
		assignVehicleGroups();
		saveVehicle();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		if (driver.getPageSource().contains("This field is required."))
		{
			System.out.println("Create Vehicle with missing milage = Test Passed!");
		} else {
			System.out.println("Create Vehicle with missing milage = Test Failed!");
		}
	}

	@Test
	public void missingVehicleFuelConsumption() throws Exception {
		//	  driver.get(baseUrl + "/satellite/user/login");
		loginUser();
		vehiclesManagement();
		Thread.sleep(1000);
		createVehicle();
		setvehivleInformation();
		driver.findElement(By.id(fuelConsumptionField)).clear();
		setGPSInfo();
		setFuelTankCalibration();
		assignVehicleGroups();
		saveVehicle();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		if (driver.getPageSource().contains("This field is required."))
		{
			System.out.println("Create Vehicle with missing fuel consumption = Test Passed!");
		} else {
			System.out.println("Create Vehicle with missing fuel consumption = Test Failed!");
		}
	}

	@Test
	public void missingVehicleDescription() throws InterruptedException {

		loginUser();
		vehiclesManagement();
		Thread.sleep(1000);
		createVehicle();
		setvehivleInformation();
		driver.findElement(By.id(vehicleDescriptionField)).clear();
		setGPSInfo();
		setFuelTankCalibration();
		assignVehicleGroups();
		saveVehicle();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		if (driver.getPageSource().contains("successfully"))
		{
			System.out.println("Create Vehicle with missing description = Test Passed!");
		} else {
			System.out.println("Create Vehicle with missing description = Test Failed!");
		}
	}
	@Test
	public void manufacturerIsNotSet() throws InterruptedException {
		loginUser();
		vehiclesManagement();
		Thread.sleep(1000);
		createVehicle();
		setvehivleInformation();
		driver.findElement(By.id("vehicle.description")).clear();
		setGPSInfo();
		setFuelTankCalibration();
		assignVehicleGroups();
		saveVehicle();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String message = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (message.equals("Vehicle successfully created!"))

		{
			System.out.println("Create Vehicle test = Passed!");
		} else {
			System.out.println("Create Vehicle test = Failed!");
		}
	}


	private void loginUser() {
		driver.findElement(By.xpath(btnAuthLogin)).click();
		driver.findElement(By.id(usernameField)).sendKeys(authusername);
		driver.findElement(By.id(passwordField)).sendKeys(authpass);
		driver.findElement(By.xpath(btnLogin)).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	private void createVehicle() {
		driver.findElement(By.xpath(createVehicleBtn)).click();
	}

	private void vehiclesManagement() {
		driver.findElement(By.xpath(vehicleManagementBtn)).click();
	}

	private void setvehivleInformation() throws InterruptedException  {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id(vehiclePlateField)).sendKeys(RandomStringUtils.randomNumeric(5));
		driver.findElement(By.id(vehiclechassisNumberField)).sendKeys(RandomStringUtils.randomNumeric(11));
		driver.findElement(By.id(calPurchaseDate)).click();
		driver.findElement(By.linkText(RandomStringUtils.randomNumeric(1))).click();
		Thread.sleep(1000);
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		driver.findElement(By.id(vehicleMilageField)).sendKeys(RandomStringUtils.randomNumeric(1));
		driver.findElement(By.id(fuelConsumptionField)).sendKeys(RandomStringUtils.randomNumeric(1));
		driver.findElement(By.id(drpdwnVehicleManufacturer)).click();
		new Select(driver.findElement(By.id(drpdwnSelectVehicleManufacturer))).selectByVisibleText("Chevrolet");
		driver.findElement(By.id(drpdwnVehicletype)).click();
		new Select(driver.findElement(By.id(drpdwnSelectVehicletype))).selectByVisibleText("Bus");  
	}

	public void setGPSInfo() throws InterruptedException {
		driver.findElement(By.xpath(GPSInfoTab)).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id(IMEIField)).sendKeys(RandomStringUtils.randomNumeric(6));
		driver.findElement(By.id(telematicsSerialNoField)).sendKeys(RandomStringUtils.randomNumeric(11));
		driver.findElement(By.id(telematicsMSISDNField)).sendKeys(RandomStringUtils.randomNumeric(8));
		driver.findElement(By.xpath(fuelSensorToggle)).click();
		driver.findElement(By.xpath(doorSensorToggle)).click();
		driver.findElement(By.id(firmwareVersionField)).sendKeys(RandomStringUtils.randomNumeric(1));
		driver.findElement(By.id(appVersionField)).sendKeys(RandomStringUtils.randomNumeric(1));
		driver.findElement(By.id(doorSensorInstallDate)).click();
		driver.findElement(By.linkText(RandomStringUtils.randomNumeric(1))).click();
		Thread.sleep(1000);
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

	}

	public void setFuelTankCalibration() {
		driver.findElement(By.linkText("Fuel Tank Calibration")).click();
	}

	public void assignVehicleGroups() {
		driver.findElement(By.linkText("Group Assignments")).click();
		driver.findElement(By.xpath(vehicleGroupToogleAll)).click();
		driver.findElement(By.xpath(vehicleGrouptoggleone)).click();
	}
	public void saveVehicle () {
		driver.findElement(By.xpath(btnSaveVehicle)).click();
	}


	@After
	public void tearDown() throws Exception {
		driver.quit();

	}
}
