/*
*@author Abhishek Sirohi
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.zendesk.client.v2.Zendesk;
import org.zendesk.client.v2.model.Ticket;

//Main Class that lists out the tickets
public class TicketList {
	private Zendesk instance;
	public static Scanner scan;
	static TicketList tl = new TicketList();
	String url = "https://abccorphelp.zendesk.com";
	static String array[] = new String[4];

	public static void main(String[] args) {
		tl.run();
	}

// Run method which prints the menu and calls the functions.
	public void run() {

		System.out.println("Welcome to the ticket listing system!");
		String userName = "asirohi90@gmail.com";
		String userPwd = "Sunita@5";
		while (true) {

			System.out.println("Select View Options\n(1.) Press 1 to see all the tickets\n(2.) "
					+ "Press 2 to see a specific ticket\n(2.) Press 3 to exit");
			scan = new Scanner(System.in);
			int choice = scan.nextInt();
			switch (choice) {
			case 1: {
				long startTime = System.nanoTime();
				tl.getAllTickets(userName, userPwd);
				long endTime = System.nanoTime();
				System.out.println("Time Taken:" + ((endTime - startTime) / 1000000000) + " seconds");
			}
				break;
			case 2: {
				System.out.println("Please Enter the Ticket Id:");
				int tickID = scan.nextInt();
				long startTime = System.nanoTime();
				tl.getTicket(tickID, userName, userPwd);
				long endTime = System.nanoTime();
				System.out.println("Time Taken:" + ((endTime - startTime) / 1000000000) + " seconds");
				break;
			}
			case 3: {
				System.out.println("Thank you for using the ticket listing system!");
				System.exit(0);
			}
			}
		}
	}

// This function lists out a specific ticket

	public void getTicket(int tickID, String userName, String userPwd) {
		try {
			final Zendesk.Builder builder = new Zendesk.Builder(url).setUsername(userName);
			builder.setPassword(userPwd);
			instance = builder.build();
			Ticket t = instance.getTicket(tickID);
			System.out.println("Subject | " + t.getSubject() + " | Submitted by " + t.getSubmitterId() + " | on | "
					+ t.getCreatedAt());
		} catch (Exception e) {
			System.out.println("Couldn't Connect to Zendesk. Username or Password is incorrect!");
			System.exit(0);
		}
	}
// This function lists out all the tickets present in the system.

	public void getAllTickets(String userName, String userPwd) {
		try {
			final Zendesk.Builder builder = new Zendesk.Builder(url).setUsername(userName);
			builder.setPassword(userPwd);
			instance = builder.build();
			for (Ticket t : instance.getTickets()) {
				System.out.println("Subject | " + t.getSubject() + " | Submitted by " + t.getSubmitterId() + " | on | "
						+ t.getCreatedAt());
			}
		} catch (Exception e) {
			System.out.println("Couldn't Connect to Zendesk. Username or Password is incorrect!");
			System.exit(0);
		}
	}

	public void testAuthorizationException(String userName, String userPwd) {
		final Zendesk.Builder builder = new Zendesk.Builder(url).setUsername(userName);
		builder.setPassword(userPwd);
		instance = builder.build();
	}
}
