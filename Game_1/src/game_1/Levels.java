package game_1;

import java.awt.Image;

public class Levels {
	BufferedImageLoader loader = new BufferedImageLoader();
	Image location = null;
	Image starsImg = null;

	public Image locationGen(int lvl, int stars, int starsLvl2) {

		if (lvl == 1) {
			if (stars == 1) {
				location = loader.loadImage("/images/location_1_1star.png");
			} else if (stars == 2) {
				location = loader.loadImage("/images/location_1_2star.png");
			} else if (stars == 3) {
				location = loader.loadImage("/images/location_1_3star.png");
			} else if (stars == 4) {
				location = loader.loadImage("/images/location_1_4star.png");
			} else if (stars == 5) {
				location = loader.loadImage("/images/location_1_5star.png");
			} else {
				System.out.println("Error lvl var!");
			}
		} else if (lvl == 2) {
			if (starsLvl2 == 1) {
				location = loader.loadImage("/images/location_2_1star.png");
			} else if (starsLvl2 == 2) {
				location = loader.loadImage("/images/location_2_2star.png");
			} else if (starsLvl2 == 3) {
				location = loader.loadImage("/images/location_2_3star.png");
			} else if (starsLvl2 == 4) {
				location = loader.loadImage("/images/location_2_4star.png");
			} else if (starsLvl2 == 5) {
				location = loader.loadImage("/images/location_2_5star.png");
			} else {
				System.out.println("Error lvl var!");
			}
		} else {
			System.out.println("Error lvl var!");
		}
		return location;
	}

	public Image starsImage(int lvl, int stars, int starsLvl2) {
		if (lvl == 1) {
			if (stars == 1) {
				starsImg = loader.loadImage("/images/1_stars.png");
			} else if (stars == 2) {
				starsImg = loader.loadImage("/images/2_stars.png");
			} else if (stars == 3) {
				starsImg = loader.loadImage("/images/3_stars.png");
			} else if (stars == 4) {
				starsImg = loader.loadImage("/images/4_stars.png");
			} else if (stars == 5) {
				starsImg = loader.loadImage("/images/5_stars.png");
			} else {
				System.out.println("Error stars var!");
			}
		} else if (lvl == 2) {
			if (starsLvl2 == 1) {
				starsImg = loader.loadImage("/images/1_stars.png");
			} else if (starsLvl2 == 2) {
				starsImg = loader.loadImage("/images/2_stars.png");
			} else if (starsLvl2 == 3) {
				starsImg = loader.loadImage("/images/3_stars.png");
			} else if (starsLvl2 == 4) {
				starsImg = loader.loadImage("/images/4_stars.png");
			} else if (starsLvl2 == 5) {
				starsImg = loader.loadImage("/images/5_stars.png");
			} else {
				System.out.println("Error stars var!");
			}
		}
		// starsLabel.setBounds(43,75,188,41);
		return starsImg;
	}
}
