import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class UserInterface extends JFrame implements ActionListener{
	JTextField input = new JTextField("");
	public void new_interface(){
		JFrame frame = new JFrame("Calculus Helper");
		JPanel panel = new JPanel();
		JPanel subPenel = new JPanel();
		JPanel subPenel2 = new JPanel();
		JPanel subPenel3 = new JPanel();
		//Create Object
		
	    frame.setSize(300,100);
	    frame.setResizable(true);
	    //Set Frame
	 
	    JButton button = new JButton("Calculate");
	    JButton number1 = new JButton("1");
	    JButton number2 = new JButton("2");
	    JButton number3 = new JButton("3");
	    JButton number4 = new JButton("4");
	    JButton number5 = new JButton("5");
	    JButton number6 = new JButton("6");
	    JButton number7 = new JButton("7");
	    JButton number8 = new JButton("8");
	    JButton number9 = new JButton("9");
	    
	    button.addActionListener(this);
	    
	    
	    input.addActionListener(this);
	    //Key Component
	    
	    panel.setLayout(new GridLayout(5,1));
	    subPenel.setLayout(new GridLayout(1,3));
	    subPenel2.setLayout(new GridLayout(1,3));
	    subPenel3.setLayout(new GridLayout(1,3));
	    panel.add(input);
	    panel.add(button);
	    subPenel.add(number1);
	    subPenel.add(number2);
	    subPenel.add(number3);
	    subPenel2.add(number4);
	    subPenel2.add(number5);
	    subPenel2.add(number6);
	    subPenel3.add(number7);
	    subPenel3.add(number8);
	    subPenel3.add(number9);
	    panel.add(subPenel);
	    panel.add(subPenel2);
	    panel.add(subPenel3);
	    //Make Panel
	    
	    frame.add(panel);
	    //Add Panel
	    frame.setVisible(true); //Must set true
	    frame.setLayout(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent event){
	   String number = input.getText();
	   int index = number.indexOf(")*(");
	   int intr = number.indexOf("integral");
	   if (intr!=-1) {
		   
		   Integral a = new Integral(number.substring(9,number.length()-1));
		   System.out.println(a.poly().substring(4));
	   }else {
		   System.out.println(1);
		   if (index!=-1) {
			   boolean tight = true;
			   if(index==-1) {
				   index = number.indexOf(") * (");
				   tight = false;
			   }
			   String part1 = number.substring(1,index);
			   String part2 = number.substring(index+3,number.length()-1);
			   System.out.println(Help.product_rule());
			   
			   Derivative t = new Derivative(part1);
			   Derivative q = new Derivative(part2);
			   String a = t.poly();
			   String b = q.poly();
			   System.out.println("(" + a + ")" + "*" +  "(" + part2 + ")" + "+" + "(" + b + ")" + "*" + "(" + part1 + ")");
			   String end = Merge.merge(a, part2, b, part1);
		   }else {
			   Derivative result = new Derivative(number);
			   String ans = result.poly();
			   System.out.println(ans.substring(2));
		   }
	   }
		  
	   
     //  Separate c = new Separate(input.getText());
    //   c.process();
       
    //   int w = c.arr.length;
    //   for(int i=0; i<w; i++) {
    ///	   System.out.println(c.arr[i]);
    //   }
       /*
       Derivative t = new Derivative();
	   String b = t.sqrt("4x");
	   System.out.println(b);
		*/
	}

	
}

