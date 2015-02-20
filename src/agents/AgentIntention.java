package agents;

import jade.content.Predicate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import ontology.action.Executable;
import ontology.action.Putdown;
import ontology.concept.BlockConcept;
import ontology.predicate.Ontable;

import behaviors.Belief;
import behaviors.Intention;
import behaviors.Desire;
import behaviors.Percept;

public class AgentIntention implements Intention {

	private Executable action;

	public AgentIntention(Percept percept) {
		action = null;
	}

	@Override
	public void updateIntention(Belief belief, Desire desire,
			Intention intention) {
		// TODO Auto-generated method stub
		AgentDesire agentDesire = (AgentDesire) desire;
		HashMap<Integer, Ontable> blockMap = new HashMap<Integer, Ontable>();
		ArrayList<Predicate> predicateList = agentDesire.getList();

		for (Predicate predicate : predicateList) {
			if (predicate.getClass() == Ontable.class) {
				Ontable ontablePredicate = (Ontable) predicate;
				BlockConcept block = ontablePredicate.getBlock();
				Integer key = block.getCol();

				if (!blockMap.containsKey(key)) {
					blockMap.put(key, ontablePredicate);
				} else {
					BlockConcept blockAdded = blockMap.get(key).getBlock();

					if (block.getRow() < blockAdded.getRow()) {
						blockMap.remove(key);
						blockMap.put(key, ontablePredicate);
					}
				}
			}
		}

		Iterator<Integer> keyIterator = blockMap.keySet().iterator();

		if (keyIterator.hasNext()) {
			Integer key = keyIterator.next();
			Ontable ontable = blockMap.get(key);
			Putdown putDownAction = new Putdown();
			putDownAction.setBlock(ontable.getBlock());
			action = putDownAction;
		} else {
			action = null;
		}
	}

	public Executable getAction() {
		return action;
	}

	public void setAction(Executable action) {
		this.action = action;
	}

}
