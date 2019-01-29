import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Draw extends JComponent{

	private BufferedImage image;
	private BufferedImage backgroundImage;
	private URL resource = getClass().getResource("run00.png");

	//circle'sposition
	public int x = 200;
	public int y = 200;
	public int state = 0;

	public Draw(){
		try {
			image = ImageIO.read(resource);
			backgroundImage = ImageIO.read(getClass().getResource("background.jpg"));
		}
		catch(IOException e){
			e.printStackTrace();
		} 
	}

	public void reloadImage(){
		state++;

		if (state == 0){
			resource = getClass().getResource("run00.png");
		}

		else if (state == 1){
			resource = getClass().getResource("run01.png");
		}

		else if (state == 2){
			resource = getClass().getResource("run02.png");
		}

		else if (state == 3){
			resource = getClass().getResource("run03.png");
		}
		
		else if (state == 4){
			resource = getClass().getResource("run04.png");
		}

		else if (state == 5){
			resource = getClass().getResource("run05.png");
			state = 0;
		}

		try {
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		} 
	}


	public void attackAnimation(){
		Thread thread1 = new Thread(new Runnable(){
			public void run(){
				for (int ctr = 0; ctr <5; ctr++){
					try{
						if (ctr==4){
							resource = getClass().getResource("run00.png");
						}
						else {
							resource = getClass().getResource("attack"+ctr+".png");
						}

						try{
							image = ImageIO.read(resource);	

						}catch (IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(100);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		});
		thread1.start();
	}


	public void jumpAnimation(){
		Thread jump1 = new Thread(new Runnable(){
			public void run(){
				for (int ctr = 0; ctr <5; ctr++){
					try{
						if (ctr==4){
							resource = getClass().getResource("run00.png");
						}
						else {
							resource = getClass().getResource("jump"+ctr+".png");
						}

						try{
							image = ImageIO.read(resource);	

						}catch (IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(150);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		});
		jump1.start();
	}



	public void  slideAnimation(){
		Thread slide1 = new Thread(new Runnable(){
			public void run(){
				for (int ctr = 0; ctr <3; ctr++){
					try{
						if (ctr==2){
							resource = getClass().getResource("run00.png");
						}
						else {
							resource = getClass().getResource("slide"+ctr+".png");
						}

						try{
							image = ImageIO.read(resource);	

						}catch (IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(150);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		});
		slide1.start();
	}



	public void attack(){
		attackAnimation();
	}

	public void jump(){
		y = y - 25;
		jumpAnimation();
		x = x + 25;
	}

	public void slide(){
		x = x +25;
		slideAnimation();
	}

	public void moveUp(){
		y=y - 5;
		reloadImage();
		repaint();
		
	}

	public void moveDown(){
		y = y + 5;
		reloadImage();
		repaint();
		
	}

		public void moveRight(){
		x = x + 5;
		reloadImage();
		repaint();
		
	}

		public void moveLeft(){
		x = x - 5;
		reloadImage();
		repaint();
		
	}




	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, this);
		g.drawImage(image, x, y, this);
	}
}