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

//	private Image[] i;

	public CanvasFps() {
		super(1280, 720);
//		i[0] = new Image("eagle.png");
//		i[1] = new Image("redbrick.png");
//		i[2] = new Image("purplestone.png");
//		i[3] = new Image("greystone.png");
//		i[4] = new Image("bluestone.png");
//		i[5] = new Image("mossy.png");
//		i[6] = new Image("wood.png");
//		i[7] = new Image("cobblestone.png");
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
				color = Color.WHITE;
				break; // white
			default:
				color = Color.YELLOW;
				break; // yellow
			}

			// give x and y sides different brightness
			if (side == 1) {
				Color a = color.saturate();
				color = a;
			}

			// draw the pixels of the stripe as a vertical line
			drawLine(x, drawStart, x, drawEnd, color);

		}

		double frameTime = getDelta() / 1000;

		double moveSpeed = frameTime * 5.0;
		double rotSpeed = frameTime * 3.0;

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
			double oldDirX = dirX;
			dirX = dirX * Math.cos(-rotSpeed) - dirY * Math.sin(-rotSpeed);
			dirY = oldDirX * Math.sin(-rotSpeed) + dirY * Math.cos(-rotSpeed);
			double oldPlaneX = planeX;
			planeX = planeX * Math.cos(-rotSpeed) - planeY * Math.sin(-rotSpeed);
			planeY = oldPlaneX * Math.sin(-rotSpeed) + planeY * Math.cos(-rotSpeed);
		}

		// rotate to the left
		if (getInput().contains("A") || getInput().contains("LEFT")) {
			// both camera direction and camera plane must be rotated
			double oldDirX = dirX;
			dirX = dirX * Math.cos(rotSpeed) - dirY * Math.sin(rotSpeed);
			dirY = oldDirX * Math.sin(rotSpeed) + dirY * Math.cos(rotSpeed);
			double oldPlaneX = planeX;
			planeX = planeX * Math.cos(rotSpeed) - planeY * Math.sin(rotSpeed);
			planeY = oldPlaneX * Math.sin(rotSpeed) + planeY * Math.cos(rotSpeed);
		}

		drawText("NPMILLI: " + getDelta() + " | X: " + (int) posX + ", Y: " + (int) posY, 10, 30, Color.CYAN);
		drawText("CURRENT INPUT: " + getInput(), 10, 50, Color.CYAN);
	}

	public static void main(String[] args) {
		CanvasFps f = new CanvasFps();
		Application.launch(f.getClass(), args);
	}

}
