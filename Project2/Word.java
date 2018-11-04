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
    * @param w String that gets stored as a word
    */
  
   public Word(String w) {
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

}

