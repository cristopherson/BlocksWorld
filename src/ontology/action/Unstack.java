package ontology.action;

import ontology.concept.BlockConcept;
import world.Block;
import agents.Environment;
import jade.content.AgentAction;
import jade.core.Agent;

public class Unstack implements AgentAction, Executable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BlockConcept block1;
	private BlockConcept block2;

	public Unstack() {
		this( new BlockConcept(), new BlockConcept());
	}
	
	public Unstack(BlockConcept block1, BlockConcept block2) {
		this.block1 = block1;
		this.block2 = block2;
	}
	@Override
	public void execute(Agent agent) {
		// TODO Auto-generated method stub
		Environment env = (Environment)agent;
		System.out.println("Unstacking");
		Block currentBlock = env.getWorld().convert(block2);
		if(currentBlock!=null) {
			currentBlock.setUp(true);
		}		
	}

	public BlockConcept getBlock1() {
		return block1;
	}

	public void setBlock1(BlockConcept block1) {
		this.block1 = block1;
	}

	public BlockConcept getBlock2() {
		return block2;
	}

	public void setBlock2(BlockConcept block2) {
		this.block2 = block2;
	}

}
