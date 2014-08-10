package read_tagged_sentences;

import java.util.ArrayList;
import java.util.List;

public class TaggedRelationship {
	// Word   Id
		public String relationship_name;
		// List of entity objects
		public List<TaggedEntity> Ent = new ArrayList<TaggedEntity>();

		public TaggedRelationship(String r) {
			relationship_name = r;

		}

}
