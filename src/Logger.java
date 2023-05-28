import model.ButtonAction;

import javax.swing.*;
import java.awt.*;

public class Logger {
    public void initUI() {
        //1：创建一个窗体的对象；

        JFrame jf = new JFrame( );

        //2：设置窗体的相关属性：标题，尺寸，关闭选项操作 可视化

        jf.setTitle("登录界面");
        jf.setSize(500, 800);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

        FlowLayout flowLayout = new FlowLayout( );
        jf.setLayout(flowLayout);

        //3：创建组件对象，按钮，输入框
        //按钮
        JButton btn = new JButton("登录");

        //标签
        JLabel nameJla = new JLabel("账号: ");
        JLabel pwdJla = new JLabel("密码: ");

        //输入框
        JTextField nameJtf = new JTextField( );
        JTextField pwdJtf = new JTextField( );

        //组件设置尺寸
        Dimension dimsize = new Dimension(420, 50);
        nameJtf.setPreferredSize(dimsize);
        pwdJtf.setPreferredSize(dimsize);

        //4：界面窗体添加按钮
        // jf.add(imgjla);
        jf.add(nameJla);
        jf.add(nameJtf);
        jf.add(pwdJla);
        jf.add(pwdJtf);
        jf.add(btn);

        //可视化在所有组件加载之后
        jf.setVisible(true);    //可视化 交给系统渲染到屏幕上

        //按钮添加监听器
        ButtonAction btnaction = new ButtonAction( );
        btn.addActionListener(btnaction);
        btnaction.count = 100;
        btnaction.nameJtf = nameJtf;
        btnaction.pwdJtf = pwdJtf;

    }

    public static class Main extends JFrame {
        public static void main(String[] args) {
            Logger loginui = new Logger( );
            //调用方法
            loginui.initUI( );

        }


    }
}
