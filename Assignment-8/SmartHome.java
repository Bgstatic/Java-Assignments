

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.sun.javafx.geom.transform.GeneralTransform3D;

public class SmartHome {

	private ArrayList<SmartObject> smartObjectList = new ArrayList<SmartObject>();

	public SmartHome() { // Constructor.

	}

	public boolean addSmartObject(SmartObject smartObject) { /* addSmartObject methods add the all smart objects to the given list.
		                                                      and it arranges the all the smart objects IP value to the given order.*/

		int adder = -1;
		smartObjectList.add(smartObject);
		System.out.println("--------------------------------------------------------------------------- ");
		System.out.println("--------------------------------------------------------------------------- ");
		System.out.println("Adding new SmartObject ");
		System.out.println("---------------------------------------------------------------------------");
		smartObject.connect("10.0.0.10" + inceaseId(adder)); // set the Id with increaseId.
		smartObject.testObject();
		System.out.println();
		

		return true;
	}

	public boolean removeSmartObject(SmartObject smartObject) { // removeSmartObject method removes the smart objects from the given list.

		return smartObjectList.remove(smartObject);
	}

	public void controlLocation(boolean onCome) { /* controlLocation method takes a boolean parameter and 
		                                             it invokes the onCome method with checking the parameter.*/

		System.out.println("--------------------------------------------------------------------------- ");
		System.out.println("--------------------------------------------------------------------------- ");
		System.out.println("LocationControl : OnCome ");
		System.out.println("---------------------------------------------------------------------------");

		for (int i = 0; i < smartObjectList.size(); i++) {

			if (smartObjectList.get(i) instanceof LocationControl) {

				if (onCome == true) {

					((LocationControl) smartObjectList.get(i)).onCome();
				}
			}
		}
	}

	public void controlMotion(boolean hasMotion, boolean isDay) { /* controlMotion method takes two boolean parameter and 
		                                             it invokes the controlMotion method with checking the parameters.  */

		System.out.println("--------------------------------------------------------------------------- ");
		System.out.println("--------------------------------------------------------------------------- ");
		System.out.println("ControlMotion : hasMotion, isDay ");
		for (int i = 0; i < smartObjectList.size(); i++) {

			if (smartObjectList.get(i) instanceof MotionControl) {
				((MotionControl) smartObjectList.get(i)).controlMotion(hasMotion, isDay);

			}

		}
		System.out.println("--------------------------------------------------------------------------- ");
		System.out.println("--------------------------------------------------------------------------- ");
	}

	public void controlProgrammable() { /* controlProgrammable method invokes the controlProgrammable method and then it prints the method.
                                   .  */
		
		System.out.println("--------------------------------------------------------------------------- ");
		System.out.println("--------------------------------------------------------------------------- ");
		System.out.println("Programmable : runProgram ");
		System.out.println("---------------------------------------------------------------------------");

		for (int i = 0; i < smartObjectList.size(); i++) {

			if (smartObjectList.get(i) instanceof Programmable) {
				System.out.println(
						"runProgram -> " + getClass().getSimpleName() + " - " + smartObjectList.get(i).getAlias());
				((Programmable) smartObjectList.get(i)).runProgram();
				
			}

		}

	}

	public void controlTimer(int seconds) { // controlTimer method invokes the setTimer method with given seconds value.

		for (int i = 0; i < smartObjectList.size(); i++) {

			if (smartObjectList.get(i) instanceof Programmable) {

				if (seconds > 0) {
					System.out.println("--------------------------------------------------------------------------- ");
					System.out.println("--------------------------------------------------------------------------- ");
					System.out.println("Programmable : Timer = " + seconds);
					System.out.println("---------------------------------------------------------------------------");
					((Programmable) smartObjectList.get(i)).setTimer(seconds);

				} else if (seconds == 0) {
					System.out.println("--------------------------------------------------------------------------- ");
					System.out.println("--------------------------------------------------------------------------- ");
					System.out.println("Programmable : cancelTimer ");
					System.out.println("---------------------------------------------------------------------------");
					((Programmable) smartObjectList.get(i)).cancelTimer();

				}
			}
		}

	}

	public void controlTimerRandomly() { /* controlTimerRandomly method invokes the setTimer methods with random values.*/

		System.out.println("Programmable : Timer = 5 or 10 seconds randomly\r\n"
				+ "---------------------------------------------------------------------------");
		int[] randomArray = new int[3];
		randomArray[0] = 0;
		randomArray[1] = 5;
		randomArray[2] = 10;
		List<Integer> givenList = Arrays.asList(0, 5, 10);

		for (int i = 0; i < smartObjectList.size(); i++) {
			Random rand = new Random();
			int randomElement = givenList.get(rand.nextInt(givenList.size()));

			if (smartObjectList.get(i) instanceof Programmable) {

				if (randomElement == 5) {

					((Programmable) smartObjectList.get(i)).setTimer(randomArray[1]);

				} else if (randomElement == 10) {

					((Programmable) smartObjectList.get(i)).setTimer(randomArray[2]);
				} else if (randomElement == 0) {

					((Programmable) smartObjectList.get(i)).cancelTimer();

				}

			}
		}
	}

	public void sortCameras() { // sortCameras method sorts the camera's battery lifes from smallest to biggest.

		ArrayList<SmartCamera> cameraList = new ArrayList<SmartCamera>();

		for (int i = 0; i < smartObjectList.size(); i++) {

			if (smartObjectList.get(i) instanceof SmartCamera) {

				cameraList.add((SmartCamera) smartObjectList.get(i));

			}
		}
		SmartCamera[] batteryList = new SmartCamera[cameraList.size()];

		for (int i = 0; i < batteryList.length; i++) {

			batteryList[i] = cameraList.get(i);
		}

		java.util.Arrays.sort(batteryList);
		System.out.println("---------------------------------------------------------------------------\r\n"
				+ "---------------------------------------------------------------------------\r\n"
				+ "Sort Smart Cameras\r\n"
				+ "---------------------------------------------------------------------------");
		for (int i = 0; i < cameraList.size(); i++) {

			System.out.println(batteryList[i].toString());

		}
	}

	// Getter and setter methods.
	public ArrayList<SmartObject> getSmartObjectList() {
		return smartObjectList;
	}

	public void setSmartObjectList(ArrayList<SmartObject> smartObjectList) {
		this.smartObjectList = smartObjectList;
	}

	public int inceaseId(int id) {

		for (int i = 0; i < smartObjectList.size(); i++) {

			id++;
		}
		return id;
	}

	int getRandomNumber(int[] arr) {
		return arr[(new Random()).nextInt(arr.length)];
	}

}
