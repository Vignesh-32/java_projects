package busReservationProject;

import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.*;
public class Booking {
	private int BusNo;
	private String passengerName;
	private Date travelDate;
	private long mobileNumber;
	private String mailId;
Scanner Scan = new Scanner(System.in);	
Booking(){
	System.out.println("Enter the Bus number: ");
	BusNo = Scan.nextInt();
	System.out.println("Enter the Passenger Name: ");
	setPassengerName(Scan.next());
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
	setMobileNumber(Scan.nextLong());
	System.out.println("Enter the MailId: ");
	setMailId(Scan.next());
}
public boolean isAvailable() throws SQLException {
	BookingDAO bookingdao = new BookingDAO();
	BusDAO busdao = new BusDAO();
	int capacity = bookingdao.getbookedcount(BusNo, travelDate);
	int Totalcap = busdao.getcapacity(BusNo);
	return capacity<Totalcap;
}
public void setBusNo(int BusNo) {
	this.BusNo = BusNo;
}
public int getBusNo() {
	return BusNo;
}
public void settravelDate(String travelDate) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	try {
		this.travelDate = dateFormat.parse(travelDate);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public Date gettravelDate() {
	return travelDate;
}
public String getPassengerName() {
	return passengerName;
}
public void setPassengerName(String passengerName) {
	this.passengerName = passengerName;
}
public long getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(long mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public String getMailId() {
	return mailId;
}
public void setMailId(String mailId) {
	this.mailId = mailId;
}

}
