import java.util.Arrays;

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
        if (board[0][0] == board[1][0] && board[0][0] == board[2][0])
        {
            return true;
        }
        else if (board[0][1] == board[1][1] && board[0][1] == board[2][1])
        {
            return true;
        }
        else if (board[0][2] == board[1][2] && board[0][2] == board[2][2])
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean checkDiagonals (Character[][] board)
    {
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2])
        {
            return true;
        }
        else if (board[0][2] == board[1][1] && board[0][2] == board[2][0])
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public static boolean isWinner(Character[][] board)
    {
        // Check rows
        if (checkRows(board))
        {
            return true;
        }
        /*
        // Check columns
        if (checkColumns(board))
        {
            return true;
        }
        // Check diagonals
        // If false then no winner.
        return checkDiagonals(board);

         */
        return false;
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
        if (isSquare(winnerBoard)) {
            if (isWinner(winnerBoard)) {
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
