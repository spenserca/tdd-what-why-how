package com.spenserca.demo.services;

import com.spenserca.demo.models.Animal;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LooperServiceTest {
    private LooperService underTest;
    private SomethingToMockService somethingToMockService = mock(SomethingToMockService.class);

    @BeforeAll
    private void setup() {
        underTest = new LooperService(somethingToMockService);
    }

    @Test
    public void loopAnimals_Called_CallsSomethingToMockServiceDoSomethingForEachAnimal() {
        Animal expectedAnimalOne = new Animal(RandomString.make(), RandomString.make(), RandomString.make());
        Animal expectedAnimalTwo = new Animal(RandomString.make(), RandomString.make(), RandomString.make());
        List<Animal> expectedAnimals = Arrays.asList(expectedAnimalOne, expectedAnimalTwo);

        underTest.loopAnimals(expectedAnimals);

        expectedAnimals.forEach((expectedAnimal -> {
            verify(somethingToMockService).logAnimal(expectedAnimal);
        }));
    }

    @Test
    public void loopAnimals_Called_ReturnsPassedInListOfAnimals() {
        Animal expectedAnimalOne = new Animal(RandomString.make(), RandomString.make(), RandomString.make());
        Animal expectedAnimalTwo = new Animal(RandomString.make(), RandomString.make(), RandomString.make());
        List<Animal> expectedAnimals = Arrays.asList(expectedAnimalOne, expectedAnimalTwo);

        List<Animal> actualAnimals = underTest.loopAnimals(expectedAnimals);

        assertThat(actualAnimals).isEqualTo(expectedAnimals);
    }
}