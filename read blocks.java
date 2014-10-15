import java.io.BufferedReader;
import java.io.FileReader;

public class Read 
{
	public int[] b_x;
	public int[] b_y;

    public static void main(String[] args)throws Exception
    {
    	String s;
    	
    	//I put my test file in f:/test.txt. of course we will change it will change when it's in Play.java
    	
    	FileReader fr=new FileReader("F:\\test.txt"); 
    	BufferedReader br=new BufferedReader(fr);
    	
		s = br.readLine();
		String[] s_x = s.split(" ");
		s = br.readLine();
		String[] s_y = s.split(" ");
		
		int[] b_x=new int[s_x.length];
		
		for(int i=0; i < s_x.length; i++)
		{
		   b_x[i]=Integer.parseInt(s_x[i]);
		}
		
		int[] b_y=new int[s_y.length];
		
		for(int i=0; i < s_y.length; i++)
		{
		   b_y[i]=Integer.parseInt(s_y[i]);
		}
		
		System.out.println(b_x[1]);
		System.out.println(b_y[2]);
		System.out.println(b_x[3]);
		
    	br.close();
    }
}
