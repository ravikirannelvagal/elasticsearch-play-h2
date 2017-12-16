package com.holidu;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UnitTest {


    public void test() {
        assertThat(Integer.toString(1), equalTo("1"));
    }
}
