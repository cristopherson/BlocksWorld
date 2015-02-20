package ontology.action;

import ontology.concept.BlockConcept;
import agents.Environment;
import jade.content.AgentAction;

public class Stack  implements AgentAction, Executable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BlockConcept block1;
	private BlockConcept block2;

	public Stack() {
		this(new BlockConcept(), new BlockConcept());
	}
	public Stack(BlockConcept block1, BlockConcept block2) {
		this.block1 = block1;
		this.block2 = block2;
	}
	
	@Override
	public void execute(Environment env) {
		// TODO Auto-generated method stub		
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
