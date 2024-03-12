class MySearchTree<T>{

  Node root;
  
  
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