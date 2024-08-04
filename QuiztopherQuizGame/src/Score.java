import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame implements ActionListener {
    Score(String username, int score){
        setSize(1200,500); //850, 650
        setLocation(0,150); //350, 100
        getContentPane().setBackground(new Color(2, 12, 57));
        setLayout(null);

        /* --------- Image settings --------- */

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = il.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); //we cannot add any conponent without Jlable
        image.setBounds(100, 150, 300, 250); //creating my own layout
        add(image);

        /* ----------- heading ----------- */

        JLabel heading = new JLabel("Thank you " + username + " for playing Quiztopher"); // I'm leaving this empty, so that question number would be change repectively
        heading.setBounds(350, 100, 700, 40);
        heading.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 28));
        heading.setForeground(new Color(255, 240, 88));
        add(heading);

        /* -------------- Score --------------- */

        JLabel yourscore = new JLabel("Your score is " + score); // I'm leaving this empty, so that question number would be change repectively
        yourscore.setBounds(500, 200, 700, 30);
        yourscore.setFont(new Font("Segoe UI", Font.BOLD, 26));
        yourscore.setForeground(new Color(250, 250, 250));
        add(yourscore);

        /*--------- Button ---------- */

        JButton submit = new JButton("Exit game");
        submit.setBounds(530, 270, 120, 30);
        submit.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        submit.setBackground(new Color(255, 255, 255));
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main (String[] args){
        new Score("User", 0);
    }
}
