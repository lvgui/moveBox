package moveBox;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	Game game = new Game();
	public MainFrame(){
		super("MingGongV1.0");
		this.setSize(Config.WIDTH,Config.HEIGHT);
		this.setLocation(500, 200);
		this.setResizable(false);
		this.add(game);
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				switch(e.getKeyCode()){
				case KeyEvent.VK_LEFT:
					game.play(Config.LEFT);
					break;
				case KeyEvent.VK_RIGHT:
					game.play(Config.RIGHT);
					break;
				case KeyEvent.VK_UP:
					game.play(Config.UP);
					break;
				case KeyEvent.VK_DOWN:
					game.play(Config.DOWN);
					break;
				case KeyEvent.VK_CONTROL:
					game.play(7);
					break;
				}
			}
		});
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
class a{}
