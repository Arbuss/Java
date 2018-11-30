package ru.omsu.imit.course3.main.collections;

import ru.omsu.imit.course3.main.collections.exceptions.InstituteErrorCodes;
import ru.omsu.imit.course3.main.collections.exceptions.InstituteException;

import java.util.Objects;
import java.util.Optional;

public class Institute {
    String name;
    String city;

    public Institute(String name, String city) throws InstituteException {
        setName(name);
        setCity(city);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InstituteException {
        if(name == null)
            throw new InstituteException(InstituteErrorCodes.NULL_NAME.getErrorText());
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws InstituteException {
        if(city == null)
            throw new InstituteException(InstituteErrorCodes.NULL_CITY.getErrorText());
        this.city = city;
    }

    @Override
    public String toString(){
        return name + " in the " + city;
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
