package fr.manitra.sd;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manitra on 02/11/16.
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

    @Override
    public Position<E> sibling(Position<E> p) {
        Position<E> parent = parent(p);
        if (parent == null) {
            return null; // It's a root
        }
        if (p == left(parent)) {
            return right(parent);
        }
        return left(parent);
    }

    public int numberChildren(Position<E> position) {
        int count = 0;
        if (left(position) != null)
            count++;
        if (right(position) != null)
            count++;
        return count;
    }

    public Iterable<Position<E>> children(Position<E> position) {
        List<Position<E>> snapshot = new ArrayList<>(2);
        if (left(position) != null) {
            snapshot.add(left(position));
        }
        if (right(position) != null) {
            snapshot.add(right(position));
        }
        return snapshot;
    }
}
