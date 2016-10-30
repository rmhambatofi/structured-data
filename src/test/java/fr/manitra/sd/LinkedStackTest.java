package fr.manitra.sd;

import org.junit.Before;

/**
 * Created by manitra on 30/10/2016.
 */
public class LinkedStackTest extends AbstractStackTest {

    private LinkedStack<String> stack;

    @Before
    public void setUp() throws Exception {
        stack = new LinkedStack<>();
        stack.push("Nirina");
    }

    @Override
    protected Stack<String> getStack() {
        return stack;
    }
}