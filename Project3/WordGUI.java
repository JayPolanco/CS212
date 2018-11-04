import javax.swing.*;
import java.awt.*;
/**
 * WordGUI class which creates a GUI with a menuBar that contains a file option.
 * Also creates an open and quit options inside of the file option.
 * Prints the unsorted and sorted word list.
 * Unsorted word List on the first column of GUI and the sorted word list on the second
 * column of the GUI
 * 
 * @author Jason Polanco
 *
 */

public class WordGUI extends JFrame {
   static Container myContentPane;
   static TextArea unsorted, sorted;
   UnsortedWordList unsort = new UnsortedWordList();
   SortedWordList sort = new SortedWordList();

   /**
    * Creates the GUI, the TextAreas and the content pane
    * @param title represents the title of the GUI
    * @param height represents the height of the GUI
    * @param width represents the width of the GUI
    */
   public WordGUI(String title, int height, int width){
      
      
      
      setTitle(title);
      setLayout(new GridLayout(1,2));
      setSize(height,width);
      setLocation(200, 200);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      myContentPane = getContentPane();
      
      //Creates a text area for unsorted/sorted list
      unsorted = new TextArea();
      sorted = new TextArea();
      unsorted.setEditable(false);
      sorted.setEditable(false);
      
      //Adds the unsorted/sorted text areas to GUI
      myContentPane.add(unsorted);
      myContentPane.add(sorted);
      
      createFileMenu();
      
      setVisible(true);
      
      
      
   }
   
   /**
    * Creates the menuBar and file menu for the GUI and also creates items for the file menu
    * such as an open and quit menu item. Also creates a FileMenuHandler and 
    * adds actionListeners to the menuItems
    */
   public void createFileMenu(){
      JMenuBar menuBar = new JMenuBar();
      JMenu fileMenu = new JMenu("File");
      JMenuItem   item; 
      
      //creates a FileMenuHandler
      FileMenuHandler fmh  = new FileMenuHandler(this, unsort, sort);
    
      //creates a new item called open
      item = new JMenuItem("Open");    //Open...
      item.addActionListener( fmh );
     
      
      //adds the open item to the fileMenu
      fileMenu.add( item );
      item.setFont(new Font("Times New Roman",Font.PLAIN,30));
      fileMenu.addSeparator();           //add a horizontal separator line
      
      //creates quit item
      item = new JMenuItem("Quit");       //Quit
      item.addActionListener( fmh );
     
      fileMenu.add( item );
      item.setFont(new Font("Times New Roman",Font.PLAIN,30));

      //adds the fileMenu to the menuBar
      fileMenu.setFont(new Font("Times New Roman",Font.PLAIN,30));
      menuBar.add(fileMenu);
      
      setJMenuBar(menuBar);
   }
   
   /**
    * Prints unsorted list to 1st column of GUI
    * In the order read from file
    * 
    * @param unsortedList represents the unsorted word list
    */
   public void printUnsorted(UnsortedWordList unsortedList){
        
    //appends the unsorted list to the unsorted text area of the GUI  
	   unsorted.append(unsortedList.toString());
	   unsorted.setFont(new Font("Times New Roman",Font.PLAIN,25));
               
    }
   
    /**
     * Prints sorted list to the 2nd column of GUI
     * @param sortedList represents the sorted word list
     */
    public void printSorted(SortedWordList sortedList) {
       
       //appends the sorted list to the sorted text area of the GUI
          sorted.append(sortedList.toString());
          sorted.setFont(new Font("Times New Roman",Font.PLAIN,25));
       }
}   
 