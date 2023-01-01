public class Kale extends Item{
    public Kale(int colorNo){
        super(colorNo);
        this.setPoint(5);
    }
    public boolean isPlayable(int fromX, int fromY, int toX, int toY, Item[][] Taslar){
        return isMovingStraight(fromX, fromY, toX, toY, Taslar);
    }
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //can move sideward
}
