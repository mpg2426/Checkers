import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Checkers extends JButton  implements ActionListener{
ImageIcon black,blackChecker,redChecker,redKing,blackKing;
String source;
Movement movement;
int Number;

public Checkers(Boolean thing,String source, Movement move,int number){
	super(source);
	this.source=source;
	movement=move;
	this.Number=number;
//red=new ImageIcon(this.getClass().getResource("red_checker.png"));
black=new ImageIcon(this.getClass().getResource("black_checker.png"));
blackChecker=new ImageIcon(this.getClass().getResource("A_BLACK.png"));
redChecker=new ImageIcon(this.getClass().getResource("RED_CHECKER.png"));
redKing=new ImageIcon(this.getClass().getResource("RED_KING_CHECKER.png"));
blackKing=new ImageIcon(this.getClass().getResource("BLACK_KING_CHECKER.png"));
addActionListener(this);
//this.createActionListener(source);
if(thing==null){
	setIcon(null);
}
else if(thing){
	setIcon(black);
}

//else if(!thing){
//	setIcon(red);
//}
}

public void blackKing(){
	setIcon(blackKing);
}

public void redKing(){
	setIcon(redKing);
}

public void setBlack(){
	setIcon(blackChecker);
}
public void setNull(){
	setIcon(null);
}

public void setRed(){
	setIcon(redChecker);
}

@Override
public void actionPerformed(ActionEvent e) {
	if(!movement.isFirst()){
		movement.setFrom(Number);
		movement.setFirst(true);
		//notifyAll();
	}
	else if(!movement.isSecond()){
		movement.setTo(Number);
		movement.setSecond(true);
		//notifyAll();
	}
//	if(e.getSource()==String.valueOf(0)){
//		System.out.println("Holy shit");
//	}
	//setText("");
	
	System.out.println(Number);
}
}