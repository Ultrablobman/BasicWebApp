package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void addsNumbers() throws Exception {
        assertThat(queryProcessor.process("1981e6a0: what is 0 plus 0"), is("0"));
        assertThat(queryProcessor.process("1981e6a0: what is 3 plus 4"), is("7"));
        assertThat(queryProcessor.process("e186e430: what is 0 plus 19"), is("19"));
    }


    @Test
    public void multiplyNumbers() throws Exception {
        assertThat(queryProcessor.process("b5aac200: what is 1 multiplied by 19"), is("19"));
    }
}
