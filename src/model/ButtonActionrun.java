package model;

import controller.GameController;
import view.ChessGameFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionrun implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(new Runnable( ) {
            @Override
            public void run() {
                ChessGameFrame mainFrame = new ChessGameFrame(1100, 810);
                GameController gameController = new GameController(mainFrame.getChessboardComponent(), new Chessboard());
                mainFrame.setThectrl(gameController);
                mainFrame.setVisible(true);
            }
        });
    }
}
