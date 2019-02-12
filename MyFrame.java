import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame implements KeyListener{

	Draw drawing;

	public MyFrame() {
		this.drawing = new Draw();
	}

	public void keyPressed(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_UP){
			drawing.moveUp();
			System.out.println("pos: " + drawing.x + ", " + drawing.y);
		}

		else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			System.out.println("pos: " + drawing.x + ", " + drawing.y);
			drawing.moveRight();
		}

		else if (e.getKeyCode() == KeyEvent.VK_DOWN){
			System.out.println("pos: " + drawing.x + ", " + drawing.y);
			drawing.moveDown();
		}


		else if (e.getKeyCode() == KeyEvent.VK_LEFT){
			System.out.println("pos: " + drawing.x + ", " + drawing.y);
			drawing.moveLeft();
		}

		else if (e.getKeyCode() == KeyEvent.VK_C){
			drawing.attack();
			System.out.println("attack");
		}

		else if (e.getKeyCode() == KeyEvent.VK_SPACE){
			drawing.jump();
			System.out.println("jump");
		}

		else if (e.getKeyCode() == KeyEvent.VK_X){
			drawing.slide();
			System.out.println("slide");
		}


		drawing.reloadImage();

	}

	public void keyReleased(KeyEvent e){
		
		


		
	}
	public void keyTyped(KeyEvent e){
	
	}

	public static void main (String args[]){
	MyFrame gameFrame = new MyFrame();
	Draw drawing = new Draw();
	gameFrame.setSize(600,600);
	gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	gameFrame.setVisible(true);
	gameFrame.getContentPane().add(gameFrame.drawing);
	gameFrame.addKeyListener(gameFrame);
	
	}
}