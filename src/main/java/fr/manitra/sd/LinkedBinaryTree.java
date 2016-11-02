package fr.manitra.sd;

import java.util.Iterator;

/**
 * Created by manitra on 02/11/2016.
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    protected static class Node<E> implements Position<E> {
        // an element stored at this node
        private E element;
        // a reference to the parent node (if any)
        private Node<E> parent;
        // a reference to the left child (if any)
        private Node<E> left;
        // a reference to the right child (if any)
        private Node<E> right;

        /**
         * Constructs a node with given element and neighbors
         * @param element
         * @param parent
         * @param left
         * @param right
         */
        public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        @Override
        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }

    /**
     * Factory function to create a new node storing element e
     * @param e
     * @param parent
     * @param left
     * @param right
     * @return
     */
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<>(e, parent, left, right);
    }

    // LinkedBinaryTree instance variables
    protected Node<E> root = null;
    private int size = 0;

    public LinkedBinaryTree() {
    }

    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("No valid position type");
        Node<E> node = (Node<E>)p;
        if (node.getParent() == node)
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }

    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    @Override
    public Position<E> left(Position<E> p) {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    @Override
    public Position<E> right(Position<E> p) {
        Node<E> node = validate(p);
        return node.getRight();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterable<Position<E>> positions() {
        return null;
    }

    /**
     * Places element e at the root of an empty tree and returns its new Position.
     * @param e
     * @return
     * @throws IllegalStateException
     */
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    /**
     * Creates new left child of Position p storing element e.
     * @param p
     * @param e
     * @return its Position
     * @throws IllegalArgumentException
     */
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getLeft() != null)
            throw new IllegalArgumentException("p already has a left child");
        Node<E> child = new Node<>(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    /**
     * Creates new right child of Position p storing elmeent e.
     * @param p
     * @param e
     * @return its Position
     * @throws IllegalArgumentException
     */
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getRight() != null)
            throw new IllegalArgumentException("p already has a right child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    /**
     * Replaces the element at Position p with e.
     * @param p
     * @param e
     * @return the replaced element
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    /**
     * Attaches trees t1 and t2 as left and right subtrees of external p.
     * @param p
     * @param t1
     * @param t2
     */
    public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (isInternal(p))
            throw new IllegalArgumentException(("p must be a leaf"));
        size += t1.size + t2.size;
        if (!t1.isEmpty()) {
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }
        if (!t2.isEmpty()) {
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }

    /**
     * Removes the node at Position p and replaces it with its child, if any
     * @param p
     * @return
     * @throws IllegalArgumentException
     */
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (numberChildren(p) == 2)
            throw new IllegalArgumentException("p has 2 children");
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if (child != null)
            child.setParent(node.getParent()); // Child grand parent becomes its parent
        if (node == root)
            root = child;
        else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft())
                parent.setLeft(child);
            else parent.setRight(child);
        }
        size--;
        E temp = node.getElement();
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node); // our conversion for defunct node
        return temp;
    }
}
