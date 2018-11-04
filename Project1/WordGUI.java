import javax.swing.*;
import java.awt.*;

public class WordGUI extends JFrame {
   
   static JFrame myFrame;
   static Container myContentPane;
   static TextArea unsorted, sorted;
   
   //Constructor
   public WordGUI(String title){
      setTitle(title);
      
   }
   
   public static void intialize() {
      
      //Creates JFrame 
      
      myFrame = new JFrame("Project 1");
      myFrame.setLayout(new GridLayout(1,2));
      myFrame.setSize(800,400);
      myFrame.setLocation(200, 200);
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      myFrame.setVisible(true);
      myContentPane = myFrame.getContentPane(); 
      
      //Creates a text area for unsorted/sorted list
      unsorted = new TextArea();
      sorted = new TextArea();
      unsorted.setEditable(false);
      sorted.setEditable(false);
      
      //Adds the unsorted/sorted text areas to GUI
      myContentPane.add(unsorted);
      myContentPane.add(sorted);
   }
   
   //Prints unsorted list by appending each word to 1st column of GUI
   //In the order read from file
   public void printUnsorted(Word[] list, int size){
     
     //Goes through every element in the unsorted list and adds it to unsorted textArea
     for(int i = 0; i < size; i++){
        unsorted.append(list[i] + "\n");
        
     }      
   }
   
   //Prints sorted list by appending it to the 2nd column of GUI
   public void printSorted(Word[] wordArray, int myArrayLength) {
      
    //Goes through every element in the sorted list and adds it to sorted textArea
      for(int i = 0; i < myArrayLength; i++){
         sorted.append(wordArray[i] + "\n");
      
      }
      
   }
}

