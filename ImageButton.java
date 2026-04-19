package Swings;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageButton implements ActionListener {

    JFrame f;
    JButton b1, b2;
    JLabel l;

    ImageButton() {
        // Create Frame
        f = new JFrame("Image Button Example");

        // Create Label
        l = new JLabel();
        l.setBounds(50, 150, 300, 30);
        l.setFont(new Font("Arial", Font.BOLD, 16));

        // Load Images (Make sure images are in same folder)
        ImageIcon clockIcon = new ImageIcon("digital_clock.jpg");
        ImageIcon hourGlassIcon = new ImageIcon("hourglass.png");

        // Create Buttons with Images
        b1 = new JButton(clockIcon);
        b1.setBounds(50, 30, 120, 100);

        b2 = new JButton(hourGlassIcon);
        b2.setBounds(200, 30, 120, 100);

        // Add Action Listener
        b1.addActionListener(this);
        b2.addActionListener(this);

        // Add components to frame
        f.add(b1);
        f.add(b2);
        f.add(l);

        f.setSize(400, 250);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    // Event Handling
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            l.setText("Digital Clock is pressed");
        } else if (e.getSource() == b2) {
            l.setText("Hour Glass is pressed");
        }
    }

    public static void main(String[] args) {
        new ImageButton();
    }
}








