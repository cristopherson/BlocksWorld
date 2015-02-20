package agents;

import ontology.BlocksWorldOntology;
import behaviors.EnvironmentBehavior;
import world.BlocksWorld;
import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.core.Agent;

public class Environment extends Agent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BlocksWorld world;
	private Codec codec;
	private Ontology ontology;
	
	public Environment() {
		setWorld(new BlocksWorld(this));
		getWorld().show();
		codec = new SLCodec();
		ontology = BlocksWorldOntology.getInstance();
	}

	public BlocksWorld getWorld() {
		return world;
	}

	public void setWorld(BlocksWorld world) {
		this.world = world;		
	}
	
	public void setup() {
		getContentManager().registerLanguage(codec);
		getContentManager().registerOntology(ontology);
		addBehaviour(new EnvironmentBehavior());
	}
}
