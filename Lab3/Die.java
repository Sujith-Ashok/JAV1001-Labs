
public class Die{

  //declaring 3 variables
  private String diceType;
  private int numSides;
  private int sideUp;

  //constructor with 0 argument
  Die(){
    this.diceType = diceType;
    this.numSides = numSides;
    this.sideUp = sideUp;

  }

  //constructor with 1 argument
  Die(int userNumSides){
    numSides = userNumSides;
    diceType = "d" + numSides;
    sideUp = (int)((Math.random() * numSides) + 1);

  }

  //constructor with 2 argument
  Die(String userDiceType, int userNumSides2){
    numSides = userNumSides2;
    diceType = userDiceType;
    sideUp = (int)((Math.random() * numSides) + 1);

  }

  //roll method
  public void roll(){
    sideUp = (int)((Math.random() * numSides) + 1);
  }

  // creating accessors for variables
  public String getDiceType(){
    return diceType;
  }

  public int getNumSides(){
    return numSides;
  }

  public int getSideUp(){
    return sideUp;
  }

  // creating mutators for variables
  public void setDiceType(String defType){
    diceType = defType;
  }

  public void setNumSides(int defSides){
    numSides = defSides;
  }

  public void setSideUp(int randomSideup){
    sideUp = randomSideup;
  }
}
