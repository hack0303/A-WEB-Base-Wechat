package cn.net.www.base;

public class PhoneDigest {
public static final char[] c={'0','1','2','3','4','5','6','7','8','9'};
	public PhoneDigest() {
	// TODO Auto-generated constructor stub
}
public static char getFirstChar(){
	return c[0];
}
public static char getLastChar(){
	return c[9];
}
public static char getCharByIndex(int index){
	if(index<0) return c[0];
	index=index%10;
	return c[index];
}
}
