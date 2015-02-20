package behaviors;

import ontology.action.Executable;

public interface Plan extends Executable{
	void updatePlan(Belief belief, Intention intention);
}
