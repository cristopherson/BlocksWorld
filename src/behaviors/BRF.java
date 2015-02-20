package behaviors;

public interface BRF {
	Belief brf(Belief belief, Percept percept);
	Desire options(Belief belief, Intention intention);
	Intention filter(Belief belief, Desire desire, Intention intention);
	Plan plan(Belief belief, Intention intention);
	void execute(Plan plan);
}
