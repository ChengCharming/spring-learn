package Learn.Socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;



public class Client {

	public static void main(String args[]) {
		try {

			Socket socket = new Socket("localhost", 666);
			System.out.println("Client  ok");
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			boolean shouldContinue = true;
			String clientMsg;
			InputHandler inputHandler = new InputHandler(input);
			inputHandler.start();

			Scanner sc = new Scanner(System.in);

			while (shouldContinue) {
				System.out.println("please input charming :");
				clientMsg = sc.next();
				output.write(clientMsg + "\r");
				output.flush();

				if ("bye".equals(clientMsg)) {
					shouldContinue = false;

				}
			}
			InputHandler.exit = false;
			sc.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static class InputHandler extends Thread {
		BufferedReader reader;
		static boolean exit = true;

		public InputHandler(BufferedReader reader) {
			this.reader = reader;
		}

		public void run() {
			while (exit) {
				try {
					String serverMsg = reader.readLine();
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
