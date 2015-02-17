package ontology.predicate;

import ontology.concept.BlockConcept;
import jade.content.Predicate;

public class Holding implements Predicate{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BlockConcept block;
	private boolean holding;
	
	public boolean getHolding() {
		return holding;
	}
	public void setHolding(boolean holding) {
		this.holding = holding;
	}
	public BlockConcept getBlock() {
		return block;
	}
	public void setBlock(BlockConcept block) {
		this.block = block;
	}
	

}
