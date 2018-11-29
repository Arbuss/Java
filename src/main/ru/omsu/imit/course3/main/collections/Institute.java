package ru.omsu.imit.course3.main.collections;

import java.util.Objects;
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

    @Override
    public String toString(){
        return name.get() + " in the " + city.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Institute institute = (Institute) o;
        return Objects.equals(name, institute.name) &&
                Objects.equals(city, institute.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city);
    }
}
