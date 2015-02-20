package ontology.concept;

import jade.content.Concept;

public class BlockConcept implements Concept{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int row;
	private int col;
	
	public BlockConcept(){
		this(0,0);
	}
	
	public BlockConcept(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	
}
