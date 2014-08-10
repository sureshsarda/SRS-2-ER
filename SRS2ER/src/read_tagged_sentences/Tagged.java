package read_tagged_sentences;

import java.util.ArrayList;
import java.util.List;

public class Tagged {

	// English  sentence
	public String sentence;

	// List of entities in the sentence
	public List<TaggedEntity> Entities = new ArrayList<TaggedEntity>();

	// List of relationship in the sentence
	public List<TaggedRelationship> RelationShips = new ArrayList<TaggedRelationship>();
}
