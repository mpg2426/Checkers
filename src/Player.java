import java.util.ArrayList;


public class Player {
private ArrayList<Square> player;//=new ArrayList<Square>();
private boolean black;
private int currentChecker;
//private ArrayList<Square> board;
//private Actions theMovement;
public Player(ArrayList<Square> temp/*,ArrayList<Square>board*/, boolean color){
	player=temp;
	black=color;
	//this.board=board;
	//theMovement=thing;
}

/*public void reduceRed(Actions action){
	action.updateRed();
}*/
public boolean isBlack(){
	return black;
}
public Player copy(){
	Player temp=new Player(getPieces(),black);
	return temp;
}
public ArrayList<Square> getPieces(){
	ArrayList<Square> temp=new ArrayList<Square>();
	for(int i=0;i<player.size();i++){
		temp.add(player.get(i).copy());
	}
	
	return temp;
}


public ArrayList<Actions> multipleBlackKingJumps(Actions action, Square tempSquare,int i){
	
	Actions newAction=action.copy();
	ArrayList<Actions> array=new ArrayList<Actions>();
	ArrayList<Square> board=newAction.getBoard();
	
	
	if(newAction.kingJump(tempSquare, board.get(tempSquare.getFrontL()).getFrontL())){

		int spot=board.get(tempSquare.getFrontL()).getFrontL();
		if(newAction.blackKingMustJump(board.get(spot))){
			ArrayList<Actions>temp=(multipleBlackKingJumps(newAction,board.get(spot),spot));
			for(int q=0;q<temp.size();q++){
				array.add(temp.get(q));
			}
			newAction=action.copy();
			board=newAction.getBoard();
			tempSquare=board.get(i);
		}
		else{
		array.add(newAction);
		newAction=action.copy();
		board=newAction.getBoard();
		tempSquare=board.get(i);
	}
	}
	 if((newAction.kingJump(tempSquare, board.get(tempSquare.getFrontR()).getFrontR()))){

			int spot=board.get(tempSquare.getFrontR()).getFrontR();
			if(newAction.blackKingMustJump(board.get(spot))){
				ArrayList<Actions>temp=(multipleBlackKingJumps(newAction,board.get(spot),spot));
				for(int q=0;q<temp.size();q++){
					array.add(temp.get(q));
				}
				newAction=action.copy();
				board=newAction.getBoard();
				tempSquare=board.get(i);
			}
			else{
			array.add(newAction);
			newAction=action.copy();
			board=newAction.getBoard();
			tempSquare=board.get(i);
		}
	}
	 if((newAction.kingJump(tempSquare, board.get(tempSquare.getBackR()).getBackR()))){

			int spot=board.get(tempSquare.getBackR()).getBackR();
			if(newAction.blackKingMustJump(board.get(spot))){
				ArrayList<Actions>temp=(multipleBlackKingJumps(newAction,board.get(spot),spot));
				for(int q=0;q<temp.size();q++){
					array.add(temp.get(q));
				}
				newAction=action.copy();
				board=newAction.getBoard();
				tempSquare=board.get(i);
			}
			else{
			array.add(newAction);
			newAction=action.copy();
			board=newAction.getBoard();
			tempSquare=board.get(i);
		}
	 }
	 if((newAction.kingJump(tempSquare, board.get(tempSquare.getBackL()).getBackL()))){

			int spot=board.get(tempSquare.getBackL()).getBackL();
			if(newAction.blackKingMustJump(board.get(spot))){
				ArrayList<Actions>temp=(multipleBlackKingJumps(newAction,board.get(spot),spot));
				for(int q=0;q<temp.size();q++){
					array.add(temp.get(q));
				}
				newAction=action.copy();
				board=newAction.getBoard();
				tempSquare=board.get(i);
			}
			else{
			array.add(newAction);
			newAction=action.copy();
			board=newAction.getBoard();
			tempSquare=board.get(i);
		}
	}
	
	return array;
	 
}






public ArrayList<Actions> multipleBlackJumps(Actions action, Square tempSquare,int i){
	
	Actions newAction=action.copy();
	ArrayList<Actions> array=new ArrayList<Actions>();
	ArrayList<Square> board=newAction.getBoard();
	
	
	if(newAction.blackJump(tempSquare, board.get(tempSquare.getFrontL()).getFrontL())){
		update(newAction);
		int spot=board.get(tempSquare.getFrontL()).getFrontL();
		if(newAction.blackMustJump(board.get(spot))){
			ArrayList<Actions>temp=(multipleBlackJumps(newAction,board.get(spot),spot));
			for(int q=0;q<temp.size();q++){
				array.add(temp.get(q));
			}
			update(newAction);
			newAction=action.copy();
			board=newAction.getBoard();
			tempSquare=board.get(i);
		}
		else{
			update(newAction);	
		array.add(newAction);
		newAction=action.copy();
		board=newAction.getBoard();
		tempSquare=board.get(i);
	}
	}
	 if((newAction.blackJump(tempSquare, board.get(tempSquare.getFrontR()).getFrontR()))){
		 update(newAction);
			int spot=board.get(tempSquare.getFrontR()).getFrontR();
			if(newAction.blackMustJump(board.get(spot))){
				ArrayList<Actions>temp=(multipleBlackJumps(newAction,board.get(spot),spot));
				for(int q=0;q<temp.size();q++){
					array.add(temp.get(q));
				}
				update(newAction);
				newAction=action.copy();
				board=newAction.getBoard();
				tempSquare=board.get(i);
			}
			else{
			update(newAction);
			array.add(newAction);
			newAction=action.copy();
			board=newAction.getBoard();
			tempSquare=board.get(i);
		}
	}
	 	
	return array;
	 
}








public ArrayList<Actions> multipleRedKingJumps(Actions action, Square tempSquare,int i){
	
	Actions newAction=action.copy();
	ArrayList<Actions> array=new ArrayList<Actions>();
	ArrayList<Square> board=newAction.getBoard();
	Square newSquare=tempSquare.copy();
	
	if(newAction.kingJump(tempSquare, board.get(tempSquare.getFrontL()).getFrontL())){

		int spot=board.get(tempSquare.getFrontL()).getFrontL();
		if(newAction.redKingMustJump(board.get(spot))){
			ArrayList<Actions>temp=(multipleRedKingJumps(newAction,board.get(spot),spot));
			for(int q=0;q<temp.size();q++){
				array.add(temp.get(q));
			}
			newAction=action.copy();
			board=newAction.getBoard();
			tempSquare=board.get(i);
		}
		else{
		array.add(newAction);
		newAction=action.copy();
		board=newAction.getBoard();
		tempSquare=board.get(i);
	}
	}
	 if((newAction.kingJump(tempSquare, board.get(tempSquare.getFrontR()).getFrontR()))){

			int spot=board.get(tempSquare.getFrontR()).getFrontR();
			if(newAction.redKingMustJump(board.get(spot))){
				ArrayList<Actions>temp=(multipleRedKingJumps(newAction,board.get(spot),spot));
				for(int q=0;q<temp.size();q++){
					array.add(temp.get(q));
				}
				newAction=action.copy();
				board=newAction.getBoard();
				tempSquare=board.get(i);
			}
			else{
			array.add(newAction);
			newAction=action.copy();
			board=newAction.getBoard();
			tempSquare=board.get(i);
		}
	}
	 if((newAction.kingJump(tempSquare, board.get(tempSquare.getBackR()).getBackR()))){

			int spot=board.get(tempSquare.getBackR()).getBackR();
			if(newAction.redKingMustJump(board.get(spot))){
				ArrayList<Actions>temp=(multipleRedKingJumps(newAction,board.get(spot),spot));
				for(int q=0;q<temp.size();q++){
					array.add(temp.get(q));
				}
				newAction=action.copy();
				board=newAction.getBoard();
				tempSquare=board.get(i);
			}
			else{
			array.add(newAction);
			newAction=action.copy();
			board=newAction.getBoard();
			tempSquare=board.get(i);
		}
	 }
	 if((newAction.kingJump(tempSquare, board.get(tempSquare.getBackL()).getBackL()))){

			int spot=board.get(tempSquare.getBackL()).getBackL();
			if(newAction.redKingMustJump(board.get(spot))){
				ArrayList<Actions>temp=(multipleRedKingJumps(newAction,board.get(spot),spot));
				for(int q=0;q<temp.size();q++){
					array.add(temp.get(q));
				}
				newAction=action.copy();
				board=newAction.getBoard();
				tempSquare=board.get(i);
			}
			else{
			array.add(newAction);
			newAction=action.copy();
			board=newAction.getBoard();
			tempSquare=board.get(i);
		}
	}
	
	return array;
	 
}





public ArrayList<Actions> multipleRedJumps(Actions action, Square tempSquare,int i){
	
	Actions newAction=action.copy();
	ArrayList<Actions> array=new ArrayList<Actions>();
	ArrayList<Square> board=newAction.getBoard();
	Square newSquare=tempSquare.copy();
	
		 if((newAction.redJump(tempSquare, board.get(tempSquare.getBackR()).getBackR()))){
			 update(newAction);
			int spot=board.get(tempSquare.getBackR()).getBackR();
			if(newAction.redMustJump(board.get(spot))){
				ArrayList<Actions>temp=(multipleRedJumps(newAction,board.get(spot),spot));
				for(int q=0;q<temp.size();q++){
					array.add(temp.get(q));
				}
				update(newAction);
				newAction=action.copy();
				board=newAction.getBoard();
				tempSquare=board.get(i);
			}
			else{
			update(newAction);
			array.add(newAction);
			newAction=action.copy();
			board=newAction.getBoard();
			tempSquare=board.get(i);
		}
	 }
	 if((newAction.redJump(tempSquare, board.get(tempSquare.getBackL()).getBackL()))){
		 update(newAction);
			int spot=board.get(tempSquare.getBackL()).getBackL();
			if(newAction.redMustJump(board.get(spot))){
				ArrayList<Actions>temp=(multipleRedJumps(newAction,board.get(spot),spot));
				for(int q=0;q<temp.size();q++){
					array.add(temp.get(q));
				}
				update(newAction);
				newAction=action.copy();
				board=newAction.getBoard();
				tempSquare=board.get(i);
			}
			else{
				update(newAction);
			array.add(newAction);
			newAction=action.copy();
			board=newAction.getBoard();
			tempSquare=board.get(i);
		}
	}
	
	return array;
	 
}









//Need to worry about multiple moves at a spot, like a king being able to make multiple jumps
public ArrayList<Actions> getNewStates(Actions action){
	setCurrent(-5);
	Actions newAction=action.copy();
	//Actions doubleAction=action.copy();
	update(newAction);
	ArrayList<Actions> array=new ArrayList<Actions>();
	ArrayList<Square> board=newAction.getBoard();
	if(black){
	for(int i=0;i<player.size();i++){
		Square tempSquare=player.get(i);
		
		/*
		 * Issues with my current approach, need to make sure that the checker can actually double jump, I might need
		 * to add another method somewhere to determine if it can multiple jump.  That sounds like a better idea, need to 
		 * add some more lines to check and see if it needs to happen again (I'm sure another function could be used here just
		 * not sure how to implement)
		 * 
		 * How about this, we go back and get the last element, and check to see if it needs to do a diagonal. 
		 */
		if(tempSquare.isKing()){
			if(newAction.blackKingMustJump(tempSquare)){
			//boolean again=false;	
			//int x;
			if(newAction.kingJump(tempSquare, board.get(tempSquare.getFrontL()).getFrontL())){

				int spot=board.get(tempSquare.getFrontL()).getFrontL();
				if(newAction.blackKingMustJump(board.get(spot))){
					ArrayList<Actions>temp=(multipleBlackKingJumps(newAction,board.get(spot),spot));
					for(int q=0;q<temp.size();q++){
						array.add(temp.get(q));
					}
					newAction=action.copy();
					board=newAction.getBoard();
					update(newAction);
					tempSquare=player.get(i);
				}
				else{
				array.add(newAction);
				newAction=action.copy();
				board=newAction.getBoard();
				update(newAction);
				tempSquare=player.get(i);
			}
			}
			 if((newAction.kingJump(tempSquare, board.get(tempSquare.getFrontR()).getFrontR()))){

					int spot=board.get(tempSquare.getFrontR()).getFrontR();
					if(newAction.blackKingMustJump(board.get(spot))){
						ArrayList<Actions>temp=(multipleBlackKingJumps(newAction,board.get(spot),spot));
						for(int q=0;q<temp.size();q++){
							array.add(temp.get(q));
						}
						newAction=action.copy();
						board=newAction.getBoard();
						update(newAction);
						tempSquare=player.get(i);
					}
					else{
					array.add(newAction);
					newAction=action.copy();
					board=newAction.getBoard();
					update(newAction);
					tempSquare=player.get(i);
				}
			}
			 if((newAction.kingJump(tempSquare, board.get(tempSquare.getBackR()).getBackR()))){

					int spot=board.get(tempSquare.getBackR()).getBackR();
					if(newAction.blackKingMustJump(board.get(spot))){
						ArrayList<Actions>temp=(multipleBlackKingJumps(newAction,board.get(spot),spot));
						for(int q=0;q<temp.size();q++){
							array.add(temp.get(q));
						}
						newAction=action.copy();
						board=newAction.getBoard();
						update(newAction);
						tempSquare=player.get(i);
					}
					else{
					array.add(newAction);
					newAction=action.copy();
					board=newAction.getBoard();
					update(newAction);
					tempSquare=player.get(i);
				}
			 }
			 if((newAction.kingJump(tempSquare, board.get(tempSquare.getBackL()).getBackL()))){

					int spot=board.get(tempSquare.getBackL()).getBackL();
					if(newAction.blackKingMustJump(board.get(spot))){
						ArrayList<Actions>temp=(multipleBlackKingJumps(newAction,board.get(spot),spot));
						for(int q=0;q<temp.size();q++){
							array.add(temp.get(q));
						}
						newAction=action.copy();
						board=newAction.getBoard();
						update(newAction);
						tempSquare=player.get(i);
					}
					else{
					array.add(newAction);
					newAction=action.copy();
					board=newAction.getBoard();
					update(newAction);
					tempSquare=player.get(i);
				}
			}

			
			
			
			
			}
			
			else if(!mustJump(newAction)){	
			/*
			 * Need to keep on going through this to make sure that the king can move around, be careful
			 * with the else if's, if one is done, that's it.
			 */
				if(newAction.kingMovable(tempSquare, tempSquare.getFrontL())){
					 newAction.move(tempSquare.getChecker(), tempSquare.getCurrent(), tempSquare.getFrontL());
					array.add(newAction);
					newAction=action.copy();
					update(newAction);
					tempSquare=player.get(i);
				}
				 if(newAction.kingMovable(tempSquare, tempSquare.getFrontR())){
					 newAction.move(tempSquare.getChecker(), tempSquare.getCurrent(), tempSquare.getFrontR());
						array.add(newAction);
						newAction=action.copy();
						update(newAction);
						tempSquare=player.get(i);
					}
				 if(newAction.kingMovable(tempSquare, tempSquare.getBackL())){
					 
					 newAction.move(tempSquare.getChecker(), tempSquare.getCurrent(), tempSquare.getBackL());
						array.add(newAction);
						newAction=action.copy();
						update(newAction);
						tempSquare=player.get(i);
					}
				 if(newAction.kingMovable(tempSquare, tempSquare.getBackR())){
					 
					 newAction.move(tempSquare.getChecker(), tempSquare.getCurrent(), tempSquare.getBackR());
						array.add(newAction);
						newAction=action.copy();
						update(newAction);
						tempSquare=player.get(i);
					}
				

			}
		}
		else if(newAction.blackMustJump(tempSquare)){
				if(newAction.blackJump(tempSquare, board.get(tempSquare.getFrontL()).getFrontL())){
					
					int spot=board.get(tempSquare.getFrontL()).getFrontL();
					if(newAction.blackMustJump(board.get(spot))){
						ArrayList<Actions>temp=(multipleBlackJumps(newAction,board.get(spot),spot));
						for(int q=0;q<temp.size();q++){
							array.add(temp.get(q));
						}
						update(newAction);
						newAction=action.copy();
						board=newAction.getBoard();
						update(newAction);
						tempSquare=player.get(i);
					}
					else{
					update(newAction);
					array.add(newAction);
					newAction=action.copy();
					board=newAction.getBoard();
					update(newAction);	
					tempSquare=player.get(i);
				}
				}
				 if((newAction.blackJump(tempSquare, board.get(tempSquare.getFrontR()).getFrontR()))){

						int spot=board.get(tempSquare.getFrontR()).getFrontR();
						if(newAction.blackMustJump(board.get(spot))){
							ArrayList<Actions>temp=(multipleBlackJumps(newAction,board.get(spot),spot));
							for(int q=0;q<temp.size();q++){
								array.add(temp.get(q));
							}
							update(newAction);
							newAction=action.copy();
							board=newAction.getBoard();
							update(newAction);
							tempSquare=player.get(i);
						}
						else{
						update(newAction);
						array.add(newAction);
						newAction=action.copy();
						board=newAction.getBoard();
						update(newAction);
						tempSquare=player.get(i);
					}
				}
			}
	else if (!mustJump(newAction)){ 
		if(newAction.blackMovable(tempSquare, tempSquare.getFrontL())){
				newAction.move(tempSquare.getChecker(), tempSquare.getCurrent(), tempSquare.getFrontL());
				update(newAction);
				array.add(newAction);
				newAction=action.copy();
				update(newAction);
				tempSquare=player.get(i);
			}
	 if(newAction.blackMovable(tempSquare, tempSquare.getFrontR())){
		newAction.move(tempSquare.getChecker(), tempSquare.getCurrent(), tempSquare.getFrontR());
		update(newAction);
		array.add(newAction);
		newAction=action.copy();
		update(newAction);
		tempSquare=player.get(i);
	}
	/*else{
		System.out.println("How did we end up here? line 133 player");
	}*/
	}
		}
	}
	//The current array in player is only for red or black, don't need to worry about null elements
	else {
		for(int i=0;i<player.size();i++){
			Square tempSquare=player.get(i);
			
			if(tempSquare.isKing()){
				if(newAction.redKingMustJump(tempSquare)){
					if(newAction.kingJump(tempSquare, board.get(tempSquare.getFrontL()).getFrontL())){

						int spot=board.get(tempSquare.getFrontL()).getFrontL();
						if(newAction.redKingMustJump(board.get(spot))){
							ArrayList<Actions>temp=(multipleRedKingJumps(newAction,board.get(spot),spot));
							for(int q=0;q<temp.size();q++){
								array.add(temp.get(q));
							}
							newAction=action.copy();
							board=newAction.getBoard();
							update(newAction);
							tempSquare=player.get(i);
						}
						else{
						array.add(newAction);
						newAction=action.copy();
						board=newAction.getBoard();
						update(newAction);
						tempSquare=player.get(i);
					}
					}
					 if((newAction.kingJump(tempSquare, board.get(tempSquare.getFrontR()).getFrontR()))){

							int spot=board.get(tempSquare.getFrontR()).getFrontR();
							if(newAction.redKingMustJump(board.get(spot))){
								ArrayList<Actions>temp=(multipleRedKingJumps(newAction,board.get(spot),spot));
								for(int q=0;q<temp.size();q++){
									array.add(temp.get(q));
								}
								newAction=action.copy();
								board=newAction.getBoard();
								update(newAction);
								tempSquare=player.get(i);
							}
							else{
							array.add(newAction);
							newAction=action.copy();
							board=newAction.getBoard();
							update(newAction);
							tempSquare=player.get(i);
						}
					}
					 if((newAction.kingJump(tempSquare, board.get(tempSquare.getBackR()).getBackR()))){

							int spot=board.get(tempSquare.getBackR()).getBackR();
							if(newAction.redKingMustJump(board.get(spot))){
								ArrayList<Actions>temp=(multipleRedKingJumps(newAction,board.get(spot),spot));
								for(int q=0;q<temp.size();q++){
									array.add(temp.get(q));
								}
								newAction=action.copy();
								board=newAction.getBoard();
								update(newAction);
								tempSquare=player.get(i);
							}
							else{
							array.add(newAction);
							newAction=action.copy();
							board=newAction.getBoard();
							update(newAction);
							tempSquare=player.get(i);
						}
					 }
					 if((newAction.kingJump(tempSquare, board.get(tempSquare.getBackL()).getBackL()))){

							int spot=board.get(tempSquare.getBackL()).getBackL();
							if(newAction.redKingMustJump(board.get(spot))){
								ArrayList<Actions>temp=(multipleRedKingJumps(newAction,board.get(spot),spot));
								for(int q=0;q<temp.size();q++){
									array.add(temp.get(q));
								}
								newAction=action.copy();
								board=newAction.getBoard();
								update(newAction);
								tempSquare=player.get(i);
							}
							else{
							array.add(newAction);
							newAction=action.copy();
							board=newAction.getBoard();
							update(newAction);
							tempSquare=player.get(i);
						}
					}
					
					}
				else if(!mustJump(newAction)){
			
				 if(newAction.kingMovable(tempSquare, tempSquare.getFrontL())){
					 newAction.move(tempSquare.getChecker(), tempSquare.getCurrent(), tempSquare.getFrontL());
					array.add(newAction);
					newAction=action.copy();
					update(newAction);
					tempSquare=player.get(i);
				}
				 if(newAction.kingMovable(tempSquare, tempSquare.getFrontR())){
					 newAction.move(tempSquare.getChecker(), tempSquare.getCurrent(), tempSquare.getFrontR());
						array.add(newAction);
						newAction=action.copy();
						update(newAction);
						tempSquare=player.get(i);
					}
				 if(newAction.kingMovable(tempSquare, tempSquare.getBackL())){
					 newAction.move(tempSquare.getChecker(), tempSquare.getCurrent(), tempSquare.getBackL());
						array.add(newAction);
						newAction=action.copy();
						update(newAction);
						tempSquare=player.get(i);
					}
				 if(newAction.kingMovable(tempSquare, tempSquare.getBackR())){
					 newAction.move(tempSquare.getChecker(), tempSquare.getCurrent(), tempSquare.getBackR());
						array.add(newAction);
						newAction=action.copy();
						update(newAction);
						tempSquare=player.get(i);
					}
				
			}
			}
			else if(newAction.redMustJump(tempSquare)){
//System.out.println(tempSquare);
				//update(newAction);
				 if((newAction.redJump(tempSquare, board.get(tempSquare.getBackR()).getBackR()))){
					 //update(newAction);	 
						int spot=board.get(tempSquare.getBackR()).getBackR();
						if(newAction.redMustJump(board.get(spot))){
							ArrayList<Actions>temp=(multipleRedJumps(newAction,board.get(spot),spot));
							for(int q=0;q<temp.size();q++){
								array.add(temp.get(q));
							}
							update(newAction);
							newAction=action.copy();
							board=newAction.getBoard();
							update(newAction);
							tempSquare=player.get(i);
							//System.out.println(tempSquare);
						}
						else{
						update(newAction);
						array.add(newAction);
						newAction=action.copy();
						board=newAction.getBoard();
						update(newAction);
						tempSquare=player.get(i);
					}
				 }
				// System.out.println(tempSquare);
				 if((newAction.redJump(tempSquare, board.get(tempSquare.getBackL()).getBackL()))){
					 //update(newAction);
					// System.out.println(tempSquare);
						int spot=board.get(tempSquare.getBackL()).getBackL();
						if(newAction.redMustJump(board.get(spot))){
							
							ArrayList<Actions>temp=(multipleRedJumps(newAction,board.get(spot),spot));
							for(int q=0;q<temp.size();q++){
								array.add(temp.get(q));
							}
							update(newAction);
							newAction=action.copy();
							board=newAction.getBoard();
							update(newAction);
							tempSquare=player.get(i);
						}
						else{
						update(newAction);
						array.add(newAction);
						newAction=action.copy();
						board=newAction.getBoard();
						update(newAction);
						tempSquare=player.get(i);
					}
				
				
				
				
				//These lines are potentially fucked, not sure if you can getBackL getBackL twice
				//System.out.println(tempSquare);
				//System.out.println(player.get(0));
				//Need to get this stuff from some place else
//				while(newAction.redMustJump(tempSquare)){
//					if(newAction.redJump(tempSquare, board.get(tempSquare.getBackL()).getBackL())){
//						array.add(newAction);
//						newAction=action.copy();
//						update(newAction);
//						tempSquare=player.get(i);
//						board=newAction.getBoard();
//					}
//					if(newAction.redJump(tempSquare, board.get(tempSquare.getBackR()).getBackR())){
//						array.add(newAction);
//						newAction=action.copy();
//						update(newAction);
//						tempSquare=player.get(i);
//						board=newAction.getBoard();
//					}
//					else{
//						System.out.println("Should never reach here line 85 player");
//					}
			//	return array;	
				}
			}
		else if(!mustJump(newAction)){ 
			//System.out.println("Printing the current state of newAction");
			//System.out.println(newAction);
			if(newAction.redMovable(tempSquare, tempSquare.getBackL())){
			newAction.move(tempSquare.getChecker(), tempSquare.getCurrent(), tempSquare.getBackL());
					update(newAction);
					array.add(newAction);
					newAction=action.copy();
					update(newAction);
					tempSquare=player.get(i);
				}
		 if(newAction.redMovable(tempSquare, tempSquare.getBackR())){
		//	 System.out.println("Moving back R");
			 
			 newAction.move(tempSquare.getChecker(), tempSquare.getCurrent(), tempSquare.getBackR());
			 update(newAction);
			array.add(newAction);
			newAction=action.copy();
			update(newAction);
			tempSquare=player.get(i);
		}
		/*else{
			System.out.println("How did we end up here? line 237 player");
		}*/
		}
			}

			
		}
	setCurrent(0);
	return array;
}
/*public void updateGame(ArrayList<Square>play/*ArrayList<Square>game){
	player=play;
	//board=game;
}*//*
public void updatePieces(ArrayList<Square>temp){
	player=temp;
}/*
public void updateBoard(ArrayList<Square>temp){
	board=temp;
}*/

//Make sure that functions using this helper function check for the null
public Square getCurrent(int current){
	for(int i=0;i<player.size();i++){
		if(player.get(i).getCurrent()==current){
			return player.get(i);
		}
	}
	return null;
}
private void setCurrent(int ID){
	//System.out.println(ID);
	currentChecker=ID;
}
public boolean mustJump(Actions theMovement){
	update(theMovement);
	if(black){
	for(int i=0;i<player.size();i++){
		if(theMovement.blackMustJump( player.get(i))){
			if(currentChecker==player.get(i).ID()||currentChecker==-5){
			//System.out.println("Black at: " +player.get(i).getCurrent());
			return true;}
			
		}
		else if(player.get(i).isKing()){
			if(theMovement.blackKingMustJump(player.get(i))){
				if(currentChecker==player.get(i).ID()||currentChecker==-5){
						//System.out.println("Black king at: "+ player.get(i).getCurrent());
				return true;}
			}
		}
	}
		return false;
}
	else{
	//System.out.println("in the else statement in mustJump");
		for(int i=0;i<player.size();i++){
			if(theMovement.redMustJump(player.get(i))){
				if(currentChecker==player.get(i).ID()||currentChecker==-5){
				//System.out.println("Red at: "+player.get(i).getCurrent());
				return true;}
			}
			else if(player.get(i).isKing()){
				if(theMovement.redKingMustJump(player.get(i))){
					if(currentChecker==player.get(i).ID()||currentChecker==-5){
					//System.out.println("Red king at: "+player.get(i).getCurrent());
					return true;}
				}
			}
		}
			return false;
		
	}

}
public void update(Actions move){
	ArrayList<Square> board=move.getBoard();
	player.clear();
	for(int i=1;i<board.size();i++){
		if((board.get(i).getColor()==black)&&(board.get(i).getChecker()!=null)){
			if(board.get(i).getColor()&&board.get(i).getFrontL()==0&&board.get(i).getFrontR()==0){
				board.get(i).setKing();
				//System.out.println("Just set a king: ");
			}
			else if((!board.get(i).getColor())&&board.get(i).getBackL()==0&&board.get(i).getBackR()==0){
				//System.out.println("Just set a red king: ");
				board.get(i).setKing();
			}
			player.add(board.get(i));
			//System.out.println(board.get(i));
		}
	}
}

//Returns a boolean value for whether or not the move was allowed,
//Uses the checker ID to keep track of multiple jumps
public boolean makeMove(Actions theMovement,int current, int spot){
	update(theMovement);
	Square temp=getCurrent(current);
	Boolean value=null;
	setCurrent(-5);
if(temp!=null&&temp.getChecker()!=null){
	if(black){
		if(mustJump(theMovement)){
			while(mustJump(theMovement)){
				int tCheck=temp.ID();
			if(temp.isKing()){
				if(theMovement.blackKingMustJump(temp)){
				value=theMovement.kingJump(temp, spot);
				if(value==false){
					return false;
				}
				setCurrent(tCheck);
				update(theMovement);
				
				}
				else{
					//System.out.println("A black king must make the jump");
					return false;
				}
			}
			else if(theMovement.blackMustJump(temp)){
				//System.out.println("Temp's ID AGAIN "+temp.ID());
				value=theMovement.blackJump(temp, spot);
				//System.out.println("Temp's ID AGAIN 2 "+temp.ID());
				if(value==false){
					//System.out.println("Failed black jump line 113");
					return false;
				}
				setCurrent(tCheck);
				update(theMovement);
				
			}
			else{
				//System.out.println("Black Must Jump!");
				return false;
			}
		}
			return value;
		}
		else{
			if(temp.isKing()){
				if(theMovement.kingMovable(temp, spot)){
					theMovement.move(temp.getChecker(), current, spot);
					update(theMovement);
					return true;
				}
				else{
				//	System.out.println("Illegal move line 127");
					return false;
					
				}
			}
			if(theMovement.blackMovable(temp, spot)){
			theMovement.move(temp.getChecker(), current, spot);
			update(theMovement);
			return true;}
			else{
				//System.out.println("Illegal move! line 141");
				return false;
			}
		}
		
	}
	else{
		if(mustJump(theMovement)){
			while(mustJump(theMovement)){
				int tCheck=temp.ID();
			if(temp.isKing()){
				if(theMovement.redKingMustJump(temp)){
					
				value=theMovement.kingJump(temp, spot);
				
				if(value==false){
					return false;
				}
				update(theMovement);
				setCurrent(tCheck);
				}
				else{
					//System.out.println("A red king must make a jump");
					return false;
				}
			}
			else if(theMovement.redMustJump(temp)){
				value=theMovement.redJump(temp, spot);
				if(value==false){
					return false;
				}
				setCurrent(tCheck);
				update(theMovement);
				
			}
			else{
				//System.out.println("Red Must Jump!");
				return false;
			}
		}
			return value;
		}
		else{
			if(temp.isKing()){
				if(theMovement.kingMovable(temp, spot)){
					theMovement.move(temp.getChecker(), current, spot);
					update(theMovement);
					return true;
				}
				else{
					//System.out.println("Illegal move! line 187");
					return false;
				}
			}
			if(theMovement.redMovable(temp, spot)){
				
			theMovement.move(temp.getChecker(), current, spot);
			update(theMovement);
			return true;
			}
			else{
				//System.out.println("Illegal move! line 198");
				return false;
			}
		}	
	}
	}
else{
	//System.out.println("No piece there!");
	return false;
}

}

/*public Actions makeJump(){
	return theMovement;
}*/
}
