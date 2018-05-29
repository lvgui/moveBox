package moveBox;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JPanel {
	
	// 1:路   0:强   2:目标位置 3：箱子位置 4：人物位置 5  箱子    6 箱子和目标位置
	private BufferedImage wall = null; //墙  0
	private BufferedImage land = null; //路 1
	private BufferedImage person = null; //人物 4
	private BufferedImage box = null; //箱子 3
	private BufferedImage target = null; //2:目标位置
	private BufferedImage targetBox = null; //5 箱子和目标位置
	//人物图片
	//路径位置
	private int row = 4;
	private int col = 2;
	public Game(){
		this.setSize(Config.WIDTH, Config.HEIGHT);
		initImage(); 
	}

	public void initImage() {
			try {
				wall = ImageIO.read(this.getClass().getResource("/res/03.jpg")); //墙
				land = ImageIO.read(this.getClass().getResource("/res/01.jpg")); //路
				person = ImageIO.read(this.getClass().getResource("/res/04.jpg")); //人物起始位置
				box = ImageIO.read(this.getClass().getResource("/res/05.jpg")); //箱子
				target = ImageIO.read(this.getClass().getResource("/res/02.jpg")); //箱子需要推到的目标位置
				targetBox = ImageIO.read(this.getClass().getResource("/res/06.jpg")); //箱子被推到了目标位置
			} catch (IOException e) {
				System.out.println("找不到图片");
			}
	}	
	
	@Override
	public void paint(Graphics g) {
		// 1:路   0:强   2:目标位置 3：箱子位置 4：人物位置 5  箱子    6 箱子和目标位置
		g.setColor(Color.white);
		g.fillRect(0, 0, Config.WIDTH, Config.HEIGHT);
		for (int i = 0; i < Config.map.length; i++){
			for (int j = 0; j < Config.map[i].length; j++) {
				if(Config.map[i][j] == 1){
					g.drawImage(land, j * Config.CELL, i * Config.CELL,null);
				}
				if(Config.map[i][j] == 0){
					g.drawImage(wall, j * Config.CELL, i * Config.CELL,null);
				}				
			}
		}
		for(int i = 0;i < Config.targersBox.length; i++){ //画目标位置
			g.drawImage(target, Config.targersBox[i][1] * Config.CELL, Config.targersBox[i][0] * Config.CELL,null);
		}
		
		for(int m = 0; m < Config.boxFirst.length; m++){ //画箱子
		if(boxRight(Config.boxFirst[m][0],Config.boxFirst[m][1])) {
			g.drawImage(targetBox, Config.boxFirst[m][1] * Config.CELL, Config.boxFirst[m][0] * Config.CELL,null);
		}else {
			g.drawImage(box, Config.boxFirst[m][1] * Config.CELL, Config.boxFirst[m][0] * Config.CELL,null);
		}
	}
		
		
		g.drawImage(person, col * Config.CELL, row * Config.CELL,null); //绘画人

	}

	public void play(int left) {
		switch(left){
		case Config.LEFT:
			if(col - 1 >= 0){
				if(Config.map[row][col - 1] != 0 ) {
					if(!boxLocation(row,col - 1)) {
						col--;
					}else if(col - 2 >= 0){
						if(!boxLocation(row,col - 2) && Config.map[row][col - 2] != 0) {
							boxChange(row,col - 1,Config.LEFT);
							col--;
							
						}
					}
					
				}

			}
			break;
		case Config.RIGHT:
			if(col + 1 <= 9){
				if(Config.map[row][col + 1] != 0 ) {
					if(!boxLocation(row,col + 1)) {
						col++;
					}else if(col + 2 <= 9){
						if(!boxLocation(row,col + 2) && Config.map[row][col + 2] != 0) {
							boxChange(row,col + 1,Config.RIGHT);
							col++;
							
						}
					}
					
				}
			}
			break;
		case Config.UP:
			if(row - 1 >= 0){
				if(Config.map[row - 1][col] != 0 ) {
					if(!boxLocation(row - 1,col)) {
						row--;
					}else if(row - 2 >= 0){
						if(!boxLocation(row - 2,col) && Config.map[row - 2][col] != 0) {
							boxChange(row - 1,col,Config.UP);
							row--;
							
						}
					}
					
				}
			}
			break;
		case Config.DOWN:
			if(row + 1 <= 9){
				if(Config.map[row + 1][col] != 0 ) {
					if(!boxLocation(row + 1,col)) {
						row++;
					}else if(row + 2 <= 9){
						if(!boxLocation(row + 2,col) && Config.map[row + 2][col] != 0) {
							boxChange(row + 1,col,Config.DOWN);
							row++;
							
						}
					}
					
				}
			}
			break;	
		}
		this.repaint();
		gameRight();
	}
	//判断位置上是否有箱子
	public boolean boxLocation(int row,int col) {
		
		for(int m = 0; m < Config.boxFirst.length; m++){
		if(Config.boxFirst[m][0] == row && Config.boxFirst[m][1] == col) {
			return true;
			}
		}
		return false;
	}
	//改变箱子位置
	public void boxChange(int row,int col,int direct) {
		
		for(int m = 0; m < Config.boxFirst.length; m++){
		if(Config.boxFirst[m][0] == row && Config.boxFirst[m][1] == col) {
			if(direct == Config.LEFT) {
				Config.boxFirst[m][1] --;
			}else if(direct == Config.RIGHT){
				Config.boxFirst[m][1] ++;
			}else if(direct == Config.UP) {
				Config.boxFirst[m][0]--;
			}else if(direct == Config.DOWN) {
				Config.boxFirst[m][0]++;
			}		
		}
	}
		
	}
	//确定箱子正确位置
	public boolean boxRight(int row,int col) {
		for(int i = 0;i < Config.targersBox.length;i++) {
			if(Config.targersBox[i][0] == row && Config.targersBox[i][1] == col) {
				return true;
			}
		}
		return false;
	}
	
	public void gameRight() {
		int index = 0;
		for (int j = 0;j < Config.boxFirst.length;j++){
			for(int i = 0;i < Config.targersBox.length;i++) {
				if(Config.targersBox[i][0] == Config.boxFirst[j][0] && Config.targersBox[i][1] == Config.boxFirst[j][1]) {
					index++;
				}
			}
			}
			
		if(index == Config.targersBox.length){
			JOptionPane.showConfirmDialog(null, "你成功进入下一关");
		}
	}
}	

