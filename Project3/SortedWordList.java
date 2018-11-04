/**
 * SortedWordList which adds the newest word to the list in the proper position
 * @author Jason Polanco
 *
 */
public class SortedWordList extends WordList {
  /**
   * Adds the new word in the correct position of the sortedWordList
   * @param s represents the new word 
   */
   public void add(Word s) {
      WordNode n = new WordNode(s);
      // if there is no WordList
      if (first.next == null) {
         //insert word onto list 
         last.next = n;
         last = n;
         length++;
      }

      else {
         WordNode current = first;
         
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
