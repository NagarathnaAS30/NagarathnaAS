package lab_5d;


import java.awt.Color;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorTabbedPane extends JFrame {

    JTabbedPane tp;
    JLabel label;

    public ColorTabbedPane() {

        // Create panels
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        p1.setBackground(Color.CYAN);
        p2.setBackground(Color.MAGENTA);
        p3.setBackground(Color.YELLOW);

        // Create tabbed pane
        tp = new JTabbedPane();
        tp.addTab("Cyan", p1);
        tp.addTab("Magenta", p2);
        tp.addTab("Yellow", p3);

        // Label to display selected tab
        label = new JLabel("Select a tab");
        label.setBounds(100, 250, 200, 30);

        // Event handling
        tp.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int index = tp.getSelectedIndex();
                String title = tp.getTitleAt(index);
                label.setText(title + " is selected");
            }
        });

        // Layout
        tp.setBounds(50, 50, 300, 150);

        add(tp);
        add(label);

        setTitle("Color Tabbed Pane");
        setSize(400, 350);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ColorTabbedPane();
    }
}


