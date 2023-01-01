public class Game {
    private Board board = new Board();
    private Player player1 = new Player();
    private Player player2 = new Player();
    
    public void addPoint(Player player,int point){
        player.addPoint(point);
    }
    public void displayGame(){
        board.displayBoard();
    }
    
    public Board getBoard() {
        return board;
    }
    public Player getPlayer2() {
        return player2;
    }
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }
    public Player getPlayer1() {
        return player1;
    }
    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
}
