package agents;

import jade.content.Predicate;

import java.util.ArrayList;

import ontology.concept.BlockConcept;
import ontology.predicate.On;
import ontology.predicate.Ontable;

import behaviors.Percept;

public class AgentPercept implements Percept{

	private ArrayList<Predicate>list;
	
	public AgentPercept() {
		ArrayList<Predicate>list =new ArrayList<Predicate>();
		setList(list);
	}
	@Override
	public void updatePercept(ArrayList<Predicate>list) {
		// TODO Auto-generated method stub		
		this.setList(list);
	}
	public ArrayList<Predicate> getList() {
		return list;
	}
	public void setList(ArrayList<Predicate> list) {
		this.list = list;
	}
}
