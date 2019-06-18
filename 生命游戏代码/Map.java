package 生命游戏;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class Map extends JFrame{
	
	private static final int ROWS = 40;
	private static final int COLS = 40;
	private static int state[][] = new int[ROWS][COLS];
	private static int nextstate[][] = new int[ROWS][COLS];
	private Container container = this.getContentPane();
	private JTextField textfield[][] = new JTextField[ROWS][COLS];
	private JPanel panel = new JPanel(new GridLayout(ROWS,COLS));
	
	public Map(){
		container.setLayout(null);
		setSize(807,840);
		setTitle("生命游戏");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for(int i=0;i<ROWS;i++) {
			for(int j=0;j<COLS;j++) {
				JTextField text = new JTextField();
				text.setBackground(panel.getBackground());
				textfield[i][j] = text;
				nextstate[i][j] = state[i][j] = 0;
				/*if(Math.random()>0.6) {
					text.setBackground(Color.black);
					nextstate[i][j] = state[i][j] = 1;
				}*/
				/*if((i>=19 && i<=22) && (j>=19 && j<=22)) {
					text.setBackground(Color.black);
					nextstate[i][j] = state[i][j] = 1;
				}*/
				if(i==20 || i==21) {
					text.setBackground(Color.black);
					nextstate[i][j] = state[i][j] = 1;
				}
				panel.add(text);
			}
		}
		panel.setBounds(0, 0, 800, 800);
		container.add(panel);
		setVisible(true);
	}
	
	public int circleCount(int i,int j) {
		int count=0;
		for(int k=i-1;k<=i+1;k++) {
			for(int n=j-1;n<=j+1;n++) {
				if(!(k==i && n==j)) {
					if((k>=0 && k<=ROWS-1) && (n>=0 && n<=COLS-1)) {
						if(state[k][n]==1)
							count++;
					}
				}
			}
		}
		return count;
	}
	
	public void changeState() {
		for(int i=0;i<ROWS;i++) {
			for(int j=0;j<COLS;j++) {
				switch(circleCount(i,j)) {
				case 3:
					nextstate[i][j] = 1;
					break;
				case 2:
					nextstate[i][j] = state[i][j];
					break;
				default:
					nextstate[i][j] = 0;
					break;
				}
			}
		}	
		
	}
	
	public void repaintMap() {
		for(int i=0;i<ROWS;i++) {
			for(int j=0;j<COLS;j++) {
				if(nextstate[i][j]==1) {
					textfield[i][j].setBackground(Color.black);
				}
				else
					textfield[i][j].setBackground(panel.getBackground());
				state[i][j]=nextstate[i][j];
			}
		}
		System.out.print("\n");
	}

}
