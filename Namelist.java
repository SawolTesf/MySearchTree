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