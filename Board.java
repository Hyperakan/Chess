public class Board {
    private Item[][] Taslar = new Item[8][8];

    public Board() {
        setBoard();
    }
    public Item[][] getTaslar(){
        return Taslar;
    }
    public int moveTo(int fromX, int fromY, int toX, int toY){
        
            Item tempItem = Taslar[toX][toY];
            Taslar[toX][toY] = Taslar[fromX][fromY];
            Taslar[fromX][fromY] = null;
            if(tempItem != null)
                return tempItem.getPoint();
        
            return 0;
    }

    public void setBoard() { 
        for (int i = 0; i < 8; i = i + 7) {
            for (int j = 0; j < 8; j++) {
                if (i == 0)
                    Taslar[i][j] = new Piyon(0);
                else
                    Taslar[i][j] = new Piyon(1);
            }
        }

        Taslar[1][0] = new Kale(0);
        Taslar[1][7] = new Kale(0);
        Taslar[6][0] = new Kale(1);
        Taslar[6][7] = new Kale(1);

        Taslar[1][1] = new At(0);
        Taslar[1][6] = new At(0);
        Taslar[6][1] = new At(1);
        Taslar[6][6] = new At(1);

        Taslar[1][2] = new Fil(0);
        Taslar[1][5] = new Fil(0);
        Taslar[6][2] = new Fil(1);
        Taslar[6][5] = new Fil(1);

        Taslar[1][3] = new Vezir(0);
        Taslar[6][3] = new Vezir(1);

        Taslar[1][4] = new Sah(0);
        Taslar[6][4] = new Sah(1);
    }

    public void displayBoard() {
        System.out.println("  1 2 3 4 5 6 7 8");
        for (int xBoard = 0; xBoard < 8; xBoard++) {
            System.out.print((char)(xBoard + 97)+" ");
            for (int yBoard = 0; yBoard < 8; yBoard++) {
                if (Taslar[xBoard][yBoard] == null)
                    System.out.print("- ");
                else {
                    if (Taslar[xBoard][yBoard] instanceof Piyon) {
                        Piyon p = (Piyon) Taslar[xBoard][yBoard];
                        if (p.getColorNo() == 0)
                            System.out.print("P ");
                        else
                            System.out.print("p ");
                    } else if (Taslar[xBoard][yBoard] instanceof At) {
                        At p = (At) Taslar[xBoard][yBoard];
                        if (p.getColorNo() == 0)
                            System.out.print("A ");
                        else
                            System.out.print("a ");
                    } else if (Taslar[xBoard][yBoard] instanceof Vezir) {
                        Vezir p = (Vezir) Taslar[xBoard][yBoard];
                        if (p.getColorNo() == 0)
                            System.out.print("V ");
                        else
                            System.out.print("v ");
                    } else if (Taslar[xBoard][yBoard] instanceof Sah) {
                        Sah p = (Sah) Taslar[xBoard][yBoard];
                        if (p.getColorNo() == 0)
                            System.out.print("S ");
                        else
                            System.out.print("s ");
                    } else if (Taslar[xBoard][yBoard] instanceof Kale) {
                        Kale p = (Kale) Taslar[xBoard][yBoard];
                        if (p.getColorNo() == 0)
                            System.out.print("K ");
                        else
                            System.out.print("k ");
                    } else if (Taslar[xBoard][yBoard] instanceof Fil) {
                        Fil p = (Fil) Taslar[xBoard][yBoard];
                        if (p.getColorNo() == 0)
                            System.out.print("F ");
                        else
                            System.out.print("f ");
                    } else
                        System.out.print("x ");
                }
            }
            System.out.println();
        }
    }

    public boolean isPlayable(int fromX,int fromY,int toX,int toY,int turn){
        if(Taslar[fromX][fromY]==null || Taslar[fromX][fromY].getColorNo() != turn)
            return false;
        if(Taslar[toX][toY]!=null && Taslar[toX][toY].getColorNo() == turn )
            return false;
        if(outOfBounds(toX, toY))
            return false;
        if(!Taslar[fromX][fromY].isPlayable( fromX, fromY, toX, toY, Taslar))
            return false;
        return true;
              

    }

    public boolean outOfBounds(int toX, int toY) {
        if (toX < 8 && toX >= 0 &&
                toY < 8 && toY >= 0)
            return false;
        return true;
    }

    public boolean isEmpty(int toX, int toY) {
        if (Taslar[toX][toY] == null)
            return true;

        return false;
    }
    public void tabloyuSolaKaydir(){
        Item[][] tempTaslar = new Item[8][8];

        for(int i = 0; i < 8 ; i++){
            for(int j = 0; j < 8 ; j++){
                tempTaslar[i][j] = Taslar[i][(j+1)%8];
            }
        }

        Taslar = tempTaslar;
    }
    

}
