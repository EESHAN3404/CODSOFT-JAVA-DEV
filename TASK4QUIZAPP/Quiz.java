import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame {
    private JLabel questionLabel;
    private JRadioButton[] options;
    private JButton submitButton;
    private JLabel timerLabel; 
    private int currentQuestionIndex;
    private int score;
    private Timer timer;

    private String[] questions = {
            "Who is Prime Minister of India?",
            "What is value of Pie(Circumference of Circle)?",
            "Automobile Company owned by Elon Musk?",
            "JAVA supports Features like?"
    };
    private String[][] choices = {
            {"Manmohan Singh", "Ramlal Gupta", "Narendra Modi", "Shaurya Athwal"},
            {"4.6", "3.14", "7.22", "8.90"},
            {"Tesla", "Ford", "Lambhorgini", "Benz"},
            {"Robust", "Secure", "Object Oriented Programming", "All of the Above"}
    };
    private int[] correctAnswers =  {2, 1, 0, 3};

    public Quiz() {
        setTitle("QUIZZY TESTS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 300);
        setLayout(new BorderLayout());

        questionLabel = new JLabel();
        add(questionLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1));
        options = new JRadioButton[4];
        ButtonGroup buttonGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            options[i].setText(choices[currentQuestionIndex][i]);
            buttonGroup.add(options[i]);
            optionsPanel.add(options[i]);
        }
        add(optionsPanel, BorderLayout.CENTER);

        submitButton = new JButton("SUBMIT");
        add(submitButton, BorderLayout.SOUTH);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                showNextQuestion();
            }
        });

        timerLabel = new JLabel();
        add(timerLabel, BorderLayout.EAST); 

        currentQuestionIndex = 0;
        showQuestion();
        startTimer();
    }

    private void showQuestion() {
        questionLabel.setText(questions[currentQuestionIndex]);
        for (int i = 0; i < 4; i++) {
            options[i].setText(choices[currentQuestionIndex][i]);
            options[i].setSelected(false);
        }
    }

    private void showNextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.length) {
            showQuestion();
            resetTimer();
        } else {
            showResult();
        }
    }

    private void checkAnswer() {
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected() && i == correctAnswers[currentQuestionIndex]) {
                score++;
            }
        }
    }

    private void showResult() {
        JOptionPane.showMessageDialog(this, "QUIZ ENDED!\nSCORE: " + score + "/" + questions.length);
        System.exit(0);
    }

    private void startTimer() {
        timer = new Timer(1000, new ActionListener() { 
            private int secondsLeft = 20; 

            @Override
            public void actionPerformed(ActionEvent e) {
                if (secondsLeft >= 0) {
                    timerLabel.setText("TIME LEFT: " + secondsLeft + "SECS");
                    secondsLeft--;
                } else {
                    timer.stop();
                    checkAnswer();
                    showNextQuestion();
                }
            }
        });
        timer.start();
    }

    private void resetTimer() {
        timer.stop();
        startTimer();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Quiz().setVisible(true);
            }
        });
    }
}