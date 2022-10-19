package Exercise1;

//Vanessa Victorino - 301201653
//COMP228 - Lab #2 - Exercise 1

import javax.swing.JOptionPane;

public class MultipleChoicesTest {

    public static void main(String args[]){
        try {
                MultipleChoices question = new MultipleChoices();
                    question.inputAnswer();

        } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Thank you for your time!");
        }
    }
}




