import java.util.*;

public class Merge {
   static int[] variable = new int[10000];
   public static String merge(String part1, String part2, String a, String b) {
	  String display = "";
	  String[] an = part1.split("[+]");
	  String[] bn = part2.split("[+]");
	  String[] cn = a.split("[+]");
	  String[] dn = b.split("[+]");
	  
	  String ans = "";
	  for(int i=0; i<an.length; i++) {
		  for(int j=0; j<bn.length; j++) {
			  if(an[i].indexOf("^")!=-1) {
		    		String be = an[i].substring(0,an[i].indexOf("^")-1);
		    		String af = an[i].substring(an[i].indexOf("^")+1,an[i].length());
		    		int aw = Integer.parseInt(be);
		    		int bw = Integer.parseInt(af);
		    		//把两个变量的系数以及次数分离一下
		    		String ce = bn[j].substring(0,bn[j].indexOf("^")-1);
		    		String df = bn[j].substring(bn[j].indexOf("^")+1,bn[j].length());
		    		int cw = Integer.parseInt(ce);
		    		int dw = Integer.parseInt(df);
		    		
		    		
		    		int z = bw+dw; //z是高次项的系数
		    		int k = aw*cw;  //k是高次项
		    		
		    		variable[z] += k;
		    	}
			  
			  ans += an[i] + "*" + bn[j] + "+";
		  }
	  }
	  
	  for(int i=0; i<cn.length; i++) {
		  for(int j=0; j<dn.length; j++) {
			  if(cn[i].indexOf("^")!=-1) {
		    		String be = cn[i].substring(0,cn[i].indexOf("^")-1);
		    		String af = cn[i].substring(cn[i].indexOf("^")+1,cn[i].length());
		    		int aw = Integer.parseInt(be);
		    		int bw = Integer.parseInt(af);
		    		//把两个变量的系数以及次数分离一下
		    		String ce = dn[j].substring(0,dn[j].indexOf("^")-1);
		    		String df = dn[j].substring(dn[j].indexOf("^")+1,dn[j].length());
		    		int cw = Integer.parseInt(ce);
		    		int dw = Integer.parseInt(df);
		    		
		    		
		    		int z = bw+dw; //z是高次项的系数
		    		int k = aw*cw;  //k是高次项
		    		
		    		variable[z] += k;
		    	}
			  
			  ans += cn[i] + "*" + dn[j]+ "+";
		  }
	  }
	  
	  for(int i=0; i<10000; i++) {
		  if(variable[i]!=0) {
			  display += variable[i];
			  display += "x";
			  display += "^";
			  display += i;
			  display += "+";
		  }
	  }
	  display = display.substring(0,display.length()-1);
	  System.out.println(Help.merge());
	  System.out.println(ans);
	  System.out.println(display);
	  return ans;
   }   
}
