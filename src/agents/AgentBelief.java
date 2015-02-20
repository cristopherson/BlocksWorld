package agents;

import jade.content.Predicate;

import java.util.ArrayList;

import behaviors.Belief;
import behaviors.Percept;

public class AgentBelief implements Belief {

	private ArrayList<Predicate> list;

	public AgentBelief(Percept percept) {
		this.list = ((AgentPercept) percept).getList();
	}

	@Override
	public void updateBeliefs(Percept percept) {
		// TODO Auto-generated method stub
		this.list = ((AgentPercept) percept).getList();
	}

	public ArrayList<Predicate> getList() {
		return list;
	}

	public void setList(ArrayList<Predicate> list) {
		this.list = list;
	}

}
