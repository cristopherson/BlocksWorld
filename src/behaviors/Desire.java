package behaviors;

public interface Desire {
	void updateDesire(Belief belief, Intention intention);
	boolean meetGoal();
}
