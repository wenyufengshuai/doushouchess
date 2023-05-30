import model.ButtonAction;
import model.ButtonAction2;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class Logger {
    public void initUI() {
        //1：创建一个窗体的对象；

        JFrame jf = new JFrame( );
        //2：设置窗体的相关属性：标题，尺寸，关闭选项操作 可视化

        jf.setTitle("登录界面");

        jf.setSize(600, 300);
        ImageIcon bg=new ImageIcon("C:\\Users\\文123\\Downloads\\CS109-2023-Sping-ChessDemo (4)\\src\\view\\background1.jpg");
        JLabel label=new JLabel(bg);
        label.setSize(600,300);
        jf.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        //2.把窗口面板设为内容面板并设为透明、流动布局。
        JPanel pan=(JPanel)jf.getContentPane();
        pan.setOpaque(false);
        //3.之后把组件和面板添加到窗口面板就可以；
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

        FlowLayout flowLayout = new FlowLayout( );
        jf.setLayout(flowLayout);

        //3：创建组件对象，按钮，输入框
        //按钮
        JButton btn = new JButton("登录");
        JButton zc = new JButton("注册");
        btn.setPreferredSize(new Dimension(180,40));
        zc.setPreferredSize(new Dimension(180,40));
        Font dlzc =new Font("华文行楷",Font.BOLD,20);
        btn.setFont(dlzc);
        zc.setFont(dlzc);
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
        nameJtf.setFont(zhmm);
        pwdJtf.setFont(zhmm);
        //4：界面窗体添加按钮
        // jf.add(imgjla);
        jf.add(nameJla);
        jf.add(nameJtf);
        jf.add(pwdJla);
        jf.add(pwdJtf);
        jf.add(btn);
        jf.add(zc);
        //可视化在所有组件加载之后
        jf.setVisible(true);    //可视化 交给系统渲染到屏幕上

        //按钮添加监听器
        ButtonAction btnaction = new ButtonAction( );
        btn.addActionListener(btnaction);
        btnaction.count = 100;
        btnaction.nameJtf = nameJtf;
        btnaction.pwdJtf = pwdJtf;

        ButtonAction2 zcaj = new ButtonAction2();
        zc.addActionListener(zcaj);
        zcaj.count = 100;


    }



    public static class Main extends JFrame {
        public static void main(String[] args) {
            Logger loginui = new Logger( );
            //调用方法
            loginui.initUI( );

        }


    }

    private class BackgroundPanel {
        public BackgroundPanel(Image image) {
        }

        public void setBounds(int i, int i1, int i2, int i3) {
        }
    }
}
