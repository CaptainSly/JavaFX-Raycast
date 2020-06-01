package captainsly.fps;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CanvasFps extends CanvasApplication {

	private int[][] worldMap = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 0, 0, 0, 0, 3, 0, 3, 0, 3, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 2, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 4, 4, 1, 1, 2, 2, 0, 2, 2, 0, 0, 0, 0, 3, 0, 3, 0, 3, 0, 0, 0, 1 },
			{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 2, 3, 4, 5, 6, 8, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
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

	private int texSize = 64;

	private List<Image> textures;

	public CanvasFps() {
		super(640, 480);

		textures = new ArrayList<Image>();
		textures.add(new Image("eagle.png"));
		textures.add(new Image("redbrick.png"));
		textures.add(new Image("purplestone.png"));
		textures.add(new Image("greystone.png"));
		textures.add(new Image("bluestone.png"));
		textures.add(new Image("mossy.png"));
		textures.add(new Image("wood.png"));
		textures.add(new Image("colorstone.png"));

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

			// Texturing
			int texNum = worldMap[mapX][mapY] - 1;
			double wallX;
			if (side == 0)
				wallX = posY + perpWallDist * rayDirY;
			else
				wallX = posX + perpWallDist * rayDirX;

			wallX -= Math.floor(wallX);

			int texX = (int) (wallX * (double) texSize);
			if (side == 0 && rayDirX > 0)
				texX = texSize - texX - 1;
			if (side == 1 && rayDirY < 0)
				texX = texSize - texX - 1;

			double step = 1.0 * texSize / lineHeight;
			double texPos = (drawStart - getCanvasHeight() / 2 + lineHeight / 2) * step;
			for (int y = drawStart; y < drawEnd; y++) {
				int texY = (int) texPos & (texSize - 1);
				texPos += step;
				// Get the pixel reader from the texture, and set the pixel of each line to the
				// color of the texture
				double r, g, b, o;
				r = textures.get(texNum).getPixelReader().getColor(texX, texY).getRed();
				g = textures.get(texNum).getPixelReader().getColor(texX, texY).getGreen();
				b = textures.get(texNum).getPixelReader().getColor(texX, texY).getBlue();
				o = textures.get(texNum).getPixelReader().getColor(texX, texY).getOpacity();

				Color pc = new Color(r, g, b, o);

				if (side == 1)
					pc = pc.darker().darker();

				drawLine(x, y, x, y, pc);
			}

			// Floor Casting
			double floorXWall, floorYWall;

			// 4 different wall directions possible
			if (side == 0 && rayDirX > 0) {
				floorXWall = mapX;
				floorYWall = mapY + wallX;
			} else if (side == 0 && rayDirX < 0) {
				floorXWall = mapX + 1.0;
				floorYWall = mapY + wallX;
			} else if (side == 1 && rayDirY > 0) {
				floorXWall = mapX + wallX;
				floorYWall = mapY;
			} else {
				floorXWall = mapX + wallX;
				floorYWall = mapY + 1.0;
			}

			double distWall, distPlayer, currentDist;

			distWall = perpWallDist;
			distPlayer = 0.0;

			if (drawEnd < 0)
				drawEnd = (int) getCanvasHeight();

			for (int y = drawEnd + 1; y < getCanvasHeight(); y++) {
				currentDist = getCanvasHeight() / (2.0 * y - getCanvasHeight());

				double weight = (currentDist - distPlayer) / (distWall - distPlayer);

				double currentFloorX = weight * floorXWall + (1.0 - weight) * posX;
				double currentFloorY = weight * floorYWall + (1.0 - weight) * posY;

				int floorTexX, floorTexY;
				floorTexX = (int) (currentFloorX * texSize) % texSize;
				floorTexY = (int) (currentFloorY * texSize) % texSize;

				Color floorColor = null;
				Color ceilingColor = null;
				double r, g, b, o;

				r = textures.get(6).getPixelReader().getColor(floorTexX, floorTexY).getRed();
				b = textures.get(6).getPixelReader().getColor(floorTexX, floorTexY).getBlue();
				g = textures.get(6).getPixelReader().getColor(floorTexX, floorTexY).getGreen();
				o = textures.get(6).getPixelReader().getColor(floorTexX, floorTexY).getOpacity();

				ceilingColor = new Color(r, g, b, o);
				drawLine(x, (int) getCanvasHeight() - y, x, (int) getCanvasHeight() - y, ceilingColor);

				r = textures.get(3).getPixelReader().getColor(floorTexX, floorTexY).getRed();
				b = textures.get(3).getPixelReader().getColor(floorTexX, floorTexY).getBlue();
				g = textures.get(3).getPixelReader().getColor(floorTexX, floorTexY).getGreen();
				o = textures.get(3).getPixelReader().getColor(floorTexX, floorTexY).getOpacity();

				floorColor = new Color(r, g, b, o).darker().darker();
				drawLine(x, y, x, y, floorColor);

			}

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
