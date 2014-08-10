package read_tagged_sentences;

import java.util.ArrayList;
import java.util.List;

public class TaggedEntity {

	// Word ID
		public String entity_name;
		// List of Attribute objects
		public List<TaggedAttribute> Attr = new ArrayList<TaggedAttribute>();

		public TaggedEntity() {

		}

		public TaggedEntity(String ent) {
			entity_name = ent;

		}
}
