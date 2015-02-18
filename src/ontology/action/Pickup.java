package ontology.action;

import world.Block;
import agents.Environment;
import jade.content.AgentAction;

public class Pickup implements AgentAction, Executable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Block block;

	public Pickup(Block block) {
		this.block = block;
	}
	@Override
	public void execute(Environment env) {
		// TODO Auto-generated method stub
		
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

}