import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class Movements {

	public final static int SPEED = 600;
	public static int moving = 0;

	public static void moveForward(final int duration) {
		Thread t = new Thread() {
			public void run() {
				try {
					moving++;
					Motor.C.setSpeed(SPEED);
					Motor.B.setSpeed(SPEED);
					Motor.C.backward();
					Motor.B.backward();

					Thread.sleep(duration);
					moving--;

					if (moving == 0) {
						Motor.C.stop();
						Motor.B.stop();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t.start();
	}

	public static void moveBackward(final int duration) {
		Thread t = new Thread() {
			public void run() {
				try {
					moving++;
					Motor.C.setSpeed(SPEED);
					Motor.B.setSpeed(SPEED);
					Motor.C.forward();
					Motor.B.forward();

					Thread.sleep(duration);
					moving--;

					if (moving == 0) {
						Motor.B.stop();
						Motor.C.stop();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t.start();
	}

	public static void stop() {
		Motor.A.stop();
		Motor.B.stop();
		Motor.C.stop();
	}

	public static void turnRight(final int duration) {
		Thread t = new Thread() {
			public void run() {
				try {
					moving++;
					Motor.B.setSpeed(SPEED);
					Motor.B.backward();
					Motor.C.setSpeed(SPEED);
					Motor.C.forward();

					Thread.sleep(duration);

					moving--;

					if (moving == 0) {
						Motor.C.stop();
						Motor.B.stop();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t.start();
	}

	public static void turnLeft(final int duration) {
		Thread t = new Thread() {
			public void run() {
				try {
					moving++;
					Motor.C.setSpeed(SPEED);
					Motor.C.backward();
					Motor.B.setSpeed(SPEED);
					Motor.B.forward();

					Thread.sleep(duration);

					moving--;

					if (moving == 0) {
						Motor.C.stop();
						Motor.B.stop();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t.start();
	}
	
	public static void openMouth(final int angle){
		Thread t = new Thread() {
			public void run() {
				Motor.A.rotate(45);
			}
		};
		t.start();
	}
	
	public static void closeMouth(final int angle){
		Thread t = new Thread() {
			public void run() {
				Motor.A.rotate(-45);
			}
		};
		t.start();
	}
	
	public static int getUltraSonic(){
		UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S4);
		return sonic.getDistance();
	}
}
