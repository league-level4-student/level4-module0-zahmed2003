package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeMaker {

	private static int width;
	private static int height;

	private static Maze maze;

	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();

	public static Maze generateMaze(int w, int h) {
		width = w;
		height = h;
		maze = new Maze(width, height);

		// 4. select a random cell to start
		int r1 = new Random().nextInt(w);
		int r2 = new Random().nextInt(h);


		// 5. call selectNextPath method with the randomly selected cell
		selectNextPath(maze.getCell(r1, r2));

		return maze;
	}

	// 6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		// A. mark cell as visited
		currentCell.setBeenVisited(true);

		
		// B. check for unvisited neighbors using the cell
		ArrayList<Cell> a = getUnvisitedNeighbors(currentCell);
		

		// C. if has unvisited neighbors,
		if(a.size() > 0) {
		// C1. select one at random.
			Cell c = a.get(randGen.nextInt(a.size()));
		// C2. push it to the stack
			uncheckedCells.push(c);
		// C3. remove the wall between the two cells
			removeWalls(currentCell, c);
		// C4. make the new cell the current cell and mark it as visited
			c.setBeenVisited(true);
		// C5. call the selectNextPath method with the current cell
			selectNextPath(c);
		}
		// D. if all neighbors are visited
		else
		{
		// D1. if the stack is not empty
			if(uncheckedCells.isEmpty() == false)
			{
		// D1a. pop a cell from the stack
				
		// D1b. make that the current cell
				
		// D1c. call the selectNextPath method with the current cell
				selectNextPath(uncheckedCells.pop());
			}
		}
	}

	// 7. Complete the remove walls method.
	// This method will check if c1 and c2 are adjacent.
	// If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		if(c1.getY() > 0 && c1.getY() - 1 == c2.getY())
		{
			c1.setNorthWall(false);
			c2.setSouthWall(false);
		}
		if(c1.getX() < maze.getWidth() && c1.getX() + 1 == c2.getX())
		{
			c1.setEastWall(false);
			c2.setWestWall(false);
		}
		if(c1.getY() < maze.getHeight() && c1.getY() + 1 == c2.getY())
		{
			c1.setSouthWall(false);
			c2.setNorthWall(false);
		}
		if(c1.getX() > 0 && c1.getX() - 1 == c2.getX())
		{
			c1.setWestWall(false);
			c2.setEastWall(false);
		}
	}

	// 8. Complete the getUnvisitedNeighbors method
	// Any unvisited neighbor of the passed in cell gets added
	// to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		ArrayList<Cell> un = new ArrayList<Cell>();
		
		if(c.getY() > 0 && maze.getCell(c.getY() - 1, c.getX()).hasBeenVisited() != true) {un.add(maze.getCell(c.getY() - 1, c.getX()));}
		if(c.getX() < maze.getWidth() - 1 && maze.getCell(c.getY(), c.getX() + 1).hasBeenVisited() != true) {un.add(maze.getCell(c.getY(), c.getX() + 1));}
		if(c.getY() < maze.getHeight() - 1 && maze.getCell(c.getY() + 1, c.getX()).hasBeenVisited() != true) {un.add(maze.getCell(c.getY() + 1, c.getX()));}
		if(c.getX() > 0 && maze.getCell(c.getY(), c.getX() - 1).hasBeenVisited() != true) {un.add(maze.getCell(c.getY(), c.getX() - 1));}
		
		return un;
		
		
	}
}
