/*
*@author Abhishek Sirohi
*/
import org.junit.Test;

//This class checks the API authorization
public class TicketListTest {
	TicketList tickList = new TicketList();

	public static void main(String[] args) {
		TicketListTest testCase = new TicketListTest();
		testCase.test1();
		testCase.test2();
	}

	String userName = "asirohi90@gmail.com";
	String userPwd = "Sunita@5";
	String userName2 = "xyz";
	String userPwd2 = "123";
// Test for correct authorization
	@Test
	public void test1() {
		System.out.println("Inside authorizationInAllTickets");
		try {
			tickList.testAuthorizationException(userName, userPwd);
			System.out.println("Authorization Test Passed!");
		} catch (Exception e) {
			System.out.println("Authorization Test Failed!");
		}
	}
// Test for Incorrect authorization
	@Test
	public void test2() {
		System.out.println("Inside authorizationInAllTickets");
		try {
			tickList.testAuthorizationException(userName2, userPwd2);
			System.out.println("Authorization Test Passed!");
		} catch (Exception e) {
			System.out.println("Authorization Test Failed!");
		}
	}
}
