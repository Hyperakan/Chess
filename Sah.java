public class Sah extends Item{
    public Sah(int colorNo){
        super(colorNo);
        this.setPoint(999);
    }
    public boolean isPlayable(int fromX, int fromY, int toX, int toY, Item[][] Taslar){
        int absoluteX = Math.abs(toX - fromX);
		int absoluteY = Math.abs(toY - fromY);
		
		if (absoluteX <= 1 && absoluteY <= 1){
			if (absoluteX == 0 && absoluteY == 0){
				return false;
			}
			return true;
		}
		return false;
    }
}
