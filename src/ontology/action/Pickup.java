package ontology.action;

import ontology.concept.BlockConcept;
import world.Block;
import agents.Environment;
import jade.content.AgentAction;

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
	public void execute(Environment env) {
		// TODO Auto-generated method stub
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
