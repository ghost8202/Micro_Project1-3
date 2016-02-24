package Micro_Project1_3;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Guess extends JFrame {
	String name, score, chance, winMes, loseMes, greatMes, lessMes;
public void game(){
	setTitle("Guess");
	JFrame b = new JFrame();
	FileDialog fd=new FileDialog(b,"pick a file:",FileDialog.LOAD);
	fd.setFile("*.*");	//get only txt files
	fd.setVisible(true);
	String path=fd.getDirectory();
	String file=fd.getFile();
	try {
		FileReader fr=new FileReader(path+"//"+file);
		try {
			BufferedReader br=new BufferedReader(fr);
			    name=br.readLine();
				score=br.readLine();
				chance=br.readLine();
				winMes=br.readLine();
				loseMes=br.readLine();
				greatMes=br.readLine();
				lessMes=br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void random(){ 
	 int guessNum1,fin=0;
	Random rnd = new Random(); 
	int attempts = 0, k; 
	int scr = 100;
	main m=new main();
	int rndNum = rnd.nextInt(100); 
	 //System.out.println(rndNum);
	while(attempts < 10&&fin!=1){ 
		attempts++; 
		scr = scr - 10; 
		 
		String guessNum = JOptionPane.showInputDialog(null, " Guess a number between 1 and 100.","",JOptionPane.CLOSED_OPTION);
		try{
		if(Integer.parseInt(guessNum)==JOptionPane.CLOSED_OPTION){
			m.main(null);
		}}catch(NumberFormatException e){
			
			if(guessNum!=null){guessNum1=0;}else{m.main(null);}
		}
		 try{
		 guessNum1 = Integer.parseInt(guessNum); 
		 }
		 catch(NumberFormatException e){guessNum1=0;}
		if(rndNum < guessNum1){ 
                        k=JOptionPane.showConfirmDialog(null, greatMes+". "+score+scr,"", JOptionPane.CLOSED_OPTION);
                        
                    }else if(rndNum > guessNum1){
                        k=JOptionPane.showConfirmDialog(null, lessMes + ". " + score + scr,"",JOptionPane.CLOSED_OPTION);
                    }else { 
                        k=JOptionPane.showConfirmDialog(null, winMes + ". " + score + scr,"",JOptionPane.CLOSED_OPTION);
		}
		
		if(k==JOptionPane.CLOSED_OPTION){
			m.main(null);
        	System.exit(0);
        }else{
        	k=JOptionPane.showConfirmDialog(null, chance +(10-attempts),"",JOptionPane.CLOSED_OPTION);
        	if(k==JOptionPane.CLOSED_OPTION){
    			m.main(null);
          	System.exit(0);
          }
        }
	} 
	
      k=JOptionPane.showConfirmDialog(null, loseMes,"",JOptionPane.CLOSED_OPTION);
      if(k==JOptionPane.CLOSED_OPTION){
			m.main(null);
      	System.exit(0);
      }

} 
}
