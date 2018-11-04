
public class Word {

   static int WORD_SIZE = 3;
   String word;

   // Constructor which takes in a string
   //and stores it in word
   public Word(String w) {
      word = w;
   }
   
   //method for converting a string into a word
   public String toString() {
      return word;
   }
   
   //returns negative number if first is < second
   //returns positive number if first > second
   //and zero if the same
   public int compareTo(Word other) {
      return word.compareTo(other.toString());
         
         
   }

}

