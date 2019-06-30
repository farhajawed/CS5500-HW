package tree.tree;

import java.util.ArrayList;
import java.util.Collections;

public class Tree {

	private int value;
	private Tree left = null;
	private Tree right = null;
	ArrayList va = new ArrayList<Integer>();
	
	 public Tree(int v){
	    this.value = v;
	    va.add(v);
	 }
 
	 public void insert(int v){
		 if (v < value) {
			 if (left != null){
				 left.insert(v);
			 } else {
				 left = new Tree(v);
			 }
			 } else {
				 if (right != null){
				 right.insert(v);
				 } 
				 else {
			 right = new Tree(v);
			 }
		 }
		 va.add(v);
	 }
 public int size(){
	 int result = 1;
	 if (left != null){
		 result += left.size();
	 }
	 if (right != null){
		 result += right.size();
	 }
	 return result;
 }
 
 @SuppressWarnings("unchecked")
public Iterator<Integer> iterator(){
	 Collections.sort(va);
	 return new Iterator<Integer>(va);
 }
 
 public Tree getLeft(){ return left; }
 public Tree getRight(){ return right; }
 public int getValue(){ return value; }

 public static void main(String [] args) {
	
    
    }
//    System.out.println(tree.getLeft().getValue());
//    System.out.println(tree.getRight().getValue());
//    System.out.println(tree.getRight().getLeft().getValue());
//    System.out.println(tree.getRight().getLeft().getLeft().getValue());
    
 }

 
