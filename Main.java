import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;
  
  JButton submitButton;
  JButton numberButton;

  JLabel instructLabel;
  JLabel yourGuessLabel;

  JTextField inputField;

  int theNumber = getRand();
  int highGuess;
  int lowGuess;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 400 pixels by 300 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,300);
    frame.setVisible(true);
 
    // make the main panel
    mainPanel = new JPanel();
    mainPanel.setLayout(null);
    frame.add(mainPanel);

    // make the buttons and add them to the frame
    submitButton = new JButton("Submit");
    numberButton = new JButton("New Number");

    submitButton.setBounds(50, 170, 145, 30);
    numberButton.setBounds(205, 170, 145, 30);

    submitButton.setActionCommand("submit");
    numberButton.setActionCommand("new");

    submitButton.addActionListener(this);
    numberButton.addActionListener(this);
    
    mainPanel.add(submitButton);
    mainPanel.add(numberButton);

    // make the labels and add them to the frame
    instructLabel = new JLabel("Guess the number between 0 and 100:");
    yourGuessLabel = new JLabel();

    instructLabel.setBounds(50, 30, 300, 30);
    yourGuessLabel.setBounds(50, 220, 250, 30);

    mainPanel.add(instructLabel);
    mainPanel.add(yourGuessLabel);

    // make the text field and add them to the frame
    inputField = new JTextField();
    inputField.setBounds(50, 100, 250, 30);
    mainPanel.add(inputField);

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
    
    // check what button was pressed
    if (command.equals("new")) {
      // get the random int
      theNumber = getRand();
      
      // tell the user the range to guess from
      instructLabel.setText("Guess the number between " + lowGuess + " and " + highGuess + ":");

    } else if (command.equals("submit")) {
      // get the input
      String userInput = inputField.getText();
      int guess = Integer.parseInt(userInput);

      // find out if there guess is high or low
      if (guess == theNumber) {
        yourGuessLabel.setText("Your guess of " + guess + " was correct!");
      } else if (guess > theNumber) {
        yourGuessLabel.setText("Your guess of " + guess + " was too high!");
        highGuess = guess;
      } else {
        yourGuessLabel.setText("Your guess of " + guess + " was too low!");
        lowGuess = guess;
      }
      // tell the user the range to guess from
      instructLabel.setText("Guess the number between " + lowGuess + " and " + highGuess + ":");
    }
  }
  // get the random int method
  public int getRand() {
    Random rand = new Random();
    // create the int
    int randInt = rand.nextInt(100) + 1;
    
    // set the low guess and high guess variables
    lowGuess = 0;
    highGuess = 100;
    
    // output the random int
    return randInt;
  }
  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
