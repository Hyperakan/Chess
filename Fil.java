public class Fil extends Item{
    public Fil(int colorNo){
        super(colorNo);
        this.setPoint(3);
    }
    public boolean isPlayable(int fromX, int fromY, int toX, int toY, Item[][] Taslar){
        return isMovingDiagonal(fromX, fromY, toX, toY, Taslar);
    }
}
