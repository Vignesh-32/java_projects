package busReservationProject;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BookingDAO {
	
	public void addBooking(Booking booking) throws SQLException {
		String insert = "insert into booking(pname,mobile,tdate,bus_no,mailid) values(?,?,?,?,?);";
		Connection con = DBconnection.getConnection();
		PreparedStatement pst = con.prepareStatement(insert);
		pst.setString(1, booking.getPassengerName());
		pst.setLong(2, booking.getMobileNumber());
		java.sql.Date sqldate = new java.sql.Date (booking.gettravelDate().getTime());
		pst.setDate(3, sqldate);
		pst.setInt(4, booking.getBusNo());
		pst.setString(5, booking.getMailId());
		int rows = pst.executeUpdate();
	}
	
	public int getbookedcount(int Busno, java.util.Date date) throws SQLException {
		String query = "select count(pname) from booking where bus_no =? and tdate = ?;";
		Connection con = DBconnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, Busno);
		java.sql.Date sqldate = new java.sql.Date (date.getTime());
		pst.setDate(2, sqldate);
		ResultSet rs = pst.executeQuery();
		rs.next();
		return rs.getInt(1);
		}
	
	public int cancelBooking(int Bookingid) throws SQLException {
		String cancel = "update booking set tstatus = 'Cancelled' where booking_id = "+ Bookingid;
		Connection con = DBconnection.getConnection();
		Statement st = con.createStatement();
		int rows = st.executeUpdate(cancel);
		return rows;
	}
	
	public int cancelBooking(int BusNo, String name, int mobileNo, String date) throws SQLException {
		java.util.Date travelDate = new java.util.Date();
		String cancel = "update booking set tstatus = 'Cancelled' where Bus_no=? and pname=? and mobile=? and Tdate=?";
		Connection con = DBconnection.getConnection();
		PreparedStatement pst = con.prepareStatement(cancel);
		pst.setInt(1, BusNo);
		pst.setString(2, name);
		pst.setInt(3, mobileNo);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			travelDate = dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqldate = new java.sql.Date (travelDate.getTime());
		pst.setDate(4, sqldate);
		int rows = pst.executeUpdate();
		return rows;
	}
	
	public void getPassengerInfo(int Bookingid) throws SQLException {
		String PassengerInfo = "Select * from booking where booking_id = "+ Bookingid;
		Connection con = DBconnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(PassengerInfo);
		rs.next();
		System.out.println("-------------------------------------------------------------");
		System.out.println("Name: "+rs.getString(2));
		System.out.println("Mobile Number" + rs.getInt(3));
		System.out.print("BusNo: " + rs.getInt(5)+ "        ");
		System.out.println("Travel Date: " + rs.getDate(4));
		System.out.println("Mail ID: " + rs.getString(6));
		System.out.println("-------------------------------------------------------------");
	}
}
