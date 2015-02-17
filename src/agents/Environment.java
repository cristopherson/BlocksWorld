package agents;

import behaviors.EnvironmentBehavior;
import world.BlocksWorld;
import jade.core.Agent;

public class Environment extends Agent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BlocksWorld world;
	
	public Environment() {
		setWorld(new BlocksWorld(this));
		getWorld().show();
	}

	public BlocksWorld getWorld() {
		return world;
	}

	public void setWorld(BlocksWorld world) {
		this.world = world;
	}
	
	public void setup() {
		addBehaviour(new EnvironmentBehavior());
	}
}
