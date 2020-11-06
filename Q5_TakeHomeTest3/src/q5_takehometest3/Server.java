/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q5_takehometest3;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/*
 * @author User
 */
public class Server extends ConnectionImpl {

    public static void main(String args[]) throws RemoteException, AlreadyBoundException {
        try {
            ConnectionImpl imp = new ConnectionImpl();

            Sales stub = (Sales) UnicastRemoteObject.exportObject(imp, 0);
            Registry reg = LocateRegistry.getRegistry();

            reg.bind("Sales", stub);
            System.err.println("ready");

        } catch (AlreadyBoundException | RemoteException e) {
            System.err.println("serverexception:" + e.toString());
        }
    }
}
