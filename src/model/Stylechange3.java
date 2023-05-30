package model;

import controller.GameController;
import view.ChessGameFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stylechange3 implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(new Runnable( ) {
            @Override
            public void run() {
                ChessGameFrame mainFrame = new ChessGameFrame(1100, 810);
                GameController gameController = new GameController(mainFrame.getChessboardComponent(), new Chessboard());
                ImageIcon bg=new ImageIcon("C:\\Users\\文123\\Downloads\\CS109-2023-Sping-ChessDemo (4)\\src\\view\\background3.jpg");
                JLabel label=new JLabel(bg);
                label.setSize(1100,810);
                mainFrame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
                //2.把窗口面板设为内容面板并设为透明、流动布局。
                JPanel pan=(JPanel)mainFrame.getContentPane();
                pan.setOpaque(false);
                //3.之后把组件和面板添加到窗口面板就可以；
                mainFrame.setLocationRelativeTo(null);
                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainFrame.setThectrl(gameController);
                mainFrame.setVisible(true);
            }
        });

    }
}
