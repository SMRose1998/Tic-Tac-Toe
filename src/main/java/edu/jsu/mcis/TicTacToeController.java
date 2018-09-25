package edu.jsu.mcis;


import java.util.Scanner;

public class TicTacToeController {

    private TicTacToeModel model;
    private TicTacToeView view;
    private Scanner keyboard;
    
    /* CONSTRUCTOR */

    public TicTacToeController(TicTacToeModel model, TicTacToeView view) {
        
        /* Initialize model and view */

        this.model = model;
        this.view = view;
        
        /* Initialize scanner (for console keyboard) */
        
        keyboard = new Scanner(System.in);

    }

    public void controlModel() {
		
    }
}