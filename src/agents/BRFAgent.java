package agents;

import ontology.BlocksWorldOntology;
import behaviors.BRF;
import behaviors.Belief;
import behaviors.BlocksBehavior;
import behaviors.Intention;
import behaviors.Desire;
import behaviors.Percept;
import behaviors.Plan;
import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.core.Agent;


public class BRFAgent extends Agent implements BRF{

	/**
	 * 
	 */	
	
	private static final long serialVersionUID = 1L;
	private Ontology  ontology;
	private Codec codec;
	private Intention agentIntention = null;
	private Belief agentBelief = null;
	private Desire agentDesire = null;
	private Plan actionPlan = null;
	private Percept percept = null;

	public BRFAgent() {
		ontology = BlocksWorldOntology.getInstance();
		codec = new SLCodec();
	}
	@Override
	public Belief brf(Belief belief, Percept percept) {
		// TODO Auto-generated method stub
		agentBelief = belief;
		agentBelief.updateBeliefs(percept);
		return agentBelief;
	}
	@Override
	public Desire options(Belief belief, Intention intention) {
		// TODO Auto-generated method stub
		agentDesire.updateDesire(belief, intention);
		return agentDesire;
	}
	@Override
	public Intention filter(Belief belief, Desire desire, Intention intention) {
		// TODO Auto-generated method stub
		agentIntention.updateIntention(belief, desire, intention);
		return agentIntention;
	}
	@Override
	public Plan plan(Belief belief, Intention intention) {
		// TODO Auto-generated method stub
		actionPlan.updatePlan(belief, intention);
		return actionPlan;
	}
	@Override
	public void execute(Plan plan) {
		// TODO Auto-generated method stub
		plan.execute(((AgentPercept)percept).getEnv());
	}
	
	@Override
	public void setup() {
		getContentManager().registerLanguage(codec);
		getContentManager().registerOntology(ontology);
		addBehaviour(new BlocksBehavior());
	}
}
