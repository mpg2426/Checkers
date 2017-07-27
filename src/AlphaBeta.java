import java.util.ArrayList;


public class AlphaBeta {
	Actions action,returnStateZ;
	Player black,red;
	int depth=5;
	Utility utility;
	public AlphaBeta(Actions action,Player black, Player red){
		this.action=action;
		this.black=black.copy();
		this.red=red.copy();
		this.utility=new Utility(black,action);
	}
	public Player getPlayer(boolean bool){
		if(bool){
			return black.copy();
		}
		else{
			return red.copy();
		}
	}
	
	public Actions helper(boolean bool, Actions acting){
		Actions returnState=null;
		//if(bool){
			ArrayList<Actions>temp=red.getNewStates(acting);
			if(temp.size()==0){
				System.out.println("empty new states");
			}
			int result=-1000000000;
			int high=0;
			//System.out.println(temp.get(3));
			int tempZ=result;
			//int ret=alphabeta(acting.copy(),11,-100000000,1000000000,true);
			System.out.println("After the experimental search");
			for(int i=0;i<temp.size();i++){
				System.out.println("States sending into alphabeta "+i);
				System.out.println(temp.get(i));
				int temporary=alphabeta(temp.get(i).copy(),8,-100000000,1000000000,false);
				System.out.println("This state's value: "+temporary);
				tempZ=Integer.max(tempZ, temporary);
				if(result<temporary){
					
					result=temporary;
					high=i;
				}
			}
		//	if(high<(temp.size()-1)){
		//high++;}
			//System.out.println("Real highest return state: "+ret);
			System.out.println("Should be the same as the second line "+tempZ);
			System.out.println("Highest return state: "+result);
			System.out.println(high);
			System.out.println(temp.get(high));
			returnState=temp.get(high);
		//}
		/*
		else{
			ArrayList<Actions>temp=red.getNewStates(acting);
			int result=100000000;
			for(int i=0;i<temp.size();i++){
				//System.out.println("Before going through alphabeta: "+i);
				//System.out.println(temp.get(i));
				int temporary=alphabeta(temp.get(i),7,-100000000,100000000,true);
			//	System.out.println("After going through alphabeta: "+i);
			//	System.out.println(temp.get(i));
				if(result>temporary){
					result=i;
				}
			}
			
			returnState=temp.get(result);
		}*/
		return returnState;
	}
	
	public Actions returning(){
		return returnStateZ;
	}
	
	public int alphabeta(Actions acting,int depth,int alpha, int beta,boolean max){
	//Going to do the evaluation function for that which called it
		if(depth==0||acting.endGame()){
		Utility temp=new Utility(getPlayer(max),acting.copy());
		int utility=temp.getUtility();
	//	System.out.println("Player "+max);
//		System.out.println("Value of this state: "+utility);
//		System.out.println(acting);
		//System.out.println("Utility: "+utility+" Player: "+!max)	;
		//System.out.println(acting);
		return utility;
		
	}
	 if(max){
		//System.out.println(max);
		ArrayList<Actions>newStates=red.getNewStates(acting);
		for(int i=0;i<newStates.size();i++){
			int result=alphabeta(newStates.get(i),(depth-1),alpha,beta,false);
			if(result>alpha){
				 alpha=result;
				// returnState=newStates.get(i);
			}
			if(alpha>=beta){
//				System.out.println("Alpha is bigger than beta");
//				System.out.println(beta);
//				System.out.println(alpha);
				return alpha;
			}
		}
		return alpha;
	}
	 if(!max){
		//System.out.println(max);
		ArrayList<Actions>newStates=black.getNewStates(acting);
		for(int i=0;i<newStates.size();i++){
			int result=alphabeta(newStates.get(i),(depth-1),alpha,beta,true);
			if(result<beta){
				 beta=result;
			}
			if(beta<=alpha){
//				System.out.println("Beta is less than alpha");
//				System.out.println(beta);
//				System.out.println(alpha);
				return beta;
			}
		}
		return beta;
		
	}
	else{
		System.out.println("Something went wrong in AlphaBeta");
	}
	
	//Need to essentially set the highest valued
	//path by setting it
//	if(max){if(temp> alphabeta)
		
	//}
		System.out.println("Something awful happened");
		return 0;
	}
}
