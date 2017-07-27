
public class Checker {
	private boolean king;
	private boolean black;
	private int ID;
	
	Checker(boolean color,int id,boolean king){
		black=color;
		this.king=king;
		this.ID=id;
	}
	public Checker copy(){
		Checker copy=new Checker(black, ID,king);
		return copy;
	}
	public boolean setKing(){
		
		king=true;
		return king;
	}
	public boolean isKing(){
		return this.king;
	}
	public boolean isBlack(){
		return black;
	}
	public int getID(){
		return ID;
	}

}
