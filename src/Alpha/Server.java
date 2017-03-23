package Alpha;

import java.io.*;
import java.net.ServerSocket;

public class Server {
	
	public static void main(String[] args) throws IOException 
	{
		boolean listening = true;
		if(args.length != 2)
		{
			System.err.println("Usage: java TcpServer listenport tunnelport");
			System.exit(1);
		}
		int i = Integer.parseInt(args[0]);
		int j = Integer.parseInt(args[1]);
		ServerSocket tcptunnelClient = new ServerSocket(i);
		ServerSocket tcptunnelDevice = new ServerSocket(j);

		try {


			while(true)
			{
				while (listening)
				{
					new MultiServerThread(tcptunnelClient.accept(),tcptunnelDevice.accept()).start();
				}
			}

		} 
		catch (IOException e) 
		{
			System.exit(-1);
		}

		tcptunnelDevice.close();
		tcptunnelClient.close();

	}


}
