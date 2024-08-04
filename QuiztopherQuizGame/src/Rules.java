import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Rules extends JFrame implements ActionListener{
    String username;
    JButton start, Back;
    Rules(String username){
        this.username = username;
        getContentPane().setBackground(new Color(2, 12, 57));
        setLayout(null);

        /*----------- Heading ------------*/

        JLabel heading = new JLabel("Welcome "+ username + " to Quiztopher"); //heading
        heading.setBounds(50, 60, 700, 30); //750, 60, 300, 45
        heading.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 28)); // font settings
        heading.setForeground(new Color(255, 240, 88));
        getContentPane().add(heading);

        JLabel rules = new JLabel(); //heading
        rules.setBounds(50, 40, 950, 350); //20, 90, 700, 350
        rules.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        rules.setText("<html>"+
                "1. The quiz has a 15-second timing limit for each question, so be sure to read and answer the question as quickly as possible.\r\n" + "" + "<br><br>" +
                "2. Once the quiz has started, you cannot quit or leave the game. Make sure you have enough time and commitment to complete the quiz before starting." + "<br><br>" +
                "3. Make sure to submit your answer before the 10-second timer expires. If you don't submit your answer in time, you may miss out on points and Question.\r\n" + "." + "<br><br>" +
                "4. You only have 15 seconds to answer each question, so don't waste time overthinking or second-guessing your answers." + "<br><br>" +
                "<html>");// font settings// HERE PASTE RULES FOR QUIZ
        rules.setForeground(new Color(255, 255, 255));
        getContentPane().add(rules);

        // Back Button
        Back = new JButton("Back");
        Back.setBounds(400, 370, 100, 30); //250, 500, 100, 30
        Back.setBackground(new Color(255, 255, 255));
        Back.setForeground(new Color(2, 12, 57));
        Back.addActionListener(this); // For Click event
        getContentPane().add(Back);

        start = new JButton("Start");
        start.setBounds(550, 370, 100, 30);
        start.setBackground(new Color(255, 255, 255));
        start.setForeground(new Color(2, 12, 57));
        start.addActionListener(this); // For Click event
        getContentPane().add(start);

        /* -------------- Setting Frame ----------- */

        setSize(1200,500); //850, 650
        setLocation(0,150); //350, 100
        setVisible(true);
    }
    public  void actionPerformed(ActionEvent ae) {
        if (ae.getSource()== start) {
            setVisible(false);
            new Quiz(username);
        }else {
            setVisible(false);
            new Login();
        }
    } public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Rules ("User");

    }
}
