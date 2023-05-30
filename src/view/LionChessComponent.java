package view;

import model.PlayerColor;

import javax.swing.*;
import java.awt.*;

public class LionChessComponent  extends ChessComponent {
    private PlayerColor owner;

    private boolean selected;

    public LionChessComponent(PlayerColor owner, int size) {
        this.owner = owner;
        this.selected = false;
        setSize(size, size);
        setLocation(0,0);
        setVisible(true);
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Font font = new Font("楷体", Font.PLAIN, getWidth() / 2);
        g2.setFont(font);
        g2.setColor(owner.getColor());
        if (owner.getColor().equals(Color.red)){
            g.drawImage(gameUtils.imagehs,0, 0, null);
            repaint();
        }
        else {
            g.drawImage(gameUtils.imageheis,0, 0, null);
            repaint();
        }
        if (isSelected()) { // Highlights the model if selected.
            g.setColor(Color.ORANGE);
            g.drawOval(0, 0, getWidth() , getHeight());
        }
    }
}
