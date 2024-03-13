package busReservationProject;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BusDAO {
	public void displayBusAvailability() throws SQLException {
		java.sql.Date bDate = getBookingDate();
		String query = "select * from bus;";
		Connection con = DBconnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		BookingDAO bookingdao = new BookingDAO(); 
		System.out.println("-----------------------------------------------------------------------");
		while(rs.next()) {
			int rem_seats = rs.getInt(7) - bookingdao.getbookedcount(rs.getInt(2), bDate);
			System.out.print("Bus No: "+rs.getInt(2)+"                ");
			System.out.println("Driver Name: " + rs.getString(3));
			System.out.print("Starting Point: " + rs.getString(4)+"  ");
			System.out.println("Destination: " + rs.getString(5));
			System.out.print("Total Seats: " + rs.getInt(7) +"     ");
			System.out.print("Remaining Seats: " + rem_seats +"    ");
			if(rs.getInt(6)==1)
				System.out.println("AC: YES");
			else
				System.out.println("AC: NO");
				System.out.println(" ");
		}
		System.out.println("-----------------------------------------------------------------------");
	}
	
	public int getcapacity(int Busno) throws SQLException {
		String query = "select capacity from bus where Bus_no = " + Busno;
		Connection con = DBconnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		return rs.getInt(1);
		}
	public static java.sql.Date getBookingDate() {
		java.util.Date tDate = new Date();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the date of travel dd-mm-yyyy: ");
		String strdate = scan.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			tDate = dateFormat.parse(strdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqlTDate = new java.sql.Date (tDate.getTime());
		return sqlTDate;
	}
	
	public int addBus(Bus bus) throws SQLException {
		String insert = "insert into bus(Bus_No,Driver,Starting_point,Destination,AC,Capacity) values(?,?,?,?,?,?);";
		Connection con = DBconnection.getConnection();
		PreparedStatement pst = con.prepareStatement(insert);
		pst.setInt(1, bus.getBusNo());
		pst.setString(2, bus.getDriverName());
		pst.setString(3, bus.getStartingPoint());
		pst.setString(4, bus.getDestination());
		pst.setBoolean(5, bus.isAC());
		pst.setInt(6, bus.getCapacity());
		int row = pst.executeUpdate();
		return row;
	}
	public int cancelBus(int BusNo) throws SQLException {
		String cancel = "update bus set bstatus = 'Cancelled' where Bus_No = "+ BusNo;
		Connection con = DBconnection.getConnection();
		Statement pst = con.createStatement();
		int row = pst.executeUpdate(cancel);
		return row;
	}
}
