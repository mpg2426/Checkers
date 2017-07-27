import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {

	public static synchronized  void main(String[] args) {
		
		Scanner input=new Scanner (System.in);
		String file="board.txt";
		ArrayList board=new ArrayList<Square>();
		ArrayList redPieces=new ArrayList<Square>();
		ArrayList blackPieces=new ArrayList<Square>();
		//This is a key design feature
		board.add(new Square (0,0,0,0,0, null));
		Player redPlayer;
		Player blackPlayer;
		Scanner inputStream=null;
		try{
			inputStream=new Scanner(new File(file));
		}catch(FileNotFoundException e){
			System.out.println("File not found");
			System.exit(0);
		}
		int x=1;
		System.out.println("Now reading in the values");
		while(inputStream.hasNext()){
			int i,frontL,frontR,backL,backR;
			i=inputStream.nextInt();
			frontL=inputStream.nextInt();
			frontR=inputStream.nextInt();
			backL=inputStream.nextInt();
			backR=inputStream.nextInt();
			//System.out.printf("%d, %d, %d, %d, %d \n",i, frontL, frontR, backL, backR);
			Square temp;
			if(i>0&&i<13){
				 temp=new Square(i, frontL, frontR, backL, backR, new Checker(true,i,false));
			 blackPieces.add(temp);
				 //redPieces.addAll(null);
			}
			else if(i>20){
				 temp=new Square(i, frontL, frontR, backL, backR, new Checker(false,i,false));
				 redPieces.add(temp);
				 //blackPieces.addAll(null);
			}
			else{
				 temp=new Square(i, frontL, frontR, backL, backR, null);
				 //blackPieces.addAll(null);
				 //redPieces.addAll(null);
			}
			board.add(temp);
			
			System.out.println(board.get(x));
			x++;
			}
	
		inputStream.close();
//		int a=14;
//		int b=18;
//		int c=16;
//		int d=19;
//		int e=32;
//		int f=27;
//		int g=26;
//		int h=30;
//		int i=25;
//		int theBlackzy=21;
//		int blackzy2=23;
//		int blackzy3=24;
//		int blackzy4=4;
//		boolean majColor=true;
//		boolean minColor=false;
//		((Square) board.get(a)).updateChecker(new Checker(majColor,a,false));
//		((Square) board.get(b)).updateChecker(new Checker(majColor,b,false));
//		((Square) board.get(c)).updateChecker(new Checker(majColor,c,false));
//		((Square) board.get(d)).updateChecker(new Checker(majColor,d,false));
//		((Square) board.get(e)).updateChecker(new Checker(majColor,e,false));
//		((Square) board.get(f)).updateChecker(new Checker(majColor,f,true));
//		((Square) board.get(g)).updateChecker(new Checker(majColor,g,false));
//		((Square) board.get(h)).updateChecker(new Checker(majColor,h,false));
//		((Square) board.get(i)).updateChecker(new Checker(majColor,i,false));
//		((Square) board.get(theBlackzy)).updateChecker(new Checker(minColor,theBlackzy,false));
//		((Square) board.get(blackzy2)).updateChecker(new Checker(minColor,blackzy2,true));
//		((Square) board.get(blackzy3)).updateChecker(new Checker(minColor,blackzy3,false));
//		((Square) board.get(blackzy4)).updateChecker(new Checker(minColor,blackzy4,false));
		//((Square) board.get(3)).updateChecker(new Checker(false,3,true));
		redPlayer=new Player(redPieces, false);
		blackPlayer=new Player(blackPieces,true);
//		Actions tempAction=new Actions(board,12,12);
//		System.out.println(tempAction);
//		if(tempAction.endGame()){
//			System.out.println("Worked");
//			
//		}
//		else{
//			System.out.println("Failed");
//		}

//		System.out.println("Before the changes");
//		System.out.println(theAction);
//		System.out.println("New states");
		//System.out.println(theAction.toString());
		
//		ArrayList<Actions> thing=blackPlayer.getNewStates(theAction);
//	for(int i=0;i<thing.size();i++){
//			System.out.println(thing.get(i));
//		}
		//AlphaBeta fucked=new AlphaBeta(theAction,blackPlayer,redPlayer);
		//theAction=fucked.helper(false, theAction);
		//fucked.alphabeta(theAction.copy(), 5, -100000, 100000, true);
		//theAction=fucked.returning();
		//System.out.println(theAction);
				


		
		
		Actions theAction=new Actions(board,12,12);
		Movement theMove=new Movement();
		Board theBoard=new Board(theAction, theMove);
		int current=0;
		int spot=0;				
				System.out.println("Black starts");
		while(!theAction.endGame()){
			if(!theAction.gameChange()){
				System.out.println("Updated tally:");
				System.out.println("Red: "+theAction.getRed());
				System.out.println("Black: "+theAction.getBlack());
				theAction.changeScore();
			}
			System.out.println("Black's turn");
			System.out.println(theAction.toString());
			theBoard.update(theAction);
			//current=input.nextInt();
			
			//spot=input.nextInt();
			while(!theMove.isFirst()){
			try {
				Thread.sleep(500);
				current=theMove.getFrom();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			System.out.println("Finished making the first move");
			while(!theMove.isSecond()){
				try {
					Thread.sleep(500);
					spot=theMove.getTo();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Finished making the second move");
				theMove.setFirst(false);
				theMove.setSecond(false);
			while(!blackPlayer.makeMove(theAction, current,spot)){
				theBoard.update(theAction);	
				System.out.println("Redo black");
					//System.out.println(theAction.toString());
					/*current=input.nextInt();
					spot=input.nextInt();*/
					while(!theMove.isFirst()){
						try {
							Thread.sleep(500);//input.wait();
							current=theMove.getFrom();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}}
						
						System.out.println("Again, did the first move");
						while(!theMove.isSecond()){
							try {
								Thread.sleep(500);//								input.wait();
								spot=theMove.getTo();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}}
						System.out.println("Again, did the second move");
							
							theMove.setFirst(false);
							theMove.setSecond(false);
							}
			ArrayList temp=theAction.getBoard();
			/*for(int a=0;a<temp.size();a++){
				System.out.println(temp.get(a));
			}*/
			System.out.println("After Black's move");
			System.out.println(theAction);
			theBoard.update(theAction);
			if(theAction.endGame()){
				System.out.println("Black won!");
				break;
			}
			if(!theAction.gameChange()){
				System.out.println("Updated tally:");
				System.out.println("Red: "+theAction.getRed());
				System.out.println("Black: "+theAction.getBlack());
				theAction.changeScore();
			}
			System.out.println("Red's turn");
			AlphaBeta fucked=new AlphaBeta(theAction,blackPlayer,redPlayer);
			theAction=fucked.helper(false, theAction);
			theBoard.update(theAction);
			//fucked.alphabeta(theAction.copy(), 6, -100000, 100000, true);
			//theAction=fucked.returning();
			//ArrayList<Actions> thing1=redPlayer.getNewStates(theAction);
	/*		for(int i=0;i<thing1.size();i++){
				System.out.println(thing1.get(i));
			}*/
			//AlphaBeta thing=new AlphaBeta(theAction,blackPlayer,redPlayer);
			//theAction=thing.helper(false, theAction);
			//System.out.println(theAction);
			/*System.out.println(theAction.toString());
			current=input.nextInt();
			spot=input.nextInt();
			while(!redPlayer.makeMove(theAction, current, spot)){
			System.out.println("Redo red");
			System.out.println(theAction.toString());
			current=input.nextInt();
			spot=input.nextInt();
		
			}*/
			
			if(theAction.endGame()){
				System.out.println("Red won!");
				}
		}
	
	}
	
	

}




/*PrintWriter output = null;

System.out.println("Starting the program!");
try
{
	output=new PrintWriter(file);
	
}catch (FileNotFoundException e){
	System.out.println("File "+file+" not found");
	System.exit(0);
}
// TODO Auto-generated method stub

/*for(int i=1;i<33;i++){
	int frontL,frontR,backL,backR;
	frontL=input.nextInt();
	frontR=input.nextInt();
	backL=input.nextInt();
	backR=input.nextInt();
	System.out.printf("%d, %d, %d, %d, %d \n",i, frontL, frontR, backL, backR);	
	output.printf("%d %d %d %d %d ",i, frontL, frontR, backL, backR);
}
output.close();*/
