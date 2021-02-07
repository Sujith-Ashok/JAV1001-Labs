import java.util.Scanner;

public class Array{

//Method for encryption
public void encrypt(String enText, int value){

//declaring variables
      char encryptLetter;
      String encryptedWord ="";
//loop to encryption
     for(int i=0; i < enText.length(); i++){

        encryptLetter = enText.charAt(i);

        encryptLetter = (char)(encryptLetter + value);
//if the char is above alphabet ascii numbers
        if(encryptLetter > 'Z' && encryptLetter < 'a'){
        encryptLetter = (char) ('A' + (encryptLetter % 90) - 1);
        }

        if(encryptLetter > 'z'){
        encryptLetter = (char) ('a' + (encryptLetter % 122) - 1);
        }
        encryptedWord = encryptedWord + encryptLetter;
     }
//printing encrypted word
     System.out.println("");
     System.out.println("Encrypted Word:" +encryptedWord);
   }



//Method for decryption
public void decrypt(String deText, int deValue){

     String decryptedWord ="";
     char decryptLetter;

//loop to decryption
    for(int i=0; i < deText.length(); i++){

       decryptLetter = deText.charAt(i);

       decryptLetter = (char)(decryptLetter - deValue);
//if the char is below alphabet ascii numbers
       if(decryptLetter < 'A'){
       decryptLetter = (char) ('Z' - (65 % decryptLetter) + 1);
       }

       if(decryptLetter < 'a' && decryptLetter > 'Z'){
       decryptLetter = (char) ('z' - (97 % decryptLetter) + 1);
       }
       decryptedWord = decryptedWord + decryptLetter;
    }
//printing decrypted word
    System.out.println("");
    System.out.println("Decrypted Word:" +decryptedWord);

}

//method to calculate sum
  public void sum(int[] arrInput){


      int sum = 0;
//loop to add the array numbers
   for (int i = 0; i < arrInput.length; i++)
   {
      sum = sum + arrInput[i];
   }
  //printing sum
      System.out.println("Sum of Array: " +sum);

}

//method to find number in array
public void contains(int[] arrCont, int arrContain){



      boolean contain = false;
      int contSum = 0;

//loop to add the array numbers
      for (int i = 0; i < arrCont.length; i++)
      {
         contSum = contSum + arrCont[i];
      }
//printing sum
      System.out.println("Sum of Array: " +contSum);
      System.out.println("");

//loop to find the number inside array
      for (int i = 0; i < arrCont.length; i++)
      {
         if(arrContain == arrCont[i])
         {
           contain = true;
         }

    }
//printing result based on boolean contain using if statement
    if(contain){
        System.out.println("Array contains: " +arrContain);
    }
    else{
      System.out.println("Array does not contain: " +arrContain);
    }
  }




public static void main(String[] args) {


//creating object for class
  Array labObj = new Array();

  System.out.println("");
  System.out.println("****************************************");
  System.out.println("      Welcome to Secret Java Club       ");
  System.out.println("****************************************");
  System.out.println("");
  System.out.println("---------------Encryption----------------");

//creating Scanner object
  Scanner keybEncrypt = new Scanner(System.in);
//getting encryption string and value from user
  System.out.print("Please enter the text to be encrypted: ");
  String encryptIn = keybEncrypt.nextLine();
  System.out.print("Please enter the value to encrypt the text: ");
  int valueIn = keybEncrypt.nextInt();
//passing the string and value to the method
  labObj.encrypt(encryptIn,valueIn);


  System.out.println("\n");
  System.out.println("---------------Decryption----------------");
//getting decryption string and value from user
  Scanner keybDecrypt = new Scanner(System.in);
  System.out.print("Please enter the text to be decrypted: ");
  String decryptIn = keybDecrypt.nextLine();
  System.out.print("Please enter the value to decrypt the text: ");
  int deValueIn = keybDecrypt.nextInt();
//passing the string and value to the method
  labObj.decrypt(decryptIn,deValueIn);


  System.out.println("\n");
  System.out.println("****************************************");
  System.out.println("         Welcome to Array Zone           ");
  System.out.println("****************************************");


  System.out.println("");
  System.out.println("-------------Sum of Array---------------");

//getting decryption string and value from user
  Scanner keybSum = new Scanner(System.in);
  int[] arrayIn = new int[10];
  System.out.println("Please enter 10 numbers for the array: ");

  for (int i = 0; i < arrayIn.length; i++)
  {
    arrayIn[i] = keybSum.nextInt();
  }
//printing the array
  System.out.println("");
  System.out.println("The array you entered is");
  System.out.print("[");
  for( int i = 0; i < arrayIn.length; i++ ){
  System.out.print(arrayIn[i]+" ");
    }
  System.out.println("]");
  System.out.println("");
//passing the array to the method
  labObj.sum(arrayIn);

  System.out.println("\n");
  System.out.println("----------Array Number Finder-----------");

  System.out.println("Hi!!! Let me create a random array for you...... ");
  System.out.println("");
  System.out.println("Array is");
//creating random array
  int[] randomCont = new int[10];

  for (int i = 0; i < randomCont.length; i++)
  {
    randomCont[i] = (int) ((Math.random() * 100) + 1);
  }
//printing the array
  System.out.print("[");
  for( int i = 0; i < randomCont.length; i++ ){
  System.out.print(randomCont[i]+" ");
    }
  System.out.println("]");

  Scanner keybContain = new Scanner(System.in);
  System.out.println("");
  System.out.print("Please enter a number to find in the above array: ");
  int containIn = keybContain.nextInt();
//passing the array and number to the method
  labObj.contains(randomCont,containIn);

  System.out.println("\n");
}
}
