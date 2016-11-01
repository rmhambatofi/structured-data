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
}
