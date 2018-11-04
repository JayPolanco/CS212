/**
 * Creates an IllegalWordException using the constructor of 
 * the super class, in this case the one parameter constructor
 * of IllegalWordException
 * @author Jason Polanco 
 *
 */
public class IllegalWordException extends IllegalArgumentException {
   
   /**
    * Passes the Illegal word to the super class(IllegalArgumentException)
    * @param word represents the illegal word
    */
   public IllegalWordException(String word){
      super(word);
      
      
   }

}
