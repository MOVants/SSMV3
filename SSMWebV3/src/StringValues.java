import org.apache.commons.lang3.RandomStringUtils;

public class StringValues {
	
	protected String randomAlphaNumChar10 = RandomStringUtils.randomAlphanumeric(10);
	protected String randomAlphaNumChar30 = RandomStringUtils.randomAlphanumeric(30);
	protected String randomAlphaNumChar3 = RandomStringUtils.randomAlphanumeric(3);
	protected String randomChar10 = RandomStringUtils.randomAlphabetic(10);
	protected String randomNum11 = RandomStringUtils.randomNumeric(11);
	protected String randomNum4 = RandomStringUtils.randomNumeric(4);
	
	
	
	//	login
	protected String btnAuthLogin = "//button[@type='submit']";
	protected String usernameField = "username";
	protected String passwordField = "password";
	protected String btnLogin = "//button[@type='submit']";

	//	Home
	protected String vehicleManagementBtn = "/html[1]/body[1]/section[1]/aside[1]/div[1]/div[1]/ul[1]/li[3]/a[1]";
	protected String vehicleGroupManagementBtn = "/html[1]/body[1]/section[1]/aside[1]/div[1]/div[1]/ul[1]/li[4]/a[1]/span[1]";
	protected String driverManagementBtn = "/html[1]/body[1]/section[1]/aside[1]/div[1]/div[1]/ul[1]/li[5]/a[1]";

	//	vehicles management

	protected String createVehicleBtn = "//span[text()='Create']";
	protected String vehiclePlateField = "vehicle.plateNumber";
	protected String vehiclechassisNumberField = "vehicle.chassisNumber";
	protected String calPurchaseDate = "input-purchase-date";
	protected String clickForm = "//div[@id='tab-vehicle-info']/div[5]/div/div/div/label";
	protected String vehicleMilageField = "vehicle.vehicleMilage";
	protected String fuelConsumptionField = "vehicle.fuelConsumption";
	protected String vehicleDescriptionField = "vehicle.description";
	protected String drpdwnVehicleManufacturer = "select-manufacturer";
	protected String drpdwnSelectVehicleManufacturer = "select-manufacturer";
	protected String drpdwnVehicletype = "select-vehicle-type";
	protected String drpdwnSelectVehicletype = "select-vehicle-type";
	protected String GPSInfoTab = "//a[contains(text(),'GPS Device Information')]";
	protected String IMEIField = "vehicle.telematicsDevice.imei";
	protected String telematicsSerialNoField = "vehicle.telematicsDevice.serialNumber";
	protected String telematicsMSISDNField = "vehicle.telematicsDevice.msisdn";
	protected String fuelSensorToggle = "//div[@id='tab-gps-device-info']/div[4]/div/div/div/label/span";
	protected String doorSensorToggle = "//div[@id='tab-gps-device-info']/div[4]/div[2]/div/div/label/span";
	protected String firmwareVersionField = "vehicle.telematicsDevice.firmWareVersion";
	protected String appVersionField = "vehicle.telematicsDevice.appVersion";
	protected String doorSensorInstallDate = "input-door-sensor-installation-date";
	protected String vehicleGroupToogleAll = "/html[1]/body[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/label[1]/span[1]";
	protected String vehicleGrouptoggleone = "(.//*[normalize-space(text()) and normalize-space(.)='Is Cylindrical'])[1]/following::span[1]";
	protected String btnSaveVehicle = "btn-save";

	// notification message
	protected String getNotifSuccess = "//span[3]";
	protected String missinfieldError = "This field is required";
	protected String getNotifError = "vehicleGroupName-error";


	//	Vehicle Groups Modules
	protected String editVehicleGroupBtn = "/html[1]/body[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]/span[1]";
	protected String createBtn = "//text()[contains(.,'Create')]/ancestor::a[1]";
	protected String vehicleGroupNameField = "vehicleGroupName";
	protected String vehicleGroupDescField = "description";
	protected String saveBtn = "btn-save";

	// Drivers Modules
	protected String editBtn = "//*[@id=\"driverTable\"]/tbody/tr[1]/td[2]/a";
	protected String createDriverBtn = "//text()[contains(.,'Create')]/ancestor::a[1]";
	protected String firstNameField = "firstName";
	protected String middleNameField = "middleName";
	protected String lastNameField = "lastName";
	protected String contactNumberField = "contactNumber";
	protected String emailField = "email";
	protected String genderDrpdwn = "status-filter";
	protected String licenseNumberField = "licenseNumber";
	protected String addressField = "personnelCurrentAddress";
	protected String licenseExpiryDateField = "licenseExpiryDate";
	protected String dateOfBirthField = "dateOfBirth";
	protected String savedDriverBtn = "//form[@id='driverForm']/div[5]/button";
	protected String cancelDriverBtn = "Cancel";


	public StringValues() {
		super();
	}

}