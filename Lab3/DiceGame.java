import java.util.*;
public class DiceGame{

  public static void main(String[] args) {
       System.out.println("****************************************************");
       System.out.println("              Dice Game - Dice no.1 🎲              ");
       System.out.println("****************************************************");
       System.out.println("");
       System.out.println("Let us create a 6 sided dice first...");
       Die Obj = new Die(); // creating object for first constructor
       //setting the values for private variables using mutators
       Obj.setNumSides(6);
       Obj.setDiceType("d6");
       Obj.setSideUp((int)((Math.random() * 6) + 1));

       //creating dice 1
       System.out.println("The dice '" + Obj.getDiceType() + "' with " + Obj.getNumSides() +" sides has been created with side " + Obj.getSideUp() + " on top.");
       System.out.println("");
       //rolling dice 1
       Obj.roll();
       System.out.println("Rolling " + Obj.getDiceType() + ".......");
       System.out.println("Now Dice '" + Obj.getDiceType() +"' has side " + Obj.getSideUp() + " on top.");




       System.out.println("");
       System.out.println("----------------------------------------------------");
       System.out.println("                    Dice no.2 🎲🎲                  ");
       System.out.println("----------------------------------------------------");
       System.out.println("");
       //Creating scanner object.
       Scanner inSide = new Scanner(System.in);
       //getting num of sides from user
       System.out.print("Enter the number of sides of the dice you want to create : ");
       int inputSides = inSide.nextInt();


       Die Obj2 = new Die(inputSides); // creating object for second constructor

       //creating dice 2
       System.out.println("");
       System.out.println("The dice '" + Obj2.getDiceType() + "' with " + Obj2.getNumSides() +" sides has been created with side " + Obj2.getSideUp() + " on top.");
       System.out.println("");
       //rolling dice 2
       Obj2.roll();
       System.out.println("Rolling " + Obj2.getDiceType() + ".......");
       System.out.println("Now Dice '" + Obj2.getDiceType() +"' has side " + Obj2.getSideUp() + " on top.");


       System.out.println("");
       System.out.println("----------------------------------------------------");
       System.out.println("                    Dice no.3 🎲🎲🎲                  ");
       System.out.println("----------------------------------------------------");
       System.out.println("");
       Scanner inType = new Scanner(System.in);

       //getting dice type from user
       System.out.print("Enter the type of dice you want to create : ");
       String userType = inType.nextLine();
       //getting num of sides from user
       System.out.print("Enter the number of sides of the dice you want to create : ");
       int inputSides2 = inType.nextInt();

       Die Obj3 = new Die(userType , inputSides2); // creating object for first constructor

       //creating dice 3
       System.out.println("");
       System.out.println("The dice '" + Obj3.getDiceType() + "' with " + Obj3.getNumSides() +" sides has been created with side " + Obj3.getSideUp() + " on top.");
       System.out.println("");
       //rolling dice 3
       Obj3.roll();
       System.out.println("Rolling " + Obj3.getDiceType() + ".......");
       System.out.println("Now Dice '" + Obj3.getDiceType() +"' has side " + Obj3.getSideUp() + " on top");

       //getting side up from user
       System.out.println("");
       System.out.println("Enter the side up you would like to change for " +Obj3.getDiceType() +" Range (0-" +Obj3.getNumSides()+").");
       int inSideUp = inType.nextInt();
       System.out.println("Setting the side up for "+Obj3.getDiceType() + " to be " +inSideUp);

       //setting the side up with side up number from user
       Obj3.setSideUp(inSideUp);
       System.out.println("");
       System.out.println("Now the side up for "+Obj3.getDiceType() +" is " +Obj3.getSideUp());



       System.out.println("");
       System.out.println("****************************************************");
       System.out.println("               Bonus game - Yahtzee 🎲              ");
       System.out.println("****************************************************");
       System.out.println("");

       System.out.println("Lets roll 5 six-sided dice ");
       int i = 0;
       //using loop to roll all 5 dice
       do {
        int die1 = (int)((Math.random() * 6) + 1);
        int die2 = (int)((Math.random() * 6) + 1);
        int die3 = (int)((Math.random() * 6) + 1);
        int die4 = (int)((Math.random() * 6) + 1);
        int die5 = (int)((Math.random() * 6) + 1);
         i++;
         if(die1 == die2 && die2 == die3 && die3 == die4 && die4 == die5){
           System.out.println("");
           System.out.println("🎯 YAY its yahtzee 🎲🎲🎲🎲🎲");
           System.out.println("");
           System.out.println("Number of rolls to get Yahtzee: "+i);
           break;
         }

       }
       while (i > 0);
  }
}
