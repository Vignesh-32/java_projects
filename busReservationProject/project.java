package busReservationProject;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class project {

	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		whileloop:
			while(true) {
			System.out.println("\n-------------------------------LOGIN MENU------------------------------");
			System.out.println("Press:-");
			System.out.println("0 - Check Availability");
			System.out.println("1 - Book a Seat");
			System.out.println("2 - Cancel a seat with Booking_id");
			System.out.println("3 - Cancel a seat without Booking_id");
			System.out.println("4 - Get Passenger Information");
			System.out.println("5 - add the Bus");
			System.out.println("6 - Remove the Bus");
			System.out.println("7 - exit");
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Enter your choice: ");
			int choice = scan.nextInt();
			BookingDAO bookingdao = new BookingDAO();
			BusDAO busdao = new BusDAO();
			switch(choice) {
			case 0:
				System.out.println("Bus Availabilty:- ");
				BusDAO busdisp = new BusDAO();
				busdisp.displayBusAvailability();
				break;
			case 1:
				System.out.println("To book a seat: ");
				Booking booking = new Booking();
				if(booking.isAvailable()) {
					bookingdao.addBooking(booking);
					System.out.println("Your Booking is successfully finished.");
				}
				else {
					System.out.println("Sorry, BusNo "+booking.getBusNo()+" reservation is full on specified date");
				}
				break;
			case 2:
				System.out.println("To cancel a booking enter your Booking Id: ");
				int bookingId = scan.nextInt();
				int row = bookingdao.cancelBooking(bookingId);
				System.out.println("Your booking has been Cancelled");
				break;
			case 3:
				System.out.println("To cancel a booking:-");
				System.out.println("");
				System.out.println("Enter the Bus No:-");
				int busNo = scan.nextInt();
				System.out.println("Enter the Travel Date:-");
				String date = scan.next();
				System.out.println("Enter the Name:-");
				String name = scan.next();
				System.out.println("Enter the Mobile Number:-");
				int mobilenum = scan.nextInt();
				int rw = bookingdao.cancelBooking(busNo, name, mobilenum, date);
				System.out.println("Your booking has been Cancelled");
				break;
			case 4:
				System.out.println("To know passenger information enter the booking id: ");
				int bkgid = scan.nextInt();
				bookingdao.getPassengerInfo(bkgid);
				break;
			case 5:
				System.out.println("To add a bus : ");
				Bus bus = new Bus();
				busdao.addBus(bus);
				break;
			case 6:
				System.out.print("To cancel a bus enter bus no :");
				int bNo = scan.nextInt();
				busdao.cancelBus(bNo);
				System.out.println("Bus No "+bNo+ "has been Cancelled");
				break;
			case 7:
				System.out.println("Thank You");
				break whileloop;			
			}
		}
	}

}
