/**
 * Defines what behaviors and properties that a Word has
 * such as comparing 2 words, converting a string to a word and
 * a constructor which takes a string 
 * @author Jason Polanco
 *
 */
public class Word {

   static int WORD_SIZE = 100;
   String word;

   /**
    * First constructor which takes in a string and makes it into a word
    * Throws an IllegalWordException if the word is not a valid word
    * @param w String that gets stored as a word
    */
  
   public Word(String w) {
      if(!isValidWord(w))
         throw new IllegalWordException("Illegal Word: " + w);
      word = w;
   }
   
   //method for converting a string into a word
   public String toString() {
      return word;
   }
 
   /**
    * compares two words
    * @param other the object to be compared to this word
    * @return 1. negative number if first is < second
    *         2. positive number if first > second
    *         3. zero if the same
    */
   public int compareTo(Word other) {
      return word.compareTo(other.toString());
         
         
   }
   /**
    *Checks if a word is valid, Word is valid if it is all characters
    *
    * @param singleWord Represents the word that is being checked
    * @return returns false if word is not valid, True if valid
    */
   private static boolean isValidWord(String singleWord) {
      String enteredWord = singleWord;
      for(int i = 0; i < enteredWord.length();i++){
         //If the character at element i of the word is not a letter 
         if(!Character.isLetter(enteredWord.charAt(i))){
            return false;
         }
      }
      return true;
      
   }

}

