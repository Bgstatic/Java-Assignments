

public class SmartCamera extends SmartObject implements MotionControl, Comparable<SmartCamera> {

	private boolean status;
	private int batteryLife;
	private boolean nightVision;

	public SmartCamera(String alias, String macId, boolean nightVision, int batteryLife) { // Constructor of SmartCamera

		setStatus(status);
		setBatteryLife(batteryLife);
		setNightVision(nightVision);
		setAlias(alias);
		setMacId(macId);

	}

	public SmartCamera() {
		// TODO Auto-generated constructor stub
	}

	public void recordOn(boolean isDay) { /*
											 * recordOn method takes boolean parameter and it prints some information
											 * about camera's status based on boolean parameter.
											 */

		if (isConnectionStatus() == true) {

			if (isStatus() == true) {

				System.out.println("Smart Camera - " + getAlias() + " has been already turned on  ");

			} else {

				System.out.println("Smart Camera - " + getAlias() + " turned on now ");
			}
			if (isDay == false) {

				if (this.nightVision == false) {

					System.out.println("Sorry! Smart Camera - " + getAlias() + " does not have night vision feature. ");
				}
			} else {

			}
		}

	}

	public void recordOff() {/* recordOff method turns off the smart camera . */

		if (isConnectionStatus() == true) {

			if (isStatus()) {
				System.out.println("Smart Camera - " + getAlias() + " has been already turned off");

			} else
				System.out.println(" Smart Camera - " + getAlias() + " turned off now ");
		}
		setStatus(false);
	}

	public int compareTo(SmartCamera smartcamera) { // compareTo method compares the smart cameras batter life's from
													// smallest to biggest

		if (getBatteryLife() > smartcamera.getBatteryLife()) {

			return 1;
		} else if (getBatteryLife() == smartcamera.getBatteryLife()) {

			return 0;
		} else {

			return -1;
		}

	}

	public boolean controlMotion(boolean hasMotion,
			boolean isDay) { /*
								 * controlMotion method takes two parameter and it prints motion status based on
								 * it's parameter
								 */

		if (isConnectionStatus() == true) {

			if (hasMotion == true) {

				System.out.println("Motion detected!");
			} else {

				System.out.println("Motion not detected!");
			}

			if (isDay == true) {

				recordOn(isDay);
			} else {

				if (this.nightVision == true) {

					recordOn(isDay);
				} else {

					recordOff();
				}
			}
		}

		return false;
	}

	@Override
	public boolean testObject() { // testObject method tests the smart camera with smart cameras functions.

		if (isConnectionStatus() == true) {

			SmartObjectToString();
			System.out.println("Test is starting for SmartCamera day time ");
			recordOn(true);
			recordOff();
			System.out.println("Test is starting for SmartCamera night time");
			recordOn(false);
			recordOff();
			System.out.println("Test completed for " + getClass().getSimpleName());
			return true;
		} else
			return false;
	}

	@Override
	public boolean shutDownObject() { // shutDownObject method shuts all the smart cameras if they are open.
		if (isConnectionStatus() == true) {

			SmartObjectToString();

			if (isStatus() == true) {

				setStatus(false);
				return true;

			} else
				return false;
		} else
			return false;
	}

	// getter and setter methods.

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getBatteryLife() {
		return batteryLife;
	}

	public void setBatteryLife(int batteryLife) {
		this.batteryLife = batteryLife;
	}

	public boolean isNightVision() {
		return nightVision;
	}

	public void setNightVision(boolean nightVision) {
		this.nightVision = nightVision;
	}

	@Override
	public String toString() { // toString method for printing the smart cameras batteryLife.

		return "SmartCamera -> " + getAlias() + "'s battery life is " + getBatteryLife() + " status is recording";

	}

}
