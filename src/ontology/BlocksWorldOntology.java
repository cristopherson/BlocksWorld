package ontology;

import jade.content.onto.BasicOntology;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.schema.AgentActionSchema;
import jade.content.schema.ConceptSchema;
import jade.content.schema.PredicateSchema;
import jade.content.schema.PrimitiveSchema;
import ontology.action.Putdown;
import ontology.action.Pickup;
import ontology.action.Stack;
import ontology.action.Unstack;
import ontology.concept.BlockConcept;
import ontology.predicate.ArmEmpty;
import ontology.predicate.Clear;
import ontology.predicate.Holding;
import ontology.predicate.On;
import ontology.predicate.Ontable;

public class BlocksWorldOntology extends Ontology {
	private static final long serialVersionUID = 1L;
	public static final String ONTOLOGY_NAME = "blocks-ontology";
	// The singleton instance of this ontology
	private static Ontology instance = new BlocksWorldOntology();

	// Retrieve the singleton vacuum ontology instance
	public static Ontology getInstance() {
		return instance;
	}
	
	// Vocabulary
	public static final String UNSTACK = "unstack";
	public static final String STACK = "stack";
	public static final String PICKUP = "pickup";
	public static final String PICKDOWN = "pickdown";
	public static final String ON = "on";
	public static final String ONTABLE = "onTable";
	public static final String CLEAR = "clear";
	public static final String HOLDING = "holding";
	public static final String ARMEMPTY = "armEmpty";
	public static final String ROW = "row";
	public static final String COL = "col";
	public static final String BLOCK = "block";
	public static final String BLOCK1 = "block1";
	public static final String BLOCK2 = "block2";
	
	
	private BlocksWorldOntology() {
		super(ONTOLOGY_NAME, BasicOntology.getInstance());
				
		try {
			add(new ConceptSchema(BLOCK), BlockConcept.class);
			
			add(new PredicateSchema(ON), On.class);
			add(new PredicateSchema(ONTABLE), Ontable.class);
			add(new PredicateSchema(CLEAR), Clear.class);
			add(new PredicateSchema(HOLDING), Holding.class);
			add(new PredicateSchema(ARMEMPTY), ArmEmpty.class);
			
			add(new AgentActionSchema(UNSTACK), Unstack.class);
			add(new AgentActionSchema(STACK), Stack.class);
			add(new AgentActionSchema(PICKUP), Pickup.class);
			add(new AgentActionSchema(PICKDOWN), Putdown.class);
			
			/************************ Concept *******************/
			ConceptSchema blockSchema = (ConceptSchema)getSchema(BLOCK);
			blockSchema.add(ROW,(PrimitiveSchema)getSchema(BasicOntology.INTEGER));
			blockSchema.add(COL,(PrimitiveSchema)getSchema(BasicOntology.INTEGER));
			
			/************************ Predicate *******************/
			PredicateSchema armEmptySchema = (PredicateSchema)getSchema(ARMEMPTY);
			armEmptySchema.add(ARMEMPTY, (PrimitiveSchema)getSchema(BasicOntology.BOOLEAN));
			
			PredicateSchema clearSchema = (PredicateSchema)getSchema(CLEAR);
			clearSchema.add(BLOCK, (ConceptSchema)getSchema(BLOCK));
			clearSchema.add(CLEAR, (PrimitiveSchema)getSchema(BasicOntology.BOOLEAN));
			
			PredicateSchema holdingSchema = (PredicateSchema)getSchema(HOLDING);
			holdingSchema.add(BLOCK, (ConceptSchema)getSchema(BLOCK));
			holdingSchema.add(HOLDING, (PrimitiveSchema)getSchema(BasicOntology.BOOLEAN));
			
			PredicateSchema onSchema = (PredicateSchema)getSchema(ON);
			onSchema.add(BLOCK1, (ConceptSchema)getSchema(BLOCK));
			onSchema.add(BLOCK2, (ConceptSchema)getSchema(BLOCK));
			onSchema.add(ON, (PrimitiveSchema)getSchema(BasicOntology.BOOLEAN));
			
			PredicateSchema onTableSchema = (PredicateSchema)getSchema(ONTABLE);
			onTableSchema.add(BLOCK, (ConceptSchema)getSchema(BLOCK));
			onTableSchema.add(ONTABLE, (PrimitiveSchema)getSchema(BasicOntology.BOOLEAN));
			/************************ Action *******************/
			AgentActionSchema pickupAction = (AgentActionSchema)getSchema(PICKUP);
			pickupAction.add(BLOCK, (ConceptSchema)getSchema(BLOCK));
			
			AgentActionSchema pickdownAction = (AgentActionSchema)getSchema(PICKDOWN);
			pickdownAction.add(BLOCK, (ConceptSchema)getSchema(BLOCK));
			
			AgentActionSchema stackAction = (AgentActionSchema)getSchema(STACK);
			stackAction.add(BLOCK1, (ConceptSchema)getSchema(BLOCK));
			stackAction.add(BLOCK2, (ConceptSchema)getSchema(BLOCK));
			
			AgentActionSchema unstackAction = (AgentActionSchema)getSchema(UNSTACK);
			unstackAction.add(BLOCK1, (ConceptSchema)getSchema(BLOCK));
			unstackAction.add(BLOCK2, (ConceptSchema)getSchema(BLOCK));
			
		} catch (OntologyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

