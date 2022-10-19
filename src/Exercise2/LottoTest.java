package Exercise2;

//Vanessa Victorino - 301201653
//COMP228 - Lab #2 - Exercise 2

import javax.swing.JOptionPane;

public class LottoTest {

    public static void main(String[] args) {

        int sayYesOrNo = JOptionPane.showConfirmDialog(null,"Do you want to guess the winning numbers?");
        if (sayYesOrNo == JOptionPane.YES_NO_OPTION) {

            new Lotto();

        } else {
            JOptionPane.showMessageDialog(null, "GOODBYE");
            System.exit(0);
        }
    }
}


