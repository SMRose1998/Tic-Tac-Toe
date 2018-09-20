package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
        System.out.println("  012");
		System.out.println();
		for(int i = 0; i<model.getWidth(); i++){
			System.out.print(i);
			System.out.print(" ");
			for(int j = 0; j<model.getWidth(); j++){
				System.out.print(model.getMark(i,j));
			}
			System.out.println();
		}

    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */
		
		if(model.isXTurn()){
			System.out.println("Player 1 (X) Move:");
		}else{
			System.out.println("Player 2 (O) Move:");
		}
		System.out.print("Enter the row and column numbers, separated by a space: ");


    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        System.out.println("Error - Incorrect input");

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}