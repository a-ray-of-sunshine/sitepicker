package com.sunshine.sitepicker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

public class ServerTest {

	public static void server(){
		
		try {
			ServerSocket server = new ServerSocket(1234);
			
			while(true){
				Socket handlerSocket = server.accept();
				PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(handlerSocket.getOutputStream())));
				
				writer.println("server .....");
				writer.flush();
				handlerSocket.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void client(){
		try {
			Socket socket = new Socket("localhost", 1234);

			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String lineText = "";
			while(null != (lineText = reader.readLine())){
				System.out.println(lineText);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void stage(){
		serverThread server = new serverThread();
		server.start();
		client();
	}
	
	class serverThread extends Thread{
		@Override
		public void run() {
			server();
		}
	}
	
}
