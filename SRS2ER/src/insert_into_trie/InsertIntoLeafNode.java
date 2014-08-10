package insert_into_trie;

import java.util.Iterator;
import java.util.Set;

import node.*;

public class InsertIntoLeafNode {

	Sequence s, seq;

	Iterator<Entity> etCurrent;
	Iterator<Entity> etPrevious;

	Iterator<Attribute> atCurrent;
	Iterator<Attribute> atPrevious;

	Entity current, previous;
	Attribute atCurr, atPrev;

	Iterator<Relationship> rtCurrent;
	Iterator<Relationship> rtPrevious;

	Iterator<Entity> etrCurrent;
	Iterator<Entity> etrPrevious;

	Relationship rcurrent, rprevious;
	Entity erCurr, erPrev;

	Boolean entityDifferent = false, attributeDifferent = false;

	Boolean relationshipDifferent = false, entDifferent = false;

	// Insert into leaf node ER tags and relationship
	public InsertIntoLeafNode(Node n, Sequence s1) {

		seq = s1;
		etCurrent = seq.Entities.iterator();
		rtCurrent = seq.RelationShips.iterator();

		if (!n.LeafNode.isEmpty()) {
			System.out.println("There is a similar pos sequence ");
			Set<Sequence> seqPresent = n.LeafNode.keySet();

			Iterator<Sequence> it = seqPresent.iterator();

			while (it.hasNext()) {
				s = it.next();

				etPrevious = s.Entities.iterator();
				rtPrevious = s.RelationShips.iterator();

				while (etPrevious.hasNext()) {
					previous = etPrevious.next();
					current = etCurrent.next();

					if (previous.entity_name == current.entity_name) {

						System.out.println("Same entity now check Attributes ");

						atPrevious = previous.Attr.iterator();
						atCurrent = current.Attr.iterator();

						while (atPrevious.hasNext()) {
							atPrev = atPrevious.next();
							atCurr = atCurrent.next();

							if (atPrev.attribute_name == atCurr.attribute_name) {

								System.out.println("yppies same att also ");
							} else
							// First Attribute name is different
							{
								System.out.println("atr dif");
								attributeDifferent = true;
								break;
							}

						}

						// If attribute name is different
						if (attributeDifferent) {
							// Same POS different ER create new pair
							System.out.println("aso heere ");
							break;
						}

					} else
					// First Entity name is different
					{
						System.out.println("Entity Different");
						entityDifferent = true;
						break;
					}

				}

				// If entity name or attribute is different
				if (entityDifferent || attributeDifferent) {
					// Same POS different ER create new pair
					n.LeafNode.put(seq, 0);
					System.out.println("Entity Different put new");
					// Reset values
					entityDifferent = false;
					attributeDifferent = false;
					break;
				} else// Check relationship
				{
					System.out.println("Now Check Relationship "
							+ rtPrevious.hasNext());

					while (rtPrevious.hasNext()) {
						System.out.println("ouye");
						rprevious = rtPrevious.next();
						rcurrent = rtCurrent.next();

						if (rprevious.relationship_name == rcurrent.relationship_name) {

							System.out
									.println("Same relationship now check entity");

							etrPrevious = rprevious.Ent.iterator();
							etrCurrent = rcurrent.Ent.iterator();

							while (etrPrevious.hasNext()) {
								erPrev = etrPrevious.next();
								erCurr = etrCurrent.next();

								if (erPrev.entity_name == erCurr.entity_name) {

									System.out
											.println("yppies same connection also ");
								} else
								// First Entity name is different
								{
									System.out.println("connection dif");
									entDifferent = true;
									break;
								}

							}

							// If entity name is different
							if (entDifferent) {
								// Same POS different ER create new pair
								System.out.println("also heere ");
								break;
							}

						} else
						// First Relationship name is different
						{
							relationshipDifferent = true;
							break;
						}

					}


					if (!entDifferent && !relationshipDifferent) {
						System.out.println("Increment frequency ");
						System.out.println(n.LeafNode.containsKey(s));
						int h = n.LeafNode.get(s);
						n.LeafNode.remove(s);
						n.LeafNode.put(seq, (h + 1));
						
						System.out.println(n.LeafNode);
					}
				}
			}

		} else
			// Same POS Sequence or ER tag not found earlier put frequency 0
			n.LeafNode.put(seq, 1);

	}
}
