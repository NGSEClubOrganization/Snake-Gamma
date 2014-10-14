/*
I have a test in my Stat tomorrow. Although I know that I still finished this code......
WHY DID I DO THAT!!!!!!!!!!!!!!!!!!!!!!
AHHHHHHHH I'M GOING TO REVIEW FOR THE DAMN TEST NOW!!!!!!!!!!
STOP DISTRACTING ME YOU STUPID ECLIPSE!!!!!!!!!!!!!!!!
OKAY I'M DONE.
-------------Disppointed Andrew
*/

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class Snake extends JFrame {



	public Snake() 
	{
        setTitle("Snake");
        setResizable(false);
        add(new Play());
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public static void main(String[] args) 
    {          
                JFrame s_f = new Snake();
                s_f.setVisible(true);
    }
}
