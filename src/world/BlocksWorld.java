package world;

import agents.Environment;
import info.gridworld.actor.Actor;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.world.World;

public class BlocksWorld extends World<Actor>{
	private int gridDimension = 5;
	private Environment env;

	public BlocksWorld(Environment env) {
		Grid<Actor> newGrid = new BoundedGrid<Actor>(gridDimension,
				gridDimension);		
		this.setGrid(newGrid);
		this.setEnv(env);
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
