package view;

import controller.GameController;
import model.*;
import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.SourceDataLine;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;
import java.io.File;

import static controller.GameController.arr;

/**
 * 这个类表示游戏过程中的整个游戏界面，是一切的载体
 */
public class ChessGameFrame extends JFrame {
    //    public final Dimension FRAME_SIZE ;
    private final int WIDTH;
    private final int HEIGTH;

    private final int ONE_CHESS_SIZE;

    private ChessboardComponent chessboardComponent;
    private GameController thectrl;
    public ChessGameFrame(int width, int height) {
        setTitle("斗 兽 棋"); //设置标题
        this.WIDTH = width;
        this.HEIGTH = height;
        this.ONE_CHESS_SIZE = (HEIGTH * 4 / 5) / 9;

        setSize(WIDTH, HEIGTH);
        setLocationRelativeTo(null); // Center the window.放在windows中央
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        setLayout(null);


        addChessboard();
        addResetButton();
        addSaveButton();
       addLoadButton();
       addrenjiButton();
       addRegretButton();
       addStyleButton();
    }

    public ChessboardComponent getChessboardComponent() {
        return chessboardComponent;
    }
    public void setThectrl(GameController ctrl){
        this.thectrl=ctrl;
    }
    public void setChessboardComponent(ChessboardComponent chessboardComponent) {
        this.chessboardComponent = chessboardComponent;
    }

    /**
     * 在游戏面板中添加棋盘
     */
    private void addChessboard() {
        chessboardComponent = new ChessboardComponent(ONE_CHESS_SIZE);
        chessboardComponent.setLocation(HEIGTH / 5, HEIGTH / 10);
        add(chessboardComponent);
    }

    /**
     * 在游戏面板中添加标签
     */


    /**
     * 在游戏面板中增加一个按钮，如果按下的话就会显示Hello, world!
     */



    private void addResetButton(){
        //这里
        JButton button = new JButton("重新开始");
        button.addActionListener(e -> {
            //GameController.init();
            thectrl.setModel(new Chessboard());
            thectrl.setCurrentPlayer(PlayerColor.BLUE);
            Chessboard mod=new Chessboard();
            chessboardComponent.initiateChessComponent(mod);
            chessboardComponent.repaint();
        });
        button.setLocation(HEIGTH, HEIGTH / 10 );
        button.setSize(200, 60);
        button.setFont(new Font("宋体", Font.BOLD, 20));
        add(button);
    }
    private  void addSaveButton(){
        JButton button = new JButton("存档游戏");
        button.setLocation(HEIGTH,HEIGTH / 10 +120);
        button.setSize(200, 60);
        button.setFont(new Font("宋体", Font.BOLD, 20));
        add(button);
//self：点击button触发的事件，即监听事件
        button.addActionListener(e -> {
            System.out.println("Click save");
            GameController.writeFileByFileWriter("chessboard.txt" );
            JOptionPane.showMessageDialog(null , "保存成功");
        });}
    private  void addrenjiButton(){
        JButton button = new JButton("人机对战");
        button.setLocation(HEIGTH,HEIGTH / 10 +360);
        button.setSize(200, 60);
        button.setFont(new Font("宋体", Font.BOLD, 20));
        add(button);
//self：点击button触发的事件，即监听事件
        button.addActionListener(e -> {

          //弹出来难度选择按钮
        });}
//    private void addLoadButton(){
//
//            JButton button = new JButton("Load");
//            button.setLocation(175 + WIDTH * 3 / 5, HEIGHT / 10 + 280);
//            button.setSize(180, 60);
//            button.setFont(new Font("Rockwell", Font.BOLD, 20));
//            button.setBackground(Color.LIGHT_GRAY);
//            add(button);
//
////self：点击button触发的事件，即监听事件
//            button.addActionListener(e -> {
//                        System.out.println("Click load");
//                        String way = JOptionPane.showInputDialog(null, "Input Path here");
//                       Chessboard.readFileByFileReader("chessboard.txt");
//                        repaint();
//                        Chessboard chessboard1 = new Chessboard(CHESSBOARD_SIZE / 2, CHESSBOARD_SIZE);
//                        chessboard1.putChess();
//
//                    });
//    }
    private void addLoadButton() {
        JButton button = new JButton("读取存档");
        button.setLocation(HEIGTH, HEIGTH / 10 + 240);
        button.setSize(200, 60);
        button.setFont(new Font("宋体", Font.BOLD, 20));
        add(button);

        button.addActionListener(e -> {
            System.out.println("Click load");
            String path = JOptionPane.showInputDialog(this,"Input Path here");
            thectrl.setModel(new Chessboard());
            thectrl.setCurrentPlayer(PlayerColor.BLUE);
            Chessboard mod=new Chessboard();
           String[] s = GameController.convertToChessboard(GameController.readFileByFileReader(path)) ;


            for (int i = 0 ; i < 9 ;i++) {
                for (int j = 0; j < 7; j++) {
                    if (arr[i][j] == 1) {
                        mod.grid[i][j].setPiece(new ChessPiece(PlayerColor.RED, "鼠", 1));
                    } else if (arr[i][j] ==  11) {
                        mod.grid[i][j].setPiece(new ChessPiece(PlayerColor.BLUE, "鼠", 11));
                    } else if (arr[i][j] ==  2) {
                        mod.grid[i][j].setPiece(new ChessPiece(PlayerColor.RED, "猫", 2));
                    } else if (arr[i][j] == 12) {
                        mod.grid[i][j].setPiece(new ChessPiece(PlayerColor.BLUE, "猫", 12));
                    } else if (arr[i][j] == 3) {
                        mod.grid[i][j].setPiece(new ChessPiece(PlayerColor.RED, "狗", 3));
                    } else if (arr[i][j] == 13) {
                        mod.grid[i][j].setPiece(new ChessPiece(PlayerColor.BLUE, "狗", 13));
                    } else if (arr[i][j] == 4) {
                        mod.grid[i][j].setPiece(new ChessPiece(PlayerColor.RED, "狼", 4));
                    } else if (arr[i][j] == 14) {
                        mod.grid[i][j].setPiece(new ChessPiece(PlayerColor.BLUE, "狼", 14));
                    } else if (arr[i][j] == 5) {
                        mod.grid[i][j].setPiece(new ChessPiece(PlayerColor.RED, "豹", 5));
                    } else if (arr[i][j] == 15) {
                        mod.grid[i][j].setPiece(new ChessPiece(PlayerColor.BLUE, "豹", 15));
                    } else if (arr[i][j] == 6) {
                        mod.grid[i][j].setPiece(new ChessPiece(PlayerColor.RED, "虎", 6));
                    } else if (arr[i][j] == 16) {
                        mod.grid[i][j].setPiece(new ChessPiece(PlayerColor.BLUE, "虎", 16));
                    } else if (arr[i][j] == 7) {
                        mod.grid[i][j].setPiece(new ChessPiece(PlayerColor.RED, "狮", 7));
                    } else if (arr[i][j] ==  17) {
                        mod.grid[i][j].setPiece(new ChessPiece(PlayerColor.BLUE, "狮", 17));
                    } else if (arr[i][j] == 8) {
                        mod.grid[i][j].setPiece(new ChessPiece(PlayerColor.RED, "象", 8));
                    } else if (arr[i][j] == 18) {
                        mod.grid[i][j].setPiece(new ChessPiece(PlayerColor.BLUE, "象", 18));
                    }
                }
            }
            chessboardComponent.initiateGridComponents();
            chessboardComponent.initiateChessComponent(mod);
            chessboardComponent.repaint();
        });
    }
    private void addRegretButton() {
        JButton button = new JButton("悔棋");
        button.setLocation(HEIGTH, HEIGTH / 10 + 480);
        button.setSize(200, 60);
        button.setFont(new Font("宋体", Font.BOLD, 20));
        add(button);

        button.addActionListener(e -> {
            System.out.println("Click load");
            String path = JOptionPane.showInputDialog(this,"Input Path here");
//            gameController.loadGameFromFile(path);
        });
    }
    private void addStyleButton() {
        JButton button = new JButton("风格切换");
        button.setLocation(HEIGTH, HEIGTH / 10 + 600);
        button.setSize(200, 60);
        button.setFont(new Font("宋体", Font.BOLD, 20));
        add(button);

        button.addActionListener(e -> {
            System.out.println("Click Style change");
            JFrame jf = new JFrame( );

            jf.setTitle("风格选择");
            jf.setSize(600, 120);
            jf.setLocationRelativeTo(null);
//            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setVisible(true);

            FlowLayout flowLayout = new FlowLayout( );
            jf.setLayout(flowLayout);
            JButton style1 = new JButton("动物世界");
            JButton style2 = new JButton("山水风光");
            JButton style3 = new JButton("二次元");
            style1.setPreferredSize(new Dimension(180,50));
            style2.setPreferredSize(new Dimension(180,50));
            style3.setPreferredSize(new Dimension(180,50));
            Font style =new Font("华文行楷",Font.BOLD,20);
            style1.setFont(style);
            style2.setFont(style);
            style3.setFont(style);
            jf.add(style1);
            jf.add(style2);
            jf.add(style3);
            //可视化在所有组件加载之后
            jf.setVisible(true);
            Stylechange1 stylechange1 = new Stylechange1();
            style1.addActionListener(stylechange1);
            Stylechange3 stylechange3 = new Stylechange3();
            style3.addActionListener(stylechange3);
            Stylechange2 stylechange2 = new Stylechange2();
            style2.addActionListener(stylechange2);


        });
    }
    public static void playMusic2() {// 背景音乐播放
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("C:\\Users\\文123\\Downloads\\CS109-2023-Sping-ChessDemo (4)\\gikja-91ntv.wav"));    //绝对路径
            AudioFormat aif = ais.getFormat();
            final SourceDataLine sdl;
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, aif);
            sdl = (SourceDataLine) AudioSystem.getLine(info);
            sdl.open(aif);
            sdl.start();
            FloatControl fc = (FloatControl) sdl.getControl(FloatControl.Type.MASTER_GAIN);
            // value可以用来设置音量，从0-2.0
            double value = 2;
            float dB = (float) (Math.log(value == 0.0 ? 0.0001 : value) / Math.log(10.0) * 20.0);
            fc.setValue(dB);
            int nByte = 0;
            final int SIZE = 1024 * 64;
            byte[] buffer = new byte[SIZE];
            while (nByte != -1) {
                nByte = ais.read(buffer, 0, SIZE);
                sdl.write(buffer, 0, nByte);
            }
            sdl.stop();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static Clip clip;
    public static void playMusic() {

        try
        {
            //这里面放 绝对路径，音频必须是wav格式，用音频转换软件 把mp3 转成wav格式
            File musicPath = new File("C:\\Users\\文123\\Downloads\\CS109-2023-Sping-ChessDemo (4)\\gikja-91ntv.wav");
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                FloatControl gainControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-20.0f);//设置音量，范围为 -60.0f 到 6.0f
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);






        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

    }

}