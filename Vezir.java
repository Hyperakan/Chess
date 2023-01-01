public class Vezir extends Item{
    public Vezir(int colorNo){
        super(colorNo);
        this.setPoint(9);
    }
    public boolean isPlayable(int fromX, int fromY, int toX, int toY, Item[][] Taslar){
        if (isMovingStraight(fromX, fromY,toX,toY,Taslar) ||
				isMovingDiagonal(fromX, fromY,toX,toY,Taslar))
				return true;
		return false;
    }
}
