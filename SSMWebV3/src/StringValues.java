
public class StringValues {
	
	// Vehicles Module
	//usercredentials
	protected String authusername = "marvin.ssmuser@ssm.com";
	protected String authpass = "1";

//	loginforms
	protected String btnAuthLogin = "//button[@type='submit']";
	protected String usernameField = "username";
	protected String passwordField = "password";
	protected String btnLogin = "//button[@type='submit']";
	
	
//	vehiclesform
	protected String vehicleManagementMenu = "/html[1]/body[1]/section[1]/aside[1]/div[1]/div[1]/ul[1]/li[3]/a[1]";
	protected String createVehicleBtn = "//span[text()='Create']";
	protected String vehiclePlateField = "vehicle.plateNumber";
	protected String vehiclechassisNumberField = "vehicle.chassisNumber";
	protected String calPurchaseDate = "input-purchase-date";
	protected String clickForm = "//div[@id='tab-vehicle-info']/div[5]/div/div/div/label";
	protected String vehicleMilageField = "vehicle.vehicleMilage";
	protected String fuelConsumptionField = "vehicle.fuelConsumption";
	protected String cehicleDescriptionField = "vehicle.description";
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
	protected String vehicleGroupToogleAll = "(.//*[normalize-space(text()) and normalize-space(.)='Select All'])[1]/following::span[1]";
	protected String vehicleGrouptoggleone = "(.//*[normalize-space(text()) and normalize-space(.)='Is Cylindrical'])[1]/following::span[1]";
	protected String btnSaveVehicle = "(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]";
	
// notification message
	protected String getNotifSuccess = "//span[3]";
	protected String getNotifError = "vehicleGroupName-error";

	
//	Vehicle Groups Modules
	protected String vehicleGroupTab = "//span[contains(text(),'Groups')]";
	protected String editVehicleGroupBtn = "/html[1]/body[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]/span[1]";
	protected String createBtn = "//a[@class='btn bg-pink waves-effect btn-lg tooltipster tooltipstered']";
	protected String vehicleGroupNameField = "vehicleGroupName";
	protected String vehicleGroupDescField = "description";
	protected String saveBtn = "//text()[contains(.,'Save')]/ancestor::button[1]";
	
// Drivers Modules
	protected String driverManagement = "//span[text()='Drivers']";
	
	
	
	
	
	
	
	
	
	
	public StringValues() {
		super();
	}

}