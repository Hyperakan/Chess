public class Item {
    private int colorNo;
    private int point;
    public Item(int colorNo){
        this.setColorNo(colorNo);
        this.setPoint(0);
    }
    public int getPoint() {
        return point;
    }
    public void setPoint(int point) {
        this.point = point;
    }
    public int getColorNo() {
        return colorNo;
    }
    public void setColorNo(int colorNo) {
        this.colorNo = colorNo;
    }
    public boolean isMovingStraight(int fromX, int fromY, int toX, int toY, Item[][] Taslar){
        int smallerVal;
		int largerVal;

		if (fromX == toX){
			if (fromY > toY){
				smallerVal = toY;
				largerVal = fromY;
			}
			else if (toY > fromY){
				smallerVal = fromY;
				largerVal = toY;
			}
			else return false;
			
			smallerVal++;
			for(; smallerVal < largerVal; smallerVal++){
				if (Taslar[fromX][smallerVal] != null ){
					return false;
				}
			}
			return true;
		}

		if (fromY == toY){
			if (fromX > toX){
				smallerVal = toX;
				largerVal = fromX;
			}
			else if (toX > fromX){
				smallerVal = fromX;
				largerVal = toX;
			}
			else return false;
	
			smallerVal++;
			for(; smallerVal < largerVal; smallerVal++){
                
				if (Taslar[smallerVal][fromY] != null){
					return false;
				}
			}
			return true;
		}
		
		return false;
    }
    public boolean isMovingDiagonal(int fromX, int fromY, int toX, int toY, Item[][] Taslar){
        int xStart = 0;
		int yStart = 0;
		int xFinish = 1;
		//int yFinish = 1;
		
		//Check if movement is diagonal
		int xTotal = Math.abs(toX - fromX);
		int yTotal = Math.abs(toY - fromY);
		
		if (xTotal == yTotal){
			if (toX < fromX){
				xStart = toX;
				xFinish = fromX;
			}
			else if (toX > fromX){
				xStart = fromX;
				xFinish = toX;
			}
			else
				return false;
			
			if (toY < fromY){
				yStart = toY;
				//yFinish = this.getYLocation();
			}
			else if (toY > fromY){
				yStart = fromY;
				//yFinish = yPosition;
			}
			else
				return false;
			
			xStart++;
			yStart++;
			
			// Loop to see if any piece is in between
            //Taslar[xStart][yStart] != null
			for(;xStart < xFinish; xStart++, yStart++){
				if (Taslar[xStart][yStart] != null){
					return false;
				}
			}
			
			return true;
		}
		
		return false;
    }
    public boolean isPlayable(int fromX, int fromY, int toX, int toY, Item[][] Taslar){
        return false;
    }
    
}
