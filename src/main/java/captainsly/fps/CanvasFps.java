package captainsly.fps;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CanvasFps extends CanvasApplication {

	private int[][] worldMap = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 0, 0, 0, 0, 3, 0, 3, 0, 3, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 2, 2, 0, 2, 2, 0, 0, 0, 0, 3, 0, 3, 0, 3, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 4, 0, 4, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 4, 0, 0, 0, 0, 5, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 4, 0, 4, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 4, 0, 4, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	
	private double posX = 22, posY = 12;
	private double dirX = -1, dirY = 0;
	private double planeX = 0, planeY = 0.66;

	public CanvasFps() {
		super(1080, 720);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		super.start(primaryStage);

		primaryStage.setTitle("Raycaster");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	@Override
	public void render() {
		// FLOOR AND CEILING CAST -
		// Uncomment for the ceiling and floor, currently lags the
		// program since each individual pixel is being drawn every
		// frame
//		for (int y = 0; y < getCanvasHeight(); y++) {
//			// rayDir for leftmost ray (x = 0) and rightmost ray (x = width)
//			float rayDirX0 = (float) (dirX - planeX);
//			float rayDirY0 = (float) (dirY - planeY);
//			float rayDirX1 = (float) (dirX + planeX);
//			float rayDirY1 = (float) (dirY + planeY);
//
//			// Current y position compared to the center of the screen (the horizon)
//			int p = (int) (y - getCanvasHeight() / 2);
//
//			// Vertical position of the camera
//			float posZ = (float) (0.5 * getCanvasHeight());
//
//			// Horizontal distance from the camera to the floor for the current row
//			// 0.5 is the z position exactly in the middle between floor and ceiling
//			float rowDistance = posZ / p;
//
//			// Calculate the real world step vector we have to add for each x (parallel to
//			// camera plane)
//			// adding step by step avoids multiplications with a weight in the inner loop
//			float floorStepX = (float) (rowDistance * (rayDirX1 - rayDirX0) / getCanvasWidth());
//			float floorStepY = (float) (rowDistance * (rayDirY1 - rayDirY0) / getCanvasWidth());
//
//			// The Pixel colors of the ceiling and floor
//			Color floorColor = Color.BROWN.darker().darker();
//			Color ceilingColor = Color.SILVER;
//
//			// Real world coordinates of the left most column. This will be updated as we
//			// step to the right
//			float floorX = (float) (posX + rowDistance * rayDirX0);
//			float floorY = (float) (posY + rowDistance * rayDirY0);
//
//			for (int x = 0; x < getCanvasWidth(); x++) {
//
//				drawPixel(x, y, floorColor);
//				drawPixel(x, (int) (getCanvasHeight() - y - 1), ceilingColor);
//			}
//
//		}

		// WALL CASTING
		for (int x = 0; x < getCanvasWidth(); x++) {
			double cameraX = 2 * x / (double) getCanvasWidth() - 1; // X-Coordinate in Camera Space
			double rayDirX = dirX + planeX * cameraX;
			double rayDirY = dirY + planeY * cameraX;

			int mapX = (int) posX;
			int mapY = (int) posY;

			double sideDistX;
			double sideDistY;

			double deltaDistX = (rayDirY == 0) ? 0 : ((rayDirX == 0) ? 1 : Math.abs(1 / rayDirX));
			double deltaDistY = (rayDirX == 0) ? 0 : ((rayDirY == 0) ? 1 : Math.abs(1 / rayDirY));
			double perpWallDist;

			int stepX;
			int stepY;

			int hit = 0;
			int side = 0;

			// calculate step and initial sideDist
			if (rayDirX < 0) {
				stepX = -1;
				sideDistX = (posX - mapX) * deltaDistX;
			} else {
				stepX = 1;
				sideDistX = (mapX + 1.0 - posX) * deltaDistX;
			}
			if (rayDirY < 0) {
				stepY = -1;
				sideDistY = (posY - mapY) * deltaDistY;
			} else {
				stepY = 1;
				sideDistY = (mapY + 1.0 - posY) * deltaDistY;
			}

			while (hit == 0) {
				// jump to next map square, OR in x-direction, OR in y-direction
				if (sideDistX < sideDistY) {
					sideDistX += deltaDistX;
					mapX += stepX;
					side = 0;
				} else {
					sideDistY += deltaDistY;
					mapY += stepY;
					side = 1;
				}
				// Check if ray has hit a wall
				if (worldMap[mapX][mapY] > 0)
					hit = 1;
			}

			// Calculate distance projected on camera direction (Euclidean distance will
			// give fisheye effect!)
			if (side == 0)
				perpWallDist = (mapX - posX + (1 - stepX) / 2) / rayDirX;
			else
				perpWallDist = (mapY - posY + (1 - stepY) / 2) / rayDirY;

			// Calculate height of line to draw on screen
			int lineHeight = (int) (getCanvasHeight() / perpWallDist);

			// calculate lowest and highest pixel to fill in current stripe
			int drawStart = (int) (-lineHeight / 2 + getCanvasHeight() / 2);
			if (drawStart < 0)
				drawStart = 0;
			int drawEnd = (int) (lineHeight / 2 + getCanvasHeight() / 2);
			if (drawEnd >= getCanvasHeight())
				drawEnd = (int) (getCanvasHeight() - 1);

//			// Texturing Calculations
//			int texNum = worldMap[mapX][mapY] - 1;
//
//			// Calculate value of wallx
//			double wallX;
//			if (side == 0)
//				wallX = posY + perpWallDist * rayDirY;
//			else
//				wallX = posX + perpWallDist * rayDirX;
//			wallX -= Math.floor(wallX);
//
//			int texX = (int) (wallX * 64);
//			if (side == 0 && rayDirX > 0)
//				texX = 64 - texX - 1;
//			if (side == 1 && rayDirY < 0)
//				texX = 64 - texX - 1;
//
//			double step = 1.0 * 64 / lineHeight;
//
//			// Starting texture coordinate
//			double texPos = (drawStart - getCanvasHeight() / 2 + lineHeight / 2) * step;
//			for (int y = drawStart; y < drawEnd; y++) {
//				// Cast the texture coordinate to integer, and mask with (64 - 1) in case of
//				// overflow
//				int texY = (int) texPos & (64 - 1);
//				texPos += step;
//
//				Image wallImg = null;
//				switch (worldMap[mapX][mapY]) {
//				case 1:
//					wallImg = new Image("redbrick.png");
//					break;
//				case 2:
//					wallImg = new Image("colorstone.png");
//					break;
//				case 3:
//					wallImg = new Image("bluestone.png");
//					break;
//				case 4:
//					wallImg = new Image("greystone.png");
//					break;
//				default:
//					wallImg = new Image("wood.png");
//				}
//
//				drawImage(wallImg, x, y, 64, 64);
//			}

			Color color;
			switch (worldMap[mapX][mapY]) {
			case 1:
				color = Color.RED;
				break; // red
			case 2:
				color = Color.GREEN;
				break; // green
			case 3:
				color = Color.BLUE;
				break; // blue
			case 4:
				color = Color.ORANGE;
				break; // white
			case 5:
				color = Color.PURPLE;
				break;
			case 6:
				color = Color.TURQUOISE;
				break;
			case 7:
				color = Color.BROWN;
				break;
			case 8:
				color = Color.YELLOW;
				break;
			default:
				color = Color.YELLOW;
				break; // yellow
			}

			// give x and y sides different brightness
			if (side == 1) {
				Color a = color.darker().darker();
				color = a;
			}

			// draw the pixels of the stripe as a vertical line
			drawLine(x, drawStart, x, drawEnd, color);
		}

		double frameTime = getDelta() / 1000;

		double moveSpeed = frameTime * 5.0;
		double rotSpeed = frameTime * 3.0;

		if (getInput().contains("SHIFT")) {
			moveSpeed *= 2.0f;
		}

		// Up Input
		if (getInput().contains("W") || getInput().contains("UP")) {
			if (worldMap[(int) (posX + dirX * moveSpeed)][(int) posY] == 0)
				posX += dirX * moveSpeed;
			if (worldMap[(int) posX][(int) (posY + dirY * moveSpeed)] == 0)
				posY += dirY * moveSpeed;
		}

		// Down input
		if (getInput().contains("S") || getInput().contains("DOWN")) {
			if (worldMap[(int) (posX - dirX * moveSpeed)][(int) (posY)] == 0)
				posX -= dirX * moveSpeed;
			if (worldMap[(int) (posX)][(int) (posY - dirY * moveSpeed)] == 0)
				posY -= dirY * moveSpeed;
		}

		// rotate to the right
		if (getInput().contains("D") || getInput().contains("RIGHT")) {
			// both camera direction and camera plane must be rotated
			rotate(-rotSpeed);
		}

		// rotate to the left
		if (getInput().contains("A") || getInput().contains("LEFT")) {
			// both camera direction and camera plane must be rotated
			rotate(rotSpeed);
		}

		drawText("TPS: " + getDelta() + " | X: " + (int) posX + ", Y: " + (int) posY + " | RotationX: " + planeX
				+ ", RotationY: " + planeY, 10, 20, Color.CYAN);
		drawText("CURRENT SPEED: " + moveSpeed, 10, 40, Color.CYAN);
		drawText("CONTROLS: WASD|ARROWS Move, SHIFT Increase movement", 10, 60, Color.CYAN);
	}

	public void rotate(double angle) {
		double oldDirX = dirX;
		dirX = dirX * Math.cos(angle) - dirY * Math.sin(angle);
		dirY = oldDirX * Math.sin(angle) + dirY * Math.cos(angle);
		double oldPlaneX = planeX;
		planeX = planeX * Math.cos(angle) - planeY * Math.sin(angle);
		planeY = oldPlaneX * Math.sin(angle) + planeY * Math.cos(angle);
	}

	public static void main(String[] args) {
		CanvasFps f = new CanvasFps();
		Application.launch(f.getClass(), args);
	}

}
