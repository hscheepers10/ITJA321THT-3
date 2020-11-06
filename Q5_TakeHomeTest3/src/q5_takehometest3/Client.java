/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q5_takehometest3;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/*
 * @author User
 */
public class Client extends JFrame{

    //Attributes.  
    JTable tab;
    JScrollPane pane;
    //Constructor.  
    private Client() {
        super("NERSA Sales Results");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,500);
        
        //Data.  
        String[][] data = {
            {"1","Gauteng","4200000"},
            {"2","Western Cape","1900000"},
            {"3","Natal","1800000"},
            {"4","Mpumahlanga","950000"},
            {"5","Eastern Cape","940000"},
            {"6","North West","470000"},
            {"7","Free State","720000"},
            {"8","Limpopo","500000"},
            {"9","Northen Cape","90000"}
        };
        
        //Column Names.  
        String[] colNames = {"SaleID","Province","Litres"};
        
        tab.add(pane);
        this.add(tab);
        this.setVisible(true);

    }

    public static void main(String[] args) throws RemoteException, NotBoundException, Exception {
        Client nani = new Client();
        try {
            Registry reg = LocateRegistry.getRegistry(null);

            Sales stub = (Sales) reg.lookup("Sales");

            //Calling remote method.  
            List<Province> list1 = (List) stub.getProvince();
            for (Province s : list1) {
                System.out.println("SaleID" + s.getSaleID());
                System.out.println("Province" + s.getProvince());
                System.out.println("Liters" + s.getLitres());
            }

        } catch (Exception e) {
            System.err.println("Client exception:"+e.toString());
            e.printStackTrace();
        }
    }

}
