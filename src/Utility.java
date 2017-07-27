import java.util.ArrayList;


public class Utility {
private ArrayList<Square> tempBoard;
//private boolean color;
private int black;
private int red;
private int checkerValue=100;
private int edgeValue=70;
private int winnerBonus=1000;
private int kingValue=150;
//private int moveValue=1;
private int positionValue=50;
private Actions action;
private Player player;
public Utility(Player player, Actions action){
	this.action=action;
	this.player=player;
}
//public void setColor(){
//	color=player.isBlack();
//}
public int win(){
	int retValue=0;
	if(action.endGame()){
		if(action.getBlack()<action.getRed()){
			retValue=winnerBonus;
		}
		else{
			retValue=(-1*winnerBonus);
		}
		
	}
//	if(color){
//		if(action.getRed()==0){
//		retValue=winnerBonus;}
//		else if(action.getBlack()==0){
//			retValue=-10000;
//		}
//	}
//	else{
//		if(action.getBlack()==0){
//			retValue=winnerBonus;
//		}
//		else if(action.getRed()==0){
//			retValue=-100000;
//		}
//	}
	return retValue;
}
public int checkersValue(){
	//setColor();
	black=action.getBlack();
	red=action.getRed();
	
		return ((red-black)*checkerValue);
	

}
public int edgeValue(){
	//player.update(action);
	//tempBoard=player.getPieces();//action.getBoard();
	tempBoard=action.blackPieces();
	int x=0;
	for(int i=0;i<tempBoard.size();i++){
		if(((!tempBoard.get(i).isKing())&&((tempBoard.get(i).getBackL()==0)||(tempBoard.get(i).getBackR()==0)))){
			x--;
			if((((tempBoard.get(i).getBackL()==0)&&(tempBoard.get(i).getBackR()==0)))){
				x-=5;
			}
		}
	}
	tempBoard=action.redPieces();
	for(int i=0;i<tempBoard.size();i++){
		if(((!tempBoard.get(i).isKing())&&((tempBoard.get(i).getFrontL()==0)||(tempBoard.get(i).getFrontR()==0)))){
			x++;
			if((((tempBoard.get(i).getFrontL()==0)&&(tempBoard.get(i).getFrontR()==0)))){
				x+=5;
			}
		}
	}
	x=x*edgeValue;
	return x;
}

public int positionValue(){
	int value=0;
	int blackPos=0;
	int redPos=0;
	tempBoard=action.getBoard();
	
		for(int i=0;i<tempBoard.size();i++){
		if(!tempBoard.get(i).isKing()){
			if(tempBoard.get(i).getColor()&&(tempBoard.get(i).getCurrent()>12)){
				blackPos++;
				if(tempBoard.get(tempBoard.get(i).getBackL()).isOccupied()||tempBoard.get(tempBoard.get(i).getBackR()).isOccupied()){
					blackPos+=5;
					if(tempBoard.get(tempBoard.get(i).getBackL()).isOccupied()&&tempBoard.get(tempBoard.get(i).getBackR()).isOccupied()){
						blackPos+=10;
					}
				}
				if(tempBoard.get(i).getCurrent()>16){
					blackPos++;
					
				}
				if(tempBoard.get(i).getCurrent()>20){
					blackPos++;
				}
				if(tempBoard.get(i).getCurrent()>24){
					blackPos++;
				}
				if(tempBoard.get(i).getCurrent()>28){
					blackPos++;
				}
				
	}	
		if((!tempBoard.get(i).getColor())&&(tempBoard.get(i).getChecker()!=null)&&(tempBoard.get(i).getCurrent()<21)){
			redPos++;
			
			if(tempBoard.get(tempBoard.get(i).getFrontL()).isOccupied()||tempBoard.get(tempBoard.get(i).getFrontR()).isOccupied()){
				redPos+=5;
				if(tempBoard.get(tempBoard.get(i).getFrontL()).isOccupied()&&tempBoard.get(tempBoard.get(i).getFrontR()).isOccupied()){
					redPos+=10;
				}
			}
			
			if(tempBoard.get(i).getCurrent()<17){
				redPos++;
			}
			if(tempBoard.get(i).getCurrent()<13){
				redPos++;
			}
			if(tempBoard.get(i).getCurrent()<9){
				redPos++;
			}
			if(tempBoard.get(i).getCurrent()<5){
				redPos++;
			}
	}
		
	}
	
	
}
		value=((redPos-blackPos)*positionValue);
		
	return value;
}
public int getKings(){
	//player.update(action);
	ArrayList<Square> pieces=action.getBoard();
	int x=0;
	for (int i=0;i<pieces.size();i++){
		if(pieces.get(i).isKing()&&pieces.get(i).getColor()){
			x--;
		}
		else if((pieces.get(i).isKing()&&(!pieces.get(i).getColor()))){
			x++;
		}
	}
	return (x*kingValue);
}
public int getUtility(){
	int ret=checkersValue()+getKings()+edgeValue()+positionValue()+win();
	return ret;
}
}
