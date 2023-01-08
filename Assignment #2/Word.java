
// Class which represents a Word object
public class Word {

    // private instance variable
    // This node object points to the first letter in a linked list of Letter
    // objects
    private LinearNode<Letter> firstLetter;

    // Constructor which creates a linked list of letter objects with
    // the firstLetter object pointing to the first letter
    public Word(Letter[] letters) {

        firstLetter = null;
        LinearNode<Letter> letterNode;

        for (int i = (letters.length - 1); i >= 0; i--) {

            letterNode = new LinearNode<Letter>(letters[i]);

            letterNode.setNext(firstLetter);
            firstLetter = letterNode;

        }

    }

    // method which gives a String representation of a "Word" Object
    // Uses the toString method of the Letter class to give a string represention
    // of individual letters to create a Word

    public String toString() {
        LinearNode<Letter> current = firstLetter;

        String string = "Word: " + firstLetter.getElement().toString() + " ";

        // while loop that goes through each node (letter object) in the linked list
        while (current.getNext() != null) {
            current = current.getNext();
            string = string + current.getElement().toString() + " ";

        }

        return string;

    }

    // private helper method which returns the number of nodes
    // (i.e number of letters) in a word object
    private int numberOfNodes(LinearNode<Letter> firstLetter) {

        int count = 0;

        LinearNode<Letter> current = firstLetter;

        // iterates through each node in the linked list
        while (current != null) {
            count++;
            current = current.getNext();
        }

        return count;

    }

    // method which changes the letter attributes in a word with respect to
    // a mystery word.
    // the letter attribute is changed using the setter methods in the Letter class
    public boolean labelWord(Word mystery) {

        // counts the number of times a letter attribute is set to Correct
        int count = 0;

        // counts the lenght (number of nodes) of the word objects
        int thisLenght = numberOfNodes(mystery.firstLetter);
        int otherLenght = numberOfNodes(this.firstLetter);

        // keeps track of the current node while iterating through the linked list
        LinearNode<Letter> current = this.firstLetter;
        LinearNode<Letter> current2 = mystery.firstLetter;

        // algorithm which maps the letter attributes with respect to a mystery word
        while (current != null) {

            if (current2 != null) {

                // if letters in both words match the character AND position,
                // the letter attribute is set to correct
                if (current.getElement().equals(current2.getElement())) {
                    count++;
                    current.getElement().setCorrect();
                }

                else {

                    // Otherwise the letter attribute is set to Unused unless
                    // that letter is found in that mystery word
                    current.getElement().setUnused();

                    // keeps track of the current node while iterating through
                    // the mystery word linked list
                    LinearNode<Letter> current2Temp = mystery.firstLetter;

                    // iterates through the mystery word linked list,
                    // setting the letter attribute to "Used" if it finds
                    // a character that matches the mystery word
                    while (current2Temp != null) {
                        if (current.getElement().equals(current2Temp.getElement()))
                            current.getElement().setUsed();

                        current2Temp = current2Temp.getNext();
                    }

                }

            }

            else {

                // Otherwise the letter attribute is set to Unused unless
                // that letter is found in that mystery word
                current.getElement().setUnused();

                // keeps track of the current node while iterating through
                // the mystery word linked list
                LinearNode<Letter> current2Temp = mystery.firstLetter;

                // iterates through the mystery word linked list,
                // setting the letter attribute to "Used" if it finds
                // a character that matches the mystery word
                while (current2Temp != null) {
                    if (current.getElement().equals(current2Temp.getElement()))
                        current.getElement().setUsed();

                    current2Temp = current2Temp.getNext();
                }

            }

            // current node goes to the next node in the linked list
            if (current != null) {
                current = current.getNext();
            }

            if (current2 != null) {
                current2 = current2.getNext();
            }

        }

        // returns true if this Word matches the Mystery Word exactly

        if (thisLenght == otherLenght) {
            if (thisLenght == count)
                return true;
            else
                return false;
        } else {
            return false;
        }

    }

}
