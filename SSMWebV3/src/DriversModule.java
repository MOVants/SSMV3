
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import org.openqa.selenium.*;
import java.io.FileInputStream;
import java.util.Properties;


public class DriversModule extends StringValues{
	WebDriver driver;
	Properties prop = new Properties();
	String getStatus;
	String driverName;
	String driverMidName;
	String driverLastName;

	
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
		Thread.sleep(500);
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void createDriverTest() throws Exception {
		loginUser();
		driverManagement();
		Thread.sleep(1000);
		clickCreateDriverBtn();
		Thread.sleep(1000);
		setDriverDetails();
		getUserData();
		saveDriver();
		Thread.sleep(500);
		if (driver.getPageSource().contains("Successfully") ||driver.getPageSource().contains(driverName) )
		{
			System.out.println("Create Driver - Test Passed" );
		}else {
			System.out.println("Create Driver - Test Failed");
		}
	}

	@Test
	public void createDriverMissingNameTest() throws Exception {
		loginUser();
		driverManagement();
		Thread.sleep(1000);
		clickCreateDriverBtn();
		Thread.sleep(1000);
		setDriverDetails();
		driver.findElement(By.id(firstNameField)).clear();
		saveDriver();
		Thread.sleep(500);
		if (driver.getPageSource().contains("This field is required."))
		{
			System.out.println("Create Driver Missing Name- Test Passed");
		}else {
			System.out.println("Create Driver Missing Name- Test Failed");
		}
	}

	@Test
	public void createDriverMissingMidNameTest() throws Exception {
		loginUser();
		driverManagement();
		Thread.sleep(1000);
		clickCreateDriverBtn();
		Thread.sleep(1000);
		setDriverDetails();
		driver.findElement(By.id(middleNameField)).clear();
		saveDriver();
		Thread.sleep(500);
		if (driver.getPageSource().contains("Successfully") ||driver.getPageSource().contains(driverName) )
		{
			System.out.println("Create Driver Missing Middle Name- Test Passed");
		}else {
			System.out.println("Create Driver Missing Middle Name- Test Failed");
		}
	}

	@Test
	public void createDriverMissingLastNameTest() throws Exception {
		loginUser();
		driverManagement();
		Thread.sleep(1000);
		clickCreateDriverBtn();
		Thread.sleep(1000);
		setDriverDetails();
		driver.findElement(By.id(lastNameField)).clear();
		saveDriver();
		Thread.sleep(500);
		if (driver.getPageSource().contains("This field is required."))
		{
			System.out.println("Create Driver Missing Last Name- Test Passed");
		}else {
			System.out.println("Create Driver Missing Last Name- Test Failed");
		}
	}

	@Test
	public void createDriverMissingcontactNumberTest() throws Exception {
		loginUser();
		driverManagement();
		Thread.sleep(1000);
		clickCreateDriverBtn();
		Thread.sleep(1000);
		setDriverDetails();
		driver.findElement(By.id(contactNumberField)).clear();
		saveDriver();
		Thread.sleep(500);
		if (driver.getPageSource().contains("This field is required."))
		{
			System.out.println("Create Driver Missing Contact Number- Test Passed");
		}else {
			System.out.println("Create Driver Missing Contact Number- Test Failed");
		}
	}


	@Test
	public void createDriverMissingEmailTest() throws Exception {
		loginUser();
		driverManagement();
		Thread.sleep(1000);
		clickCreateDriverBtn();
		Thread.sleep(1000);
		setDriverDetails();
		driver.findElement(By.id(emailField)).clear();
		saveDriver();
		Thread.sleep(500);
		if (driver.getPageSource().contains("Successfully") ||driver.getPageSource().contains(driverName) )
		{
			System.out.println("Create Driver Missing Email- Test Passed");
		}else {
			System.out.println("Create Driver Missing Email- Test Failed");
		}
	}

	@Test
	public void createDriverGenderIsMale() throws Exception {
		loginUser();
		driverManagement();
		Thread.sleep(1000);
		clickCreateDriverBtn();
		Thread.sleep(1000);
		setDriverDetails();
		driver.findElement(By.id(genderDrpdwn)).click();
		new Select(driver.findElement(By.id(genderDrpdwn))).selectByVisibleText("Male");
		saveDriver();
		Thread.sleep(500);
		if (driver.getPageSource().contains("This field is required."))
		{
			System.out.println("Create Driver Gender is Male- Test Passed");
		}else {
			System.out.println("Create Driver Gender is Male- Test Failed");
		}
	}


	@Test
	public void createDriverMissingLicenseNum() throws Exception {
		loginUser();
		driverManagement();
		Thread.sleep(1000);
		clickCreateDriverBtn();
		Thread.sleep(1000);
		setDriverDetails();
		driver.findElement(By.id(licenseNumberField)).clear();
		saveDriver();
		Thread.sleep(500);
		if (driver.getPageSource().contains("This field is required."))
		{
			System.out.println("Create Driver Missing license Number- Test Passed");
		}else {
			System.out.println("Create Driver Missing license Number- Test Failed");
		}
	}

	@Test
	public void createDriverMissingAddress() throws Exception {
		loginUser();
		driverManagement();
		Thread.sleep(1000);
		clickCreateDriverBtn();
		Thread.sleep(1000);
		setDriverDetails();
		driver.findElement(By.id(addressField)).clear();
		saveDriver();
		Thread.sleep(1000);
		if (driver.getPageSource().contains("Successfully") ||driver.getPageSource().contains(driverName) )
		{
			System.out.println("Create Driver Missing Address- Test Passed");
		}else {
			System.out.println("Create Driver Missing Address- Test Failed");
		}
	}

	@Test
	public void createDriverMissingLicenseExpiryDate() throws Exception {
		loginUser();
		driverManagement();
		Thread.sleep(1000);
		clickCreateDriverBtn();
		Thread.sleep(1000);
		setDriverDetails();
		driver.findElement(By.id(licenseExpiryDateField)).clear();
		saveDriver();
		Thread.sleep(500);
		if (driver.getPageSource().contains("This field is required."))
		{
			System.out.println("Create Driver Missing License Expiry Date- Test Passed");
		}else {
			System.out.println("Create Driver Missing License Expiry Date- Test Failed");
		}
	}

	@Test
	public void createDriverMissingDateOfBirth() throws Exception {
		loginUser();
		driverManagement();
		Thread.sleep(1000);
		clickCreateDriverBtn();
		Thread.sleep(1000);
		setDriverDetails();
		driver.findElement(By.id(dateOfBirthField)).clear();
		saveDriver();
		Thread.sleep(500);
		if (driver.getPageSource().contains("This field is required."))
		{
			System.out.println("Create Driver Missing Date Of Birth- Test Passed");
		}else {
			System.out.println("Create Driver Missing Date Of Birth- Test Failed");
		}
	}

	@Test
	public void cancelCreateDriver() throws Exception {
		loginUser();
		driverManagement();
		Thread.sleep(1000);
		clickCreateDriverBtn();
		Thread.sleep(1000);
		setDriverDetails();
		Thread.sleep(1000);
		cancelDriver();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(1000);
		if (driver.getPageSource().contains("NAVIGATION"))
		{
			System.out.println("Cancel Create Driver - Test Passed");
		}else {
			System.out.println("Cancel Create Driver - Test Failed");
		}
	}


	@Test
	public void modifyDriverDetails() throws Exception {
		loginUser();
		driverManagement();
		Thread.sleep(1000);
		editDriverBtn();
		getUserData();
		Thread.sleep(1000);
		setDriverDetails();
		saveDriver();
		Thread.sleep(500);
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		
		if (driver.getPageSource().contains(""))
		if (str.contains(driverName) && str.contains(driverMidName) && str.contains(driverLastName))
		{
			System.out.println("Modify Driver Details - Test Passeded");
		}else {
			System.out.println("Modify Driver Details - Test Failed");
		}
	}

	@Test
	public void modifyDriverName() throws Exception {
		loginUser();
		driverManagement();
		Thread.sleep(1000);
		editDriverBtn();
		Thread.sleep(1000);
		driver.findElement(By.id(firstNameField)).clear();
		driver.findElement(By.id(firstNameField)).sendKeys(randomChar10);
		getUserData();
		saveDriver();
		Thread.sleep(500);
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains(driverName) && str.contains(driverMidName) && str.contains(driverLastName))
		{
			System.out.println("Modify Driver Name - Test Passed");
		}else {
			System.out.println("Modify Driver Name - Test Failed");
		}
	}

	@Test
	public void modifyDriverMidName() throws Exception {
		loginUser();
		driverManagement();
		Thread.sleep(1000);
		editDriverBtn();
		Thread.sleep(1000);
		driver.findElement(By.id(middleNameField)).clear();
		driver.findElement(By.id(middleNameField)).sendKeys(randomChar10);
		getUserData();
		saveDriver();
		Thread.sleep(500);
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains(driverName) && str.contains(driverMidName) && str.contains(driverLastName))
		{
			System.out.println("Modify Driver Middle Name - Test Passed");
		}else {
			System.out.println("Modify Driver Middle Name - Test Failed");
		}
	}

	@Test
	public void modifyDriverLastName() throws Exception {
		loginUser();
		driverManagement();
		Thread.sleep(1000);
		editDriverBtn();
		Thread.sleep(1000);
		driver.findElement(By.id(lastNameField)).clear();
		driver.findElement(By.id(lastNameField)).sendKeys(randomChar10);
		getUserData();
		saveDriver();
		Thread.sleep(500);
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains(driverName) && str.contains(driverMidName) && str.contains(driverLastName))
		{
			System.out.println("Modify Driver Last Name - Test Passed");
		}else {
			System.out.println("Modify Driver Last Name - Test Failed");
		}
	}


	@Test
	public void modifyDriverContNum() throws Exception {
		loginUser();
		driverManagement();
		Thread.sleep(1000);
		editDriverBtn();
		Thread.sleep(1000);
		driver.findElement(By.id(contactNumberField)).clear();
		driver.findElement(By.id(contactNumberField)).sendKeys(randomNum4);
		getUserData();
		saveDriver();
		Thread.sleep(500);
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains(driverName) && str.contains(driverMidName) && str.contains(driverLastName))
		{
			System.out.println("Modify Driver Contact Number - Test Passed");
		}else {
			System.out.println("Modify Driver Contact Number - Test Failed");
		}
	}

	@Test
	public void modifyDriverEmail() throws Exception {
		loginUser();
		driverManagement();
		Thread.sleep(1000);
		editDriverBtn();
		Thread.sleep(1000);
		driver.findElement(By.id(emailField)).clear();
		driver.findElement(By.id(emailField)).sendKeys(randomAlphaNumChar10 +"@"+randomAlphaNumChar3+".com");
		getUserData();
		saveDriver();
		Thread.sleep(500);
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains(driverName) && str.contains(driverMidName) && str.contains(driverLastName))
		{
			System.out.println("Modify Driver Email - Test Passed");
		}else {
			System.out.println("Modify Driver Email - Test Failed");
		}
	}

	@Test
	public void modifyDriverGender() throws Exception {
		loginUser();
		driverManagement();
		Thread.sleep(1000);
		editDriverBtn();
		Thread.sleep(1000);
		driver.findElement(By.id(genderDrpdwn)).click();
		new Select(driver.findElement(By.id(genderDrpdwn))).selectByVisibleText("Male");
		getUserData();
		saveDriver();
		Thread.sleep(500);
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains(driverName) && str.contains(driverMidName) && str.contains(driverLastName))
		{
			System.out.println("Modify Driver Email - Test Passed");
		}else {
			System.out.println("Modify Driver Email - Test Failed");
		}
	}

	@Test
	public void modifyDriverLicenseNum() throws Exception {
		loginUser();
		driverManagement();
		Thread.sleep(500);
		editDriverBtn();
		Thread.sleep(500);
		driver.findElement(By.id(licenseExpiryDateField)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(500);
		driver.findElement(By.id(licenseExpiryDateField)).sendKeys(randomNum4+"2025");
		getUserData();
		saveDriver();
		Thread.sleep(500);
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains(driverName) && str.contains(driverMidName) && str.contains(driverLastName))
		{
			System.out.println("Modify Driver License Number - Test Passed");
		}else {
			System.out.println("Modify Driver License Number - Test Failed");
		}
	}

	@Test
	public void modifyDriverDateOfBirth() throws Exception {
		loginUser();
		driverManagement();
		Thread.sleep(1000);
		editDriverBtn();
		Thread.sleep(1000);
		driver.findElement(By.id(dateOfBirthField)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.id(dateOfBirthField)).sendKeys(randomNum4+ "1992");
		getUserData();
		Thread.sleep(1000);
		saveDriver();
		Thread.sleep(2000);
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains(driverName) && str.contains(driverMidName) && str.contains(driverLastName))
		{
			System.out.println("Modify Driver Date of Birth - Test Passed");
		}else {
			System.out.println("Modify Driver Date of Birth - Test Failed");
		}
	}

	@Test
	public void modifyDriverCancel() throws Exception {
		loginUser();
		driverManagement();
		Thread.sleep(500);
		editDriverBtn();
		Thread.sleep(500);
		setDriverDetails();
		Thread.sleep(500);
		cancelDriver();
		Thread.sleep(500);
		if (driver.getPageSource().contains("NAVIGATION"))
		{
			System.out.println("Cancel Modification of Driver Details - Test Passed");
		}else {
			System.out.println("Cancel Modification of Driver Details - Test Failed");
		}
	}

	private void loginUser() {
		driver.findElement(By.xpath(btnAuthLogin)).click();
		driver.findElement(By.id(usernameField)).sendKeys(prop.getProperty("rightUsername"));
		driver.findElement(By.id(passwordField)).sendKeys(prop.getProperty("rightPassword"));
		driver.findElement(By.xpath(btnLogin)).click();
	}

	private void driverManagement() {
		driver.findElement(By.xpath(driverManagementBtn)).click();
	}

	private void clickCreateDriverBtn() {
		driver.findElement(By.xpath(createDriverBtn)).click();
	}

	private void editDriverBtn() {
		driver.findElement(By.xpath(editBtn)).click();
	}

	private void setDriverDetails() {
		driver.findElement(By.id(firstNameField)).sendKeys(randomChar10);
		driver.findElement(By.id(middleNameField)).sendKeys(randomChar10);
		driver.findElement(By.id(lastNameField)).sendKeys(randomAlphaNumChar3);
		driver.findElement(By.id(contactNumberField)).sendKeys(randomNum11);
		driver.findElement(By.id(emailField)).sendKeys(randomAlphaNumChar10 +"@"+randomAlphaNumChar3+".com");
		driver.findElement(By.id(genderDrpdwn)).click();
		new Select(driver.findElement(By.id(genderDrpdwn))).selectByIndex(0);
		driver.findElement(By.id(licenseNumberField)).sendKeys(randomNum4);
		driver.findElement(By.id(addressField)).sendKeys(randomAlphaNumChar10);
		driver.findElement(By.id(licenseExpiryDateField)).sendKeys(randomNum4+ "2025");
		driver.findElement(By.id(dateOfBirthField)).sendKeys(randomNum4+ "1992");

	}
	
	public void getUserData() {
		 driverName = driver.findElement(By.id(firstNameField)).getText();
		 driverMidName = driver.findElement(By.id(middleNameField)).getText();
		 driverLastName = driver.findElement(By.id(lastNameField)).getText();
	}

	private void saveDriver() {
		driver.findElement(By.xpath(savedDriverBtn)).click();
	}

	private void cancelDriver() {
		driver.findElement(By.linkText(cancelDriverBtn));
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}

