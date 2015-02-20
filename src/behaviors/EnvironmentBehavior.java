package behaviors;

import ontology.action.Executable;
import agents.Environment;
import jade.content.ContentElementList;
import jade.content.ContentManager;
import jade.content.lang.Codec.CodecException;
import jade.content.onto.OntologyException;
import jade.content.onto.UngroundedException;
import jade.content.onto.basic.Action;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.util.leap.Iterator;

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
			
			try {
				ContentElementList elementList = (ContentElementList) contentManager
						.extractContent(msgRx);

				Iterator elementIterator = elementList.iterator();

				while (elementIterator.hasNext()) {
					Action action = (Action) elementIterator.next();
					((Executable) (action.getAction()))
							.execute((Environment) myAgent);
				}

			} catch (UngroundedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CodecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (OntologyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			block();
		}
		
	}

}
