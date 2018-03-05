package cn.net.www.unit;

import java.util.Random;

public class MathUnit {
public static String returnRandom(int length,int round){
	String out="";
	Random r=new Random();
	for(int i=0;i<length;i++){
		out+=r.nextInt(round);
	}
	return out.trim();
}
}
