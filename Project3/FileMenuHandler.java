import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;

/**
 * Handles the actions that happen when you click on a menu item on the GUI.
 * Also takes in a text file of words selected by the user from a file menu and puts them 
 * in sorted and unsorted linked lists. Then calls to print the unsorted and sorted list
 * of words onto the GUI.
 * @author Jason Polanco 
 *
 */
public class FileMenuHandler implements ActionListener {
   UnsortedWordList unSWL; 
   SortedWordList sortWL;
   WordGUI WG;
   
   /**
    * Constructor which gives a reference to the WordGUI, unsorted/sorted Lists 
    * 
    * @param original - Original GUI
    * @param UWL - the UnsortedWordList
    * @param SWL - the SortedWordList
    */

   public FileMenuHandler (WordGUI original, UnsortedWordList UWL, SortedWordList SWL) {
      unSWL = UWL;
      sortWL = SWL;
      WG = original;
   }
   
   /**
    * Determines the action that is done relative to the event
    * If open is clicked, we call the openFile method
    * if quit is clicked, exit the program
    */
   public void actionPerformed(ActionEvent event) {
      String  menuName;
      //stores the string representation of the action command
      menuName = event.getActionCommand();
      if (menuName.equals("Open"))
         openFile( ); 
      else if (menuName.equals("Quit")){
         JOptionPane.showMessageDialog(null, " Quit was clicked");
         System.exit(0);
      }
   } //actionPerformed

   /**
    * Opens file menu and then calls to read the file that was selected
    */
    private void openFile( ) {
       JFileChooser chooser;
       int status;
       chooser = new JFileChooser( );
       status = chooser.showOpenDialog(null);
       if (status == JFileChooser.APPROVE_OPTION) 
          //read file and pass in the selected file, unsortedWordList and sortedWordList
          readSource(chooser.getSelectedFile(), unSWL, sortWL );
       else 
          JOptionPane.showMessageDialog(null, "Open File dialog canceled");
    } //openFile
  
    /**
     * Reads the words in a file one at a time and if valid adds them to the unsorted and sorted word list
     * in the proper order, otherwise if not valid throws an exception.
     * 
     * @param chosenFile represents the file that was selected by the user
     * @param unSWL represents the unsorted word list
     * @param sortWL represents the sorted word list
     */
    private void readSource(File chosenFile, UnsortedWordList unSWL, SortedWordList sortWL ) {
       String chosenFileName = chosenFile.getAbsolutePath();
       TextFileInput in = new TextFileInput(chosenFileName);
       
       //Read next line
       String line = in.readLine();
       Word subWord;
       while (line != null ) {
        //Creates StringTokenizer object that will read each word separately
          StringTokenizer st = new StringTokenizer(line, ",");          
          
          while(st.hasMoreTokens()){
             //Creates a new word from the next string in text
             try{
             subWord = new Word(st.nextToken());
           //add(append) it to the end of the unsorted list and
             unSWL.add(subWord);
           
           //add(insert) it in the proper place of the sorted list  
             sortWL.add(subWord);
             }
             
             //If an exception is thrown
             catch (IllegalWordException iwe){
                System.out.println(iwe.getMessage());
             
             }
             
                
          }
          //reads in next line
          line = in.readLine();       
       }
       
       //Prints the unsorted/sorted word list to the GUI
       WG.printUnsorted(unSWL);
       WG.printSorted(sortWL);
       in.close();
        //while
    }    

}