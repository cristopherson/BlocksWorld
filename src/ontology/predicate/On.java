package ontology.predicate;

import ontology.concept.BlockConcept;
import jade.content.Predicate;

public class On implements Predicate{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BlockConcept block1;
	private BlockConcept block2;
	private boolean on;
	
	public On() {
		this(null, null, false);
	}
	
	public On(BlockConcept block1, BlockConcept block2, boolean on) {
		this.block1 = block1;
		this.block2 = block2;
		this.on = on;
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
	public boolean getOn() {
		return on;
	}
	public void setOn(boolean on) {
		this.on = on;
	}

}
