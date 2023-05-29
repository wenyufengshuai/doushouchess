package model;

import view.ChessGameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonAction2 implements ActionListener {
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

        //1：创建一个窗体的对象；

        JFrame jf = new JFrame( );

        //2：设置窗体的相关属性：标题，尺寸，关闭选项操作 可视化

        jf.setTitle("新用户注册");
        jf.setSize(600, 300);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

        FlowLayout flowLayout = new FlowLayout( );
        jf.setLayout(flowLayout);

        //3：创建组件对象，按钮，输入框
        //按钮

        JButton zc = new JButton("注册");
        zc.setPreferredSize(new Dimension(180,40));
        Font dlzc =new Font("华文行楷",Font.BOLD,20);
        zc.setFont(dlzc);

        //标签
        //标签
        Font zhmm =new Font("华文行楷",Font.BOLD,15);
        JLabel nameJla = new JLabel("账号: ");
        JLabel pwdJla = new JLabel("密码: ");
        nameJla.setFont(zhmm);
        pwdJla.setFont(zhmm);

        //输入框
        JTextField nameJtf = new JTextField( );
        JTextField pwdJtf = new JTextField( );

        //组件设置尺寸
        Dimension dimsize = new Dimension(550, 60);
        nameJtf.setPreferredSize(dimsize);
        pwdJtf.setPreferredSize(dimsize);

        //4：界面窗体添加按钮
        // jf.add(imgjla);
        jf.add(nameJla);
        jf.add(nameJtf);
        jf.add(pwdJla);
        jf.add(pwdJtf);
        jf.add(zc);
        //可视化在所有组件加载之后
        jf.setVisible(true);    //可视化 交给系统渲染到屏幕上
        ButtonAction3 zccg = new ButtonAction3();
        zc.addActionListener(zccg);


            }
        }

