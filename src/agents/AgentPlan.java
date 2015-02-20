package agents;

import jade.content.AgentAction;
import jade.content.ContentElementList;
import jade.content.ContentManager;
import jade.content.Predicate;
import jade.content.lang.Codec.CodecException;
import jade.content.onto.OntologyException;
import jade.content.onto.basic.Action;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

import java.util.ArrayList;

import ontology.action.Executable;
import ontology.action.Putdown;
import ontology.action.Unstack;
import ontology.concept.BlockConcept;
import ontology.predicate.On;

import behaviors.Belief;
import behaviors.Intention;
import behaviors.Plan;

public class AgentPlan implements Plan {

	private ArrayList<Executable> list;

	public AgentPlan() {
		this.list = new ArrayList<Executable>();
	}

	@Override
	public void updatePlan(Belief belief, Intention intention) {
		// TODO Auto-generated method stub
		this.list = new ArrayList<Executable>();
		AgentIntention agentIntention = (AgentIntention) intention;
		AgentBelief agentBelief = (AgentBelief) belief;
		ArrayList<Predicate> predicateList = agentBelief.getList();
		AgentAction action = (AgentAction) agentIntention.getAction();

		if (action.getClass() == Putdown.class) {
			Putdown putdownAction = (Putdown) action;
			BlockConcept currentBlock = putdownAction.getBlock();

			for (Predicate predicate : predicateList) {
				if (predicate.getClass() == On.class) {
					On onPredicate = (On) predicate;
					if (onPredicate.getBlock2().getCol() == currentBlock
							.getCol()
							&& onPredicate.getBlock2().getRow() == currentBlock
									.getRow()) {

						Unstack unstackAction = new Unstack();
						unstackAction.setBlock1(onPredicate.getBlock1());
						unstackAction.setBlock2(onPredicate.getBlock2());

						list.add(unstackAction);
						list.add(putdownAction);
						break;
					}
				}
			}
		}
	}

	@Override
	public void execute(Agent agent) {
		// TODO Auto-generated method stub
		AID aid = agent.getAID();
		ACLMessage message = new ACLMessage(ACLMessage.REQUEST);
		ContentManager contentManager = agent.getContentManager();
		ContentElementList cel = new ContentElementList();

		message.addReceiver(new AID("env", false));
		message.setLanguage("fipa-sl");
		message.setOntology("blocks-ontology");

		for (Executable action: list) {
			cel.add(new Action(aid, (AgentAction)action));
		}
		
		try {
			contentManager.fillContent(message, cel);
		} catch (CodecException | OntologyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("MSG " + message);
		agent.send(message);
	}
}

