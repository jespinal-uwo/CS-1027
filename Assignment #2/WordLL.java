
// Class which represents a Wordle game:
// it stores a mystery word and all the word guesses tried so far
public class WordLL {

    // instance variable which represents a mysteryWord
    private Word mysteryWord;
    // node instance variable which points to the most recent guessed word
    private LinearNode<Word> history;

    // constructor which initializes all instance varaibles
    public WordLL(Word mystery) {
        history = null;
        mysteryWord = mystery;
    }

    // Tests a word guess against the mystery word, changing all the label
    // attributes
    public boolean tryWord(Word guess) {

        // creates a word object which is the user's guess
        LinearNode<Word> guessNode;
        guessNode = new LinearNode<Word>(guess);

        // stores the guessed word object in a linked list of word objects
        // with history pointing to the most recent guessed word
        guessNode.setNext(history);
        history = guessNode;

        // tests the guessed word with the mystery word
        // changing all the appropiate label attributes
        guess.labelWord(this.mysteryWord);

        // returns true if the guessed word matches exactly with the mystery word

        if (guess.labelWord(this.mysteryWord) == true)
            return true;
        else
            return false;
    }

    // Returns a string representation of all the guessed words along with their
    // updated letter attributes
    public String toString() {
        LinearNode<Word> current = this.history;
        String string = "";

        while (current != null) {
            string = string + current.getElement().toString() + "\n";
            current = current.getNext();
        }

        return string;
    }

}
