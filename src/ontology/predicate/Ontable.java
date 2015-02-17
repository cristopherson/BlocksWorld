package ontology.predicate;

import ontology.concept.BlockConcept;
import jade.content.Predicate;

public class Ontable implements Predicate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BlockConcept block;	
	private boolean onTable;
	
	public BlockConcept getBlock() {
		return block;
	}
	public void setBlock(BlockConcept block) {
		this.block = block;
	}
	public boolean getOnTable() {
		return onTable;
	}
	public void setOnTable(boolean onTable) {
		this.onTable = onTable;
	}

}
