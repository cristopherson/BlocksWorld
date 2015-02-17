package ontology.predicate;

import ontology.concept.BlockConcept;
import jade.content.Predicate;

public class Clear implements Predicate{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BlockConcept block;
	private boolean clear;
	
	public Clear(BlockConcept block, boolean clear) {
		this.block = block;
		this.clear = clear;
	}
	
	public BlockConcept getBlock() {
		return block;
	}
	public void setBlock(BlockConcept block) {
		this.block = block;
	}

	public boolean getClear() {
		return clear;
	}

	public void setClear(boolean clear) {
		this.clear = clear;
	}	

}
