import javax.swing.*;
import java.awt.*;

public class TicTacToeFrame extends JFrame {
    JPanel mainPnl,boardPnl,statPnl,playerPnl;
    JLabel playerTurn,playerXLbl,playerOLbl,tieLbl;
    JButton quit;
    JTextField playerXTF, playerOTF, tieTF;
    int playerXWinCount, playerOWinCount, tieCount = 0;
    public TicTacToeFrame()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();

        int height = screenSize.height;
        int width = screenSize.width;
        setSize(800,600);
        setLocation((width/4),height/10);

        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createGUI();
        setVisible(true);
    }
    private void createGUI()
    {
        mainPnl = new JPanel();


        createPlayerPnl();
        createBoardPnl();
        createStatPnl();
        mainPnl.setLayout(new BorderLayout());
        mainPnl.add(playerPnl, BorderLayout.NORTH);
        mainPnl.add(boardPnl, BorderLayout.CENTER);
        mainPnl.add(statPnl, BorderLayout.SOUTH);

        add(mainPnl);

    }

    private void createPlayerPnl()
    {
        playerPnl = new JPanel();
        playerTurn = new JLabel("Player X Turn");
        playerTurn.setFont(new Font("Serif", Font.PLAIN, 20));
        playerPnl.add(playerTurn);
    }

    public void createBoardPnl()
    {
        boardPnl = new JPanel();
        boardPnl.setLayout(new GridLayout(3,3));
        TicTacToeBoard.createBoard(boardPnl);
        TicTacToeBoard.onClick(playerTurn);
    }

    private void createStatPnl()
    {
        statPnl = new JPanel();
        statPnl.setLayout(new GridLayout(3,2));
        statPnl.setLayout(new FlowLayout(FlowLayout.CENTER));

        playerXLbl = new JLabel("Player X won: ");
        playerXTF = new JTextField();
        playerXTF.setText(String.valueOf(playerXWinCount));
        playerXTF.setEditable(false);

        playerOLbl = new JLabel("Player O won: ");
        playerOTF = new JTextField();
        playerOTF.setText(String.valueOf(playerOWinCount));
        playerOTF.setEditable(false);


        tieLbl = new JLabel("Tie: ");
        tieTF = new JTextField();
        tieTF.setText(String.valueOf(tieCount));
        tieTF.setEditable(false);

        //Since using GridLayout, we must add labels and text fields in order.

        quit = new JButton();
        quit.setText("Exit");
        quit.setFont(new Font("Serif", Font.PLAIN, 14));
        quit.addActionListener(e ->
        {
            System.exit(0);
        });
        statPnl.add(playerXLbl);
        statPnl.add(playerXTF);

        statPnl.add(playerOLbl);
        statPnl.add(playerOTF);

        statPnl.add(tieLbl);
        statPnl.add(tieTF);
        statPnl.add(quit);
    }
}