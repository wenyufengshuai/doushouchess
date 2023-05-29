package view;


import controller.GameController;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static model.Constant.CHESSBOARD_COL_SIZE;
import static model.Constant.CHESSBOARD_ROW_SIZE;

/**
 * This class represents the checkerboard component object on the panel
 */
public class ChessboardComponent extends JComponent {
    private final CellComponent[][] gridComponents = new CellComponent[CHESSBOARD_ROW_SIZE.getNum()][CHESSBOARD_COL_SIZE.getNum()];
    private final int CHESS_SIZE;
    private final Set<ChessboardPoint> riverCell = new HashSet<>();
    private final Set<ChessboardPoint> trap = new HashSet<>();
    private final Set<ChessboardPoint> cave = new HashSet<>();

    private GameController gameController;

    public ChessboardComponent(int chessSize) {
        CHESS_SIZE = chessSize;
        int width = CHESS_SIZE * 7;
        int height = CHESS_SIZE * 9;
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);// Allow mouse events to occur
        setLayout(null); // Use absolute layout.
        setSize(width, height);
        System.out.printf("chessboard width, height = [%d : %d], chess size = %d\n", width, height, CHESS_SIZE);

        initiateGridComponents();
    }


    /**
     * This method represents how to initiate ChessComponent
     * according to Chessboard information
     */
    public void initiateChessComponent(Chessboard chessboard) {
        Cell[][] grid = chessboard.getGrid();
        for (int i = 0; i < CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < CHESSBOARD_COL_SIZE.getNum(); j++) {
                // TODO: Implement the initialization checkerboard

                if (grid[i][j].getPiece() != null) {
                    ChessPiece chessPiece = grid[i][j].getPiece();
                    System.out.println(chessPiece.getOwner());

                    if (chessPiece.getName().equals("象")){
                        gridComponents[i][j].add(new ElephantChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    }
                    if (chessPiece.getName().equals("狮")){
                        gridComponents[i][j].add(new LionChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    }
                    if (chessPiece.getName().equals("虎")){
                        gridComponents[i][j].add(new TigerChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    }
                    if (chessPiece.getName().equals("豹")){
                        gridComponents[i][j].add(new LeopardChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    }
                    if (chessPiece.getName().equals("狼")){
                        gridComponents[i][j].add(new WolfChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    }
                    if (chessPiece.getName().equals("狗")){
                        gridComponents[i][j].add(new DogChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    }
                    if (chessPiece.getName().equals("猫")){
                        gridComponents[i][j].add(new CatChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    }
                    if (chessPiece.getName().equals("鼠")){
                        gridComponents[i][j].add(new RatChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    }
                }
            }
        }

    }

    public void initiateGridComponents() {
        trap.add(new ChessboardPoint(0,2));
        trap.add(new ChessboardPoint(0,4));
        trap.add(new ChessboardPoint(1,3));

        trap.add(new ChessboardPoint(8,2));
        trap.add(new ChessboardPoint(8,4));
        trap.add(new ChessboardPoint(7,3));

        cave.add(new ChessboardPoint(0,3));
        cave.add(new ChessboardPoint(8,3));

        riverCell.add(new ChessboardPoint(3,1));
        riverCell.add(new ChessboardPoint(3,2));
        riverCell.add(new ChessboardPoint(4,1));
        riverCell.add(new ChessboardPoint(4,2));
        riverCell.add(new ChessboardPoint(5,1));
        riverCell.add(new ChessboardPoint(5,2));

        riverCell.add(new ChessboardPoint(3,4));
        riverCell.add(new ChessboardPoint(3,5));
        riverCell.add(new ChessboardPoint(4,4));
        riverCell.add(new ChessboardPoint(4,5));
        riverCell.add(new ChessboardPoint(5,4));
        riverCell.add(new ChessboardPoint(5,5));

        for (int i = 0; i < CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < CHESSBOARD_COL_SIZE.getNum(); j++) {
                ChessboardPoint temp = new ChessboardPoint(i, j);
                CellComponent cell;
                if (riverCell.contains(temp)) {
                    cell = new CellComponent(Color.CYAN, calculatePoint(i, j), CHESS_SIZE);
                    this.add(cell);
                }
                else if (trap.contains(temp)) {
                    cell = new CellComponent(Color.GRAY, calculatePoint(i, j), CHESS_SIZE);
                    this.add(cell);
                }
                else if (cave.contains(temp)) {
                    cell = new CellComponent(Color.GREEN, calculatePoint(i, j), CHESS_SIZE);
                    this.add(cell);
                }
                else {//tnnd，不写else if是吧，害我一通好找（指指点点）
                    cell = new CellComponent(Color.LIGHT_GRAY, calculatePoint(i, j), CHESS_SIZE);
                    this.add(cell);
                }
                gridComponents[i][j] = cell;
            }
        }
    }

    public void registerController(GameController gameController) {
        this.gameController = gameController;
    }

    public void setChessComponentAtGrid(ChessboardPoint point, ChessComponent chess) {
        getGridComponentAt(point).add(chess);
    }

    public ChessComponent removeChessComponentAtGrid(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        ChessComponent chess = (ChessComponent) getGridComponentAt(point).getComponents()[0];
        getGridComponentAt(point).removeAll();
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }
    private CellComponent getGridComponentAt(ChessboardPoint point) {
        return gridComponents[point.getRow()][point.getCol()];
    }

    private ChessboardPoint getChessboardPoint(Point point) {
        System.out.println("[" + point.y/CHESS_SIZE +  ", " +point.x/CHESS_SIZE + "] Clicked");
        return new ChessboardPoint(point.y/CHESS_SIZE, point.x/CHESS_SIZE);
    }
    private Point calculatePoint(int row, int col) {
        return new Point(col * CHESS_SIZE, row * CHESS_SIZE);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        paintChessImage(g);
//        repaint();
    }

    @Override
    protected void processMouseEvent(MouseEvent e) {
        if (e.getID() == MouseEvent.MOUSE_PRESSED) {
            JComponent clickedComponent = (JComponent) getComponentAt(e.getX(), e.getY());
            if (clickedComponent.getComponentCount() == 0) {
                System.out.print("None chess here and ");
                gameController.onPlayerClickCell(getChessboardPoint(e.getPoint()), (CellComponent) clickedComponent);
            } else {
                System.out.print("One chess here and ");
                gameController.onPlayerClickChessPiece(getChessboardPoint(e.getPoint()), (ChessComponent) clickedComponent.getComponents()[0]);
            }
        }
    }

    private void paintChessImage(Graphics g) {
        if (this.getName().equals("狗")) {
            g.drawImage(gameUtils.imagehx,0, 0, null);}
//         else if (.equals("兵")) {
//            g.drawImage(gameUtils.image7, 5, 5, null);
//            setChessType(10);
//        } else if (this.name.equals("仕")) {
//            g.drawImage(gameUtils.image8, 5, 5, null);
//            setChessType(2);
//        } else if (this.name.equals("士")) {
//            g.drawImage(gameUtils.image3, 5, 5, null);
//            setChessType(3);
//        } else if (this.name.equals("炮")) {
//            g.drawImage(gameUtils.image1, 5, 5, null);
//            setChessType(12);
//        } else if (this.name.equals("砲")) {
//            g.drawImage(gameUtils.image5, 5, 5, null);
//            setChessType(13);
//        } else if (this.name.equals("俥")) {
//            g.drawImage(gameUtils.image10, 5, 5, null);
//            setChessType(6);
//        } else if (this.name.equals("車")) {
//            g.drawImage(gameUtils.image12, 5, 5, null);
//            setChessType(7);
//        } else if (this.name.equals("傌")) {
//            g.drawImage(gameUtils.image11, 5, 5, null);
//            setChessType(8);
//        } else if (this.name.equals("馬")) {
//            g.drawImage(gameUtils.image13, 5, 5, null);
//            setChessType(9);
//        } else if (this.name.equals("相")) {
//            g.drawImage(gameUtils.image9, 5, 5, null);
//            setChessType(4);
//        } else if (this.name.equals("象")) {
//            g.drawImage(gameUtils.image6, 5, 5, null);
//            setChessType(5);
//        } else if (this.name.equals("帥")) {
//            g.drawImage(gameUtils.image, 5, 5, null);
//            setChessType(0);
//        } else if (this.name.equals("將")) {
//            g.drawImage(gameUtils.image4, 5, 5, null);
//            setChessType(1);
//        }
//    }
}}
