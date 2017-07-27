
public class Square {
	private Integer current;
	private Integer frontL;
	private Integer frontR;
	private Integer backL;
	private Integer backR;
	private Checker checker;
	//private boolean occupied;
	
	 Square(int current, int frontL,int frontR, int backL, int backR, Checker check){
		this.current=current;
		this.frontL=frontL;
		this.frontR=frontR;
		this.backL=backL;
		this.backR=backR;
		this.checker=check;
		/*if(check==null){
			occupied=false;
		}
		else{
			occupied=true;
		}*/
	}
	/*public void setBack(int back1, int back2){
		this.backL=back1;
		this.backR=back2;
	}*/
	 public Square copy(){
		 Square temp;
		 if(checker!=null){
		  temp=new Square(current,frontL,frontR,backL,backR,checker.copy());}
		 else{
			 temp=new Square(current,frontL,frontR,backL,backR,null);
		 }
		 return temp;
	 }
	 public void updateChecker(Checker check){
		 this.checker=check;
	 }
	 public Checker getChecker(){
		 return checker;
	 }
	public boolean getColor(){
		if(checker!=null){
		return this.checker.isBlack();}
		return false;
	}
	public boolean isKing(){
		if(checker!=null){
		return this.checker.isKing();
	}
		return false;}
	public boolean setKing(){
		if(checker!=null&&getColor()){
			if(frontL==0&&frontR==0){
			return	checker.setKing();}
			else{return false;}
		}
		if(checker!=null&&!getColor()){
			if(backL==0&backR==0){
				return checker.setKing();
			}
			else{
				return false;
			}
		}
		return false;
	}
	public Integer getCurrent() {
		return current;
	}
	public Integer getFrontL() {
		return frontL;
	}
	public Integer getFrontR() {
		return frontR;
	}
	public Integer getBackL() {
		return backL;
	}
	public Integer getBackR() {
		return backR;
	}
	public String toString(){
		String string=current+", "+frontL+", "+frontR+", "+backL+", "+backR;
		if (checker!=null &&checker.isBlack()){
			string+=", black"+", "+checker.getID();
		}
		else if (checker!=null){
			string+=", red"+", "+checker.getID();
		}
		return string;
	}
	public int ID(){
		if(checker!=null){
		return checker.getID();}
		//System.out.println("RETURNING NEGATIVE 5");
		return 0;
	}
	public boolean isOccupied(){
		if(checker!=null){
			return true;
		}
		else{
			return false;
		}
	}
}

