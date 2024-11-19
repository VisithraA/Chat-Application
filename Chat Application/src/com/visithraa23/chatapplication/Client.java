package com.visithraa23.chatapplication;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 7776);
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
			DataInputStream din = new DataInputStream(socket.getInputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String str = "", str2 = "";
			while (!str.equals("stop")) {
				str = br.readLine();
				dout.writeUTF(str);
				dout.flush();
				str2 = din.readUTF();
				System.out.print("Server Says : " + str2 + "\n");
				dout.flush();
			}
			dout.close();
			din.close();
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
