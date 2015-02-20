package agents;

import info.gridworld.grid.Location;
import jade.content.Predicate;

import java.awt.Color;
import java.util.ArrayList;

import ontology.action.Pickdown;
import ontology.predicate.Clear;
import ontology.predicate.Holding;
import ontology.predicate.On;
import ontology.predicate.Ontable;
import world.Block;
import behaviors.Belief;
import behaviors.Desire;
import behaviors.Intention;
import behaviors.Percept;

public class AgentDesire implements Desire {

	private ArrayList<Predicate> list;

	public AgentDesire() {
		list = new ArrayList<Predicate>();
	}

	@Override
	public boolean meetGoal() {
		// TODO Auto-generated method stub
		for (Predicate intentionPredicate : list) {
			if (intentionPredicate.getClass() != Ontable.class)
				return false;

			if (!((Ontable) intentionPredicate).getOnTable())
				return false;
		}
		return true;
	}

	@Override
	public void updateDesire(Belief belief, Intention intention) {
		// TODO Auto-generated method stub
		Percept percept = new AgentPercept();
		Environment env = ((AgentPercept) percept).getEnv();
		ArrayList<Location> locationList = env.getWorld().getGrid()
				.getOccupiedLocations();
		setList(new ArrayList<Predicate>());

		for (Location location : locationList) {
			Block block = env.getWorld().getGrid().get(location);
			if (block.getColor() == Color.BLACK) {
				getList().add(new Ontable(env.getWorld().convert(block), true));
			} else {
				if (location.getRow() == 0) {
					getList().add(
							new Holding(env.getWorld().convert(block), true));
				} else {
					Location block2Location = new Location(
							location.getRow() - 1, location.getCol());
					Block block2 = env.getWorld().getGrid().get(block2Location);
					if (block2 != null) {
						getList().add(
								new Clear(env.getWorld().convert(block), true));
					} else if (location.getRow() == env.getWorld()
							.getGridDimension() - 1) {
						getList()
								.add(new Ontable(env.getWorld().convert(block),
										true));
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
