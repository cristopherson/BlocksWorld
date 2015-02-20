package behaviors;

import ontology.action.Executable;

public interface Intention {
	
	void updateIntention(Belief belief, Desire desire, Intention intention);
	Executable getAction();
}
