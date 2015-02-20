package ontology.action;

import info.gridworld.grid.Location;
import ontology.concept.BlockConcept;
import world.Block;
import agents.Environment;
import jade.content.AgentAction;
import jade.core.Agent;

public class Putdown implements AgentAction, Executable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BlockConcept block;

	public Putdown() {
		this(new BlockConcept());
	}

	public Putdown(BlockConcept block) {
		this.block = block;
	}

	@Override
	public void execute(Agent agent) {
		// TODO Auto-generated method stub
		Environment env = (Environment) agent;
		System.out.println("Putting down");
		Block currentBlock = env.getWorld().convert(block);
		if (currentBlock != null) {
			int maxRow = env.getWorld().getGridDimension() - 1;
			for (int i = 0; i < env.getWorld().getGridDimension(); ++i) {
				if(env.getWorld().getGrid().get(new Location(maxRow, i)) == null) {
					env.getWorld().remove(
							new Location(block.getRow(), block.getCol()));
					env.getWorld().add(new Location(maxRow, i), currentBlock);
					break;
				}
			}

			currentBlock.setUp(false);
		}
	}

	public BlockConcept getBlock() {
		return block;
	}

	public void setBlock(BlockConcept block) {
		this.block = block;
	}

}
