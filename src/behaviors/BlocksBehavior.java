package behaviors;

import java.util.ArrayList;
import java.util.Iterator;

import agents.AgentPercept;

import jade.content.ContentElementList;
import jade.content.ContentManager;
import jade.content.Predicate;
import jade.content.lang.Codec.CodecException;
import jade.content.onto.OntologyException;
import jade.content.onto.UngroundedException;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class BlocksBehavior extends CyclicBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void action() {
		// TODO Auto-generated method stub
		ACLMessage msgRx = myAgent.receive();
		if (msgRx != null && msgRx.getPerformative() == ACLMessage.INFORM) {
			System.out.println("MSG " + msgRx);
			msgRx.setLanguage("fipa-sl");
			msgRx.setOntology("blocks-ontology");

			ContentManager contentManager = myAgent.getContentManager();			

			try {
				ContentElementList elementList = (ContentElementList) contentManager
						.extractContent(msgRx);
				ArrayList<Predicate> list = new ArrayList<Predicate>();
				Iterator<Predicate> elementIterator = elementList.iterator();

				while (elementIterator.hasNext()) {
					list.add(elementIterator.next());
				}

				Percept percept = new AgentPercept();
				percept.updatePercept(list);

				BRF agent = (BRF) myAgent;
				agent.brf(agent.getBelief(), percept);
				agent.options(agent.getBelief(), agent.getIntention());

				if (agent.getDesire().meetGoal()) {
					System.out.println("Goal has been met");
				} else {
					agent.filter(agent.getBelief(), agent.getDesire(),
							agent.getIntention());
					agent.plan(agent.getBelief(), agent.getIntention());
					agent.execute(agent.getPlan());
				}

			} catch (UngroundedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (CodecException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (OntologyException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			block();
		}
	}

}
