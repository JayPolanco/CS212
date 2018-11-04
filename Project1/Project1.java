/*Jason Polanco
 * 
 * This Program takes in a text file of words and puts them 
 * in an array. Then prints the unsorted and sorted list
 * of words onto a GUI.
 * 
 */
import java.util.*;
public class Project1 {
   public static void main(String[] args) {
      
      String fileName = "words.txt";
      
      Word[] wordArray = new Word[100];
      
      //Stores the number of words put into the array
      int myArrayLength = inputFromFile(fileName, wordArray);
      
      //Creates a GUI object with the title Project1
      WordGUI myGUI = new WordGUI("Project1");
      WordGUI.intialize();
      
      //Method calls to: 1.print unsorted list to GUI,
      //2.sort the list, 3.Print sorted list to GUI
      myGUI.printUnsorted(wordArray, myArrayLength);
      selectSort(wordArray, myArrayLength);
      myGUI.printSorted(wordArray, myArrayLength);  
      
   }
   
   //Sorts words in alphabetical order using selection sort
   private static void selectSort(Word[] wordArray, int myArrayLength) {
      for (int i = 0; i < myArrayLength - 1; i++) {
         int indexLowest = i;
         for (int j = i + 1; j < myArrayLength; j++) {
            
            /*If the word at indexLowest comes after the word in the current element
            alphabetically, new lowestIndex is the index of the current element*/
             
            if (wordArray[indexLowest].compareTo(wordArray[j]) >= 1)
                indexLowest = j;
         }//for j
        
         //swaps the word at the lowest index with the word at the top of list that isn't sorted already
         if(indexLowest != i){
            Word temp = wordArray[indexLowest];
            wordArray[indexLowest] = wordArray[i];
            wordArray[i] = temp;
         }//if   
      }//for i
      
      
   }

   //Reads text file line by line and stores words into an array of words 
   private static int inputFromFile(String myFile, Word[] words){
      TextFileInput in = new TextFileInput(myFile);
      int lengthFilled = 0;
      
      //Read line
      String line = in.readLine();
      
      while ( lengthFilled < words.length && line != null ) {
         
         //Creates StringTokenizer object that will read each word separately
         StringTokenizer st = new StringTokenizer(line, ",");          
         
         while(st.hasMoreTokens()){
            //Creates a new word from the next string in text
            Word subWord = new Word(st.nextToken());
            
            //If word is valid store it in array, otherwise print to console
            if (isValidWord(subWord))
               words[lengthFilled++] = subWord; 
         
            else 
               System.out.println(subWord);
         }
         //reads in next line
         line = in.readLine();       
      }                             
      
      //If array isn't big enough
      if ( line != null ) {
         System.out.println("File contains too many words.");
         System.out.println("This program can process only " +
                            words.length + " words.");
         System.exit(1);
      } 
      
      in.close();
      //return the size of the array filled
      return lengthFilled;
   }  

   //Checks if the word is not of size 3 and if any characters 
   //are not letters, if so invalid, else valid word
   private static boolean isValidWord(Word singleWord) {
      String enteredWord = singleWord.toString();
      if(enteredWord.length()!=3)
         return false;
      for(int i = 0; i < enteredWord.length();i++){
         if(!Character.isLetter(enteredWord.charAt(i))){
            return false;
         }
      }
      return true;
      
   }
   

}
