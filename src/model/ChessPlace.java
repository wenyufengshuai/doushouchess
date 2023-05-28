package model;

public class ChessPlace {
    private int row;
    private int col;
    public int getPlace(){
        return row*10+col;
    }
    public void setPlace(int row,int col){
        this.row=row;
        this.col=col;
    }
}
