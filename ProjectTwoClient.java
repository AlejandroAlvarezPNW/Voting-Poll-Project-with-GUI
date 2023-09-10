import java.awt.*;
import java.rmi.*;
import javax.swing.*;

/**
 * This class represents the object client for a distributed
 * object of class Hello, which implements the remote interface
 * HelloInterface.
 * @author M. L. Liu
 */



public class ProjectTwoClient {
    private static JLabel yesLabel, noLabel, dontCareLabel;
    //private static JProgressBar yesProgressBar, noProgressBar, dontCareProgressBar;
    public static void main(String[] args) {
       try {
           int RMIPort = 100;
           String hostName = "localhost";
           String registryURL =
                   "rmi://" + hostName + ":" + RMIPort + "/hello";
           // find the remote object and cast it to an interface object
           ProjectTwoInterface h =
                   (ProjectTwoInterface) Naming.lookup(registryURL);

           JFrame frame = new JFrame("Voting System");
           frame.setSize(400, 300);
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

           // Button Creation
           JButton yes = new JButton("yes");
           JButton no = new JButton("no");
           JButton dontCare = new JButton("Don't Care");

           // Create labels to display the counts for each button
           yesLabel = new JLabel("yes: " + h.getYesCount());
           noLabel = new JLabel("no: " + h.getNoCount());
           dontCareLabel = new JLabel("Don't Care: " + h.getDontCareCount());

           yes.addActionListener(e -> {
               try {
                   h.incrementYes();
                   yesLabel.setText("yes: " + h.getYesCount());
                   System.exit(0);
               } catch (RemoteException ex) {
                   throw new RuntimeException(ex);
               }
           });

           no.addActionListener(e -> {
               try {
                   h.incrementNo();
                   noLabel.setText("no: " + h.getNoCount());
                   System.exit(0);
               } catch (RemoteException ex) {
                   throw new RuntimeException(ex);
               }
           });

           dontCare.addActionListener(e -> {
               try {
                   h.incrementDontCareCount();
                   dontCareLabel.setText("Don't Care: " + h.getDontCareCount());
                   System.exit(0);
               } catch (RemoteException ex) {
                   throw new RuntimeException(ex);
               }
           });

           // Disclaimer telling the user that the program will close after a vote is cast
           JLabel disclaimer_text = new JLabel("Disclaimer: Program will close when a vote is cast");

           // Panels for buttons
           JPanel buttonPanel = new JPanel();
           buttonPanel.add(yes);
           buttonPanel.add(no);
           buttonPanel.add(dontCare);

           // Counter Panels
           JPanel counterPanel = new JPanel();
           counterPanel.add(yesLabel);
           counterPanel.add(noLabel);
           counterPanel.add(dontCareLabel);

           // Add panels to the frame
           frame.add(buttonPanel, BorderLayout.NORTH);
           frame.add(counterPanel, BorderLayout.CENTER);
           frame.add(disclaimer_text, BorderLayout.SOUTH);

           frame.setVisible(true);
       }
      catch (Exception e) {
         System.out.println("Exception in ProjectTwoClient: " + e);
      }
   } //end main
}//end class
