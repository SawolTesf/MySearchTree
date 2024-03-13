import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.String;
import java.io.File;
class MySearchTree<T extends Comparable<T>>{

  Node root;

  MySearchTree(){
    root = null;
  }
  public Node getRoot(){
    return root;
  }
  public void add(T key){
    root = addRecursive(key, root);
  }
  public Node addRecursive(T value, Node root){
    if(root == null){
      root = new Node(value, null, null);
      return root;
    }

    if(root.data.compareTo(value) < 0){
      root.right = addRecursive(value, root.right);
    }
    else if(root.data.compareTo(value) > 0){
      root.left = addRecursive(value, root.left);
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
  public void preOrderPrint(Node root){
    if(root != null){
        System.out.print(root.data + " ");
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }
  }

  private class Node{
    T data;
    Node left;
    Node right;

    Node(T data, Node left, Node right){
      this.data = data;
      this.left = left;
      this.right = right;
    }

  }
}

class Namelist{
  public static void main(String[] args){
    MySearchTree<String> tree = new MySearchTree<String>();
    try{
      Scanner scanner = new Scanner(new FileInputStream(new File("input.txt")));
      Scanner lineScanner = null;
      String name = "";
      while(scanner.hasNextLine()){
        String line = scanner.nextLine();
        if(line.isEmpty()){
          break;
        }
        lineScanner = new Scanner(line);
        String command = lineScanner.next();
        if(command.compareTo("A") == 0 || command.compareTo("C") == 0){
          name = lineScanner.next();
        }
        switch(command){
          case "A":
            tree.add(name);
            break;
          case "C":
            boolean found = tree.find(name, tree.getRoot());
            System.out.println(found ? "Found" : "Not Found");
            break;
          case "L":
            System.out.println(tree.leafCount(tree.getRoot()));
            break;
          case "P":
            System.out.println(tree.parentCount(tree.getRoot()));
            break;
          case "T":
            System.out.println(tree.twoChildCount(tree.getRoot()));
            break;
          case "D":
            tree.preOrderPrint(tree.getRoot());
            break;
        }
      }
      scanner.close();
      lineScanner.close();
    }
    catch(FileNotFoundException e){

    }
  }
}