package q4tht3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * @author User
 */
public class calculateClient extends JFrame implements calculate {

    //Attributes.  
    JLabel title, devTitle, fNum, sym, sNum, answerLbl;
    JTextField fNumTxt, sNumTxt;
    JComboBox symCb;
    JButton calcBtn;

    private DefaultListCellRenderer listRenderer;
    String[] cbArray = {"+", "-", "*", "/"};

    //Constructor.  
    public calculateClient() {
        //Code.  
        super("Edureka Calculator App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 200);

        //JComponents.  
        title = new JLabel("Edureka Calculator App v1.0");
        devTitle = new JLabel("Develloper: H.Scheepers");
        fNum = new JLabel("Input 1st num: ");
        sym = new JLabel("Choose symbol ");
        sNum = new JLabel("Input 2nd num: ");

        answerLbl = new JLabel();
        answerLbl.setHorizontalAlignment(JLabel.CENTER);

        fNumTxt = new JTextField();
        fNumTxt.setHorizontalAlignment(JLabel.CENTER);

        sNumTxt = new JTextField();
        sNumTxt.setHorizontalAlignment(JLabel.CENTER);

        //Combobox.  
        symCb = new JComboBox(cbArray);
        listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        symCb.setRenderer(listRenderer);

        calcBtn = new JButton("Calculate");
        calcBtn.addActionListener(new calcBtnPressed());

        //Layouts.  
        GridLayout grid1 = new GridLayout(5, 2);

        //MainFrame.  
        this.setLayout(grid1);
        this.add(title);
        this.add(devTitle);
        this.add(fNum);
        this.add(fNumTxt);
        this.add(sym);
        this.add(symCb);
        this.add(sNum);
        this.add(sNumTxt);
        this.add(calcBtn);
        this.add(answerLbl);
        this.setVisible(true);

    }

    @Override
    public int add(int num1, int num2) throws RemoteException {
        return num1 + num2;
    }

    @Override
    public int subtract(int num1, int num2) throws RemoteException {
        return num1 - num2;
    }

    @Override
    public int multiply(int num1, int num2) throws RemoteException {
        return num1 * num2;
    }

    @Override
    public int divide(int num1, int num2) throws RemoteException {
        return num1 / num2;
    }

    class calcBtnPressed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (fNumTxt.getText().equals("") || fNumTxt.getText() == null || 
                sNumTxt.getText().equals("") || sNumTxt.getText() == null) {
                    JOptionPane.showMessageDialog(null,"Please enter the numbers first! ", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                String fNumString = fNumTxt.getText();
                int num1 = Integer.parseInt(fNumString);

                String sNumString = sNumTxt.getText();
                int num2 = Integer.parseInt(sNumString);

                String opp = (String) symCb.getSelectedItem();
                int answer = 0;

                switch (opp) {
                    case "+": {
                        try {
                            answer = add(num1, num2);
                        } catch (RemoteException ex) {
                            Logger.getLogger(calculateClient.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String numtot = Integer.toString(answer);
                        answerLbl.setText((String) numtot);
                    }
                    break;

                    case "-": {
                        try {
                            answer = subtract(num1, num2);
                        } catch (RemoteException ex) {
                            Logger.getLogger(calculateClient.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String numtot = Integer.toString(answer);
                        answerLbl.setText((String) numtot);
                    }
                    break;

                    case "*": {
                        try {
                            answer = multiply(num1, num2);
                        } catch (RemoteException ex) {
                            Logger.getLogger(calculateClient.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String numtot = Integer.toString(answer);
                        answerLbl.setText((String) numtot);
                    }
                    break;

                    case "/": {
                        try {
                            answer = divide(num1, num2);
                        } catch (RemoteException ex) {
                            Logger.getLogger(calculateClient.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String numtot = Integer.toString(answer);
                        answerLbl.setText((String) numtot);
                    }
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws RemoteException {
        calculateClient c1 = new calculateClient();
    }
}
