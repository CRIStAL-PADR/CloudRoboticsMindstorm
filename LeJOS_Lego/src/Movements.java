import lejos.nxt.Motor;

public class Movements {

	public final static int SPEED = 600;
	public static int moving = 0;

	public static void moveForward(final int duration) {
		Thread t = new Thread() {
			public void run() {
				try {
					moving++;
					Motor.A.setSpeed(SPEED);
					Motor.B.setSpeed(SPEED);
					Motor.A.backward();
					Motor.B.backward();

					Thread.sleep(duration);
					moving--;

					if (moving == 0) {
						Motor.A.stop();
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
					Motor.A.setSpeed(SPEED);
					Motor.B.setSpeed(SPEED);
					Motor.A.forward();
					Motor.B.forward();

					Thread.sleep(duration);
					moving--;

					if (moving == 0) {
						Motor.A.stop();
						Motor.B.stop();
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

	public static void turnRight(final int angle) {
		Thread t = new Thread() {
			public void run() {
				Motor.C.rotate(angle);
			}
		};
		t.start();
	}

	public static void turnLeft(final int angle) {
		Thread t = new Thread() {
			public void run() {
				Motor.C.rotate(-angle);
			}
		};
		t.start();
	}
}
