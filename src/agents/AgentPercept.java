package agents;

import jade.content.Predicate;

import java.util.ArrayList;

import behaviors.Percept;

public class AgentPercept implements Percept{

	private ArrayList<Predicate>list;
	
	public AgentPercept() {
		setList(new ArrayList<Predicate>());
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
