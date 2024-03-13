import java.util.Scanner;
import java.io.FileInputStream;
import java.lang.String;

class MySearchTree<T extends Comparable<T>>{

  Node root;

  MySearchTree(){
    root = null;
  }

  public Node add(T value, Node root){
    if(root == null){
      return new Node(value, null, null);
    }

    if(root.data.compareTo(value) < 0){
      root.right = add(value, root.right);
    }
    else if(root.data.compareTo(value) > 0){
      root.left = add(value, root.left);
    }

    return root;
  }
  public boolean find(T value, Node root){
    if(root == null){
      return false;
    }
    if(root.data.compareTo(value) < 0){
      return find(value, root.right);
    }
    else if(root.data.compareTo(value) > 0){
      return find(value, root.left);
    }
    else{
      return true;
    }
  }
  public int leafCount(Node root){
    if(root == null){
        return 0;
    }
    if(root.left == null && root.right == null){
        return 1;
    }
    return leafCount(root.left) + leafCount(root.right);
  }
  public int parentCount(Node root){
    if(root == null || (root.left == null && root.right == null)){
        return 0;
    }
    return 1 + parentCount(root.left) + parentCount(root.right);
  }
  public int twoChildCount(Node root){
      if(root == null || root.left == null || root.right == null){
          return 0;
      }
      return 1 + twoChildCount(root.left) + twoChildCount(root.right);
  }

  private class Node{
    T data;
    Node left;
    Node right;

    Node(){
      data = null;
      right = null;
      left = null;
    }
    Node(T data, Node left, Node right){
      this.data = data;
      this.left = left;
      this.right = right;
    }

  }
}

class NameList{
  public static void main(){

  }
}