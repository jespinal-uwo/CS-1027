/**
 * Class represents a single six-sided die that will be used in the game
 */


public class Dice {
    private int value;

    // Constructor with no parameter that sets the value of the die to -1
    public Dice (){
        this.value = -1;
    }
    // Constructor with a single parameter that sets the value of the die
    public Dice (int valuetoSet){
        this.value = valuetoSet;
    }
    // Calculates a random number between 1 and 6 inclusive and stores it
    // as the value of the die
    public void roll (){     
       value = RandomNumber.getRandomNumber(1, 6);
    }
    // Getter method that gets the value of the die
    public int getValue(){
        return this.value;
    }

}
