/* 
 Emily Breneman
 01.26.2021
 Assignment 1
*/
package itsc1213.assignment1;

import java.util.Random;

/*
 Simulation of the Craps dice game
 If the first roll of 2 die sums to a 7 or 11, the round is won. If the first
 roll of 2 die sums to 2, 3, or 12 ("craps"), the round is lost. Tally the win 
 or loss. 
 If none of the above is rolled initially, the total rolled (sum) is saved as
 the point (a point is established). Continue rolling the dice until either a 7
 is rolled or the point is rolled (ending the round). If the point is rolled 
 before a 7, the round is won. If the 7 is rolled before the point, the round is
 lost. Tally the win or loss.
*/

public class Craps 
{
    public static void main(String[] args)
    {
        //Declare/Initialize variables
        Random r = new Random(System.currentTimeMillis()); //generates a random value based on current time in milliseconds
        int die1;   
        int die2;   //stores random die value from 1-6
        int point;  //stores point value (sum of die1 and die2) for subsequent rolls
        int roll;   //stores number of rolls in a round
        int wins = 0;
        int losses = 0; //stores number of total wins and losses
    
        // -- GAME --
        //loop with iterate for i rounds
        for(int i = 0; i < 100000; i++)
        {
            //Initialize "roll" die
            roll = 1;   //resets roll to 1 per round
            die1 = r.nextInt(6) + 1;    
            die2 = r.nextInt(6) + 1;    //generates random value for dice roll
            
            int sum = die1 + die2;  //sum of dice roll
            
            System.out.println("Round: " + (i + 1) + "\tRoll " + roll + " -- Die1: " + die1 + " Die2: " + die2 + " -- Total: " + sum);
            
            //if-statement to determing whether round is won/lost/continues
            if (sum == 7 || sum == 11)
            {
                //if sum of die is 7 or 11, the round is immediately won
                wins++;
                System.out.println("Win!");
                System.out.println(wins + " Win(s), " + losses + " loss(es)");
                System.out.println(); 
            }
            else if (sum == 2 || sum == 3 || sum == 12)
            {
                //if sum of die is 2, 3, or 12, the round is immediately lost
                losses++;
                System.out.println("Loss!");
                System.out.println(wins + " Win(s), " + losses + " loss(es)");
                System.out.println();   
            }
            else
            {
                //if sum of die does not yield win/loss, round continues
                point = sum;
                System.out.println("Point is " + point);
                
                //loop that determines when round ends
                do
                {
                    //round continues so die is rolled again
                    roll++;
                    die1 = r.nextInt(6) + 1;    
                    die2 = r.nextInt(6) + 1;
                    
                    sum = die1 + die2;
                    
                    System.out.println("Round: " + (i + 1) + "\tRoll " + roll + " -- Die1: " + die1 + " Die2: " + die2 + " -- Total: " + sum);
                    
                    //if-statement determining whether subsequent rolls yield win/loss/continue
                    if (sum == 7)
                    {
                        losses++;
                        System.out.println("Loss!");
                        System.out.println(wins + " Win(s), " + losses + " loss(es)");
                        System.out.println();
                    }
                    else if (sum == point)
                    {
                        wins++;
                        System.out.println("Win!");
                        System.out.println(wins + " Win(s), " + losses + " loss(es)");
                        System.out.println(); 
                    }
                }
                while (!(sum == point || sum == 7)); //ensures NEITHER of these conditions can apply
            }
        }
        System.out.println(wins + " win(s), " + losses + " loss(es)");  
    }
}
