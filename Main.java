import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Game game = new Game();
        int turn = 0;
        int islem = 0;
        while (true) {
            if (turn == 0)
                System.out.println("Sira beyazda!");
            else
                System.out.println("Sira siyahda!");
            if(islem == 0){
                System.out.println("******************");
                game.displayGame();
                System.out.println("******************");
            }
            else{
                System.out.println("******************");
                game.displayGame();
                System.out.println("******************");
            }
            
            int fromX;
            int fromY;
            int toX;
            int toY;
            String input = scan.nextLine();
            if (input.equals("exit")){
                System.out.println("Player 1 :"+game.getPlayer1().getPoint()+" points");
                System.out.println("Player 2 :"+game.getPlayer2().getPoint()+" points");
                System.exit(0);
            }
            else if (input.length() == 5) {
                fromX = input.charAt(0) - 97;
                fromY = input.charAt(1) - 49;

                toX = input.charAt(3) - 97;
                toY = input.charAt(4) - 49;
                if (game.getBoard().getTaslar()[fromX][fromY].getColorNo() == turn) {
                    if ((game.getBoard().getTaslar()[toX][toY] != null)
                            && (turn == game.getBoard().getTaslar()[toX][toY].getColorNo())) {
                        System.out.println("Kendi tasini yiyemezsin!");
                        continue;
                    }

                    else if (turn == 0) {
                        if (game.getBoard().getTaslar()[fromX][fromY].isPlayable(fromX, fromY, toX, toY,
                                game.getBoard().getTaslar())) {
                            game.addPoint(game.getPlayer1(), game.getBoard().moveTo(fromX, fromY, toX, toY));
                            game.getBoard().tabloyuSolaKaydir();
                        } else {
                            System.out.println("Hatali bir hamle, tekrar giriniz!");
                            continue;
                        }
                    }

                    else {
                        if (game.getBoard().getTaslar()[fromX][fromY].isPlayable(fromX, fromY, toX, toY,
                                game.getBoard().getTaslar())) {
                            game.addPoint(game.getPlayer2(), game.getBoard().moveTo(fromX, fromY, toX, toY));
                            game.getBoard().tabloyuSolaKaydir();
                        } else {
                            System.out.println("Hatali bir hamle, tekrar giriniz!");
                            continue;
                        }
                    }
                } else {
                    System.out.println("Sira sizde degil!");
                    continue;
                }

            } else {
                System.out.println("Hatali girdi!");
                continue;
            }
            if (game.getPlayer1().getPoint() > 500){
                System.out.println("Beyaz oyuncu oyunu kazandi.");
                game.getBoard().displayBoard();
                System.exit(0);
            }
                

            if (game.getPlayer2().getPoint() > 500){
                System.out.println("Siyah oyuncu oyunu kazandi.");
                game.getBoard().displayBoard();
                System.exit(0);
            }
                

            turn = (turn + 1) % 2;
            islem++;
        }
    }
}

