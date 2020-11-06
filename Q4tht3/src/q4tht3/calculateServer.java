/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q4tht3;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

/*
 * @author User
 */

public class calculateServer {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        try {
            Registry reg = java.rmi.registry.LocateRegistry.createRegistry(1090);
            reg.rebind("calculateClient", new calculateClient());
            System.out.println("Server is running");
        } catch (RemoteException e) {
            System.out.println(e);
        }
    }
}
