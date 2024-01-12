package busReservationProject;

import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.*;
public class Booking {
	int BusNo;
	String passengerName;
	Date travelDate;
	long mobileNumber;
	String mailId;
Scanner Scan = new Scanner(System.in);	
Booking(){
	System.out.println("Enter the Bus number: ");
	BusNo = Scan.nextInt();
	System.out.println("Enter the Passenger Name: ");
	passengerName = Scan.next();
	System.out.println("Enter the date of travel dd-mm-yyyy: ");
	String strdate = Scan.next();
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	try {
		travelDate = dateFormat.parse(strdate);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Enter the Mobile Number: ");
	mobileNumber = Scan.nextLong();
	System.out.println("Enter the MailId: ");
	mailId = Scan.next();
}
public boolean isAvailable() throws SQLException {
	BookingDAO bookingdao = new BookingDAO();
	BusDAO busdao = new BusDAO();
	int capacity = bookingdao.getbookedcount(BusNo, travelDate);
	int Totalcap = busdao.getcapacity(BusNo);
	return capacity<Totalcap;
}

}
