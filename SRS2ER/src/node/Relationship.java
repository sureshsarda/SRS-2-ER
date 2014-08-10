package node;

import java.util.ArrayList;

import java.util.List;

public class Relationship {

	// Word  Id
	public int relationship_name;
	// List of entity objects
	public List<Entity> Ent = new ArrayList<Entity>();

	public Relationship(int r) {
		relationship_name = r;

	}

}
