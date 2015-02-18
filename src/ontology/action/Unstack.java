package ontology.action;

import world.Block;
import agents.Environment;
import jade.content.AgentAction;

public class Unstack implements AgentAction, Executable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Block block1;
	private Block block2;

	public Unstack(Block block1, Block block2) {
		this.block1 = block1;
		this.block2 = block2;
	}
	@Override
	public void execute(Environment env) {
		// TODO Auto-generated method stub
		
	}

	public Block getBlock1() {
		return block1;
	}

	public void setBlock1(Block block1) {
		this.block1 = block1;
	}

	public Block getBlock2() {
		return block2;
	}

	public void setBlock2(Block block2) {
		this.block2 = block2;
	}

}
