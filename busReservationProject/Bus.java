package busReservationProject;
import java.util.*;

public class Bus {
private int busNo;
private String DriverName;
private String StartingPoint;
private String Destination;
private boolean AC;
private int capacity;

public Bus(){
	Scanner scan = new  Scanner(System.in);
	System.out.println("Enter Bus No: ");
	setBusNo(scan.nextInt());
	System.out.println("Enter Driver Name: ");
	setDriverName(scan.next());
	System.out.println("Is it AC(True/False): ");
	setAC(scan.nextBoolean());
	System.out.println("Enter the  Starting Point: ");
	setStartingPoint(scan.next());
	System.out.println("Enter the Destination: ");
	setDestination(scan.next());
	System.out.println("Enter the capacity: ");
	setCapacity(scan.nextInt());
}

public int getBusNo() {
	return busNo;
}

public void setBusNo(int busNo) {
	this.busNo = busNo;
}

public String getDriverName() {
	return DriverName;
}

public void setDriverName(String driverName) {
	DriverName = driverName;
}

public String getStartingPoint() {
	return StartingPoint;
}

public void setStartingPoint(String startingPoint) {
	StartingPoint = startingPoint;
}

public String getDestination() {
	return Destination;
}

public void setDestination(String destination) {
	Destination = destination;
}

public boolean isAC() {
	return AC;
}

public void setAC(boolean aC) {
	AC = aC;
}

public int getCapacity() {
	return capacity;
}

public void setCapacity(int capacity) {
	this.capacity = capacity;
}

}
