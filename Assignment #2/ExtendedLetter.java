
// subclass which extends the functionallity of a Letter object
// each letter object can now be related to a family
// all letter releated to a family contain the same label attribute
public class ExtendedLetter extends Letter {

    // private instance variables
    private String content;
    private int family;
    private boolean related;

    // constant
    final private int SINGLETON = -1;

    // constructor which initalizes the content to String s
    public ExtendedLetter(String s) {
        super('c');

        this.content = s;
        this.related = false;
        this.family = SINGLETON;

    }

    // constructor which initalizes the content to String s
    // and relates the letter to a family

    public ExtendedLetter(String s, int fam) {
        super('c');

        this.content = s;
        this.related = false;
        this.family = fam;
    }

    // method which checks if two letter objects are related if both letter
    // objects are part of the same family

    public boolean equals(Object other) {

        if (other instanceof ExtendedLetter) {
            if (this.family == ((ExtendedLetter) other).family) {
                this.related = true;
            }

            // returns true if both letter objects contain the same content/String
            if (this.content.equals(((ExtendedLetter) other).content)) {
                return true;
            }

            else {
                return false;
            }

        } else {
            return false;
        }

    }

    // Gives a String representation of the letter objects
    // surrounding the letter with "." if letter object is related to a family
    // (and if the letter object is unused)

    public String toString() {

        if (this.isUnused() && this.related == true) {
            return "." + this.content + ".";
        }

        // Otherwise, it surrounds the Letter object with the normal decorators
        else {
            return this.decorator() + this.content + this.decorator();
        }
    }

    // Creates an array letters of Letter objects of the same size as the size of
    // the array
    // content received as parameter. This array letters will be returned by the
    // method
    // after storing in it the following information:
    public static Letter[] fromStrings(String[] content, int[] codes) {

        Letter[] letters = new Letter[content.length];

        int i = content.length - 1;

        if (codes == null) {
            ExtendedLetter extendedLetter = new ExtendedLetter(content[i]);
            letters[i] = extendedLetter;
        }

        if (codes != null) {
            ExtendedLetter extendedLetter2 = new ExtendedLetter(content[i], codes[i]);
            letters[i] = extendedLetter2;
        }

        return letters;

    }

}
