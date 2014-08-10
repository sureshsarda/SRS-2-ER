package node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sequence {
	// English sentence
	public String sentence;

	// POS tag and word index
	public Map<Integer,String> pos = new HashMap<Integer, String>();

	// List of  Entities in the sentence
	public List<Entity> Entities = new ArrayList<Entity>();

	// List of relationship in the sentence
	public List<Relationship> RelationShips = new ArrayList<Relationship>();


	public Sequence() {

	}
}
