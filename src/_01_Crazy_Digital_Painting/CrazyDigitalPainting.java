package _01_Crazy_Digital_Painting;

import java.awt.Color;

public class CrazyDigitalPainting {
	//1. Create two final static integers for the width and height of the display.
static final int width = 1000;
static final int height = 1000;
	
	//2. Create a 2D array of Color objects. You will need to import
	//java.awt.Color. Initialize the size of the array using the 
	//integers created in step 1.
	static Color[][] colors = new Color[height][width];
	
	
	public CrazyDigitalPainting() {
		//3. Open the crazy_digital_painting.png file and look at the image.
		
		//4. Iterate through the 2D array and initialize each Color object
		//   to a new color. The sample image was created using the following 
		//   pattern:
		//   colors[i][j] = new Color(i % 256, (i * j) % 256, j % 256);
		for(int i = 0; i < colors.length; i++)
		{
			for(int j = 0; j < colors[i].length; j++)
			{
				colors[i][j] = new Color(i%256, j%256, (i*j)%256);
			}
		}
		//5. Come up with your own pattern to make a cool crazy image.
		//6. Use the ColorArrayDisplayer class to call the displayColorsAsImage method 
		//   to show off your picture.
	}
	
	public static void main(String[] args) {
		new CrazyDigitalPainting();
		ColorArrayDisplayer.displayColorsAsImage(colors);
	}
}
