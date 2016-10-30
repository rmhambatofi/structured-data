package fr.manitra.sd;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by manitra on 29/10/2016.
 */
public class ArrBasedStackTest extends AbstractStackTest {

    private ArrBasedStack<String> stack;

    @Before
    public void setUp() throws Exception {
        stack = new ArrBasedStack<>(10);
        stack.push("Nirina");
    }

    @Override
    protected Stack<String> getStack() {
        return stack;
    }

    @Test(expected = IllegalStateException.class)
    public void stack_should_be_full() {
        getStack().push("Andry");
        getStack().push("Miora");
        getStack().push("Haja");
        getStack().push("Hery");
        getStack().push("Hary");
        getStack().push("Tahina");
        getStack().push("Itokiana");
        getStack().push("Manitra");
        getStack().push("Kemba");
        getStack().push("Lanto");
        getStack().push("Nivo");
    }
}