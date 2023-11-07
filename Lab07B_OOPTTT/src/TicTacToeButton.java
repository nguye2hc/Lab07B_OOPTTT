import javax.swing.*;
import java.awt.*;

public class TicTacToeButton extends JButton {
    private int row;
    private int col;
    public TicTacToeButton(int row, int col) {
        super();
        this.row = row;
        this.col = col;
        setPreferredSize(new Dimension(50, 50));
        setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        setVerticalAlignment(SwingConstants.CENTER); // Center text vertically
        setFont(new Font(Font.SERIF, Font.PLAIN, 15)); // Set the font size as needed
    }
    public int getRow()
    {
        return row;
    }
    public int getCol()
    {
        return col;
    }
}