package com.spenserca.demo.models;

import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AnimalTest {
    private Animal underTest;

    @Test
    public void toString_Called_ReturnsExpectedString() {
        String expectedName = RandomString.make();
        String expected = "I'm a " + expectedName + ".";
        underTest = new Animal(expectedName, RandomString.make(), RandomString.make());

        String actual = underTest.toString();

        assertThat(actual).isEqualTo(expected);
    }
}