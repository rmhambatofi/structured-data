package fr.manitra.sd;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by manitra on 30/10/2016.
 */
public abstract class AbstractStackTest {

    @Test
    public void should_return_one() throws Exception {
        assertThat(getStack().size()).isEqualTo(1);
        getStack().push("Andry");
        assertThat(getStack().size()).isEqualTo(2);
    }

    @Test
    public void stack_should_be_empty() throws Exception {
        String top = getStack().pop();
        System.out.println("Popped: " + top);
        assertThat(getStack().isEmpty()).isTrue();
    }

    @Test
    public void stack_should_not_be_empty() throws Exception {
        assertThat(getStack().isEmpty()).isFalse();
    }

    @Test
    public void should_push_string() throws Exception {
        assertThat(getStack().size()).isEqualTo(1);
        getStack().push("Andry");
        assertThat(getStack().size()).isEqualTo(2);
    }

    @Test
    public void should_get_top_element() throws Exception {
        assertThat(getStack().size()).isEqualTo(1);
        getStack().push("Andry");
        assertThat(getStack().top()).isEqualTo("Andry");
        getStack().push("Miora");
        assertThat(getStack().top()).isEqualTo("Miora");
        assertThat(getStack().size()).isEqualTo(3);
    }

    @Test
    public void popTest() throws Exception {
        assertThat(getStack().size()).isEqualTo(1);
        getStack().push("Andry");
        getStack().push("Miora");
        assertThat(getStack().pop()).isEqualTo("Miora");
        assertThat(getStack().pop()).isEqualTo("Andry");
        assertThat(getStack().pop()).isEqualTo("Nirina");
        assertThat(getStack().isEmpty()).isTrue();
    }

    protected abstract Stack<String> getStack();
}
