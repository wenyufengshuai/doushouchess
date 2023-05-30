package model;

import view.ChessGameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class ButtonAction3 implements ActionListener {
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
                //创建一个新窗体弹出

        JFrame jf = new JFrame( );
                jf.setTitle("注册成功！！");
                jf.setSize(500, 200);
                jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                java.awt.FlowLayout f1 = new java.awt.FlowLayout( );
                jf.setLayout(f1);
                JButton qd = new JButton("开始游戏");
                Font ksyx =new Font("华文行楷",Font.BOLD,60);
                qd.setFont(ksyx);
                qd.setPreferredSize(new Dimension(400,120));
                qd.setBorderPainted(false);
                jf.add(qd);
                jf.setVisible(true);
                jf.setLocationRelativeTo(null);
                ButtonActionrun zccg = new ButtonActionrun();
                qd.addActionListener(zccg);


            }

}
