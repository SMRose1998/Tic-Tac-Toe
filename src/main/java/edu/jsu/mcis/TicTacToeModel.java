package edu.jsu.mcis;

public class TicTacToeModel {
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */

        grid = new Mark[width][width];

        /* Initialize grid by filling every square with empty marks */

        for(int i = 0; i<width; i++){
			for(int j = 0; j<width; j++){
				grid[i][j] = Mark.EMPTY;
			}
		}
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */
        
        Mark attemptedPlacement = getMark(row,col);
		
		if(attemptedPlacement==Mark.EMPTY){
			grid[row][col] = (xTurn) ? Mark.X : Mark.O;
			xTurn = (xTurn) ? false : true;
			return true;
		}
		
		return false;

    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
		if(row>=0 && col>=0){
			return row<width && col <width;
		}
		return false;
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
        
        Mark square = getMark(row,col);
		
		if(square==Mark.EMPTY){
			return false;
		}
		return true;
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
		if(isValidSquare(row, col))
			return grid[row][col];
		else
			return null;
            
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
		   
		
        
        if(isMarkWin(Mark.X)){
			return Result.X;
		}
		else if (isMarkWin(Mark.O)){
			return Result.O;
		}
		else if (isGameOngoing()){
			return Result.NONE;
		}
		else if (isTie()){
			return Result.TIE;
		}

        return null; /*Error catcher*/

    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
		   
		//Check Horizontal Win
		for(int i = 0; i<width; i++){
			for(int j = 0; j<width; j++){
				if(grid[i][j] != mark){
					break;
				}
				if (j == width-1){
					return true;
				}
			}
		}
		
		//Check Vertical Win
		for(int j = 0; j<width; j++){
			for(int i = 0; i<width; i++){
				if(grid[i][j] != mark){
					break;
				}
				if (i == width-1){
					return true;
				}
			}
		}
		
		//check downward diagonal
		for(int i = 0; i<width; i++){
			if(grid[i][i] != mark){
				break;
			}
			if (i == width-1){
				return true;
			}
		}
		
		//check Upward diagonal
		for(int i = 0; i<width; i++){
			if(grid[width-1-i][i] != mark){
				break;
			}
			if (i == width-1){
				return true;
			}
		}
		
		return false;
    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */
		if(!isMarkWin(Mark.X) || !isMarkWin(Mark.O)||!isGameOngoing()){
			
			return true;
		}

        return false; 
        
    }
	
	private boolean isGameOngoing() {
		/*Check the board to see if the game is still going on*/
		for(int i = 0; i<width; i++){
			for(int j = 0; j<width; j++){
				if(grid[i][j] == Mark.EMPTY){
					return true;
				}
			}
		}
		return false;
	}

    public boolean isGameover() {
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
}