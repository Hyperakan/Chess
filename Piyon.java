public class Piyon extends Item{
    public Piyon(int colorNo){
        super(colorNo);
        this.setPoint(1);
    }
    public boolean isPlayable(int fromX, int fromY, int toX, int toY, Item[][] Taslar) {
        int adim;
		Item target = Taslar[toX][toY];
        if(this.getColorNo()==0){
            adim = 1;
        }
        else{
            adim = -1;
        }
        
		if (toX - fromX == adim){
			
			if (toY == fromY && target == null){
				return true;
			}
			
			else if (Math.abs(fromY-toY) == 1 && target != null){
				return true;
			}
            else
                return false;
		}
		return false;
    }
    
}
