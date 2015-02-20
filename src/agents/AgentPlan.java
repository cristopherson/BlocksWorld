package agents;

import java.util.ArrayList;

import ontology.action.Executable;

import behaviors.Belief;
import behaviors.Intention;
import behaviors.Plan;

public class AgentPlan implements Plan{

	private ArrayList<Executable> list;
	
	public AgentPlan() {
		this.list = new ArrayList<Executable>();
	}
	@Override
	public void updatePlan(Belief belief, Intention intention) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void execute(Environment env) {
		// TODO Auto-generated method stub
		
		for(Executable action:list) {
			action.execute(env);
		}
		
	}
}
