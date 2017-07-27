import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Board extends JFrame {
JPanel jP=new JPanel();
ArrayList<Checkers> array=new ArrayList<Checkers>(32);
Movement move;
private String printer;
ArrayList<Square> theArray;
	public void setPrinter(String print){
		printer=print;
	}
	public String getPrinter(){
		return printer;
	}
	
	public void update(Actions theAction){
		theArray=theAction.getBoard();
		//array.clear();
		for(int i=1;i<33;i++){
			if(theArray.get(i).isOccupied()&&theArray.get(i).getColor()){
				if(theArray.get(i).isKing()){
					array.get(i).blackKing();
					array.get(i).setText("");
				}else{
				array.get(i).setBlack();
				array.get(i).setText("");}//setText("b");}
				}//(new Checkers(null,"b",move));	}//String.valueOf(i)
			else if (theArray.get(i).isOccupied()&&!theArray.get(i).getColor()){
				if(theArray.get(i).isKing()){
					array.get(i).redKing();
					array.get(i).setText("");
				}else{
				array.get(i).setText("");
				array.get(i).setRed();}//array.add(new Checkers(null,"r",move));
			}
			else if(!theArray.get(i).isOccupied()){
			array.get(i).setText("");
			array.get(i).setNull();//	array.add(new Checkers(null,"",move));
			}
		}
	}
	
	public Board(Actions theAction,Movement move){
		super("Checkers");
		this.move=move;
		theArray=theAction.getBoard();
		setSize(1000,1000);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jP.setLayout(new GridLayout(8,8));
		array.add(new Checkers(null,null,null,0));
		for(int i=1;i<33;i++){
			if(theArray.get(i).isOccupied()&&theArray.get(i).getColor()){
		array.add(new Checkers(null,"b",move,i));	}//String.valueOf(i)
			else if (theArray.get(i).isOccupied()&&!theArray.get(i).getColor()){
				array.add(new Checkers(null,"r",move,i));
			}
			else if(!theArray.get(i).isOccupied()){
				array.add(new Checkers(null,"",move,i));
			}
		}
		int count=32;
		for(int i=1;i<9;i++){
			if(i%2==0){for(int z=1;z<5;z++){
				jP.add(array.get(count));
				jP.add((new Checkers(true,String.valueOf(0),move,0)));
			count--;}}
			else{
				for(int z=1;z<5;z++){
					jP.add((new Checkers(true,String.valueOf(0),move,0)));
				jP.add(array.get(count));
					count--;}
				}
			}
		/*for(int i=1;i<33;i++){
			if(i%2==0)-{jP.add(new JLabel());
			checker[i]=new Checkers(true);
			//else{checker[i]=new Checkers(false);}
			jP.add((checker[i]));}
			else{
				checker[i]=new Checkers(true);
//				else{checker[i]=new Checkers(false);}	
				jP.add((checker[i]));
				jP.add(new JLabel());
			}
		//	jP.add(checker[i]);
			
	//	jP.add(new JButton());
		/*	if(i>40){*///}}
		
		setVisible(true);
		add(jP);
	}

}
