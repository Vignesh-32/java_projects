package busReservationProject;
import java.util.*;

public class Bus {
int busNo;
String DriverName;
String StartingPoint;
String Destination;
boolean AC;
int capacity;

public Bus(){
	Scanner scan = new  Scanner(System.in);
	System.out.println("Enter Bus No: ");
	busNo = scan.nextInt();
	System.out.println("Enter Driver Name: ");
	DriverName = scan.next();
	System.out.println("Is it AC(True/False): ");
	AC = scan.nextBoolean();
	System.out.println("Enter the  Starting Point: ");
	StartingPoint = scan.next();
	System.out.println("Enter the Destination: ");
	Destination = scan.next();
	System.out.println("Enter the capacity: ");
	capacity = scan.nextInt();
}

}
