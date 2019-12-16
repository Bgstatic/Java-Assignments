

public abstract class SmartObject {
   
	private String alias; 
	private String macId;
	private String IP;
	private boolean connectionStatus;
	
	public SmartObject() {// Constructor.
		
		setAlias(alias);
		setMacId(macId);
		setIP(IP);
		setConnectionStatus(connectionStatus);
	}
	public boolean connect(String IP) { // connect method connects the device with informative message.
		
		setIP(IP);
		setConnectionStatus(true);
		
		System.out.println(getAlias()
				+ " connection established " );
		return true;
		
	}
	public boolean disconnect() { // disconnect method disconnects the device.
		
		setIP(this.IP);
		setConnectionStatus(false);
		
		return false;
		
	}
	public void SmartObjectToString() { 
		System.out.println("Test is starting for " + getClass().getSimpleName());
		System.out.println("This is " + getClass().getSimpleName() + " device " + alias);
		System.out.println("        MacId: " + this.macId);
		System.out.println("        IP: " + this.IP);
		
		
	}
	public boolean controlConnection() { // controlConnection prints the status of the connection of a device based on connectin status.
		
		if(this.connectionStatus == false) {
			
			System.out.println("This device is not connected. " + getClass() + " -> " + alias );
			
			return false;
		}
		return true;
		
	}
	// abstract methods
	public abstract boolean testObject();
	
	public abstract boolean shutDownObject();
	
	// Getter and setter methods.
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public String getMacId() {
		return macId;
	}
	public void setMacId(String macId) {
		this.macId = macId;
	}
	public boolean isConnectionStatus() {
		return connectionStatus;
	}
	public void setConnectionStatus(boolean connectionStatus) {
		this.connectionStatus = connectionStatus;
	}
	
}
