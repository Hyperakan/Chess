public class At extends Item{
    public At(int colorNo){
        super(colorNo);
        this.setPoint(3);
    }
    public boolean isPlayable(int fromX, int fromY, int toX, int toY, Item[][] Taslar){
        if (Math.abs(fromX - toX) == 2 && Math.abs(fromY - toY) == 1)
			return true;
		if (Math.abs(fromX - toX) == 1 && Math.abs(fromY - toY) == 2)
			return true;
		return false;
    }
}
