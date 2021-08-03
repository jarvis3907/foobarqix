package com.wemanity.foobarqix.service;

import com.wemanity.foobarqix.exception.InvalidNumberException;
import com.wemanity.foobarqix.model.Result;
import com.wemanity.foobarqix.service.impl.FooBarQixService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Foo bar qix service test.
 */
public class FooBarQixServiceTest {

    /**
     * The Foo bar qix service.
     */
    FooBarQixService fooBarQixService = new FooBarQixService();

    /**
     * Test computation.
     */
    @Test
    void testComputation() {
        Result case1 = fooBarQixService.process("1");
        assertEquals("1", case1.getResult(), "Asserting the result for value: 1");
        Result case2 = fooBarQixService.process("2");
        assertEquals("2", case2.getResult(), "Asserting the result for value: 2");
        Result case3 = fooBarQixService.process("5");
        assertEquals("BarBar", case3.getResult(), "Asserting the result for value: 5");
        Result case4 = fooBarQixService.process("3");
        assertEquals("FooFoo", case4.getResult(), "Asserting the result for value: 3");
        Result case5 = fooBarQixService.process("10");
        assertEquals("Bar*", case5.getResult(), "Asserting the result for value: 10");
        Result case6 = fooBarQixService.process("15");
        assertEquals("FooBarBar", case6.getResult(), "Asserting the result for value: 15");
        Result case7 = fooBarQixService.process("53");
        assertEquals("BarFoo", case7.getResult(), "Asserting the result for value: 53");
        Result case8 = fooBarQixService.process("101");
        assertEquals("1*1", case8.getResult(), "Asserting the result for value: 101");
        Result case9 = fooBarQixService.process("105");
        assertEquals("FooBarQix*Bar", case9.getResult(), "Asserting the result for value: 105");
        Result case10 = fooBarQixService.process("10101");
        assertEquals("FooQix**", case10.getResult(), "Asserting the result for value: 10101");
    }

    /**
     * Test computation edge case.
     */
    @Test
    void testComputationEdgeCase() {
        Assertions.assertThrows(InvalidNumberException.class, () -> {
            fooBarQixService.process("ajksbdas");
        });
    }

}
