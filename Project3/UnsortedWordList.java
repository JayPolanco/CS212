/**
 * UnsortedWordList which adds the newest word to the end of the list
 * @author Jason Polanco
 *
 */
public class UnsortedWordList extends WordList {
   /**
    * Adds the new word to the end of the unsortedWordList
    * @param s represents the new word
    */
   public void add(Word s) {
      WordNode n = new WordNode(s);
      last.next = n;
      //Changes the pointer that points to the last node to the 
      //node that we added to the end
      last = n;
      length++;
   }
}
