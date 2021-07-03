
public class Integral {
	String t;
	String ans = "";
	float[] tem = new float[10000];
	int e = 0; //indicator
	int j; //indicator
	Integral(String t){
		this.t = t;
	}
	
    String sqrt(String underProcess) {
    	String t= "\\frac{1}"+"{2*"+underProcess+"}";
    	return t;
    }   
    //Delete White Space
    String deleb(String w) {
    	String fin = "";
    	w.trim();
    	if(w.indexOf("^")!=-1) {
    		String be = w.substring(0,w.indexOf("^")-1);
    		String af = w.substring(w.indexOf("^")+1,w.length());
    		int a = Integer.parseInt(be);
    		int b = Integer.parseInt(af);
    		float z = (float) (((float)(a))/((float)(b)+1.00)); //z是高次项的系数
    		int k = b+1;  //k是高次项
    		if(k>e) {
    			e = k;
    		}
    		tem[k] += z;
    	}else {
    	    String ke = w.substring(0,w.indexOf("x"));
    	    int b = Integer.parseInt(ke);
    	    tem[1] += b;
    	}
    	return fin;
    }
    String poly() {
    	int[] counter = new int[30];
    	int j = 0;
    	for(int i=0; i<t.length(); i++) {
    		if(t.charAt(i)=='+'||t.charAt(i)=='-') {
    			counter[j] = i;
    			j++;
    		}
    	}
    	deleb(t.substring(0,counter[0]));
    	for(int i=0; i<j-1; i++) {
    		deleb(t.substring(counter[i]+1,counter[i+1]));
    	}
    	deleb(t.substring(counter[j-1]+1,t.length()));
    	ans += tem[1] + "+";
    	for(int i=2; i<10000; i++) {
    		if(tem[i]!=0) {
    			if(i==e) {
    				ans += tem[i] + "x^" + i;
    			}else {
    				ans += tem[i] + "x^" + i + "+";
    			}
    		}
    	}

		return ans;
    }

}
