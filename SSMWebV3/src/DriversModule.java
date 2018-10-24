
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.*;
import org.openqa.selenium.*;

public class DriversModule extends StringValues{
	private WebDriver driver;
	private String baseUrl;


	@Before
	public void setUp() throws Exception {


//		System.setProperty("webdriver.gecko.driver","/home/marvin/Documents/Selinium/geckodriver"); 
//		driver = new FirefoxDriver();
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
		String driverName = driver.findElement(By.id(firstNameField)).getText();
		saveDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains(driverName))
		{
			System.out.println("Create Driver - Test Pass");
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (driver.getPageSource().contains("This field is required."))
		{
			System.out.println("Create Driver Missing Name- Test Pass");
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (driver.getPageSource().contains("This field is required."))
		{
			System.out.println("Create Driver Missing Middle Name- Test Pass");
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (driver.getPageSource().contains("This field is required."))
		{
			System.out.println("Create Driver Missing Last Name- Test Pass");
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (driver.getPageSource().contains("This field is required."))
		{
			System.out.println("Create Driver Missing Contact Number- Test Pass");
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (driver.getPageSource().contains("This field is required."))
		{
			System.out.println("Create Driver Missing Email- Test Pass");
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (driver.getPageSource().contains("This field is required."))
		{
			System.out.println("Create Driver Gender is Male- Test Pass");
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (driver.getPageSource().contains("This field is required."))
		{
			System.out.println("Create Driver Missing license Number- Test Pass");
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (driver.getPageSource().contains("This field is required."))
		{
			System.out.println("Create Driver Missing Address- Test Pass");
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (driver.getPageSource().contains("This field is required."))
		{
			System.out.println("Create Driver Missing License Expiry Date- Test Pass");
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (driver.getPageSource().contains("This field is required."))
		{
			System.out.println("Create Driver Missing Date Of Birth- Test Pass");
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
		Thread.sleep(3000);
		if (driver.getPageSource().contains("NAVIGATION"))
		{
			System.out.println("Cancel Create Driver - Test Pass");
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
		String driverName = driver.findElement(By.id(firstNameField)).getText();
		String driverMidName = driver.findElement(By.id(middleNameField)).getText();
		String driverLastName = driver.findElement(By.id(lastNameField)).getText();
		Thread.sleep(1000);
		setDriverDetails();
		saveDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains(driverName) && str.contains(driverMidName) && str.contains(driverLastName))
		{
			System.out.println("Modify Driver Details - Test Pass");
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
		driver.findElement(By.id(firstNameField)).sendKeys(RandomStringUtils.randomAlphabetic(6));
		String driverName = driver.findElement(By.id(firstNameField)).getText();
		String driverMidName = driver.findElement(By.id(middleNameField)).getText();
		String driverLastName = driver.findElement(By.id(lastNameField)).getText();
		saveDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains(driverName) && str.contains(driverMidName) && str.contains(driverLastName))
		{
			System.out.println("Modify Driver Name - Test Pass");
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
		driver.findElement(By.id(middleNameField)).sendKeys(RandomStringUtils.randomAlphabetic(6));
		String driverName = driver.findElement(By.id(firstNameField)).getText();
		String driverMidName = driver.findElement(By.id(middleNameField)).getText();
		String driverLastName = driver.findElement(By.id(lastNameField)).getText();
		saveDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains(driverName) && str.contains(driverMidName) && str.contains(driverLastName))
		{
			System.out.println("Modify Driver Middle Name - Test Pass");
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
		driver.findElement(By.id(lastNameField)).sendKeys(RandomStringUtils.randomAlphabetic(6));
		String driverName = driver.findElement(By.id(firstNameField)).getText();
		String driverMidName = driver.findElement(By.id(middleNameField)).getText();
		String driverLastName = driver.findElement(By.id(lastNameField)).getText();
		saveDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains(driverName) && str.contains(driverMidName) && str.contains(driverLastName))
		{
			System.out.println("Modify Driver Last Name - Test Pass");
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
		driver.findElement(By.id(contactNumberField)).sendKeys(RandomStringUtils.randomNumeric(6));
		String driverName = driver.findElement(By.id(firstNameField)).getText();
		String driverMidName = driver.findElement(By.id(middleNameField)).getText();
		String driverLastName = driver.findElement(By.id(lastNameField)).getText();
		saveDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains(driverName) && str.contains(driverMidName) && str.contains(driverLastName))
		{
			System.out.println("Modify Driver Contact Number - Test Pass");
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
		driver.findElement(By.id(emailField)).sendKeys(RandomStringUtils.randomNumeric(6));
		String driverName = driver.findElement(By.id(firstNameField)).getText();
		String driverMidName = driver.findElement(By.id(middleNameField)).getText();
		String driverLastName = driver.findElement(By.id(lastNameField)).getText();
		saveDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains(driverName) && str.contains(driverMidName) && str.contains(driverLastName))
		{
			System.out.println("Modify Driver Email - Test Pass");
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
		String driverName = driver.findElement(By.id(firstNameField)).getText();
		String driverMidName = driver.findElement(By.id(middleNameField)).getText();
		String driverLastName = driver.findElement(By.id(lastNameField)).getText();
		saveDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains(driverName) && str.contains(driverMidName) && str.contains(driverLastName))
		{
			System.out.println("Modify Driver Email - Test Pass");
		}else {
			System.out.println("Modify Driver Email - Test Failed");
		}
	}

	@Test
	public void modifyDriverLicenseNum() throws Exception {
		loginUser();
		driverManagement();
		Thread.sleep(1000);
		editDriverBtn();
		Thread.sleep(1000);
		driver.findElement(By.id(licenseExpiryDateField)).clear();
		driver.findElement(By.id(licenseExpiryDateField)).sendKeys(RandomStringUtils.randomNumeric(6));
		String driverName = driver.findElement(By.id(firstNameField)).getText();
		String driverMidName = driver.findElement(By.id(middleNameField)).getText();
		String driverLastName = driver.findElement(By.id(lastNameField)).getText();
		saveDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains(driverName) && str.contains(driverMidName) && str.contains(driverLastName))
		{
			System.out.println("Modify Driver License Number - Test Pass");
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
		driver.findElement(By.id(dateOfBirthField)).clear();
		driver.findElement(By.id(dateOfBirthField)).sendKeys(RandomStringUtils.randomNumeric(6));
		String driverName = driver.findElement(By.id(firstNameField)).getText();
		String driverMidName = driver.findElement(By.id(middleNameField)).getText();
		String driverLastName = driver.findElement(By.id(lastNameField)).getText();
		saveDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String str = driver.findElement(By.xpath(getNotifSuccess)).getText();
		if (str.contains(driverName) && str.contains(driverMidName) && str.contains(driverLastName))
		{
			System.out.println("Modify Driver Date of Birth - Test Pass");
		}else {
			System.out.println("Modify Driver Date of Birth - Test Failed");
		}
	}

	@Test
	public void modifyDriverCancel() throws Exception {
		loginUser();
		driverManagement();
		Thread.sleep(1000);
		editDriverBtn();
		Thread.sleep(1000);
		setDriverDetails();
		cancelCreateDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (driver.getPageSource().contains("NAVIGATION"))
		{
			System.out.println("Cancel Modification of Driver Details - Test Pass");
		}else {
			System.out.println("Cancel Modification of Driver Details - Test Failed");
		}
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

	private void editDriverBtn() {
		driver.findElement(By.xpath(editBtn)).click();
	}

	private void setDriverDetails() {
		driver.findElement(By.id(firstNameField)).sendKeys(RandomStringUtils.randomNumeric(6));
		driver.findElement(By.id(middleNameField)).sendKeys(RandomStringUtils.randomNumeric(6));
		driver.findElement(By.id(lastNameField)).sendKeys(RandomStringUtils.randomNumeric(6));
		driver.findElement(By.id(contactNumberField)).sendKeys(RandomStringUtils.randomNumeric(6));
		driver.findElement(By.id(emailField)).sendKeys(RandomStringUtils.randomNumeric(4)+"@"+RandomStringUtils.randomNumeric(3)+".com");
		driver.findElement(By.id(genderDrpdwn)).click();
		new Select(driver.findElement(By.id(genderDrpdwn))).selectByVisibleText("Female");
		driver.findElement(By.id(licenseNumberField)).sendKeys(RandomStringUtils.randomNumeric(8));
		driver.findElement(By.id(addressField)).sendKeys(RandomStringUtils.randomNumeric(6));
		driver.findElement(By.id(licenseExpiryDateField)).sendKeys("02022019");
		driver.findElement(By.id(dateOfBirthField)).sendKeys("02021992");

	}

	private void saveDriver() {
		driver.findElement(By.xpath(savedDriverBtn)).click();
	}

	private void cancelDriver() {
		driver.findElement(By.xpath(cancelDriverBtn));
	}

	private void setBrowserConfig() {

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}

