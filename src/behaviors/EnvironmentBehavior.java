package behaviors;

import jade.content.ContentManager;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class EnvironmentBehavior extends CyclicBehaviour{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void action() {
		// TODO Auto-generated method stub
		ACLMessage msgRx = myAgent.receive();
		if (msgRx != null && msgRx.getPerformative() == ACLMessage.REQUEST) {
			ContentManager contentManager = myAgent.getContentManager();
			System.out.println("RECEIVED = " + msgRx.getContent());
			msgRx.setLanguage("fipa-sl");
			msgRx.setOntology("blocks-ontology");
		} else {
			block();
		}
		
	}

}
