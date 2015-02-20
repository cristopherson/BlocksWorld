package agents;

import jade.content.Predicate;

import java.util.ArrayList;

import ontology.predicate.Ontable;

import behaviors.Percept;

public class AgentPercept implements Percept{

	private Environment env;
	private ArrayList<Predicate>list;
	
	public AgentPercept() {
		list = new ArrayList<Predicate>();
	}
	@Override
	public void updatePercept(Environment env) {
		// TODO Auto-generated method stub
		
		if(env != null) {
			this.setEnv(env);
		} else {
			
		}
	}
	public Environment getEnv() {
		return env;
	}
	public void setEnv(Environment env) {
		this.env = env;
	}

}
