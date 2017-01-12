import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import control.MindstormControl;
import lejos.pc.comm.NXTComm;
import lejos.pc.comm.NXTCommException;
import lejos.pc.comm.NXTCommFactory;
import lejos.pc.comm.NXTInfo;

public class Main {
	public static void main(String[] args) throws NXTCommException, IOException {
		System.out.println("Connecting..");

		MindstormControl mindstormControl = new MindstormControl("Robogator", "00:16:53:13:1B:B0");
		mindstormControl.BTconnect();
		
		
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String command = "";
		int commandTime = 1;

		while (true) {
			System.out.print("Write a command : ");
			command = br.readLine();
			command = command.toLowerCase();
			commandTime = 1;

			if (command.contains(" ")) {
				commandTime = Integer.parseInt(command.split(" ")[1]);
				command = command.split(" ")[0];
			}

			switch (command) {
			case "exit":
				mindstormControl.BTdisconnect();
				return;
			case "forward":
				mindstormControl.move_forward(commandTime);
				break;
			case "left":
				mindstormControl.turnLeft(commandTime);
				break;
			case "right":
				mindstormControl.turnRight(commandTime);
				break;
			case "backward":
				mindstormControl.move_backward(commandTime);
				break;
			case "stop":
				mindstormControl.stop();
				break;
			case "open":
				mindstormControl.openMouth(commandTime);
				break;
			case "close":
				mindstormControl.closeMouth(commandTime);
				break;
			case "ultrasound":
				System.out.println("Distance : " + mindstormControl.getUltraSonic());
				break;
			}
		}
	}

}
