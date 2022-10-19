package Exercise1;

//Vanessa Victorino - 301201653
//COMP228 - Lab #2 - Exercise 1

import java.util.Random;
import javax.swing.JOptionPane;

/*
 -	create a method to simulate the questions – simulateQuestion
-	create a method to check the answer – checkAnswer
-	create a method to display a random message for the user – generateMessage
-	create a method to interact with the user - inputAnswer
*/
    public class MultipleChoices {

    private int correct = 0;
    private int total = 5;
    private int count = 1;

    private String simulateQuestion(String qNumber) {
        String question = "";

        switch (qNumber) {
            case "q1": //b
                question += "Which of the following declares an array of integers named number?\n" +
                        "      (a) int number;\n" +
                        "      (b) int[ ] number;\n" +
                        "      (c) int new number [ ] ;\n" +
                        "      (d) int number = int[ ] ;\n\n";
                break;
            case "q2": //b
                question += "What is the main function of a Java compiler?\n"
                         + "(a) It examines the bytecodes to ensure that they  are valid and do not violate Java’s security restrictions.\n"
                         + "(b) It translates the Java source code into bytecodes that represent the tasks to execute.\n"
                         + "(c) It executes the bytecodes.\n"
                         + "(d) It places the program in memory to execute it.\n\n";
                break;
            case "q3"://a
                question += "What is the output for the following code fragment?\n" +
                        "       int [ ] a = new int [5];\n" +
                        "       a[0] = 5;\n" +
                        "       a[1] = 4;\n" +
                        "       a[2] = 3;\n" +
                        "       System.out.print(a[0] + a[1] + a[4]);\n" +
                        "\n" +
                        "      (a) 9\n" +
                        "      (b) 5 3 1\n" +
                        "      (c) 5 3 0\n" +
                        "      (d) 8\n\n";
                break;
            case "q4": //c
                question += "Which of the following components does a Java application need to have at least one of?\n"
                        + "(a) Instance variable\r\n"
                        + "(b) Local variable\r\n"
                        + "(c) Class\r\n"
                        + "(d) Non-static Method\r\n\n";
                break;
            case "q5": //d
                question += "Method arguments may be_______________.\n"
                         + "(a) only variables\n"
                         + "(b) only strings\n"
                         + "(c) only constants\n"
                         + "(d) constants, variables, or expressions\n\n";
                break;
        }
        return question;

    }
    protected void checkAnswer(String qNumber, String input) {
        String ans = "";
        input.toLowerCase();
        boolean userMes = false;
        switch (qNumber) {
            case "q1":
            case "q2":
                 if (input.equals("b")) {
                    correct++;
                    userMes = true;
                 } else
                    ans += "\nThe correct answer is: B";
                break;
            case "q3":
                if (input.equals("a")) {
                    correct++;
                    userMes = true;
                } else
                    ans += "\nThe correct answer is: A";
                break;
            case "q4":
                if (input.equals("c")) {
                    correct++;
                    userMes = true;
                } else
                    ans += "\nThe correct answer is: C";
                break;
            case "q5":
                if (input.equals("d")) {
                    correct++;
                    userMes = true;
                } else
                    ans += "\nThe correct answer is: D";
                break;
        }
        JOptionPane.showMessageDialog(null, this.generateMessage(userMes) + ans);
    }

    protected String generateMessage(boolean userAns) {
        Random randomObject = new Random();
        String sysReply = "";
        if (userAns) {
            switch (randomObject.nextInt(4)) {
                case 0:
                    return ("Very good!");
                case 1:
                    return ("Excellent!");
                case 2:
                    return ("Keep up the good work!");
                case 3:
                    return ("Wow");
            }
        } else {
            switch (randomObject.nextInt(4)) {
                case 0:
                    return ("No. Please try again");
                case 1:
                    return ("Wrong. Try once more");
                case 2:
                    return ("Don't give up!");
                case 3:
                    return ("No. Keep trying..");
            }
        }
        return sysReply;
    }
    protected String inputAnswer() {
        while (count <= 5) {
            String answer = JOptionPane.showInputDialog(simulateQuestion("q" + Integer.toString(count)));
            if (answer.toLowerCase().equals("a") || answer.toLowerCase().equals("b") || answer.toLowerCase().equals("c")
                    || answer.toLowerCase().equals("d")) {
                this.checkAnswer("q" + Integer.toString(count), answer);
                count++;
            } else
                JOptionPane.showMessageDialog(null, "Make sure you enter 'a', 'b', 'c' or 'd'");
        }

         double percent = ((double)correct / (double)total ) * 100;

        while (count == 6) {
            JOptionPane.showMessageDialog(null, "You have finished the test!\nCorrect answer: " + correct
                    + "\nIncorrect answer: " + (total - correct) + "\nPercentage of correct answer: " + String.format("%.0f",percent) + "%");
            count++;
        }
        return "";
    }
}