
import java.util.*;

import javax.swing.text.html.StyleSheet;
public class TestHarness {
    public static void main (String[] args ){

        Yahtzee game1, game2, game3;
        
       // game1 = new Yahtzee();
	//	game2 = new Yahtzee(new Dice[] {new Dice(2), new Dice(5), new Dice(3), new Dice(5), new Dice(6)});
		game3 = new Yahtzee(new Dice[] {new Dice(5), new Dice(3), new Dice(5), new Dice(4), new Dice(2)});
       
      //  System.out.println(game1);
      //  System.out.println(game2);
          System.out.println(game3);
          System.out.println(Arrays.toString(game3.getScoreOptions()));
          System.out.println(Arrays.toString(game3.getValueCount() ));
          System.out.println(Arrays.toString(game3.score()));
        //  System.out.println(game3.consecutiveValues());
        //  System.out.println(game3.sumOfDice());
     //   System.out.println(game1.equals(game3));


    }
}
