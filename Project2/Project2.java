/**
 * 
 * This Program takes in a text file of words and puts them 
 * in sorted and unsorted linked lists. Then calls to print the unsorted and sorted list
 * of words onto a GUI.
 * 
 *@author Jason Polanco Lab Section 11C
 *
 */
import java.util.*;
public class Project2 {
   public static void main(String[] args) {
      
      //Creates 2 new list of words
      WordList unsorted = new WordList();
      WordList sorted = new WordList();
      
      String fileName = "words.txt";
      
      
      //method call to read the file
      inputFromFile(fileName, unsorted,sorted);
      
      //Creates a GUI object with the title Project1
      WordGUI myGUI = new WordGUI("Project 2");
      WordGUI.intialize();
      
      //Method calls to: 1.print unsorted list to GUI,
      //2.Print sorted list to GUI
      myGUI.printUnsorted(unsorted);
     
      myGUI.printSorted(sorted);  
      
   }

   /**
    * 
    * Reads text file line by line and places words in a unsorted and sorted lists
    * 
    * @param myFile Represents the file we will read from
    * @param unsorted Represents unsorted word list
    * @param sorted Represents sorted word list
    */
   private static void inputFromFile(String myFile, WordList unsorted, WordList sorted){
      TextFileInput in = new TextFileInput(myFile);
      
      //Read line
      String line = in.readLine();
      
      while (line != null ) {
         
         //Creates StringTokenizer object that will read each word separately
         StringTokenizer st = new StringTokenizer(line, ",");          
         
         while(st.hasMoreTokens()){
            //Creates a new word from the next string in text
            Word subWord = new Word(st.nextToken());
            
            //If word is valid
            if (isValidWord(subWord)){
               
               //add it to the end of the unsorted list and
               //insert it in the proper place of the sorted list
               unsorted.append(subWord);
               sorted.insert(subWord);
            }
            else 
               System.out.println(subWord);
         }
         //reads in next line
         line = in.readLine();       
      }                             
      in.close();
      
   } 
   
   /**
    *Checks if a word is valid, Word is valid if it is all characters
    *
    * @param singleWord Represents the word that is being checked
    * @return returns false if word is not valid, True if valid
    */

   private static boolean isValidWord(Word singleWord) {
      String enteredWord = singleWord.toString();
      for(int i = 0; i < enteredWord.length();i++){
         //If the character at element i of the word is not a letter 
         if(!Character.isLetter(enteredWord.charAt(i))){
            return false;
         }
      }
      return true;
      
   }
   

}
