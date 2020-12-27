package university;

public class Tree {

    private class Node {
        int key;
        Object inf;
        Node left;
        Node right;

        /*  public Node(int key)
          {
              this.key=key;
          }
          */
        public Node(int key, Object inf) {
            this.key = key;
            this.inf = inf;
            right = null;
            left = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", inf=" + inf +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void add(int key, Object inf) {
        if (root == null) {
            root = new Node(key, inf);
        } else {
            Node parent = findNode(root, key);
            if (key < parent.key) {
                parent.left = new Node(key, inf);
            } else {
                parent.right = new Node(key, inf);
            }
        }
    }

    public Node findNode(Node current, int key) {
        if (key < current.key) {
            if (current.left == null) {
                return current;
            } else {
                return findNode(current.left, key);
            }
        } else {
            if (current.right == null) {
                return current;
            } else {
                return findNode(current.right, key);
            }
        }
    }
    public Node find(Node current, int key) {
        if (current!=null && key < current.key) {

                return find(current.left, key);
            }
        else {
            if(current!=null && key>current.key)
            {
                return find(current.right,key);
            }
            else
            {
                return  current;
            }
        }

    }
///////////////////////////////////
    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            visit(node.key);
            traverseInOrder(node.right);
        }
    }

    public void traversePreOrder(Node node) {
        if (node != null) {
            visit(node.key);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            visit(node.key);
        }
    }
    private void visit(int value) {
        System.out.print(" " + value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.key) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }
            int smallestValue = findSmallestValue(current.right);
            current.key = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.key) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }

        current.right = deleteRecursive(current.right, value);
        return current;
    }
    private int findSmallestValue(Node root) {
        return root.left == null ? root.key : findSmallestValue(root.left);
    }
    /////////////////////////////////////////////////////////////////////
    public void decRenat(int kase,int num){
        switch (kase) {
            case 0:
            deleteRecursive(root, num);
            break;
            case 1:
            traverseInOrder(root);
            break;
            case 2:
            traversePreOrder(root);
            break;
            case 3:
            traversePostOrder(root);
            break;
        }
    }
    ////
    public boolean checkKey(int key)
    {
        Node tmp=find(root,key);
        return tmp!=null;
    }
}
