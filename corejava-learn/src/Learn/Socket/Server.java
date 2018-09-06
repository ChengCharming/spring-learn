package Learn.Socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String args[]) {
		try {
			System.out.println("server starting......");
			ServerSocket serverSocket = new ServerSocket(666);
			System.out.println("server  ok wait client connection");

			Socket socket = serverSocket.accept();
			System.out.println("server  has  client  connection");

			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
			boolean shouldContinue = true;
			String serverMsg;
			InputHandler inputHandler = new InputHandler(input);
			inputHandler.start();


			Scanner sc = new Scanner(System.in);

			while (shouldContinue) {


				System.out.println("please input znn :");
				serverMsg = sc.nextLine();

				output.write(serverMsg + "\r");
				output.flush();
				if ("bye".equals(serverMsg)) {
					shouldContinue = false;
				
				}
			}
			InputHandler.exit=false;
			sc.close();
			socket.close();
			serverSocket.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static class InputHandler extends Thread{
		BufferedReader reader;
		static  boolean exit=true;
		public InputHandler(BufferedReader reader) {
			this.reader=reader;

		}
		public void run() {
			while(exit) {
				try {
				String	serverMsg = reader.readLine();
					if ("bye".equals(serverMsg))
						exit = false;
				System.out.println("jinan:" + serverMsg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
}
