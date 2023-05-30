package model;

import view.ChessGameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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


        //1：创建一个窗体的对象；

        JFrame jf = new JFrame( );
        ImageIcon bg=new ImageIcon("C:\\Users\\文123\\Downloads\\CS109-2023-Sping-ChessDemo (4)\\src\\view\\background1.jpg");
        JLabel label=new JLabel(bg);
        label.setSize(1100,810);
        jf.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        //2.把窗口面板设为内容面板并设为透明、流动布局。
        JPanel pan=(JPanel)jf.getContentPane();
        pan.setOpaque(false);
        //3.之后把组件和面板添加到窗口面板就可以；

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
        JTextField nameJtf2 = new JTextField( );
        JTextField pwdJtf2 = new JTextField( );
        String nameText2 = nameJtf2.getText( );
        String pwdText2 = pwdJtf2.getText( );

        //组件设置尺寸
        Dimension dimsize = new Dimension(550, 60);
        nameJtf2.setPreferredSize(dimsize);
        pwdJtf2.setPreferredSize(dimsize);

        //4：界面窗体添加按钮
        // jf.add(imgjla);
        jf.add(nameJla);
        jf.add(nameJtf2);
        jf.add(pwdJla);
        jf.add(pwdJtf2);
        jf.add(zc);
        //可视化在所有组件加载之后
        jf.setVisible(true);    //可视化 交给系统渲染到屏幕上
        ButtonAction3 zccg = new ButtonAction3();
        zc.addActionListener(zccg);
        File file=new File("C:\\Users\\文123\\Downloads\\CS109-2023-Sping-ChessDemo (4)\\666.txt");
        try {
            file.createNewFile();
            FileWriter  write = new FileWriter("C:\\Users\\文123\\Downloads\\CS109-2023-Sping-ChessDemo (4)\\666.txt");
            BufferedWriter bw=new BufferedWriter(write);
            bw.write(nameText2);
            bw.write(System.lineSeparator());
            bw.write(pwdText2);
            bw.close();
            write.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }








    }
        }

