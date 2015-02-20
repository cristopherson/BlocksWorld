package ontology.predicate;

import jade.content.Predicate;

public class ArmEmpty implements Predicate{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean armEmpty = true;
	
	public ArmEmpty() {
		this(true);
	}
	
	public ArmEmpty(boolean armempty) {
		this.armEmpty = armempty;
	}
	
	public boolean getArmEmpty() {
		return armEmpty;
	}
	public void setArmEmpty(boolean armEmpty) {
		this.armEmpty = armEmpty;
	}

}
