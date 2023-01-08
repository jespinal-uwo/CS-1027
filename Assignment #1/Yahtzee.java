

// imports the Array class that helps sort Arrays numerically
import java.util.Arrays;
/**
 * Class represents Yahtzee game in which there are 5 rolled dice and
 * the scoring is performed.
 */
public class Yahtzee { 
    // Dice arrays that stores die objects
    private Dice [] dice;

    // Constructor  that initializes the Dice array with 6 random die stored
    // in it.
    public Yahtzee(){
        Dice die1  = new Dice();
        Dice die2  = new Dice();
        Dice die3  = new Dice();
        Dice die4  = new Dice();
        Dice die5  = new Dice();

        die1.roll();
        die2.roll();
        die3.roll();
        die4.roll();
        die5.roll();

        this.dice =  new Dice []{die1,die2,die3,die4,die5};
    }
    // Constructor method that initalizes Dice array with an array of die objects given
    // as a parameter.
    public Yahtzee(Dice [] diceToSet){
        this.dice = new Dice [] {diceToSet[0], diceToSet[1], diceToSet[2], diceToSet [3], diceToSet[4]};
    }

    // Counts how many of each die show 
    // in the Dice array and records them in an int array
    public int [] getValueCount (){
        // Counters that count each individual die
        int countDie1, countDie2, countDie3, countDie4, countDie5, countDie6;

        countDie1 = 0;
        countDie2 = 0;
        countDie3 = 0;
        countDie4 = 0;
        countDie5 = 0;
        countDie6 = 0;

        // Initializes the int array to 0
        int [] array = {0,0,0,0,0,0};

        // Checks to see how many "1s" are present in the dice array
        for (int i = 0; i < this.dice.length; i ++){
            if (this.dice[i].getValue() == 1){
                countDie1 ++;
                array[0] = countDie1;
            }                         
        }
         // Checks to see how many "1s" are present in the dice array
        for (int i = 0; i < this.dice.length; i ++){
            if ( this.dice[i].getValue() == 2){
                countDie2 ++;
                array[1] = countDie2;
            }                         
        }
         // Checks to see how many "2s" are present in the dice array
        for (int i = 0; i < this.dice.length; i ++){
            if ( this.dice[i].getValue() == 3){
                countDie3 ++;
                array[2] = countDie3;
            }                         
        }
         // Checks to see how many "3s" are present in the dice array
        for (int i = 0; i < this.dice.length; i ++){
            if ( this.dice[i].getValue() == 4){
                countDie4 ++;
                array[3] = countDie4;
            }                         
        }
         // Checks to see how many "4s" are present in the dice array
        for (int i = 0; i < this.dice.length; i ++){
            if ( this.dice[i].getValue() == 5){
                countDie5 ++;
                array[4] = countDie5;
            }                         
        }
         // Checks to see how many "5s" are present in the dice array
        for (int i = 0; i < this.dice.length; i ++){
            if ( this.dice[i].getValue() == 6){
                countDie6 ++;
                array[5] = countDie6;
            }                         
        }
        // returns the int array
        return array;

    }
    // calculates all the possible 13 scoring options as per the
    // Yahtzee rules of the game and stores them in a 13 element array
    public int [] getScoreOptions (){

        // initalizes the 13 element array
        int [] array = {0,0,0,0,0,0,0,0,0,0,0,0,0};
        
        // Calculates the sums of 1s through 6s and stores them in the
        // first 6 indeces of the array
        int sum_of_ones = this.getValueCount()[0] * 1;
        int sum_of_twos = this.getValueCount()[1] * 2;
        int sum_of_threes = this.getValueCount()[2] * 3;
        int sum_of_fours = this.getValueCount()[3] * 4;
        int sum_of_fives = this.getValueCount()[4] * 5;
        int sum_of_six = this.getValueCount()[5] *6;

        array[0] = sum_of_ones;
        array[1] = sum_of_twos;
        array[2] = sum_of_threes;
        array[3] = sum_of_fours;
        array[4] = sum_of_fives;
        array[5] = sum_of_six;

        // stores the sum of the dice in the last index of the array
        array [12] = this.sumOfDice();

        // Calculates if Dice array contains a Yahtzee
        // Which would include a 4 of a Kind and
        // a 3 of a Kind automatically 
        for (int i = 0; i < 6; i ++){
            if (this.getValueCount()[i] == 5){
                array[11] = 50;
                array[7] = this.sumOfDice();
                array[6] = this.sumOfDice();
            }

            // Calculates if Dice array contains 4 of a kind
            // which would include 3 of a kind automatically
            else if (this.getValueCount()[i] == 4){
                array[7] = this.sumOfDice();
                array[6] = this.sumOfDice();
            }
            // Calculaes if Dice array contains a 3 of a kind
            else if (this.getValueCount()[i] == 3){
                array[6] = this.sumOfDice();

                // Calculates if Dice array contains a Full House
                for (int j = 0; j < 6; j ++){
                    if (this.getValueCount()[j] == 2 ){
                        array [8] = 25;
                    }

                }
            }

        }
        
        // Calculates if Dice Array Contains a Large Straight
        // Which would automatically include a Small Straight
        if (this.consecutiveValues() == "Large Straight"){
            array [10] = 40;
            array [9] = 30;
        }

        // Calculates if Dice Array Contains a Small Straight
        if (this.consecutiveValues() == "Small Straight"){
            array [9] = 30;
        }


        // returs the 13 element array
       return array;
    }
    // Determines the maximum value from the Score Options array
    // as well as the index in which the maximum value is found.

    public int [] score (){

        // Initializes the maximumArray Array with the first element
        // being the maxiumum number and the second element being the
        // index where it was found.
        int [] maximumArray = {0,0};
        int [] scoreOptionsArray = this.getScoreOptions();

        int index  = 0;
        int maximum = 0;

        // Algorithm that finds the maximum value in an array of numbers
        // as well as the index where it was found
        for (int i = 0; i < scoreOptionsArray.length ; i++){
            if (scoreOptionsArray[i] > maximum){
                maximum = scoreOptionsArray[i];
                index = i;
            }
        }

        maximumArray[0] = maximum;
        maximumArray[1] = index;

        // Returns the maximum Array
        return maximumArray;

    }

    // Private helper method that calculates the sum of all elements
    // in the index array
    private int sumOfDice (){
        int sum = 0;

        // Algorithm that calculates the sum of all elements
        // in the index array
        for (int i = 0; i < this.dice.length; i ++){
            sum = sum + this.dice[i].getValue();
        }

        return sum;

    }

    // Private helper method that counts how many consecutive values 
    // are found in an array of sorted numbers
    private String consecutiveValues (){
        int count = 0;

        int die1 = this.dice[0].getValue();
        int die2 = this.dice[1].getValue();
        int die3 = this.dice[2].getValue();
        int die4 = this.dice[3].getValue();
        int die5 = this.dice[4].getValue();

        // stores all die values in an int array
        int [] array = {die1,die2,die3,die4,die5};

        // sortes the array of dice
        Arrays.sort(array);

        // Algorithm that counts how many consecutive values 
        // are found in an array of sorted numbers
        for (int i = 0; i < (array.length - 1); i ++){
            if (array[i + 1] - array[i] == 1 ){
                count ++;
            }
        }

        // Depending of the number of Consecutive Values it determines
        // if the Dice array contains either a "Large Straight"
        // or a "Small Straight"
        if (count  == 4){
            return "Large Straight";
        }

        else if (count == 3){
            return "Small Straight";
        }

        else {
            return "No Straight";
        }


        
    }

    // Method that checks whether two Dice array contain the same 
    // values stored inside
    public boolean equals (Yahtzee game){
        
        int die1 = this.dice[0].getValue();
        int die2 = this.dice[1].getValue();
        int die3 = this.dice[2].getValue();
        int die4 = this.dice[3].getValue();
        int die5 = this.dice[4].getValue();
        
        int die6 = game.dice[0].getValue();
        int die7 = game.dice[1].getValue();
        int die8 = game.dice[2].getValue();
        int die9 = game.dice[3].getValue();
        int die10 = game.dice[4].getValue();

        // Stores the dicenvalue of both Dice array objects
        // into two respective arrays 
        int [] array1 = {die1,die2,die3,die4,die5};
        int [] array2 = {die6,die7, die8, die9, die10};

        // Sorts both arrays numerically
        Arrays.sort (array1);
        Arrays.sort (array2);

        // Checks to see if both arrays contains the same dice values
        if (Arrays.equals(array1, array2)){
            return true;
        }
        else {
            return false;
        }
        
       
    }
    // Provides a String representation of a Yahtzee object.
    public String toString(){
        int die1, die2, die3,die4, die5;

        die1 = this.dice[0].getValue();
        die2 = this.dice[1].getValue();
        die3 = this.dice[2].getValue();
        die4 = this.dice[3].getValue();
        die5 = this.dice[4].getValue();

        return "Dice: {" + die1 + ", " + die2 + ", " + die3 + ", " + die4 + ", " + die5 +"}";

    }

}
