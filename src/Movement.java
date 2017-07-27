
public class Movement {
private int from,to;
private boolean first, second;
public Movement(){
	from=0;
	to=0;
	first=false;
	second=false;
}
public boolean isFirst() {
	return first;
}
public void setFirst(boolean first) {
	this.first = first;
}
public boolean isSecond() {
	return second;
}
public void setSecond(boolean second) {
	this.second = second;
}
public int getFrom() {
	return from;
}
public void setFrom(int from) {
	this.from = from;
}
public int getTo() {
	return to;
}
public void setTo(int to) {
	this.to = to;
}

}
