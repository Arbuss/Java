package ru.omsu.imit.course3.main.collections;

import java.util.Optional;

public class Institute {
    Optional<String> name;
    Optional<String> city;

    public Institute(String name, String city) {
        setName(name);
        setCity(city);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = Optional.ofNullable(name);
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city = Optional.ofNullable(city);
    }
}
