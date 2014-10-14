/*
THIS IS THE UNIT TEST!!!!!!!!!!!!!!!!!!!!!!!!
I'M SO NERVOUS!!!!!!!!!!!!!!!!!!!!!
I WILL START REVIEW FOR THE DAMN TEST RIGHT NOW!!!!!!!!!
I WON'T BE DISTRACTED ANYMORE!!!!!!!!!!
i hope so
        ------Disppointed Andrew
*/
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
public class Play extends JPanel implements ActionListener 
{
    private Timer timer;
    private Image ball;
    private Image body;
    private Image head;
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private int dot_count;
    private int x[] = new int[900];
    private int y[] = new int[900];
    private int food_x;
    private int food_y;
    private int max_block = 50;
    private int block_size = 10;
    private int WIDTH = max_block*block_size;
    private int HEIGHT = max_block*block_size;
    
    
    
    Random r_a = new Random();

    public Play() 
    {

        addKeyListener(new Dir());
        setBackground(Color.white);
        setFocusable(true);
        setPreferredSize(new Dimension(max_block*block_size, max_block*block_size));
        initImg();
        initGame();
    }

    private void initGame() 
    {
        dot_count = 3;
        for(int z = 0; z<=dot_count; z++)
        {
            x[z] = 10;
            y[z] = 10;
        }
        Food();
        timer = new Timer(150, this);
        timer.start();
    }
    
    @Override
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Draw(g);
    }  

    private void initImg() 
    {

        ImageIcon iid = new ImageIcon(Play.class.getResource("food.png"));
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon(Play.class.getResource("body.png"));
        body = iia.getImage();

        ImageIcon iih = new ImageIcon(Play.class.getResource("head.png"));
        head = iih.getImage();
    }
    
    private void Draw(Graphics g) 
    {
            g.drawImage(body, food_x, food_y, this);
            for(int z=1; z<=dot_count; z++)
            {
                g.drawImage(ball, x[z], y[z], this);
            }
            g.drawImage(head, x[0], y[0], this);
    }

    public void Food() //need fix
    {
    	food_x = Math.abs(r_a.nextInt())%max_block*block_size;
    	food_y = Math.abs(r_a.nextInt())%max_block*block_size;
    }
    
    private void move() 
    {
    	
        for (int z = dot_count ; z > 0; z--) 
        {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }
    	if(up)
    	{
    		y[0]-=block_size;
    	}
    	
    	if(down)
    	{
    		y[0]+=block_size;
    	}
    	
    	if(left)
    	{
    		x[0]-=block_size;
    	}
    	
    	if(right)
    	{
    		x[0]+=block_size;
    	}

    }

    private void getFood()
    {
    	if( x[0] == food_x && y[0] == food_y )
    	{
    		Food();
    		dot_count++;
    	}
    }
    
    private void getOut() 
    {

        if(y[0] < 0)
        {
        	y[0] = HEIGHT;
        }
        
        if(y[0] > HEIGHT)
        {
        	y[0] = -10;
        }
        
        if(x[0] < 0)
        {
        	x[0] = WIDTH;
        }
        
        if(x[0] > WIDTH)
        {
        	x[0] = 0;
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) 
{
    	getFood();	//done
    	getOut();	//done
    	move();		//done
        repaint();
}
    
    public void dis()
    {
    	left = right = up = down = false;
    }

    private class Dir extends KeyAdapter 
    {

        @Override
        public void keyPressed(KeyEvent e) 
        {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (x[1] != x[0]-block_size)) 
            {
            	dis();
            	left = true;
            }

            if ((key == KeyEvent.VK_RIGHT) && (x[1] != x[0]+block_size)) 
            {
            	dis();
            	right = true;
            }

            if ((key == KeyEvent.VK_UP) && (y[1] != y[0]-block_size)) 
            {
            	dis();
            	up = true;
            }

            if ((key == KeyEvent.VK_DOWN) && (y[1] != y[0]+block_size)) 
            {
            	dis();
            	down = true;
            }
        }
    }
}
