package control;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.pc.comm.NXTComm;
import lejos.pc.comm.NXTCommException;
import lejos.pc.comm.NXTCommFactory;
import lejos.pc.comm.NXTInfo;

public class MindstormControl {
	private NXTComm nxtComm = null;
	private NXTInfo nxt = null;
	DataOutputStream dos;
	DataInputStream dis;
	
	public String name; // "ClapTrap"
	public String macAddress; // "00:16:53:10:10:C3"
	
	public MindstormControl(String name, String macAddress) {
		this.name = name;
		this.macAddress = macAddress;
	}
	
	public void BTconnect() {
		try {
	         nxtComm = NXTCommFactory.createNXTComm(NXTCommFactory.BLUETOOTH);
	         nxt = new NXTInfo(NXTCommFactory.BLUETOOTH, name, macAddress);
	         while(!nxtComm.open(nxt)) {}
	      } catch (NXTCommException e) {
	         e.printStackTrace();
	      }
		
		dos = new DataOutputStream(nxtComm.getOutputStream());
		dis = new DataInputStream(nxtComm.getInputStream());
	}
	
	public void BTdisconnect() {
		try {
			dos.writeInt(2);		
			dos.flush();
			nxtComm.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void turnLeft(int angle) {
		try {
			dos.writeInt(3);
			dos.flush();		    		  
			dos.writeInt(angle);
			dos.flush();
			get_acknowledgement();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void turnRight(int angle) {
		try {
			dos.writeInt(4);
			dos.flush();		    		  
			dos.writeInt(angle);
			dos.flush();
			get_acknowledgement();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void move_forward(int duration) {
		try {
			dos.writeInt(1);
			dos.flush();		    		  
			dos.writeInt(duration);
			dos.flush();
			get_acknowledgement();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void move_backward(int duration) {
		try {
			dos.writeInt(5);
			dos.flush();		    		  
			dos.writeInt(duration);
			dos.flush();
			get_acknowledgement();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void stop() {
		try {
			dos.writeInt(6);
			dos.flush();	
			dos.writeInt(0);
			dos.flush();	
			get_acknowledgement();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void openMouth(int angle) {
		try {
			dos.writeInt(7);
			dos.flush();		    		  
			dos.writeInt(angle);
			dos.flush();
			get_acknowledgement();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void closeMouth(int angle) {
		try {
			dos.writeInt(8);
			dos.flush();		    		  
			dos.writeInt(angle);
			dos.flush();
			get_acknowledgement();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Integer getUltraSonic() {
		try {
			dos.writeInt(9);
			dos.flush();		    		  
			dos.writeInt(0);
			dos.flush();
			return get_acknowledgement();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private Integer get_acknowledgement() throws IOException{
		try {
			int command = dis.readInt();
			
			System.out.println("Command successful.");
			return command;
		} catch (IOException e) {
			failed_acknowledgment();
		}
		return null;
	}
	
	private void failed_acknowledgment() throws IOException{
		System.out.println("Bluetooth connection lost");
		nxtComm.close();
	}
}
