package ru.firsov.kirill.lesson6;

import ru.firsov.kirill.lesson4.Person;

import java.sql.Statement;
import java.util.Stack;

/**
 * ^ @project Data-Structures-and-Algorithms
 *
 * @author Kirill Firsov on 18.10.2018.
 */
public class Tree {

    private class TreeNode {
        private Person p;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(Person p) {
            this.p = p;
        }

        @Override
        public String toString() {
            return String.format("id: %d, name: %s, age: %d", p.id, p.getName(), p.getAge());
        }
    }

    TreeNode root;

    public Tree() {
        root = null;
    }

    public void insert(Person p) {
        TreeNode node = new TreeNode(p);
        if (root == null)
            root = node;
        else {
            TreeNode current = root;
            TreeNode parent;
            while (true) {
                parent = current;
                if (p.id < current.p.id) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                } else if (p.id > current.p.id) {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        return;
                    }
                } else
                    return;
            }
        }
    }

    public Person find (int id) {
        TreeNode current = root;
        while (current.p.id != id) {
            current = (id < current.p.id) ? current.left : current.right;
            if (current == null) return null;
        }
        return current.p;
    }

    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 64;
        boolean isRowEmpty = false;
        System.out.println("...................................");
        while(isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int i = 0; i < nBlanks; i++)
                System.out.print(' ');

            while(globalStack.isEmpty() == false) {
                TreeNode temp = (TreeNode)globalStack.pop();
                if(temp!=null) {
                    System.out.println(temp.p.id);
                    localStack.push(temp.left);
                    localStack.push(temp.right);

                    if(temp.left != null || temp.right != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int i = 0; i < nBlanks*2-2; i++)
                    System.out.print(' ');
            }
            System.out.println();
            nBlanks /= 2;
            while(localStack.isEmpty()==false)
                globalStack.push(localStack.pop());
        }
        System.out.println("...................................");
    }

    public boolean delete(int id) {
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = true;
        while (current.p.id != id) {
            parent = current;
            if (id < current.p.id) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
            if (current == null)
                return false;
        }

        // if a leaf
        if (current.left == null && current.right == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.left = null;
            else
                parent.right = null;
        }
        // if has one ancestor
        else if (current.right == null) {
            if (isLeftChild)
                parent.left = current.left;
            else
                parent.right = current.left;
        } else if (current.left == null) {
            if (isLeftChild)
                parent.left = current.right;
            else
                parent.right = current.right;
        }
        // if two ancestors
        else {
            TreeNode successor = getSuccessor(current);
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.left = successor;
            else
                parent.right = successor;
            successor.left = current.left;
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode parent = node;
        TreeNode s = node;
        TreeNode current = node.right;

        while (current != null) {
            parent = s;
            s = current;
            current = current.left;
        }
        if (s != node.right) {
            parent.left = s.right;
            s.right = node.right;
        }
        return s;
    }
}
