public class TicTacToe {

    public static boolean isSquare (Character[][] board)
    {
        int rowSize = board.length;
        for (int i = 0; i < rowSize; i++)
        {
            if (board[i].length != rowSize)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean checkRows (Character[][] board)
    {
        for (int i = 0; i < board.length; i++)
        {
            boolean rowWinner = true;
            for (int j = 1; j < board.length; j++)
            {
                if (board[i][0] != board[i][j])
                {
                    rowWinner = false;
                    break;
                }
            }
            if (rowWinner)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean checkColumns (Character[][] board)
    {
        for (int i = 0; i < board.length; i++)
        {
            boolean colWinner = true;
            for (int j = 1; j < board.length; j++)
            {
                if (board[0][i] != board[j][i])
                {
                    colWinner = false;
                    break;
                }
            }
            if (colWinner)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean checkDiagonals (Character[][] board)
    {
        boolean diagWinner = true;
        // top left to bottom right
        for (int i = 1; i < board.length; i++)
        {
            if (board[0][0] != board[i][i])
            {
                diagWinner = false;
                break;
            }
        }
        if (diagWinner)
        {
            return true;
        }
        diagWinner = true;
        // top right to bottom left
        for (int i = 1; i < board.length; i++)
        {
            if (board[0][board.length - 1] != board[i][board.length - (i + 1)])
            {
                diagWinner = false;
                break;
            }
        }
        return diagWinner;
    }


    public static boolean isWinner(Character[][] board)
    {
        // Check rows
        if (checkRows(board))
        {
            return true;
        }
        // Check columns
        if (checkColumns(board))
        {
            return true;
        }
        // Check diagonals
        // If false then no winner.
        return checkDiagonals(board);
    }

    public static void main(String[] args) {
        // A winner board
        // [X, X, 'O']
        // [' ', O, X]
        // [O, X, O]
        Character[][] winnerBoard = new Character[][]{{'X', 'X', 'O'}, {' ', 'O', 'X'}, {'O', 'X', 'O'}};
        
        // A no winner board
        // [X, X, O]
        // [O, O, X]
        // [X, X, O]
        Character[][] noWinnerBoard = new Character[][]{{'X', 'X', 'O'}, {'O', 'O', 'X'}, {'X', 'X', 'O'}};

        // Check if board is square
        // Check if there is a winner and display results
        if (isSquare(noWinnerBoard)) {
            if (isWinner(noWinnerBoard)) {
                System.out.println("A winner board!");
            } else {
                System.out.println("A no winner board!");
            }
        }
        else {
            System.out.println("Not a proper Tic-Tac-Toe board!");
        }
    }
}
