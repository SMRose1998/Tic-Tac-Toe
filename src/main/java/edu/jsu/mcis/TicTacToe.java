package edu.jsu.mcis;

public class TicTacToe {

    private static final int DEFAULT_WIDTH = 3;

    public static void main(String[] args) {
        
        /* Set initial size of game board (default is 3x3) */

        int width = DEFAULT_WIDTH;
        
        /* If a different size is provided as a command-line argument, use it instead */

        if (args.length >= 1) {
            
            try {
                width = Integer.parseInt(args[0]);
            }
            catch(NumberFormatException e) {}
            
        }
        
        /* Create MVC Objects */

        TicTacToeModel model = new TicTacToeModel(width);
        TicTacToeView view = new TicTacToeView(model);
        TicTacToeController controller = new TicTacToeController(model, view);
        
        /* MAIN LOOP */

        while (!model.isGameover()) {
            
            view.viewModel();
			controller.controlModel()
            /*if(!controller.controlModel()){
				break;
			}*/
            
        }
        
        /* Game is over; show the final board and the winner */

        view.viewModel();

        view.showResult(model.getResult().toString());

    }

}