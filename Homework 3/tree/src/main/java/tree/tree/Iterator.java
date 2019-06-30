package tree.tree;

import java.util.ArrayList;

public class Iterator<Integer> {
 
	int position = 0;
	ArrayList v = new ArrayList<Integer>();
	
	public Iterator(ArrayList v) {
		this.v = v;
	}
	
	public boolean hasNext() {
		
		return this.position!=v.size();
	}
	
	public int next() {
		this.position++;
		return (java.lang.Integer) v.get(position);
	}
}
