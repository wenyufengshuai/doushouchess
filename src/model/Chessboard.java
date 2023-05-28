package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class store the real chess information.
 * The Chessboard has 9*7 cells, and each cell has a position for chess
 */
public class Chessboard {
    private Cell[][] grid;

    private ChessPlace chessplace[];
    private int turn;

    public int getTurn(){
        return this.turn;
    }

    public ChessPlace getChessplace(int rank) {
        return chessplace[rank];
    }

    public Chessboard() {
        this.grid =
                new Cell[Constant.CHESSBOARD_ROW_SIZE.getNum()][Constant.CHESSBOARD_COL_SIZE.getNum()];//19X19
        this.chessplace=new ChessPlace[20];
        initGrid();
        initPieces();
    }

    private void initGrid() {
        for (int i = 0; i < Constant.CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < Constant.CHESSBOARD_COL_SIZE.getNum(); j++) {
                grid[i][j] = new Cell();
            }
        }
        this.turn=0;//开始第一回合（下完棋后会回合+1，所以这里是0）
    }
    private void iniChessPlace(int place,int row,int col){
        chessplace[place]=new ChessPlace();
        chessplace[place].setPlace(row,col);
    }

    private void initPieces() {
        iniChessPlace(1,2,0);
        iniChessPlace(2,1,5);
        iniChessPlace(3,1,1);
        iniChessPlace(4,2,4);
        iniChessPlace(5,2,2);
        iniChessPlace(6,0,6);
        iniChessPlace(7,0,0);
        iniChessPlace(8,2,6);
        iniChessPlace(11,6,6);
        iniChessPlace(12,7,1);
        iniChessPlace(13,7,5);
        iniChessPlace(14,6,2);
        iniChessPlace(15,6,4);
        iniChessPlace(16,8,0);
        iniChessPlace(17,8,6);
        iniChessPlace(18,6,0);
        /*chessplace[1].setPlace(2,0);
        chessplace[2].setPlace(1,5);
        chessplace[3].setPlace(1,1);
        chessplace[4].setPlace(2,4);
        chessplace[5].setPlace(2,2);
        chessplace[6].setPlace(0,6);
        chessplace[7].setPlace(0,0);
        chessplace[8].setPlace(2,6);
        chessplace[11].setPlace(6,6);
        chessplace[12].setPlace(7,1);
        chessplace[13].setPlace(7,5);
        chessplace[14].setPlace(6,2);
        chessplace[15].setPlace(6,4);
        chessplace[16].setPlace(8,0);
        chessplace[17].setPlace(8,6);
        chessplace[18].setPlace(6,0);*/
        /*grid[6][0].setPiece(new ChessPiece(PlayerColor.BLUE, "Elephant",18));
        grid[6][2].setPiece(new ChessPiece(PlayerColor.BLUE, "Wolf",14));
        grid[6][4].setPiece(new ChessPiece(PlayerColor.BLUE, "Leopard",15));
        grid[6][6].setPiece(new ChessPiece(PlayerColor.BLUE, "Mouse",11));
        grid[7][1].setPiece(new ChessPiece(PlayerColor.BLUE, "Cat",12));
        grid[7][5].setPiece(new ChessPiece(PlayerColor.BLUE, "Dog",13));
        grid[8][0].setPiece(new ChessPiece(PlayerColor.BLUE, "Tiger",16));
        grid[8][6].setPiece(new ChessPiece(PlayerColor.BLUE, "Lion",17));
        grid[0][0].setPiece(new ChessPiece(PlayerColor.RED, "Lion",7));
        grid[0][6].setPiece(new ChessPiece(PlayerColor.RED, "Tiger",6));
        grid[1][1].setPiece(new ChessPiece(PlayerColor.RED, "Dog",3));
        grid[1][5].setPiece(new ChessPiece(PlayerColor.RED, "Cat",2));
        grid[2][0].setPiece(new ChessPiece(PlayerColor.RED, "Mouse",1));
        grid[2][2].setPiece(new ChessPiece(PlayerColor.RED, "Leopard",5));
        grid[2][4].setPiece(new ChessPiece(PlayerColor.RED, "Wolf",4));
        grid[2][6].setPiece(new ChessPiece(PlayerColor.RED, "Elephant",8));*/
        grid[1][1].setPiece(new ChessPiece(PlayerColor.RED, "狗",3));
        grid[7][5].setPiece(new ChessPiece(PlayerColor.BLUE, "狗",13));
        grid[6][6].setPiece(new ChessPiece(PlayerColor.BLUE, "鼠",11));
        grid[2][0].setPiece(new ChessPiece(PlayerColor.RED, "鼠",1));
        grid[2][6].setPiece(new ChessPiece(PlayerColor.RED, "象",8));
        grid[6][0].setPiece(new ChessPiece(PlayerColor.BLUE, "象",18));
        grid[2][2].setPiece(new ChessPiece(PlayerColor.RED, "豹",5));
        grid[6][4].setPiece(new ChessPiece(PlayerColor.BLUE, "豹",15));
        grid[0][0].setPiece(new ChessPiece(PlayerColor.RED, "狮",7));
        grid[8][6].setPiece(new ChessPiece(PlayerColor.BLUE, "狮",17));
        grid[0][6].setPiece(new ChessPiece(PlayerColor.RED, "虎",6));
        grid[8][0].setPiece(new ChessPiece(PlayerColor.BLUE, "虎",16));
        grid[2][4].setPiece(new ChessPiece(PlayerColor.RED, "狼",4));
        grid[6][2].setPiece(new ChessPiece(PlayerColor.BLUE, "狼",14));
        grid[1][5].setPiece(new ChessPiece(PlayerColor.RED, "猫",2));
        grid[7][1].setPiece(new ChessPiece(PlayerColor.BLUE, "猫",12));
    }

    private ChessPiece getChessPieceAt(ChessboardPoint point) {
        return getGridAt(point).getPiece();
    }

    private ChessPiece getChessPieceAt(int row,int col) {
        return getGridAt(row,col).getPiece();
    }

    private Cell getGridAt(ChessboardPoint point) {
        return grid[point.getRow()][point.getCol()];
    }

    private Cell getGridAt(int row,int col) {
        return grid[row][col];
    }

    private int calculateDistance(ChessboardPoint src, ChessboardPoint dest) {
        return Math.abs(src.getRow() - dest.getRow()) + Math.abs(src.getCol() - dest.getCol());
    }

    private ChessPiece removeChessPiece(ChessboardPoint point) {
        ChessPiece chessPiece = getChessPieceAt(point);
        getGridAt(point).removePiece();
        return chessPiece;
    }
    //这个之后看下
    //好像不用改，这个功能被我写在move里了emm重复了注释掉吧

    private void setChessPiece(ChessboardPoint point, ChessPiece chessPiece) {
        getGridAt(point).setPiece(chessPiece);
    }
    private void setChessPiece(int row,int col, ChessPiece chessPiece) {
        getGridAt(row,col).setPiece(chessPiece);
    }

    public void moveChessPiece(ChessboardPoint src, ChessboardPoint dest) {
        if (!isMoveLegal(src, dest,1)) {
            throw new IllegalArgumentException("Illegal chess move!");
        }
        if(isMoveLegal(src.getRow(),src.getCol(),dest.getRow(),dest.getCol(),this.turn,1)){
            int opprank=-1;
            this.turn+=1;
            if(getChessPieceAt(dest.getRow(),dest.getCol())!=null){
                opprank=getChessPieceAt(dest.getRow(),dest.getCol()).getRank();
            }
            int thirank=getChessPieceAt(src.getRow(),src.getCol()).getRank();
            /*if(opprank%10==thirank%10){//互吃同归于尽
                chessplace[opprank].setPlace(-1,-1);
                chessplace[thirank].setPlace(-1,-1);
                setChessPiece(src.getRow(),src.getCol(),null);
                setChessPiece(dest.getRow(),dest.getCol(),null);
                return 1;
            }
            else */if(opprank!=-1){//我方能吃对方
                chessplace[opprank].setPlace(-1,-1);
                chessplace[thirank].setPlace(dest.getRow(),dest.getCol());
                setChessPiece(dest.getRow(),dest.getCol(),getChessPieceAt(src.getRow(),src.getCol()));
                setChessPiece(src.getRow(),src.getCol(),null);
                //return 2;
            }
            else{//目的地没有棋子
                chessplace[thirank].setPlace(dest.getRow(),dest.getCol());
                setChessPiece(dest.getRow(),dest.getCol(),getChessPieceAt(src.getRow(),src.getCol()));
                setChessPiece(src.getRow(),src.getCol(),null);
                //return 3;
            }
        }
        //return 0;
        //setChessPiece(dest, removeChessPiece(src));
    }

    /*public void captureChessPiece(ChessboardPoint src, ChessboardPoint dest) {
        if (isValidCapture(src, dest)) {
            throw new IllegalArgumentException("Illegal chess capture!");
        }
        // TODO: Finish the method.
    }*/

    public Cell[][] getGrid() {
        return grid;
    }
    public PlayerColor getChessPieceOwner(ChessboardPoint point) {
        return getGridAt(point).getPiece().getOwner();
    }

    public PlayerColor getChessPieceOwner(int row,int col) {
        return getGridAt(row,col).getPiece().getOwner();
    }

    /*public boolean isValidMove(ChessboardPoint src, ChessboardPoint dest) {
        if (getChessPieceAt(src) == null || getChessPieceAt(dest) != null) {
            return false;
        }
        return calculateDistance(src, dest) == 1;
    }


    public boolean isValidCapture(ChessboardPoint src, ChessboardPoint dest) {
        // TODO:Fix this method
        return false;
    }*/
    public boolean isMoveLegal(ChessboardPoint src,ChessboardPoint dest,int mode){
        return isMoveLegal(src.getRow(),src.getCol(),dest.getRow(),dest.getCol(),this.turn,mode);
    }
    public boolean isMoveLegal(int lastrow,int lastcol,int thisrow,int thiscol,int turn,int mode){
        int num=checkMoveLegal(lastrow,lastcol,thisrow,thiscol,turn);
        if(mode==0){//检查胜利时的，不用输出非法格式
            if(num==0||num==10){
                return true;
            }
            return false;
        }
        else if(mode==1){//移动棋子，需要输出非法格式
            if(num==1){
                System.out.printf("非法移动：超出棋盘\n");
                return false;
            }
            else if(num==2){
                System.out.printf("非法移动：原位置无棋子\n");
                return false;
            }
            else if(num==3){
                System.out.printf("非法移动：非直线移动\n");
                return false;
            }
            else if(num==4){
                System.out.printf("非法移动：横向跨河，河中有鼠\n");
                return false;
            }
            else if(num==5){
                System.out.printf("非法移动：纵向跨河，河中有鼠\n");
                return false;
            }
            else if(num==6){
                System.out.printf("非法移动：红方棋子进入己方兽穴\n");
                return false;
            }
            else if(num==7){
                System.out.printf("非法移动：蓝方棋子进入己方兽穴\n");
                return false;
            }
            else if(num==8){
                System.out.printf("非法移动：行动不止一步且非狮虎下河\n");
                return false;
            }
            else if(num==9){
                System.out.printf("非法移动：非鼠下河\n");
                return false;
            }
            else if(num==10){
                System.out.printf("合法移动：目的位置无棋子，免除后续吃子判定\n");
                return true;
            }
            else if(num==11){
                System.out.printf("非法移动：目的位置为己方棋子\n");
                return false;
            }
            else if(num==12){
                System.out.printf("非法移动：在陷阱/河中吃子\n");
                return false;
            }
            else if(num==13){
                System.out.printf("非法移动：象吃鼠\n");
                return false;
            }
            else if(num==14){
                System.out.printf("非法移动：目的位置非陷阱且权重小于对方\n");
                return false;
            }
        }
        return true;
    }
    public int checkMoveLegal(int lastrow,int lastcol,int thisrow,int thiscol,int turn){
        if(thisrow<0||thiscol<0||thisrow>8||thiscol>6){//默认第一次点击时会判断是否在棋盘上，因此只判断目的地是否在棋盘上
            return 1;
        }
        if(getChessPieceAt(lastrow,lastcol)==null){//如果上一个位置没有棋子，则非法
            return 2;
        }
        if(lastcol!=thiscol&&lastrow!=thisrow){//如果没有直线移动，则非法
            return 3;
        }
        //考虑到棋盘为9*7，则查找棋子可以一次性返回行列，其中十位数为行个位数为列
        //若棋子已经被吃，可以考虑返回(-1)
        int tem1=chessplace[1].getPlace();
        int tem2=chessplace[11].getPlace();//不论我方还是对方的鼠，只要在河里就不能跨河
        //int tem=获取行列(((turn+1)%2)*10+1);//获取对手鼠的位置
        //若河里有鼠，则不能跨河
        //纵向
        if(crossTheRiver(lastrow,lastcol,thisrow,thiscol)==1&&(tem1/10==lastrow&&(tem1%10>lastcol&&tem1%10<thiscol)||(tem1%10<lastcol&&tem1%10>thiscol))){
            return 4;
        }
        if(crossTheRiver(lastrow,lastcol,thisrow,thiscol)==1&&(tem2/10==lastrow&&(tem2%10>lastcol&&tem2%10<thiscol)||(tem2%10<lastcol&&tem2%10>thiscol))){
            return 4;
        }
        //横向
        if(crossTheRiver(lastrow,lastcol,thisrow,thiscol)==2&&(tem1%10==lastcol&&(tem1/10>lastrow&&tem1/10<thisrow)||(tem1/10<lastrow&&tem1/10>thisrow))){
            return 5;
        }
        if(crossTheRiver(lastrow,lastcol,thisrow,thiscol)==2&&(tem2%10==lastcol&&(tem2/10>lastrow&&tem2/10<thisrow)||(tem2/10<lastrow&&tem2/10>thisrow))){
            return 5;
        }
        //棋子不能进入己方兽穴
        if((getChessPieceOwner(lastrow,lastcol)==PlayerColor.RED&&thisrow==0&&thiscol==3)||(getChessPieceOwner(lastrow,lastcol)==PlayerColor.BLUE&&thisrow==8&&thiscol==3)) {
            return 6;
        }

        if((getChessPieceOwner(lastrow,lastcol)==PlayerColor.BLUE&&getChessPieceAt(lastrow,lastcol).getRank()/10==0)||(getChessPieceOwner(lastrow,lastcol)==PlayerColor.RED&&getChessPieceAt(lastrow,lastcol).getRank()/10==1)){
            return 7;
        }
        if(!((getChessPieceAt(lastrow,lastcol).getRank()%10==6||getChessPieceAt(lastrow,lastcol).getRank()%10==7)&&crossTheRiver(lastrow,lastcol,thisrow,thiscol)!=0)&&(lastcol-thiscol)*(lastcol-thiscol)+(lastrow-thisrow)*(lastrow-thisrow)!=1){
            //如果不是狮虎跨河且移动的不是一步
            return 8;
        }
        if(isRiver(thisrow,thiscol)&&getChessPieceAt(lastrow,lastcol).getRank()%10!=1){//如果下河且不是鼠
            return 9;
        }
        if(getChessPieceAt(thisrow,thiscol)==null){
            return 10;
        }
        if(getChessPieceAt(lastrow,lastcol).getRank()/10==getChessPieceAt(thisrow,thiscol).getRank()/10){//不能吃自己的棋子
            return 11;
        }
        if((isRiver(lastrow,lastcol)||isTrap(lastrow,lastcol))&&getChessPieceAt(thisrow,thiscol).getRank()!=0){//上一次在河/陷阱里且目的地有棋
            return 12;
        }
        //象不能吃鼠
        if(!isTrap(thisrow,thiscol)&&getChessPieceAt(thisrow,thiscol).getRank()%10==1&&getChessPieceAt(lastrow,lastcol).getRank()%10==8){
            return 13;
        }
        //如果吃不了目的地的棋子（不能吃且目的地不为陷阱）
        if(getChessPieceAt(lastrow,lastcol).getRank()%10<getChessPieceAt(thisrow,thiscol).getRank()%10&&!(getChessPieceAt(lastrow,lastcol).getRank()%10==1&&getChessPieceAt(thisrow,thiscol).getRank()%10==8)&&!isTrap(thisrow,thiscol)){
            return 14;
        }
        //if(turn%2!=(getChessPieceAt(lastrow,lastcol).getRank()/10)){//不能移动对手的棋
        //    return false;
        //}
        return 0;
    }
    /*public int moveChess(int lastrow,int lastcol,int thisrow,int thiscol,int turn){
        if(isMoveLegal(lastrow,lastcol,thisrow,thiscol,this.turn)){
            int opprank=getChessPieceAt(thisrow,thiscol).getRank();
            int thirank=getChessPieceAt(lastrow,lastcol).getRank();
            if(opprank==thirank){//互吃同归于尽
                chessplace[opprank].setPlace(-1,-1);
                chessplace[thirank].setPlace(-1,-1);
                setChessPiece(lastrow,lastcol,null);
                setChessPiece(thisrow,thiscol,null);
            }
            else if(opprank!=0){//我方能吃对方
                chessplace[opprank].setPlace(-1,-1);
                chessplace[thirank].setPlace(thisrow,thiscol);
                setChessPiece(thisrow,thiscol,getChessPieceAt(lastrow,lastcol));
                setChessPiece(lastrow,lastcol,null);
            }
            else{
                chessplace[thirank].setPlace(thisrow,thiscol);
                setChessPiece(thisrow,thiscol,getChessPieceAt(lastrow,lastcol));
                setChessPiece(lastrow,lastcol,null);
            }
            turn+=1;
        }
        return turn;
    }*/
    public boolean checkWin(int turn){
        System.out.printf("检查胜利中……\n");
        //每一轮，下完棋后需检查己方是否胜利
        //是否占领对方兽穴
        if((turn%2==1&&getChessPieceAt(0,3)!=null)||(turn%2==0&&(getChessPieceAt(8,3)!=null))){
            return true;
        }
        System.out.printf("Turn=%d ,未出现占领兽穴胜利者\n",turn);
        //对手是否无法移动
        boolean opponentcantmove=true;
        for(int r0=1;r0<=8;r0++){
            int tem=chessplace[((turn+1)%2)*10+r0].getPlace();
            if(tem!=-1){//如果该棋子还在棋盘上
                if(isMoveLegal(tem/10,tem%10,tem/10-1,tem%10,turn+1,0)||isMoveLegal(tem/10,tem%10,tem/10+1,tem%10,turn+1,0)||isMoveLegal(tem/10,tem%10,tem/10,tem%10-1,turn+1,0)||isMoveLegal(tem/10,tem%10,tem/10,tem%10+1,turn+1,0)){
                    opponentcantmove=false;
                }
                if(r0==6||r0==7){
                    if(tem/10==3||tem/10==4||tem/10==5){
                        if(tem%10==0){
                            if(isMoveLegal(tem/10,0,tem/10,3,turn+1,0)){
                                opponentcantmove=false;
                            }
                        }
                        if(tem%10==3){
                            if(isMoveLegal(tem/10,3,tem/10,0,turn+1,0)||isMoveLegal(tem/10,0,tem/10,6,turn+1,0)){
                                opponentcantmove=false;
                            }
                        }
                        if(tem%10==6){
                            if(isMoveLegal(tem/10,6,tem/10,3,turn+1,0)){
                                opponentcantmove=false;
                            }
                        }
                    }
                    if(tem%10==1||tem%10==2||tem%10==4||tem%10==5){
                        if(tem/10==2){
                            if(isMoveLegal(2,tem%10,6,tem%10,turn+1,0)){
                                opponentcantmove=false;
                            }
                        }
                        if(tem/10==6){
                            if(isMoveLegal(6,tem%10,2,tem%10,turn+1,0)){
                                opponentcantmove=false;
                            }
                        }
                    }
                }
            }
        }
        if(opponentcantmove){
            System.out.printf("一方胜利！\n");
            return true;
        }
        System.out.printf("未出现胜利方\n");
        return false;
    }
    private boolean isRiver(int row,int col){//判断这个格子是不是河
        if((row==3||row==4||row==5)&&(col==1||col==2||col==4||col==5)){
            return true;
        }
        return false;
    }
    private boolean isTrap(int row,int col){//判断这个格子是不是陷阱
        if((row==0&&col==2)||(row==0&&col==4||(row==1&&col==3)||(row==8&&col==2)||(row==8&&col==4)||(row==7&&col==3))){
            return true;
        }
        return false;
    }
    private int crossTheRiver(int lastrow,int lastcol,int thisrow,int thiscol){
        //横向跨河
        if((lastrow==3&&thisrow==3)||(lastrow==4&&thisrow==4)||(lastrow==5&&thisrow==5)){
            if((lastcol==0&&thiscol==3)||(lastcol==3&&thiscol==6)||(lastcol==3&&thiscol==0)||(lastcol==6&&thiscol==3)){
                return 1;
            }
        }
        //纵向跨河
        if((lastcol==1&&thiscol==1)||(lastcol==2&&thiscol==2)||(lastcol==4&&thiscol==4)||(lastcol==5&&thiscol==5)){
            if((lastrow==2&&thisrow==6)||(lastrow==6&&thisrow==2)){
                return 2;
            }
        }
        return 0;//否则则不是跨河
    }
    public static void writeFileByFileWriter(String path) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> readFileByFileReader(String path) {
        List<String> readLines = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {
                readLines.add(line);
            }
            String[] array = readLines.toArray(new String[readLines.size()]);

            reader.close();
            fileReader.close();
            return readLines;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readLines;
    }
}