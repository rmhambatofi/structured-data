package fr.manitra.sd;

import java.util.Iterator;

/**
 * Created by manitra on 01/11/2016.
 */
public interface Tree<E> extends Iterable<E> {
    Position<E> root();
    Position<E> parent(Position<E> position) throws IllegalArgumentException;
    Iterable<Position<E>> children(Position<E> position) throws IllegalArgumentException;
    int numberChildren(Position<E> position) throws IllegalArgumentException;
    boolean isInternal(Position<E> position) throws IllegalArgumentException;
    boolean isExternal(Position<E> position) throws IllegalArgumentException;
    boolean isRoot(Position<E> position) throws IllegalArgumentException;
    int size();
    boolean isEmpty();
    Iterator<E> iterator();
    Iterable<Position<E>> positions();
}
