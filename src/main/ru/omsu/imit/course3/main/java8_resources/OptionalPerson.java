package ru.omsu.imit.course3.main.java8_resources;

import java.util.Optional;

public class OptionalPerson {
    private Optional<OptionalPerson> mother;
    private Optional<OptionalPerson> father;

    public OptionalPerson(OptionalPerson mother, OptionalPerson father) {
        this.mother = Optional.ofNullable(mother);
        this.father = Optional.ofNullable(father);
    }

    public Optional<OptionalPerson> getFather() {
        return father;
    }

    public Optional<OptionalPerson> getMother() {
        return mother;
    }

    private OptionalPerson getMothersMotherFather() {
        return mother.flatMap(p -> p.getMother()
                .flatMap(OptionalPerson::getMother)
                .flatMap(OptionalPerson::getFather))
                .orElse(null);
    }
}
