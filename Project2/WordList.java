/**
 * Holds the information for a linked list of words
 * contains methods that a word list can and can not do
 * such as adding to end of list and inserting in proper position
 * @author Jason Polanco Lab Section 11C
 *
 */
public class WordList {

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
 * Append Adds the word to the end of the Word list   
 * @param s word that
 */
   public void append(Word s) {
      WordNode n = new WordNode(s);
      last.next = n;
      //Changes the pointer that points to the last node to the 
      //node that we added to the end
      last = n;
      length++;
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

   /**
    * Inserts a word into the proper position of a word list
    * @param s Represents the word that will be inserted in word list
    */
   public void insert(Word s) {
      WordNode n = new WordNode(s);
      // if there is no WordList
      if (first.next == null) {
         //insert word onto list 
         last.next = n;
         last = n;
         length++;
      }

      else {
         WordNode current = first.next;
         
         // while we haven't reached the end of the list
         while (current.next != null) {

            // if the new word comes after the current word, Compare it to the next
            // word on list
            if ((n.data).compareTo(current.next.data) > 0)
               current = current.next;

            // if the new word comes before then current word, break out of loop
            else if ((n.data).compareTo(current.next.data) <= 0)
               break;

         }

         // if current points to nothing(reached end of list), word n comes after
         // than every word in list so place it at the end
         if (current.next == null) {
            last.next = n;
            last = n;
            length++;
         } else {
            // inserts new word node in between the 2 nodes
            n.next = current.next;
            current.next = n;
            if (n.next == null) {
               last = n;
            }
            length++;
         }
      }
   }

}
