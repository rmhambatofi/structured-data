package fr.manitra.sd;

/**
 * Created by manitra on 02/11/16.
 */
public interface BinaryTree<E> {

    /**
     * Returns the Position of p's left child (or null if no child exists)
     * @param p
     * @return
     */
    Position<E> left(Position<E> p);

    /**
     * Returns the Position of p's right child (or null if no child exists)
     * @param p
     * @return
     */
    Position<E> right(Position<E> p);

    /**
     * Returns the Position of p's sibling
     * @param p
     * @return
     */
    Position<E> sibling(Position<E> p);
}
