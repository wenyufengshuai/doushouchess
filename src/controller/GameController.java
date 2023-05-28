package controller;


import listener.GameListener;
import model.Constant;
import model.PlayerColor;
import model.Chessboard;
import model.ChessboardPoint;
import view.CellComponent;
import view.ChessComponent;
import view.ChessboardComponent;

import javax.swing.*;

/**
 * Controller is the connection between model and view,
 * when a Controller receive a request from a view, the Controller
 * analyzes and then hands over to the model for processing
 * [in this demo the request methods are onPlayerClickCell() and onPlayerClickChessPiece()]
 *
 */
public class GameController implements GameListener {


    private Chessboard model;
    private ChessboardComponent view;
    private PlayerColor currentPlayer;

    // Record whether there is a selected piece before
    private ChessboardPoint selectedPoint;

    /*public void init(){
        initialize();
        this.view.initiateChessComponent(new Chessboard());
        this.view.repaint();
    }*/
    public GameController(ChessboardComponent view, Chessboard model) {
        this.view = view;
        this.model = model;
        this.currentPlayer = PlayerColor.BLUE;

        view.registerController(this);
        //initialize();//这是初始化吗/好像不是/这是干什么的
        view.initiateChessComponent(model);
        view.repaint();
    }

    public void setCurrentPlayer(PlayerColor a){
        this.currentPlayer = a;
    }
    public void setModel(Chessboard mode){
        this.model=mode;
    }
    private void initialize() {
        for (int i = 0; i < Constant.CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < Constant.CHESSBOARD_COL_SIZE.getNum(); j++) {

            }
        }
    }

    // after a valid move swap the player
    private void swapColor() {
        currentPlayer = currentPlayer == PlayerColor.BLUE ? PlayerColor.RED : PlayerColor.BLUE;
    }

    private boolean win() {
        // TODO: Check the board if there is a winner
        if(model.checkWin(model.getTurn())){
            return true;
        }
        return false;
    }


    // click an empty cell
    @Override
    public void onPlayerClickCell(ChessboardPoint point, CellComponent component) {
        if (selectedPoint != null && model.isMoveLegal(selectedPoint, point,1)) {
            model.moveChessPiece(selectedPoint, point);
            view.setChessComponentAtGrid(point, view.removeChessComponentAtGrid(selectedPoint));
            selectedPoint = null;
            view.repaint();
            if(win()){
                JOptionPane.showMessageDialog(null,"Game over! Player "+currentPlayer.getColor()+"win");
                //怎么结束并重启
                return;
            }
            swapColor();
            // TODO: if the chess enter Dens or Traps and so on
        }
    }

    // click a cell with a chess
    @Override
    public void onPlayerClickChessPiece(ChessboardPoint point, ChessComponent component) {
        if (selectedPoint == null) {
            if (model.getChessPieceOwner(point).equals(currentPlayer)) {
                selectedPoint = point;
                component.setSelected(true);
                //component.repaint();
                view.repaint();
                System.out.printf("选中棋子\n");
            }
        } else if (selectedPoint.equals(point)) {//如果又点了原地
            selectedPoint = null;
            component.setSelected(false);
            //component.repaint();
            view.repaint();
            System.out.printf("原地点击\n");
        }
        else{
            if(!model.isMoveLegal(selectedPoint,point,1)){//component是目的位置
                //要达到非法移动和原地点击的效果比较麻烦，要记录上一步鼠标位置
                //所以省事一点，把非法移动搞成无效点击
                System.out.printf("无效移动：非合法吃子\n");
                return;
            }
            /*int a=model.moveChessPiece(selectedPoint, point);
            if(a==1){
                view.removeChessComponentAtGrid(selectedPoint);
                view.removeChessComponentAtGrid(point);
                System.out.printf("互吃\n");
            }
            else if(a==2){
                view.removeChessComponentAtGrid(point);
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGrid(selectedPoint));
                System.out.printf("吃对方\n");
            }
            理解有误，好像互吃是指哪个先走哪个能吃对方*/
            model.moveChessPiece(selectedPoint, point);
            view.removeChessComponentAtGrid(point);
            view.setChessComponentAtGrid(point, view.removeChessComponentAtGrid(selectedPoint));
            System.out.printf("吃对方\n");
            selectedPoint = null;
            component.setSelected(false);
            view.repaint();
            if(win()){
                JOptionPane.showMessageDialog(null,"Game over! Player "+currentPlayer.getColor()+"win");
                //怎么结束并重启
                return;
            }
            swapColor();
        }
        //点击棋子后进行的判断，是否是本方点击，如果是本方点击且之前无点击泽记录这次点击
        // TODO: Implement capture function
    }
}