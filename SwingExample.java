 package Swings;

 import java.awt.Color;
 import java.awt.Font;
 import javax.swing.*;

 class SwingExample {

     SwingExample() {

         // Create a new JFrame container
         JFrame jfrm = new JFrame("A Simple Swing Application");

         // Set size
         jfrm.setSize(500, 200);

         // Close operation
         jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         // Create label
         JLabel jlab = new JLabel("Hello! VI C, Welcome to Swing Programming!", JLabel.CENTER);

         // Set font and color
         jlab.setFont(new Font("Verdana", Font.PLAIN, 20));
         jlab.setForeground(new Color(0, 0, 255));

         // Add label to frame
         jfrm.add(jlab);

         // Make frame visible
         jfrm.setVisible(true);
     }

     public static void main(String args[]) {

         // Run on Event Dispatch Thread
         SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 new SwingExample();
             }
         });
     }
 }