
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SmartPlug extends SmartObject implements Programmable {

	private boolean status;
	private Calendar programTime;
	private boolean programAction;

	public SmartPlug() {

	}

	public SmartPlug(String alias, String macId) { // Constructor

		setStatus(status);
		setProgramTime(programTime);
		setProgramAction(programAction);
		setAlias(alias);
		setMacId(macId);

	}

	public void turnOn() { // turnOn method prints the plug status based on it's status property.

		if (isConnectionStatus() == true) {

			if (isStatus() == false) {

				System.out
						.println("Smart Plug - " + getAlias() + " is turned on now  (Current time: " + getTime() + ")");
			} else {

				System.out.println("Smart Plug - " + getAlias() + " has been already turned on ");
			}

		}
		setProgramAction(true);

	}

	public void turnOff() { // turnOn method prints the plug status based on it's status property.

		if (isConnectionStatus() == true) {

			if (isStatus() == true) {

				System.out.println("Smart Plug - " + getAlias() + " has been already turned off  ");

			} else {
				System.out.println(
						"Smart Plug - " + getAlias() + " is turned off now  (Current time: " + getTime() + ")");

			}
		}
		setProgramAction(false);

	}

	public void setTimer(int seconds) { /*
										 * setTimer method sets the timer of a smart light with the given amount of
										 * seconds and the it prints some informative messages
										 */

		if (isConnectionStatus() == true) {

			Calendar calendar = Calendar.getInstance();

			Date date = new Date();
			date.setTime(date.getTime() + seconds * 1000);
			setProgramTime(calendar);

			if (isStatus() == true) {

				System.out.println("Smart plug - " + getAlias() + " will be turned on " + seconds + " seconds later! "
						+ "(Current time: " + getTime() + ")");
				setProgramAction(true);

			} else
				System.out.println("Smart plug - " + getAlias() + " will be turned off " + seconds + " seconds later! "
						+ "(Current time: " + getTime() + ")");
			setProgramAction(false);
		} else
			System.out.println("The system is not connected");

	}

	public void cancelTimer() { // cancelTimer method resets the programTime time's.

		if (isConnectionStatus() == true) {

			programTime = null;
		} else
			System.out.println("The system is not connected");

	}

	public void runProgram() { //// runProgram method runs the given object based on programAction value.

		if (isConnectionStatus() == true) {

			if (isProgramAction() == true) {

				turnOn();
				setProgramAction(true);
			} else {

				turnOff();
				setProgramAction(false);
			}

		}

	}

	public boolean testObject() { // testObject method tests the given device.

		if (isConnectionStatus() == true) {

			SmartObjectToString();
			turnOn();
			turnOff();
			System.out.println("Test completed for SmartPlug");
			return true;
		} else
			return false;

	}

	public boolean shutDownObject() { // shutDownObject method shuts all the smart plugs if they are open.

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

	public Calendar getProgramTime() {
		return programTime;
	}

	public void setProgramTime(Calendar programTime) {
		this.programTime = programTime;
	}

	public boolean isProgramAction() {
		return programAction;
	}

	public void setProgramAction(boolean programAction) {
		this.programAction = programAction;
	}

	public String getTime() { // getTime method returns the current time in the specified format with string.

		DateFormat dateFormat = new SimpleDateFormat(" HH:mm:ss");
		programTime = Calendar.getInstance();
		String time = dateFormat.format(programTime.getTime());

		return time;
	}

}
