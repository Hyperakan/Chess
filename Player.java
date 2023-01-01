public class Player {
    private int point;
    public Player() {
        this.setPoint(0);
    }
    public int getPoint() {
        return point;
    }
    public void setPoint(int point) {
        this.point = point;
    }
    public void addPoint(int point) {
        this.point += point;
    }
    
}
