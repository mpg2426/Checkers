import java.util.ArrayList;


public class Actions {
	private ArrayList<Square> board;
	private int red;
	private int black;
	private boolean score=true;
	public Actions(ArrayList<Square> board, int black, int red){
		this.red=red;
		this.black=black;
		this.board=board;
	}
	
	public int getRed(){
		return red;
	}
	public int getBlack(){
		return black;
	}
	public ArrayList<Square> getBoard(){
		return board;
	}
	public Actions copy(){
		ArrayList<Square> tempSquare=new ArrayList<Square>();
		for(int i=0;i<board.size();i++){
			tempSquare.add(board.get(i).copy());
		}
		Actions temp=new Actions(tempSquare, black,red);
		return temp;
	}
	public boolean gameChange(){
		return score;
	}
	public void changeScore(){
		score=(!score);
	}
	public int updateBlack(){
		black--;
		changeScore();
	//	changeScore();
		//System.out.println("New black: "+black);
		return black;
	}
	public int updateRed(){
		red--;
		changeScore();
		//changeScore();
		//System.out.println("new red: "+red);
		return red;
	}
	public boolean endGame(){
		ArrayList<Square> blackList=blackPieces();
		ArrayList<Square> redList=redPieces();
		boolean ret=false;
		if (red==0){
			//System.out.println("Black has won");
			return true;
		}
		 if(black==0){
			//System.out.println("Red has won");
			return true;
		}
		 if((black<6)){//&&(!blackMustJump(blackPieces().get(0))
			for(int r=0;r<blackList.size();r++){
		Square tempSquare=blackList.get(r);
		if(blackMustJump(tempSquare)){
			ret= false;
			break;
		}
			if(tempSquare.isKing()){
				if(blackKingMustJump(tempSquare)){
					ret=false;
					break;
				}
				if(kingMovable(tempSquare,tempSquare.getFrontL())){
					ret= false;
					break;
				}
				if(kingMovable(tempSquare,tempSquare.getFrontR())){
					ret= false;
					break;
				}
				if(kingMovable(tempSquare,tempSquare.getBackL())){
					ret= false;
					break;
				}
				if(kingMovable(tempSquare,tempSquare.getBackR())){
					ret= false;
					break;
				}
				else{
//					System.out.println("Setting ret to true black king");
					ret=true;
					
				}
			}
			 if((!tempSquare.isKing())&&blackMovable(tempSquare,tempSquare.getFrontL())){
				ret= false;
				break;
			}
			if((!tempSquare.isKing())&&blackMovable(tempSquare,tempSquare.getFrontR())){
				ret= false;
				break;
			}
			else{ret=true;
//			System.out.println("Setting ret to true black");
			}
		
		 }
			if(ret){
//				System.out.println("Returning true for black");
				return true;
			}
		 }
		  if((red<6)){//&&(!redMustJump(redPieces().get(0)))){
			for(int r=0;r<redList.size();r++){
			Square tempSquare=redList.get(r);
			//System.out.println(tempSquare)	;
			if(redMustJump(tempSquare)){
//				System.out.println("Red must jump!");
				ret= false;
				break;
			}
			if(tempSquare.isKing()){
				if(redKingMustJump(tempSquare)){
//					System.out.println("Red king must jump");
					ret=false;
					break;
				}
				if(kingMovable(tempSquare,tempSquare.getFrontL())){
					ret= false;
					break;
				}
				if(kingMovable(tempSquare,tempSquare.getFrontR())){
					ret= false;
					break;
				}
				if(kingMovable(tempSquare,tempSquare.getBackL())){
					ret= false;
					break;
				}
				if(kingMovable(tempSquare,tempSquare.getBackR())){
					ret= false;
					break;
				}
				else{
//					System.out.println("Setting ret to true red king");
					ret= true;
				}
			}
			if((!tempSquare.isKing())&&redMovable(tempSquare,tempSquare.getBackL())){
				ret= false;
				break;
			}
			if((!tempSquare.isKing())&&redMovable(tempSquare,tempSquare.getBackR())){
				ret= false;
				break;
			}
			if(!tempSquare.isKing()){
//				System.out.println("setting ret to true red");
				ret=true;
			}
			
		}
			if(ret){
//				System.out.println("Red returning true");
				return true;
			}
		}
		else{
			return false;
		}
		// System.out.println("Should never make it here in endgame");
		 return ret;
		}

	public ArrayList<Square> blackPieces(){
		ArrayList<Square> blackPiece=new ArrayList<Square>();
		for(int i=0;i<board.size();i++){
			if(board.get(i).getColor()){
				blackPiece.add(board.get(i));
			}
				
		}
		return blackPiece;
	}
	
	public ArrayList<Square> redPieces(){
		ArrayList<Square> redPiece=new ArrayList<Square>();
		for(int i=0;i<board.size();i++){
			if(board.get(i).isOccupied()&&!board.get(i).getColor()){
				redPiece.add(board.get(i));
			}
				
		}
		return redPiece;
	}
	
	public boolean redKingMustJump(Square square){
		Square frontL=board.get(square.getFrontL());
		Square frontLFrontL=board.get(frontL.getFrontL());
		Square frontR=board.get(square.getFrontR());
		Square frontRFrontR=board.get(frontR.getFrontR());
		return(redMustJump( square)||
		(frontL.isOccupied()&&(frontL.getColor())&&(!frontLFrontL.isOccupied())&&(frontLFrontL.getCurrent()!=0))||
		(frontR.isOccupied()&&(frontR.getColor())&&(!frontRFrontR.isOccupied())&&(frontRFrontR.getCurrent()!=0)));
	}
	
	public boolean redMustJump(Square square){
		Square backL=board.get(square.getBackL());
		Square backLBackL=board.get(backL.getBackL());
		Square backR=board.get(square.getBackR());
		Square backRBackR=board.get(backR.getBackR());
		return (backL.isOccupied()&&backL.getColor()&&(!backLBackL.isOccupied())&&(backLBackL.getCurrent()!=0))||
				(backR.isOccupied()&&backR.getColor()&&(!backRBackR.isOccupied())&&backRBackR.getCurrent()!=0);
	}
	
	public boolean blackMustJump(Square square){
		Square frontL=board.get(square.getFrontL());
		Square frontLFrontL=board.get(frontL.getFrontL());
		Square frontR=board.get(square.getFrontR());
		Square frontRFrontR=board.get(frontR.getFrontR());
	return((frontL.isOccupied()&&(!frontL.getColor())&&(!frontLFrontL.isOccupied())&&(frontLFrontL.getCurrent()!=0))
	||(frontR.isOccupied()&&(!frontR.getColor())&&(!frontRFrontR.isOccupied()))&&(frontRFrontR.getCurrent()!=0));
		
	}
	public boolean blackKingMustJump(Square square){
		Square backL=board.get(square.getBackL());
		Square backLBackL=board.get(backL.getBackL());
		Square backR=board.get(square.getBackR());
		Square backRBackR=board.get(backR.getBackR());
		return(blackMustJump(square)||
		((backL.isOccupied()&&(!backL.getColor())&&(!backLBackL.isOccupied())&&backLBackL.getCurrent()!=0)||
		(backR.isOccupied()&&(!backR.getColor())&&(!backRBackR.isOccupied())&&backRBackR.getCurrent()!=0)));		
	}

	public boolean redMovable(Square square, int spot){
		if(spot==0){
			return false;
		}
		return ((!board.get(spot).isOccupied())&&((square.getBackL()==spot)||square.getBackR()==spot));	
	}
	
	
	/*Need to see whether a move is legal
	 * public boolean redMovableR(ArrayList<Square> board, Square square){
		return !board.get(square.getBackR()).isOccupited();
	}*/
	public boolean blackMovable(Square square, int spot){
		if(spot==0){
			return false;
		}
		return ((!board.get(spot).isOccupied())&&((square.getFrontL()==spot)||square.getFrontR()==spot));
	}
	public boolean kingMovable(Square square, int spot){
		return (blackMovable(square, spot)||
				redMovable(square,spot));
	}
	
	private void removePiece(int spot){
		board.get(spot).updateChecker(null);
		
		
		//board.remove(spot);
		//board.add(spot, square);
		
	}
	
	public void move(Checker check, int current, int spot){
		if(spot!=0){
		removePiece(current);//board.get(current).updateChecker(null);
		board.get(spot).updateChecker(check);}
	/*	Square temp=new Square(square.getCurrent(),square.getFrontL(),square.getFrontR(),square.getBackL(),square.getBackR(),null);
		updateGame(temp, square.getCurrent());
		updateGame(square,spot);*/
	}
	public boolean kingJump(Square square, int spot){
		if(square.getColor()){
			Square backL=board.get(square.getBackL());
			Square backLBackL=board.get(backL.getBackL());
			Square backR=board.get(square.getBackR());
			Square backRBackR=board.get(backR.getBackR());
			if(spot!=0&&spot==backL.getBackL()){
				if((backL.isOccupied()&&!backL.getColor()&&(!backLBackL.isOccupied()))){
					move(square.getChecker(),square.getCurrent(),backL.getBackL());
					removePiece(backL.getCurrent());
					updateRed();
					return true;
				}
			}
			else if(spot!=0&&spot==backR.getBackR()){
				if((backR.isOccupied()&&!backR.getColor()&&(!backRBackR.isOccupied()))){
					move(square.getChecker(),square.getCurrent(),backR.getBackR());
					removePiece(backR.getCurrent());
					updateRed();
					return true;}	
			}
			else{
				return blackJump(square,spot);
			}
		}
		else{
			Square frontL=board.get(square.getFrontL());
			Square frontLFrontL=board.get(frontL.getFrontL());
			Square frontR=board.get(square.getFrontR());
			Square frontRFrontR=board.get(frontR.getFrontR());
			if(spot!=0&&spot==frontL.getFrontL()){
				if(frontL.isOccupied()&&(frontL.getColor())&&(!frontLFrontL.isOccupied())){
					move(square.getChecker(),square.getCurrent(),frontL.getFrontL());
					removePiece(frontL.getCurrent());
					updateBlack();
					return true;
				}
				
			}
			else if(spot!=0&&spot==frontR.getFrontR()){
				if(frontR.isOccupied()&&(frontR.getColor())&&(!frontRFrontR.isOccupied())){
					move(square.getChecker(),square.getCurrent(),frontR.getFrontR());
					removePiece(frontR.getCurrent());
					updateBlack();
					return true;
				}
			}
			else{
				return redJump(square,spot);
			}
			
		}
		return false;
	}
	public boolean redJump(Square square, int spot){
		Square backL=board.get(square.getBackL());
		Square backLBackL=board.get(backL.getBackL());
		Square backR=board.get(square.getBackR());
		Square backRBackR=board.get(backR.getBackR());
		if(spot!=0&&spot==backL.getBackL()){
			if((backL.isOccupied()&&backL.getColor()&&(!backLBackL.isOccupied()))){
				move(square.getChecker(),square.getCurrent(),backL.getBackL());
				removePiece(backL.getCurrent());
				updateBlack();
				return true;
			}
		}
		else if(spot!=0&&spot==backR.getBackR()){
			if((backR.isOccupied()&&backR.getColor()&&(!backRBackR.isOccupied()))){
			move(square.getChecker(),square.getCurrent(),backR.getBackR());
			removePiece(backR.getCurrent());
			updateBlack();
			return true;
			}
		}
		else{
			
		//	System.out.println("Illegal move line 180 in actions");
			return false;
		}
		return false;
		//return (backL.isOccupied()&&backL.getColor()&&(!backLBackL.isOccupied()))||
			//	(backR.isOccupied()&&backR.getColor()&&(!backRBackR.isOccupied()));
		
	}
	public boolean blackJump(Square square, int spot){
		Square frontL=board.get(square.getFrontL());
		Square frontLFrontL=board.get(frontL.getFrontL());
		Square frontR=board.get(square.getFrontR());
		Square frontRFrontR=board.get(frontR.getFrontR());
//	((frontL.isOccupied()&&(!frontL.getColor())&&(!frontLFrontL.isOccupied()))
	//||(frontR.isOccupied()&&(!frontR.getColor())&&(!frontRFrontR.isOccupied())));
		if(spot!=0&&spot==frontL.getFrontL()){
			if(frontL.isOccupied()&&(!frontL.getColor())&&(!frontLFrontL.isOccupied())){
				move(square.getChecker(),square.getCurrent(),frontL.getFrontL());
				removePiece(frontL.getCurrent());
				updateRed();
				return true;
			}
			
		}
		else if(spot!=0&&spot==frontR.getFrontR()){
			if(frontR.isOccupied()&&(!frontR.getColor())&&(!frontRFrontR.isOccupied())){
				move(square.getChecker(),square.getCurrent(),frontR.getFrontR());
				removePiece(frontR.getCurrent());
				updateRed();
				return true;
			}
		}
		else{
			//System.out.println("Illegal move line 209 actions");
			return false;
		}
		return false;
	
	}
	public String toString(){
		//System.out.println("toString");
		String string="";
		int z=32;
		for(int i=0;i<8;i++){
			//System.out.println("In the for loop");
			if(i==0||i==2||i==4||i==6){
				string+="  ";
			}
			for(int x=0;x<4;x++){
				
				if(board.get(z).getColor()){
					if(board.get(z).isKing()){
						string+="B";	
					}
					else{
						string+="b";
					}
				}
				else if(board.get(z).getChecker()==null){
					string+="E";
				}
				else{
					if(board.get(z).isKing()){
						string+="R";	
					}
					else{
					string+="r";}
				}
				if(x<3){
				string+="  ";}
				z--;
			}
			if(i==1||i==3||i==5||i==7){
				string+="  ";
			}
			string+="\n";
		}
		
		return string;
	}
	/*
	public boolean blackMovableR(ArrayList<Square> board, Square square){
		return !board.get(square.getFrontR()).isOccupited();
	}*/
}
