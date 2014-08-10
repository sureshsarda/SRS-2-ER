package node;

import java.util.ArrayList;

import java.util.List;

public class Entity {

	// Word  Id
	public int entity_name;
	// List of Attribute objects
	public List<Attribute> Attr = new ArrayList<Attribute>();

	public Entity() {

	}

	public Entity(int ent) {
		entity_name = ent;

	}

}
