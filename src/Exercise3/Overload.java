package Exercise3;

//Vanessa Victorino - 301201653
//COMP228 - Lab #2 - Exercise 3

public class Overload {

    /* Write a Java class that implements a set of three overloaded static methods.
     * The methods should have different set of parameters and perform similar
     * functionalities. Call the methods within main method and display the results.
     */
    public static int multiply (int one,int two,int three) {

        return one * two * three;
    }
    public static int multiply (int one,int two) {

        return one * two;
    }
    public static int multiply (int one) {

        return one * 10;
    }
}



