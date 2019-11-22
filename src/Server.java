/** @author 		Conor Power
 *  @date			22/11/2019
 *  @studentNumber 	20075871
 *  @description	The server class extends UnicastRemoteObject and implements
 *  				the Calculator interface. The server registers the server 
 *  				object and defines the method operations for the interface.
 */

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements Calculator {
	
	public ServerGUI serverGUI;
	
	public Server() throws RemoteException {
		super();
		serverGUI = new ServerGUI();
		serverGUI.getDisplay().append("Connected to Client!\n");
	}
	
	public static void main(String[] args) {
		try {
			Server obj = new Server();
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("Calculator", obj);
			obj.serverGUI.getDisplay().append("Bound Calculator to registry.\n");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	/** Add numbers method **/
	@Override
	public float add(String val1, String val2) throws RemoteException {
		float num1 = Integer.parseInt(val1);
		float num2 = Integer.parseInt(val2);
		float total = num1 + num2;
		serverGUI.getDisplay().append("First Number: " + num1 + "\n");
		serverGUI.getDisplay().append("Second Number: " + num2 + "\n");
		serverGUI.getDisplay().append("Operator: +\n");
		serverGUI.getDisplay().append("Data to Client: " + total + "\n");
		return total;
	}
	
	/** Subtract numbers method **/
	@Override
	public float subtract(String val1, String val2) throws RemoteException {
		float num1 = Integer.parseInt(val1);
		float num2 = Integer.parseInt(val2);
		float total = num1 - num2;
		serverGUI.getDisplay().append("First Number: " + num1 + "\n");
		serverGUI.getDisplay().append("Second Number: " + num2 + "\n");
		serverGUI.getDisplay().append("Operator: -\n");
		serverGUI.getDisplay().append("Data to Client: " + total + "\n\n");
		return total;
	}
	
	/** Multiply numbers method **/
	@Override
	public float multiply(String val1, String val2) throws RemoteException {
		float num1 = Integer.parseInt(val1);
		float num2 = Integer.parseInt(val2);
		float total = num1 * num2;
		serverGUI.getDisplay().append("First Number: " + num1 + "\n");
		serverGUI.getDisplay().append("Second Number: " + num2 + "\n");
		serverGUI.getDisplay().append("Operator: *\n");
		serverGUI.getDisplay().append("Data to Client: " + total + "\n");
		return total;
	}
	
	/** Divide numbers method **/
	@Override
	public float divide(String val1, String val2) throws RemoteException {
		float num1 = Integer.parseInt(val1);
		float num2 = Integer.parseInt(val2);
		float total = num1 / num2;
		serverGUI.getDisplay().append("First Number: " + num1 + "\n");
		serverGUI.getDisplay().append("Second Number: " + num2 + "\n");
		serverGUI.getDisplay().append("Operator: /\n");
		serverGUI.getDisplay().append("Data to Client: " + total + "\n");
		return total;
	}
}
