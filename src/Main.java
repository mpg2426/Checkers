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
			}
			board.add(temp);
			
			System.out.println(board.get(x));
			x++;
			}
	
		inputStream.close();
		redPlayer=new Player(redPieces, false);
		blackPlayer=new Player(blackPieces,true);
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
		
			
			if(theAction.endGame()){
				System.out.println("Red won!");
				}
		}
	
	}
	
	

}



