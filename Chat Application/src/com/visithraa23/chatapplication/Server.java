package com.visithraa23.chatapplication;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(7776);
			Socket socket = serverSocket.accept();
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
			DataInputStream din = new DataInputStream(socket.getInputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String str = "", str2 = "";
			while (!str.equals("stop")) {
				str = din.readUTF();
				System.out.print("Client Says : " + str + "\n");
				str2 = br.readLine();
				dout.writeUTF(str2);
				dout.flush();
			}

			dout.close();
			din.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
