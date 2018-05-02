package app;

import java.util.List;

import employee.Employee;
import employee.EmployeeDAO;
import employee.EmployeeImpl;
import manager.Manager;
import manager.ManagerDAO;
import manager.ManagerImpl;
import request.Request;
import request.RequestDAO;
import request.RequestImpl;

public class Service
{
	EmployeeDAO em = EmployeeImpl.getInstance();
	ManagerDAO ma = ManagerImpl.getInstance();
	RequestDAO req = RequestImpl.getInstance();
	
	public Request getRequest(int rid)
	{
		return ma.getRequest(rid);
	}
	public boolean approveRequest(int rid, int mid, int ap) {
		return ma.approveRequest(rid, mid, ap);
	}

	public void getImg(int rid) {
		ma.getImg(rid);
		
	}

	public List<Employee> getAllEmployees() {
		return ma.getAllEmployees();
		
	}

	public boolean login(String username, String password) {
		return ma.login(username, password);
	}

	public boolean logout() {
		return ma.logout();
	}

	public Manager getManager(int mid) {
		return ma.getManager(mid);
	}

	public Manager updateManager(int mid, String username, String password) {
		return ma.updateManager(mid, username, password);
	}
	

	public Employee getEmployee(int eid) {
		return em.getEmployee(eid);
	}
	
	public Employee updateEmployee(int eid,  String username, String password) {
		return em.updateEmployee(eid, username, password);
	}

	public List<Request> getAllPendingRequests() {
		return ma.getAllPendingRequests();
	}

	public List<Request> getAllResolvedRequests() {
		return ma.getAllResolvedRequests();
	}
	
	
	public List<Request> getEmployeeRequests(int eid) {
		return ma.getEmployeeRequests(eid);
	}
	
	public List<Request> getPendingRequests(int eid) {
		return em.getPendingRequests(eid);
		
	}
	
	public List<Request> getResolvedRequests(int eid) {
		return em.getResolvedRequests(eid);
	}
	
	public boolean submitRequest(float amount, String purpose, int eid) {
		return em.submitRequest(amount, purpose, eid);
		
	}

	public void uploadImg(int rid) {
		em.uploadImg(rid);
	}
	
	
	public boolean insertManager(String username, String password, String lastname, String firstname)
	{
		return ma.insertManager(username, password, lastname, firstname);
	}
	
	
	public boolean insertEmployee(String username, String password, String lastname, String firstname)
	{
		return ma.insertEmployee(username, password, lastname, firstname);
	}
	
	public boolean deleteEmployee(int eid)
	{
		return ma.deleteEmployee(eid);
	}
}
