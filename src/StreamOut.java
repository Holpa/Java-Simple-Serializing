import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class StreamOut {
	private String s=null;
	public StreamOut()
	{
		s="haha";
	}

	public void output()
	{
		try{
			// create a new output stream
			OutputStream os = new FileOutputStream("test.txt");

			// craete a new input stream
			InputStream is = new FileInputStream("test.txt");

			// write something
			os.write(s.getBytes());


		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void Serial()
	{

		try
		{
			FileOutputStream fileOut =
					new FileOutputStream("Obj");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject("GG NO RE");
			out.close();
			fileOut.close();
			System.out.println("Same file as the code");
		}catch(IOException i)
		{
			i.printStackTrace();
		}
	}

	public void getObject()
	{
		try
		{
			FileInputStream fileIn = new FileInputStream("Obj");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			s = (String)in.readObject();
			in.close();
			fileIn.close();
			System.out.println(" OWNED " + s);
		}catch(IOException i)
		{
			i.printStackTrace();
			return;
		}catch(ClassNotFoundException c)
		{
			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
		}
	}


	public static void main(String args[])
	{
		StreamOut so= new StreamOut();
		so.output();
		so.Serial();
		so.getObject();
	}
}
