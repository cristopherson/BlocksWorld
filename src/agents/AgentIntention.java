package agents;

import ontology.action.Executable;

import behaviors.Belief;
import behaviors.Intention;
import behaviors.Desire;
import behaviors.Percept;

public class AgentIntention implements Intention{

	private Executable action;
	
	public AgentIntention(Percept percept) {
		action = null;
	}
	
	@Override
	public void updateIntention(Belief belief, Desire desire, Intention intention) {
		// TODO Auto-generated method stub
		
		
	}

	public Executable getAction() {
		return action;
	}

	public void setAction(Executable action) {
		this.action= action;
	}

}
