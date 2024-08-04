import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class QuizBase extends JFrame {
    JLabel questionNo, question;
    JRadioButton option_1, option_2, option_3, option_4;
    ButtonGroup groupOptions;
    JButton next, LifeLine, submit;

    public QuizBase() {
        setSize(1200, 500);
        setLocation(0, 150);
        getContentPane().setBackground(new Color(2, 12, 57));
        setLayout(null);

        /* --------- Image settings --------- */
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/quiz1.png"));
        JLabel image = new JLabel(il);
        image.setBounds(150, 0, 735, 200);
        add(image);

        /* ----------- Quiz starts here ----------- */
        questionNo = new JLabel();
        questionNo.setBounds(80, 230, 50, 30);
        questionNo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        questionNo.setForeground(new Color(255, 255, 255));
        add(questionNo);

        question = new JLabel();
        question.setBounds(100, 230, 900, 30);
        question.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        question.setForeground(new Color(255, 255, 255));
        add(question);

        /* ---------- Radio Button ------------ */
        option_1 = new JRadioButton();
        option_1.setBounds(100, 270, 700, 30);
        option_1.setBackground(new Color(2, 12, 57));
        option_1.setFont(new Font("Dialog", Font.PLAIN, 18));
        option_1.setForeground(new Color(255, 255, 255));
        add(option_1);

        option_2 = new JRadioButton();
        option_2.setBounds(100, 300, 700, 30);
        option_2.setBackground(new Color(2, 12, 57));
        option_2.setFont(new Font("Dialog", Font.PLAIN, 18));
        option_2.setForeground(new Color(255, 255, 255));
        add(option_2);

        option_3 = new JRadioButton();
        option_3.setBounds(100, 330, 700, 30);
        option_3.setBackground(new Color(2, 12, 57));
        option_3.setFont(new Font("Dialog", Font.PLAIN, 18));
        option_3.setForeground(new Color(255, 255, 255));
        add(option_3);

        option_4 = new JRadioButton();
        option_4.setBounds(100, 360, 700, 30);
        option_4.setBackground(new Color(2, 12, 57));
        option_4.setFont(new Font("Dialog", Font.PLAIN, 18));
        option_4.setForeground(new Color(255, 255, 255));
        add(option_4);

        /* Used to group buttons so the user can choose one option only */
        groupOptions = new ButtonGroup();
        groupOptions.add(option_1);
        groupOptions.add(option_2);
        groupOptions.add(option_3);
        groupOptions.add(option_4);

        /* ------------- More Buttons ------------- */
        next = new JButton("Next");
        next.setBounds(800, 250, 150, 40);
        next.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        next.setBackground(new Color(255, 255, 255));
        next.setForeground(Color.BLACK);
        add(next);

        LifeLine = new JButton("50-50 Life Line");
        LifeLine.setBounds(800, 300, 150, 40);
        LifeLine.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        LifeLine.setBackground(new Color(255, 255, 255));
        LifeLine.setForeground(Color.BLACK);
        add(LifeLine);

        submit = new JButton("Submit");
        submit.setBounds(800, 350, 150, 40);
        submit.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        submit.setBackground(new Color(255, 255, 255));
        submit.setForeground(Color.BLACK);
        submit.setEnabled(false);
        add(submit);

        setVisible(true);
    }
}

public class Quiz extends QuizBase implements ActionListener {
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String userAns[][] = new String[10][1];
    public static int score = 0;
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    String username;

    Quiz(String username) {
        super();
        this.username = username;

        /* ----------- Initialize questions and answers ----------- */
        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        /* ----------- Event listeners ----------- */
        next.addActionListener(this);
        LifeLine.addActionListener(this);
        submit.addActionListener(this);

        /* ----------- Method to insert data ----------- */
        start(count);
    }

    public void actionPerformed(ActionEvent ae) {
        // Check if the next button was clicked
        if (ae.getSource() == next) {
            repaint(); // Redraw the component
            ans_given = 1; // Set answer given flag to true
            // Enable all options
            option_1.setEnabled(true);
            option_2.setEnabled(true);
            option_3.setEnabled(true);
            option_4.setEnabled(true);
            // Check if an option is selected
            if (groupOptions.getSelection() == null) {
                userAns[count][0] = ""; // No selection
            } else {
                userAns[count][0] = groupOptions.getSelection().getActionCommand(); // Get selected option
            }

            // If it's the 9th question, disable next button and enable submit button
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++; // Move to the next question
            start(count); // Start the next question
        } else if (ae.getSource() == LifeLine) {
            // Disable two options based on the question number
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                option_2.setEnabled(false);
                option_3.setEnabled(false);
            } else {
                option_1.setEnabled(false);
                option_4.setEnabled(false);
            }
            LifeLine.setEnabled(false); // Disable the lifeline button
        } else if (ae.getSource() == submit) {
            ans_given = 1; // Set answer given flag to true
            // Check if an option is selected
            if (groupOptions.getSelection() == null) {
                userAns[count][0] = ""; // No selection
            } else {
                userAns[count][0] = groupOptions.getSelection().getActionCommand(); // Get selected option
            }

            // Calculate score
            for (int i = 0; i < userAns.length; i++) {
                if (userAns[i][0].equals(answers[i][1])) {
                    score += 10; // Correct answer
                } else {
                    score += 0; // Incorrect answer
                }
            }
            // Save score to database
            saveScoreToDatabase(username, score);
            this.setVisible(false); // Hide the current frame
            new Score(username, score); // Show the score
        }
    }

    public void paint(Graphics g) {
        super.paint(g); // Call the superclass's paint method

        String time = "Time left - " + timer + " seconds"; // Display timer
        g.setColor(Color.RED); // Set text color to red
        g.setFont(new Font("Segoe UI", Font.BOLD, 15)); // Set font

        if (timer > 0) {
            g.drawString(time, 880, 250); // Draw the timer if time left
        } else {
            g.drawString("Times up!!", 880, 250); // Draw times up if no time left
        }

        timer--; // Decrease timer

        try {
            Thread.sleep(1000); // Pause for 1 second
            repaint(); // Redraw the component
        } catch (Exception e) {
            e.printStackTrace(); // Print the exception if any
        }

        if (ans_given == 1) {
            ans_given = 0; // Reset answer given flag
            timer = 15; // Reset timer
        } else if (timer < 0) {
            timer = 15; // Reset timer

            if (count == 8) {
                next.setEnabled(false); // Disable next button if it's the 9th question
                submit.setEnabled(true); // Enable submit button
            }
            if (count == 9) {
                // Check if an option is selected
                if (groupOptions.getSelection() == null) {
                    userAns[count][0] = ""; // No selection
                } else {
                    userAns[count][0] = groupOptions.getSelection().getActionCommand(); // Get selected option
                }

                // Calculate score
                for (int i = 0; i < userAns.length; i++) {
                    if (userAns[i][0].equals(answers[i][1])) {
                        score += 10; // Correct answer
                    } else {
                        score += 0; // Incorrect answer
                    }
                }
                // Save score to database
                saveScoreToDatabase(username, score);
                this.setVisible(false); // Hide the current frame
                new Score(username, score); // Show the score
            } else {
                // Check if an option is selected
                if (groupOptions.getSelection() == null) {
                    userAns[count][0] = ""; // No selection
                } else {
                    userAns[count][0] = groupOptions.getSelection().getActionCommand(); // Get selected option
                }
                count++; // Move to the next question
                start(count); // Start the next question
            }
        }
    }

    public void start(int count) {
        // Set question and options text
        questionNo.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        option_1.setText(questions[count][1]);
        option_1.setActionCommand(questions[count][1]);

        option_2.setText(questions[count][2]);
        option_2.setActionCommand(questions[count][2]);

        option_3.setText(questions[count][3]);
        option_3.setActionCommand(questions[count][3]);

        option_4.setText(questions[count][4]);
        option_4.setActionCommand(questions[count][4]);

        groupOptions.clearSelection(); // Clear previous selection
    }

    public void saveScoreToDatabase(String username, int score) {
        String url = "jdbc:mysql://localhost:3306/quiz_game";
        String user = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO scores (username, score) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, score);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}
