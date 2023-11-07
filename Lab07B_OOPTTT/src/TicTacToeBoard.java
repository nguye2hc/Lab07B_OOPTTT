import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeBoard {

    private static TicTacToeButton[][] board = new TicTacToeButton[3][3];
    private static int numMove = 0;
    private static String player = "X";

    public static void createBoard(JPanel game) {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++) {
                board[row][col] = new TicTacToeButton(row, col);
                board[row][col].setText(" ");
                board[row][col].setFont(new Font(Font.SERIF, Font.PLAIN, 30));
                numMove++;
                game.add(board[row][col]);
            }
    }

    public static boolean restartGame() {
        int dialogButton = JOptionPane.showConfirmDialog(null, "Do you play the game again?", "End Game?", JOptionPane.YES_NO_OPTION);
        if (dialogButton == JOptionPane.YES_OPTION) {
            TicTacToeGame.clearBoard();
            for (int row = 0; row < 3; row++)
                for (int col = 0; col < 3; col++)
                {
                    board[row][col].setText(" ");
                }
        }
        else {
            System.exit(0);
        }
        return false;
    }

    public static void onClick(JLabel game) {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++) {
                board[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        TicTacToeButton player = (TicTacToeButton) e.getSource();

                        if (!player.getText().isBlank()) {
                            JOptionPane.showMessageDialog(null, "This is not a valid move");
                        }
                        else
                        {
                            player.setText(String.valueOf(TicTacToeBoard.player));
                            TicTacToeGame.updateGame(String.valueOf(TicTacToeBoard.player), player.getRow(), player.getCol());

                            numMove++;
                            updatePlayer(game);

                            if(numMove >= 5){
                                winGame(game);
                            }
                            if(numMove >= 7) {
                                tieGame();
                            }
                        }
                    }
                });
            }
    }

    private static void tieGame() {
        if (TicTacToeGame.checkTie())
        {
            JOptionPane.showMessageDialog(null, "It's a tie!");
            restartGame();
        }
    }

    private static void winGame(JLabel game) {
        if (TicTacToeGame.checkWin(player))
        {
            JOptionPane.showMessageDialog(null, "Player " + player + " " + "wins!");
            restartGame();

            player = "X";
            game.setText("Current Player: X");
        }
    }

    public static void updatePlayer(JLabel game)
    {
        if (player == "X")
        {
            player = "O";
        }
        else
        {
            player = "X";
        }
        game.setText("Current Player: " + player);
    }

}