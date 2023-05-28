package view;

import controller.GameController;
import model.Chessboard;
import model.PlayerColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        setTitle("2023 CS109 Project Demo"); //设置标题
        this.WIDTH = width;
        this.HEIGTH = height;
        this.ONE_CHESS_SIZE = (HEIGTH * 4 / 5) / 9;

        setSize(WIDTH, HEIGTH);
        setLocationRelativeTo(null); // Center the window.放在windows中央
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        setLayout(null);


        addChessboard();
        addLabel();
        addHelloButton();
        addResetButton();
        addSaveButton();
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
    private void addLabel() {
        JLabel statusLabel = new JLabel("Sample label");
        statusLabel.setLocation(HEIGTH, HEIGTH / 10);
        statusLabel.setSize(200, 60);
        statusLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(statusLabel);
    }

    /**
     * 在游戏面板中增加一个按钮，如果按下的话就会显示Hello, world!
     */

    private void addHelloButton() {
        JButton button = new JButton("Show Hello Here");
        button.addActionListener((e) -> JOptionPane.showMessageDialog(this, "Hello, world!"));
        button.setLocation(HEIGTH, HEIGTH / 10 + 120);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
    }

    private void addResetButton(){
        //这里
        JButton button = new JButton("Reset the Game");
        button.addActionListener(e -> {
            //GameController.init();
            thectrl.setModel(new Chessboard());
            thectrl.setCurrentPlayer(PlayerColor.BLUE);
            Chessboard mod=new Chessboard();
            chessboardComponent.initiateChessComponent(mod);
            chessboardComponent.repaint();
        });
        button.setLocation(HEIGTH, HEIGTH / 10 + 240);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
    }
    private void addSaveButton(){
        JButton button = new JButton("save");
        button.setLocation(HEIGTH,HEIGTH / 10 + 360);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
//self：点击button触发的事件，即监听事件
        button.addActionListener(e -> {
            System.out.println("Click save");
            Chessboard.writeFileByFileWriter("chessboard.txt");
            JOptionPane.showMessageDialog(null , "保存成功");
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
//    private void addLoadButton() {
//        JButton button = new JButton("Load");
//        button.setLocation(HEIGTH, HEIGTH / 10 + 240);
//        button.setSize(200, 60);
//        button.setFont(new Font("Rockwell", Font.BOLD, 20));
//        add(button);
//
//        button.addActionListener(e -> {
//            System.out.println("Click load");
//            String path = JOptionPane.showInputDialog(this,"Input Path here");
//            gameController.loadGameFromFile(path);
//        });
//    }


}