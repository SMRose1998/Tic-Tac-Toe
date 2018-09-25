package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import edu.jsu.mcis.TicTacToeModel.Mark;
import edu.jsu.mcis.TicTacToeModel.Result;

public class TicTacToeView extends JPanel implements ActionListener {
	
    TicTacToeModel model;

    private JButton[][] squares;
    private JPanel squaresPanel;
    private JLabel resultLabel;
	private int row;
	private int col;


    public TicTacToeView(TicTacToeModel model) {

        this.model = model;

        int width = model.getWidth();

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        squares = new JButton[width][width];
        squaresPanel = new JPanel(new GridLayout(width,width));
        resultLabel = new JLabel();
        resultLabel.setName("ResultLabel");
        
        for (int row = 0; row < width; row++){
            
            for (int col = 0; col < width; col++){
                
                squares[row][col] = new JButton(); 
                squares[row][col].addActionListener(this);
                squares[row][col].setName("Square" + row + col);
                squares[row][col].setPreferredSize(new Dimension(64,64));
                squaresPanel.add(squares[row][col]);
                
            }
            
        }

        this.add(squaresPanel);
        this.add(resultLabel);
        
        resultLabel.setText("Welcome to Tic-Tac-Toe!");

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        
        /* Handle button clicks.  Extract the row and col values from the name
           of the button that was clicked, then make the mark in the grid using
           the Model's "makeMark()" method.  Finally, use the "updateSquares()"
           method to refresh the View.  If the game is over, show the result
           (from the Model's "getResult()" method) in the result label. */
        
        String name = ((JButton) event.getSource()).getName(); // Get button name
        
		
		//Get/ Set the row number
        row = Integer.parseInt(name.substring(6,7));
		this.row = row;
		//Get/ Set the col number
		col = Integer.parseInt(name.substring(7,8));
		this.col = col;
		
		
		//Check if the model has NOT triggered GameOver
		if(!model.isGameover()){
			
			//On button click, if game is continuing, edit the model data to include
			//A mark on the button the player pressed
			model.makeMark(row,col);
			
			//Change the GUI to reflect the model
			updateSquares();
			
			//Display results
			Result result = model.getResult();
			resultLabel.setText(result.toString());
		}

    }
        
    public void updateSquares() {

        /* Loop through all View buttons and (re)set the text of each button
           to reflect the grid contents (use the Model's "getMark()" method). */
		Mark buttonText = model.getMark(this.row, this.col);
		squares[this.row][this.col].setText(buttonText.toString());

    }
        
    public void showResult(String message) {
        resultLabel.setText(message);
    }

}