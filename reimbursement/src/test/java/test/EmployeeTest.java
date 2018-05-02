package test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import app.ConnectionUtil;
import app.Service;
import dev.InvalidInputException;
import employee.Employee;
import junit.framework.TestCase;
import request.Request;
/**
 * Tests for Employee. Only failed assertions are recorded by Assert
 * @author joeyi
 *
 */
public class EmployeeTest extends TestCase {
	Employee emA = new Employee(101, null, null, null, null);
	
	Service serv = new Service();
	Connection con=null;
	//setup database connection here, run once before any test method
	@BeforeClass
	public void beforeClass() throws Exception {
		con = ConnectionUtil.getConnection();
		
		
	}

	//close database connection
	@AfterClass
	public void afterClass() throws Exception {
		con.close();
		System.out.println("No. of Test cases: " + this.countTestCases());
		
	}
	
	
	@Before
	public void setUp() {
		emA.setFirstname("Sally");
		emA.setLastname("Sundance");
		emA.setPassword("12345678");
		emA.setUsername("hello@world.com");
		
	}
	
	
	@After
	public void tearDown() {
		emA =null;
	}
	
	@Ignore @Test (expected = InvalidInputException.class)
	public void testGetPendingRequests()
	{
		//serv.submitRequest(90, "more party", 111);
		 serv.submitRequest(100, "party", 9);
		 serv.getPendingRequests(9);
	}
	@Test
	public void testGetPendingRequests2()
	{
		//serv.submitRequest(90, "more party", 113);
		//serv.submitRequest(90, "more party", 111);
		List<Request> temp= serv.getPendingRequests(135).stream().collect(Collectors.toList());
		//list.forEach((value) -> {System.out.println( "Value:" + value);});
		temp.forEach(e->{System.out.println(e.toString());});
		System.out.println(temp.size());
		assertEquals(temp.size(),3); 
	}
	
	@Ignore @Test public void testSubmitRequest()
	{
		float[] amount= {(float) 0.01, (float) 0.9,(float) 11.90,1200,193,(float) 1.7894};
		String purpose="enthulware";
		int eid =105;
		for(float i:amount)
			serv.submitRequest(i, purpose, eid);
	}
	
	@Ignore
	@Test(expected = InvalidInputException.class)
	public void testInvalidLogin()
	{	emA.setUsername("username@email.com");
		emA.setPassword("1234567890");
		assertFalse(serv.login(emA.getUsername(), emA.getPassword()));
	}
	
	@org.junit.Ignore
	@Test
	public void testLogin() {
		emA.setUsername("username@email.com");
		emA.setPassword("password");
		assertTrue(serv.login(emA.getUsername(), emA.getPassword()));
	}
	
	@org.junit.Ignore
	@Test
	public void testLogout() {
		assertTrue(serv.logout());
	}
	
	@Ignore
	@Test 
	public void testUpdateEmployee() {
	
		Employee emB = new Employee(105, "Newjulie@jackson.com", "123new456", "Teddy", "Teddy");
		assertEquals(serv.updateEmployee(105, "Newjulie@jackson.com", "123new456"), emB);
		assertEquals(serv.updateEmployee(101, "hello@world.com", "12345678"), emA);
	}
	
	//JUnit cannot do deep comparison of objects!!!!
	@Test
	public void testGetEmployee() {
		assertEquals(serv.getEmployee(101), emA);
	}
	
	@Ignore
	@Test
	public void testInsertEmployee()
	{	
	/*	assertTrue(serv.insertEmployee("hello@world.com", "12345678", "Sundance", "Hammy"));
		assertTrue(serv.insertEmployee("julie@jackson.com", "12345678", "Teddy", "Teddy"));
		assertTrue(serv.insertEmployee("joe@world.com", "12345678", "Jackson", "Sourcream"));
		assertTrue(serv.insertEmployee("kevin@world.com", "12345678", "Eevee", "Sight"));
		assertTrue(serv.insertEmployee("sam@world.com", "12345678", "Apple", "Icecream"));
		assertTrue(serv.insertEmployee("susan@world.com", "12345678", "Object", "Orange"));
	*/
		assertFalse(serv.insertEmployee("whyvioated@unique.com", "123456f78", "Violet", "Sally"));
		//violates unique constraint
	}
}
