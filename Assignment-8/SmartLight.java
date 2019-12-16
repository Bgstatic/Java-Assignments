

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SmartLight extends SmartObject implements LocationControl, Programmable {

	private boolean hasLightTurned;
	private Calendar programTime;
	private boolean programAction;

	public SmartLight() {

	}

	public SmartLight(String alias, String macId) { // Constructor

		setProgramTime(programTime);
		setProgramAction(programAction);
		setAlias(alias);
		setMacId(macId);

	}

	public void turnOnLight() { // turnOnLight method turns on the light with the given string value.

		if (isConnectionStatus() == true) {

			if (isHasLightTurned() == false) {

				System.out
						.println("Smart Light - " + getAlias() + " is turned on now (Current time: " + getTime() + ")");
			} else {

				System.out.println("Smart Light - " + getAlias() + " has been already turned on ");
			}

		}
		setProgramAction(true);

	}

	public void turnOffLight() { // turnOffLight method turns off the light with the given string value.

		if (isConnectionStatus() == true) {

			if (isHasLightTurned() == true) {

				System.out.println("Smart Light - " + getAlias() + " has been already turned off ");

			} else {
				System.out.println(
						"Smart Light - " + getAlias() + " is turned off now (Current time: " + getTime() + ")");

			}
		}
		setProgramAction(false);
	}

	public void setTimer(int seconds) { /* setTimer method sets the programTime's time with the current time then it adds the seconds
		                                  to the programTime and it prints some informative messages */

		if (isConnectionStatus() == true) {

			Calendar calendar = Calendar.getInstance();
			Date date = new Date();
			date.setTime(date.getTime() + seconds * 1000);
			setProgramTime(calendar);

			if (isHasLightTurned() == true) {

				System.out.println("Smart light - " + getAlias() + " will be turned on " + seconds + " seconds later! "
						+ "(Current time: " + getTime() + ")");
				setProgramAction(true);
			} else
				System.out.println("Smart light - " + getAlias() + " will be turned off " + seconds + " seconds later! "
						+ "(Current time: " + getTime() + ")");
			setProgramAction(false);
		} else
			System.out.println("The system is not connected");
	}

	public void cancelTimer() { // cancelTimer method resets the programTime's time.

		if (isConnectionStatus() == true) {

			programTime = null;
		} else
			System.out.println("The system is not connected");

	}

	public void runProgram() { // runProgram method runs the given object based on programAction value.

		if (isConnectionStatus() == true) {

			if (isProgramAction() == true) {

				turnOnLight();
				setProgramAction(true);
			} else {

				turnOffLight();
				setProgramAction(false);
			}
		}

	}

	public void onLeave() { // onLeave method turns off the light based on setHasLightTurned value.

		if (isConnectionStatus() == true) {

			setHasLightTurned(false);

			System.out.println("On Leave -> Smart Light - " + getAlias());
			System.out.println("Smart Light - " + getAlias() + " is turned off now  (Current time: " + getTime() + ")");
		} else
			System.out.println("The system is not connected");

	}

	public void onCome() { // onCome method turns on the light based on setHasLightTurned value.

		if (isConnectionStatus() == true) {

			setHasLightTurned(true);

			System.out.println("On Come -> Smart Light - " + getAlias());
			System.out.println("Smart Light - " + getAlias() + " is turned on now  (Current time: " + getTime() + ")");
		} else
			System.out.println("The system is not connected");

	}

	public boolean testObject() { // testObject method tests the given device.

		if (isConnectionStatus() == true) {

			SmartObjectToString();
			turnOnLight();
			turnOffLight();
			System.out.println("Test completed for SmartLight");
			return true;
		} else
			return false;

	}

	public boolean shutDownObject() {// shutDownObject method shuts all the smart lights if they are open.

		if (isConnectionStatus() == true) {

			SmartObjectToString();

			if (isHasLightTurned() == true) {

				setHasLightTurned(false);
				return true;

			} else
				return false;
		} else
			return false;
	}
     // Getter and setter methods.
	public boolean isHasLightTurned() {
		return hasLightTurned;
	}

	public void setHasLightTurned(boolean hasLightTurned) {
		this.hasLightTurned = hasLightTurned;
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
