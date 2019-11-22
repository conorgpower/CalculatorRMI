/** @author 		Conor Power
 *  @date			22/11/2019
 *  @studentNumber 	20075871
 *  @description	This remote interface class, its instances can be accessed remotely 
 *  				via the machine where normal object or accessed on other 
 *  				machines via object handles.
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

/** Calculator Interface **/
public interface Calculator extends Remote {
    float add(String val1, String val2) throws RemoteException;
    float subtract(String val1, String val2) throws RemoteException;
    float multiply(String val1, String val2) throws RemoteException;
    float divide(String val1, String val2) throws RemoteException;
}