class Problem1 extends ConsoleProgram {

  /**
  * A program that allows students to create an student account
  * @author: Kayla Jin
  */
  
  public void run() {
    
    // Title of the program
    System.out.println("***** Student Account Registration *****");

    // Receive user input
    String strFirstName = readLine("Enter your first name: ");
    String strLastName = readLine("Enter your last name: ");
    String strStudentNumber = readLine("Enter your student number: ");
    String strPassword = readLine("Enter a new password: ");

    // Print out the result
    System.out.println("");
    System.out.println("Your username is: " + createUserName(strFirstName, strLastName, strStudentNumber));
    System.out.println("Valid password: " + validatePassword(strPassword));
    
  }

  /**
   * A method that creates a username based on information entered by the student
   * 
   * @param strFirst The user's first name
   * @param strLast The user's last name
   * @param strNum The 9 digit student number
   * @return The user's generated username
   */
  public String createUserName(String strFirst, String strLast, String strNum){
    
    // Change the last name to lowercase
    strLast = strLast.toLowerCase();

    // Create a variable to store the final username
    String strUsername = "";

    if (strFirst.equals("") || strLast.equals("") || strNum.equals("") || strNum.length() != 9){
      throw new IllegalArgumentException();
    }
    // If statement to check if the length of the last name is greater than 3 to prevent an index out of bounds error
    if (strLast.length() > 3){

      strUsername = "" + strFirst.charAt(0) + strLast.substring(0, 4) + strNum.substring(6);
    }
    // Writes the final username if the last name is 3 or less characters
    else {
      strUsername = "" + strFirst.charAt(0) + strLast + strNum.substring(6);
    }

    // Returns the username
    return strUsername;
  }
  
  /**
   * A method that validates whether or not a password meets certain criteria
   * 
   * @param strPassword The user's password
   * @return Whether or not the password is valid (true) or invalid (false)
   */
  public boolean validatePassword(String strPassword){
    
    // Variable to count the number of uppercase characters
    int intUpperCount = 0;

    // If statement to check if the length of the password is greater than or equal to 7
    if (strPassword.length() >= 7){

      // For loop to check each character in the string
      for (int i = 0; i < strPassword.length(); i ++){
        
        // If statement to return false if the character is not a letter or digit
        if (!(Character.isLetterOrDigit(strPassword.charAt(i)))){

          return false;
          }
        
        // If statement to count the number of uppercase letters
        if (Character.isUpperCase(strPassword.charAt(i))){
            intUpperCount += 1;
          }
        }
      
      // Returns true if there is at least one uppercase character in the string
      if (intUpperCount > 0){
        return true;
      }
    }

    // Returns false the password is less than 7 characters
    return false;
  }
}