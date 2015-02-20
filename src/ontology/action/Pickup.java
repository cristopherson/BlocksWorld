package ontology.action;

import ontology.concept.BlockConcept;
import world.Block;
import agents.Environment;
import jade.content.AgentAction;
import jade.core.Agent;

public class Pickup implements AgentAction, Executable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BlockConcept block;

	public Pickup() {
		this(new BlockConcept());
	}
	
	public Pickup(BlockConcept block) {
		this.block = block;
	}
	@Override
	public void execute(Agent agent) {
		// TODO Auto-generated method stub
		Environment env = (Environment)agent;
		System.out.println("Picking up");
		Block currentBlock = env.getWorld().convert(block);
		if(currentBlock!=null) {
			currentBlock.setUp(true);
		}
	}

	public BlockConcept getBlock() {
		return block;
	}

	public void setBlock(BlockConcept block) {
		this.block = block;		
	}

}
