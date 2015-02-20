package agents;

import info.gridworld.grid.Location;
import jade.content.Predicate;

import java.awt.Color;
import java.util.ArrayList;

import ontology.predicate.Holding;
import ontology.predicate.On;
import ontology.predicate.Ontable;

import world.Block;

import behaviors.Belief;
import behaviors.Percept;

public class AgentBelief implements Belief {

	private ArrayList<Predicate> list;

	public AgentBelief(Percept percept) {
		list = new ArrayList<Predicate>();
		Environment env = ((AgentPercept) percept).getEnv();
		ArrayList<Location> locationList = env.getWorld().getGrid()
				.getOccupiedLocations();
		
		
		for (Location location : locationList) {
			Block block = env.getWorld().getGrid().get(location);
			list.add(new Ontable(env.getWorld().convert(block), true));
		}
		
	}

	@Override
	public void updateBeliefs(Percept percept) {
		// TODO Auto-generated method stub
		Environment env = ((AgentPercept) percept).getEnv();
		ArrayList<Location> locationList = env.getWorld().getGrid()
				.getOccupiedLocations();
		setList(new ArrayList<Predicate>());

		for (Location location : locationList) {
			Block block = env.getWorld().getGrid().get(location);
			if (block.getColor() == Color.BLACK) {
				getList().add(new Holding(env.getWorld().convert(block), true));
			} else {
				if (location.getRow() == env.getWorld().getGridDimension() - 1) {
					getList().add(new Ontable(env.getWorld().convert(block), true));
				} else {
					if (location.getRow() != 0) {
						Location block2Location = new Location(
								location.getRow() - 1, location.getCol());
						Block block2 = env.getWorld().getGrid()
								.get(block2Location);
						if (block2 != null) {
							getList().add(new On(env.getWorld().convert(block), env
									.getWorld().convert(block2), true));
						}
					}
				}
			}
		}

	}

	public ArrayList<Predicate> getList() {
		return list;
	}

	public void setList(ArrayList<Predicate> list) {
		this.list = list;
	}

}
