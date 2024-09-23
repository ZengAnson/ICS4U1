import java.util.*;

class Main {
  public static int userChoice=0; //for when they pick a game
  public static boolean possible=false; //global boolean

  public static void game1(){
    String[] colours={"", "\u001B[31m", "\u001B[33m", "\u001B[32m", "\u001B[36m", "\u001B[34m", "\u001B[35m", "\u001B[37m"}; //red, yellow, green, cyan, blue, purple, white
    String intToStr; //convert integer to string
    ArrayList<Character> userInputList=new ArrayList<Character>(); //separates input to char array --> splits the string
    ArrayList <Integer> colourOrder=new ArrayList<Integer>(); //turn char array into int
    ArrayList <String> colourList=new ArrayList<String>(); //colour order with respective colour codes
    String userText; //text that the user wants to print
    int counter=0; //counter
    String reset = "\u001B[0m"; //reset colour
    Scanner input=new Scanner(System.in);
    System.out.println("\nEnter the following in the order which you want the colours in: [ie: 1263...]\n1. Red\n2. Yellow\n3. Green\n4. Cyan\n5. Blue\n6. Purple\n7. White");
    game1Valid();
    if (possible==true) {
      intToStr=Integer.toString(userChoice); //runs if game1Valid is true automatically
      char[] userInput=intToStr.toCharArray(); //turn into char array to separate each number
      for (int i=0; i<userInput.length; i++){
        userInputList.add(userInput[i]); //add each number to array list
      } for (int i=0; i<userInputList.size(); i++){
        colourOrder.add(userInputList.get(i)-'0'); //turns char into int
      } 
      for (int i=0; i<colourOrder.size(); i++){
        colourList.add(colours[colourOrder.get(i)]); //gets respective colours
      } System.out.print ("\nThe text that you want to print: ");
      userText=input.nextLine();
      String[] splitText=userText.split(""); //splits string into characters without char array --> char too hard for operands
      for (int i=0; i<splitText.length; i++){
        if (!splitText[i].equals(" ")){
          System.out.print(colourList.get(counter%colourList.size())+splitText[i]+reset); //if doesn't equal space, counter modulo size to repeat colours + character + reset colour
          counter++;
        } else {
          System.out.print(" "); //add space because sapce isn't coloured
        }
      }
      possible=false;
    } System.out.println("\n"); 
    // gui(); //returns to game menu
  } public static void game1Valid(){
    Scanner input=new Scanner (System.in);
    try {
      userChoice=input.nextInt(); //user input
      String noZero=Integer.toString(userChoice).replaceAll("(0|8|9)", ""); //removes 0, 8, 9 because not possible
      userChoice=Integer.parseInt(noZero); //parse back into int
      if (userChoice<0) {
        System.out.println("Negative input. Try again."); //negative
        game1();
        return;
      } else {
        possible=true;
        return;
      }
    } catch (Exception notAnInt) {
      System.out.println("Impossible input. Try Again."); //not an integer
      game1();
      return;
    }
  }