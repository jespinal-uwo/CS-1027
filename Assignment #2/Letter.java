// Class that represents a single Letter


public class Letter {

    // private instance variables
    private char letter;
    private int label;

    // private constants 
    private final int UNSET = 0;
    private final int UNUSED = 1;
    private final int USED = 2;
    private final int CORRECT = 3;

    // constructor which initialize instance variabless
    public Letter(char c) {
        this.label = UNSET;
        this.letter = c;
    }


    // method which checks if the letter attribute of this letter
    // object is equal to the letter attribue of the "other" letter
    // object
    public boolean equals(Object otherObject) {

        // checks if the "other" object is of class Letter
        if (otherObject instanceof Letter) {

            if (this.letter == ((Letter) otherObject).letter)
                return true;

            else
                return false;
        }

        else
            return false;
    }


    // method which returns a specified decorator that is used to surround
    // the letter with depending if the letter is "Used", "Unused" or "Correct"
    // with respect to the mystery word

    public String decorator() {

        if (this.label == USED)
            return "+";

        if (this.label == UNUSED)
            return "-";

        if (this.label == CORRECT)
            return "!";

        if (this.label == UNSET)
            return " ";

        else
            return " ";

    }

    // method which gives a string representation of a letter object 

    public String toString() {

        return this.decorator() + this.letter + this.decorator();

    }

    // setter method that sets the label attribute to "Unused"
    public void setUnused() {
        this.label = UNUSED;
    }

    // setter method that sets the label attribute to "Used"
    public void setUsed() {
        this.label = USED;
    }

     // setter method that sets the label attribute to "Correct"
    public void setCorrect() {
        this.label = CORRECT;
    }

    // method that returns true if the lable attribute is "Unused"
    // Returns false otherwisd
    public boolean isUnused() {
        if (this.label == UNUSED)
            return true;

        else
            return false;

    }

    // method which takes in a string and returns an array full of Letter objects
    // Each character in the string corresponds to a Letter object

    public static Letter[] fromString(String s) {

        Letter[] array = new Letter[s.length()];

        for (int i = 0; i < s.length(); i++) {

            char character = s.charAt(i);
            Letter letter = new Letter(character);

            array[i] = letter;

        }

        return array;

    }

}