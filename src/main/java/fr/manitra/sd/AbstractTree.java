package fr.manitra.sd;

/**
 * Created by manitra on 01/11/2016.
 */
public abstract class AbstractTree<E> implements Tree<E> {

    @Override
    public boolean isInternal(Position<E> position) throws IllegalArgumentException {
        return numberChildren(position) > 0;
    }

    @Override
    public boolean isExternal(Position<E> position) throws IllegalArgumentException {
        return numberChildren(position) == 0;
    }

    @Override
    public boolean isRoot(Position<E> position) throws IllegalArgumentException {
        return position == root();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public int depth(Position<E> position) {
        if (isRoot(position))
            return 0;
        return 1 + depth(parent(position));
    }

    public int height(Position<E> position) {
        int h = 0;
        for (Position<E> p : children(position)) {
            h = Math.max(h, 1 + height(p));
        }
        return h;
    }

    private int heightBad() {
        int h = 0;
        for (Position<E> p : positions()) {
            if (isExternal(p))
                h = Math.max(h, depth(p));
        }
        return h;
    }
}
