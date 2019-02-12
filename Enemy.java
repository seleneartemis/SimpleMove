import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Enemy extends Draw{
	
	public BufferedImage image;
	public URL resource = getClass().getResource("slimeMove0.png");


	public int xPos = 150;
    public int yPos = 300;
    public int width = 0;
    public int height = 0;
    public int life = 20;
    public boolean idle = true;
    public boolean alive = true;
    public boolean contact = false;

public BufferedImage image;
    public URL resource = getClass().getResource("slime/idle0.png");

    public Monster(Draw comp){
        try{
            image = ImageIO.read(resource);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        animate(comp);
    }

    public Monster(int xPass, int yPass, Draw comp){
        xPos = xPass;
        yPos = yPass;

        try{
            image = ImageIO.read(resource);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        height = image.getHeight();
        width = image.getWidth();

        animate(comp);
    }

    public void animate(Draw compPass){
        Thread monThread = new Thread(new Runnable(){
            public void run(){
                while(idle){
                    for(int ctr = 0; ctr < 5; ctr++){
                        try {
                            if(ctr==4){
                                resource = getClass().getResource("slime/idle0.png");
                            }
                            else{
                                resource = getClass().getResource("slime/idle"+ctr+".png");
                            }
                            
                            try{
                                image = ImageIO.read(resource);
                            }
                            catch(IOException e){
                                e.printStackTrace();
                            }

                            compPass.repaint();
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    if(life<=0){
                        die(compPass);
                    }
                }
            }
        });
        monThread.start();
    }

    public void moveTo(int toX, int toY){
        if(xPos<toX){
            xPos++;
        }
        else if(xPos>toX){
            xPos--;
        }

        if(yPos<toY){
            yPos++;
        }
        else if(yPos>toY){
            yPos--;
        }
    }

    public void die(Draw compPass){
        idle = false;
        if(alive){
            Thread monThread = new Thread(new Runnable(){
                public void run(){
                    for(int ctr = 0; ctr < 4; ctr++){
                        try {                    
                            resource = getClass().getResource("slime/die"+ctr+".png");
                            
                            try{
                                image = ImageIO.read(resource);
                            }
                            catch(IOException e){
                                e.printStackTrace();
                            }
                            compPass.repaint();
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            monThread.start();
        }
        alive = false;
    }
}











	Sprites sprites = new Sprites();


public void reloadImage1(){
		state++;

		if (state == 0){
			resource = getClass().getResource("slimeMove0.png");
		}

		else if (state == 1){
			resource = getClass().getResource("slimeMove1.png");
		}

		else if (state == 2){
			resource = getClass().getResource("slimeMove2.png");
		}

		else if (state == 3){
			resource = getClass().getResource("slimeMove3.png");
		}

		try {
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		} 
	}

	public void slimeAttackAnimation(){
		Thread slimeAttack1 = new Thread(new Runnable(){
			public void run(){
				for (int ctr = 0; ctr <5; ctr++){
					try{
						if (ctr==4){
							resource = getClass().getResource("slimeMove0.png");
						}
						else {
							resource = getClass().getResource("slimeAttack"+ctr+".png");
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
		slimeAttack1.start();
	}



}