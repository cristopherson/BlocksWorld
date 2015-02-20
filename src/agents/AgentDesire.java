package agents;

import jade.content.Predicate;

import java.util.ArrayList;
import ontology.predicate.On;
import ontology.predicate.Ontable;
import behaviors.Belief;
import behaviors.Desire;
import behaviors.Intention;

public class AgentDesire implements Desire {

	private ArrayList<Predicate> list;

	public AgentDesire() {
		list = new ArrayList<Predicate>();
	}

	@Override
	public boolean meetGoal() {
		// TODO Auto-generated method stub		
		return list.isEmpty();
	}

	@Override
	public void updateDesire(Belief belief, Intention intention) {
		// TODO Auto-generated method stub
		list = new ArrayList<Predicate>();

		for (Predicate predicate : ((AgentBelief) belief).getList()) {
			if (predicate.getClass() != Ontable.class) {
				if (predicate.getClass() == On.class) {
					On onPredicate = (On) predicate;
					Ontable ontablePredicate = new Ontable();					
					
					ontablePredicate.setBlock(onPredicate.getBlock2());
					list.add(ontablePredicate);
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
