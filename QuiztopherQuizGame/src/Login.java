import javax.swing.*; // contains utilities for Jframe
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; // contains utilities for Jframe color
/* main class is extended by Jframe */
public class Login extends JFrame implements ActionListener{
    JButton rules, Back;
    JTextField tfname;
    /*----------- Heading ------------*/
    /* this constructor is created for frame */
    Login(){
        /*------Calling the utilities--------*/
        getContentPane().setBackground(new Color(2, 12, 57));
        getContentPane().setLayout(null); // for designing my own layout
        /*Calling the image from the directory*/
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        JLabel image = new JLabel(il); //we cannot add any component without Jlable
        image.setBounds(0, 0, 600, 400); // 0, 0, 600, 500 //creating my own layout
        /*to add any conponent on the frame*/
        getContentPane().add(image);

        /*----------- Heading ------------*/

        JLabel heading = new JLabel("Quiztopher Game"); //heading
        heading.setBounds(650, 60, 300, 45); //750, 60, 300, 45
        heading.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 30)); // font settings
        heading.setForeground(new Color(255, 240, 88));
        getContentPane().add(heading);

        /*-----------To get name from user----------*/

        JLabel name = new JLabel("Enter your name: "); //heading
        name.setBounds(710, 150, 300, 20); //810, 150, 300, 20
        name.setFont(new Font("Segoe UI", Font.BOLD, 18)); // font settings
        name.setForeground(new Color(255, 255, 255));
        getContentPane().add(name);

        /*----------- Text Field --------------*/

        tfname = new JTextField();
        tfname.setBounds(630, 200, 300, 25); //735, 200, 300, 25
        tfname.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        tfname.setForeground(new Color(61, 60, 60));
        getContentPane().add(tfname);

        /*------------- Buttons --------------*/
        // Continue
        rules = new JButton("Continue");
        rules.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        rules.setBounds(630, 270, 120, 25); //735, 270, 120, 25
        rules.setBackground(new Color(255, 255, 255));
        rules.setForeground(new Color(2, 12, 57));
        rules.addActionListener(this); // For Click event
        getContentPane().add(rules);


        // Back Button
        Back = new JButton("Back");
        Back.setBounds(810, 270, 120, 25); //915, 270, 120, 25
        Back.setBackground(new Color(255, 255, 255));
        Back.setForeground(new Color(2, 12, 57));
        Back.addActionListener(this); // For Click event
        getContentPane().add(Back);

        /*-----------Setting the frame--------*/

        setSize(1200,500);
        setLocation(0,150); //200, 150
        setVisible(true);
    }
    /*---------- Action perform ---------*/
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource () == rules) {
            String username = tfname.getText();
            setVisible(false);

            new Rules (username);
        }
        else if (ae.getSource() == Back) {
            setVisible (false);
        }
    }
    public static void main(String[] args){
        // object for main method // no need to store in a variable.
        new Login();
    }
}