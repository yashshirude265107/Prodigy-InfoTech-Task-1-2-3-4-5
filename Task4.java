class Task4 {

    private static final int GRID_SIZE = 9;

    public static void main(String[] args) {
        
        int[][] board = new int[][] {
            {7, 0, 2, 0, 5, 0, 6, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 0, 0}, 
            {1, 0, 0, 0, 0, 9, 5, 0, 0},
            {8, 0, 0, 0, 0, 0, 0, 9, 0},
            {0, 4, 3, 0, 0, 0, 7, 5, 0},
            {0, 9, 0, 0, 0, 0, 0, 0, 8},
            {0, 0, 9, 7, 0, 0, 0, 0, 5},
            {0, 0, 0, 2, 0, 0, 0, 0, 0},
            {0, 0, 7, 0, 4, 0, 2, 0, 3}
        };
        
        if (solveBoard(board)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists");
        }

    }

    private static void printBoard(int[][] board) {
        for(int row = 0; row < GRID_SIZE; row++) {
            for(int col = 0; col < GRID_SIZE; col++) {
                System.out.print(board[row][col]);
                System.out.print(" ");
            }
            System.out.println(); 
        }
    }

    private static boolean solveBoard(int[][] board) {
        for(int row = 0; row < GRID_SIZE; row++) {
            for(int col = 0; col < GRID_SIZE; col++) {
                if(board[row][col] == 0) {
                    for(int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                        if(isValidPlacement(board, row, col, numberToTry)) {
                            board[row][col] = numberToTry;

                            if(solveBoard(board)) {
                                return true;
                            } else {
                                board[row][col] = 0;
                            }
                        }
                    }
                    
                    return false; 
                }
            }
        }
        return true; 
    }

    private static boolean isValidPlacement(int[][] board, int row, int col, int number) {
        return !isNumberInRow(board, row, number)  && 
               !isNumberInCol(board, col, number) &&
               !isNumberInBox(board, row - row % 3, col - col % 3, number);
    }

    private static boolean isNumberInRow(int[][] board, int row, int number) {
        for(int i = 0; i < GRID_SIZE; i++) {
            if(board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInCol(int[][] board, int col, int number) {
        for(int i = 0; i < GRID_SIZE; i++) {
            if(board[i][col] == number) { 
                return true;
            }
        }
        return false;
    }
    
    private static boolean isNumberInBox(int[][] board, int row, int col, int number) {
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                if(board[row+r][col+c] == number) {
                    return true;
                }
            }
        }
        return false;
    }
}