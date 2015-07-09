package com.samlikescode.stackoverflow.questions.q31264303;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.List;

public class Zoo {
    public List<Animal> animals = Lists.newArrayList();

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("animals", animals)
                .toString();
    }
}
