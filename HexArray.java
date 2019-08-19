import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class HexArray
{
	private String path;

	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.out.println("Must give path to input file as argument");
			System.exit(-1);
		}

		HexArray harr = new HexArray(args[0]);
		harr.dumpfile();
	}

	public HexArray(String path)
	{
		this.path = path;
	}
	
	public void dumpfile()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Uint8Array([");
		byte[] data = getBytes(this.path);
		for (int j = 0; j < data.length; j++) 
		{
			sb.append("0x");
			sb.append(String.format("%02x", data[j]));
			if (j < data.length-1)
			{
				sb.append(", ");
			}
		}
		
		sb.append("])");
		System.out.println(sb.toString());
	}
	
	private byte[] getBytes(String path)
	{
		byte[] inBytes = {};
		try
		{
			File file = new File(path);
			inBytes = new byte[(int) file.length()];
			InputStream is = new FileInputStream(file);
			is.read(inBytes);
			is.close();
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return inBytes;
	}
	
}
