/**
 * The word node class contains 2 constructors, 1 for a dummy node
 * and one that takes a word as a parameter and creates a word 
 * node using that word 
 * @author Jason Polanco
 *
 */
public class WordNode {
   
   protected Word data;
   protected WordNode next;

//Constructor, Dummy Node
   public WordNode(){
      this.data = null;
      this.next = null;
   }
/**
 * Constructor which takes a word and creates a wordNode for that word    
 * @param data Represents the word that will be placed in the newly created word node
 */
   public WordNode(Word data)  {
      this.data = data;
      this.next = null;
   }  
   
}
