/**
 * Holds the information for a linked list of words
 * contains methods that a word list can and can not do
 * such as adding to end of list and inserting in proper position
 * @author Jason Polanco 
 *
 */
public abstract class WordList {

   protected WordNode first;
   protected WordNode last;
   protected int length;

   /**
    * Constructor that creates a dummy node
    */
   
   public WordList() {
      WordNode ln = new WordNode();
      first = ln;
      last = ln;
      length = 0;
   }

   /**
    * Converts elements of list to strings 
    */
   public String toString() {
      WordNode p = first.next;
      String returnString = "";
      //while we haven't reached the end of the list, convert data in node to a string
      while (p != null) {
         returnString += p.data + "\n";
         p = p.next;
      }
      return returnString;

   }
}
