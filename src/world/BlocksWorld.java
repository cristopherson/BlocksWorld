package world;

import jade.content.ContentElementList;
import jade.content.ContentManager;
import jade.content.lang.Codec.CodecException;
import jade.content.onto.OntologyException;
import jade.core.AID;
import jade.lang.acl.ACLMessage;

import java.awt.Color;
import java.util.ArrayList;

import ontology.action.Executable;
import ontology.concept.BlockConcept;
import ontology.predicate.Holding;
import ontology.predicate.On;
import ontology.predicate.Ontable;

import agents.Environment;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class BlocksWorld extends World<Block> {
	private int gridDimension = 5;
	private Environment env;
	private int offset = 'A';
	private ArrayList<Executable>actionList;

	public BlocksWorld(Environment env) {
		setActionList(new ArrayList<Executable>());
		Grid<Block> newGrid = new BoundedGrid<Block>(gridDimension,
				gridDimension);
		this.setGrid(newGrid);
		this.setEnv(env);

		for (int i = 0; i < gridDimension; ++i) {
			Color color = new Color((int) (Math.random() * 254) + 1,
					(int) (Math.random() * 254) + 1,
					(int) (Math.random() * 254) + 1);
			Block block = new Block(color, "" + (char) (offset + i));
			int col = ((int) (Math.random() * gridDimension));
			int row = gridDimension - 1;

			while (row >= 0
					&& this.getGrid().get(new Location(row, col)) != null)
				row--;
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
		
		if(!actionList.isEmpty()) {
			Executable action = actionList.remove(0);
			action.execute(env);
			return;
		}
		
		ArrayList<Location> list = this.getGrid().getOccupiedLocations();
		ContentManager contentManager = env.getContentManager();
		ContentElementList cel = new ContentElementList();

		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		msg.addReceiver(new AID("block", AID.ISLOCALNAME));
		msg.setLanguage("fipa-sl");
		msg.setOntology("blocks-ontology");

		for (Location location : list) {
			Block block = this.getGrid().get(location);

			if (block.getColor() == Color.BLACK) {
				cel.add(new Holding(env.getWorld().convert(block), true));
			} else {
				if (location.getRow() == env.getWorld().getGridDimension() - 1) {
					cel.add(new Ontable(env.getWorld().convert(block), true));
				}
				if (location.getRow() != 0) {
					Location block2Location = new Location(
							location.getRow() - 1, location.getCol());
					Block block2 = env.getWorld().getGrid().get(block2Location);
					if (block2 != null) {
						cel.add(new On(env.getWorld().convert(block), env
								.getWorld().convert(block2), true));
					}
				}
			}
		}

		try {
			contentManager.fillContent(msg, cel);
		} catch (CodecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OntologyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		env.send(msg);
	}

	public BlockConcept convert(Block block) {
		ArrayList<Location> locations = this.getGrid().getOccupiedLocations();

		for (Location location : locations) {
			Block currentBlock = this.getGrid().get(location);
			if (currentBlock != null
					&& currentBlock.getText() == block.getText()) {
				return new BlockConcept(location.getRow(), location.getCol());
			}
		}

		return null;
	}

	public Block convert(BlockConcept block) {
		ArrayList<Location> locations = this.getGrid().getOccupiedLocations();

		for (Location location : locations) {
			Block currentBlock = this.getGrid().get(location);
			if (currentBlock != null && location.getCol() == block.getCol()
					&& location.getRow() == block.getRow()) {
				return currentBlock;
			}
		}

		return null;
	}

	public ArrayList<Executable> getActionList() {
		return actionList;
	}

	public void setActionList(ArrayList<Executable> actionList) {
		this.actionList = actionList;
	}

}
