package BlackDragon;

import java.awt.Color;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
//import static robocode.util.Utils.normalRelativeAngleDegrees;
/**
 * BlackDragon - a robot by Davi R. Lima (br.ucsal)
 * 
 * @DaviRamosLima (original)
 */
public class BlackDragon extends Robot {

	boolean olhar; 
	double mover; 
	double distancia =50;

	
	public void run() {
	
		setBodyColor(Color.black);
		setGunColor(Color.black);
		setRadarColor(Color.white);
		setBulletColor(Color.white);
		setScanColor(Color.white);


		mover = Math.max(getBattleFieldWidth(), getBattleFieldHeight());

		olhar = false;

		turnLeft(getHeading() % 90);
		ahead(mover);

		olhar = true;
		turnGunRight(90);
		turnRight(90);

		while (true) {

			olhar = true;
			
			ahead(mover);
			
			olhar = false;
			
			turnRight(90);
		}
	}

	public void onHitRobot(HitRobotEvent e) {
		
		if (e.getBearing() > -90 && e.getBearing() < 90) {
			back(100);
		} 
		else {
			ahead(100);
		}
	}

	public void onHitByBullet(HitByBulletEvent e) {
//		turnRight(normalRelativeAngleDegrees(90 - (getHeading() - e.getHeading())));
//
//		ahead(distancia);
//		distancia *= -1;
//		scan();
		
		if (e.getBearing() > -90 && e.getBearing() < 90) {
			back(100);
		}
		else {
			ahead(100);
		}
	}
	
	public void onScannedRobot(ScannedRobotEvent e) {
		fire(2);
		if (olhar) {
			scan();
		}
	}
}