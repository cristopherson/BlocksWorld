package world;

import java.awt.Color;
import java.util.ArrayList;

import ontology.action.Pickdown;
import ontology.action.Pickup;

import agents.Environment;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class BlocksWorld extends World<Block>{
	private int gridDimension = 5;
	private Environment env;
	private int offset = 'A';
	private int index = 0;
	private boolean up = false;

	public BlocksWorld(Environment env) {
		Grid<Block> newGrid = new BoundedGrid<Block>(gridDimension,
				gridDimension);		
		this.setGrid(newGrid);
		this.setEnv(env);
		
		
		for (int i = 0; i< gridDimension;++i) {
			Color color = new Color((int)(Math.random() * 256) + 1, (int)(Math.random() * 256) + 1, (int)(Math.random() * 256) + 1);
			Block block = new Block(color, "" + (char)(offset + i));
			int col = ((int)(Math.random()  * gridDimension));
			int row = gridDimension - 1;
			
			while(row >=0 && this.getGrid().get(new Location(row, col)) != null) row--;
			this.add(new Location(row, col), block);				
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
	
	@Override
	public void step() {
		ArrayList<Location> list = this.getGrid().getOccupiedLocations();
		if(index >= gridDimension) {
			index = 0;
			up = !up;
		}
		
		Block block = this.getGrid().get(list.get(index));
		Pickup pickup = new Pickup(block);
		Pickdown pickdown = new Pickdown(block);
		if(!up)
			pickup.execute(env);
		else
			pickdown.execute(env);
		
		index++;		
	}
	
	
}
