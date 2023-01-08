import java.util.Arrays;

public class PublicHarness {

    public static void main (String [] args){
        Letter letter = new Letter('h');

        Letter letter2 = new Letter('h');

        letter2.setCorrect();

        Letter [] array  = Letter.fromString ("BEAR");
        Letter [] array2  = Letter.fromString ("ORDER");
        Letter [] array3  = Letter.fromString ("REJECT");
        Letter [] array4  = Letter.fromString ("SHORE");

        /**
       
        array[0].setUnused();
        array[1].setCorrect();

        array2[0].setUnused();
        array2[1].setUsed();
        array2[2].setUnused();
        array2[3].setUsed();
        /** */


   //     System.out.println(Arrays.toString(array));

     //   System.out.println("Unused: "  + array[0].isUnused());


        Word word  = new Word (array); // BEAR
        Word word2 = new Word (array2); // MYSTERY
        Word word3  = new Word (array3); // REJECT
        Word word4 = new Word (array4); // SHORE

        WordLL wordLL = new WordLL(word2);

        wordLL.tryWord(word);
        wordLL.tryWord(word3);
        wordLL.tryWord(word4);
        wordLL.tryWord(word2);

        System.out.println(wordLL);
        System.out.println("Correct Word: " +  wordLL.tryWord(word2));

       // word.labelWord(word2);

      //  System.out.println(word.labelWord(word2));
     //   System.out.println(word);
       



    }
    
}
