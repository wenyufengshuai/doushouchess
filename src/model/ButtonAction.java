package model;

import controller.GameController;
import view.ChessGameFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonAction implements ActionListener {
    public int count = 0;
    //先声明一个输入框的引用地址存储变量；
    public JTextField nameJtf;
    public JTextField pwdJtf;
    public JFrame jf1;
    private ArrayList<ChessGameFrame> list = new ArrayList<>( );
    public static ChessGameFrame chessGameFrame;

    public static ChessGameFrame getChessGameFrame() {
        return chessGameFrame;
    }

    public static void setChessGameFrame(ChessGameFrame chessGameFrame) {
        ButtonAction.chessGameFrame = chessGameFrame;
    }

    //监听器
    public void actionPerformed(ActionEvent e) {

        //获取输入框中的字符串
        String nameText = nameJtf.getText( );
        String pwdText = pwdJtf.getText( );

        if (nameText.equals("1") || nameText.equals("user1")) {
            System.out.println("比较成功！！");
            if (pwdText.equals("1") || pwdText.equals("a123456")) {
                System.out.println("比较成功！！");
                //创建一个新窗体弹出
                JFrame jf = new JFrame( );
                jf.setTitle("登录响应！！");
                jf.setSize(500, 200);
                jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                java.awt.FlowLayout f1 = new java.awt.FlowLayout( );
                jf.setLayout(f1);
                JLabel jla = new JLabel("登录成功！！");
                jf.add(jla);
                jf.setVisible(true);
                jf.setLocationRelativeTo(null);
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
    }


}
