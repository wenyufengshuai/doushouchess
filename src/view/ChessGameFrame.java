package view;

import controller.GameController;
import model.ChessPiece;
import model.Chessboard;
import model.PlayerColor;

import javax.swing.*;
import java.awt.*;

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


        });
    }


}