package Lab02;

import javax.swing.JOptionPane;

public class Lab02Task01 {

	public static void main(String[] args) {
		
		String age = JOptionPane.showInputDialog("What is your age?");
		String name = JOptionPane.showInputDialog("What is your name?");
		String hobby = JOptionPane.showInputDialog("What is your favorite hobby?");
		String movie = JOptionPane.showInputDialog("What is your favorite movie?");
		String color = JOptionPane.showInputDialog("What is your favorite color?");
		String place = JOptionPane.showInputDialog("What is your favorite place?");
		
		String outputMessage = "My name is " + name + ". I am "	+ age + " years old."
			   + " My favorite hobby is " + hobby + " and my favorite movie is "  
			   + movie + ". I love the color " + color + " and I love visiting "
			   + place + "!";
		
		JOptionPane.showMessageDialog(null,outputMessage);

	}

}
