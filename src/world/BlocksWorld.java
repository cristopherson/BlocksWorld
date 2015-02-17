package world;

import java.awt.Color;

import agents.Environment;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.world.World;

public class BlocksWorld extends World<Block>{
	private int gridDimension = 5;
	private Environment env;
	private int offset = 'A';

	public BlocksWorld(Environment env) {
		Grid<Block> newGrid = new BoundedGrid<Block>(gridDimension,
				gridDimension);		
		this.setGrid(newGrid);
		this.setEnv(env);
		
		
		for (int i = 0; i< gridDimension;++i) {
			Color color = new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
			this.add(getRandomEmptyLocation(), new Block(color, "" + (char)(offset + i)));
		}
	}
	
	public int getGridDimension() {
		return gridDimension;
	}

	public void setGridDimension(int gridDimension) {
		this.gridDimension = gridDimension;
	}

	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}
}
