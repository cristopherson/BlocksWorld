package behaviors;

import java.awt.Color;

import ontology.action.Pickdown;
import world.Block;
import jade.content.ContentElementList;
import jade.content.ContentManager;
import jade.content.lang.Codec.CodecException;
import jade.content.onto.OntologyException;
import jade.content.onto.UngroundedException;
import jade.content.onto.basic.Action;
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
			
			ACLMessage msgTx = msgRx.createReply();
			msgTx.setPerformative(ACLMessage.REQUEST);
			msgTx.setLanguage("fipa-sl");
			msgTx.setOntology("blocks-ontology");			

			ContentManager contentManager = myAgent.getContentManager();
			ContentElementList cel = new ContentElementList();
			
			try {
				ContentElementList elementList = (ContentElementList) contentManager.extractContent(msgRx);
				Action action = new Action(myAgent.getAID(), new Pickdown());
				cel.add(action);
				contentManager.fillContent(msgTx, cel);
				System.out.println("MSG " + msgTx);
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
			
			myAgent.send(msgTx);
		} else {
			block();
		}
	}

}
