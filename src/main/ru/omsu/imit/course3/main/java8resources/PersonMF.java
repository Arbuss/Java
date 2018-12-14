package ru.omsu.imit.course3.main.java8resources;

public class PersonMF {
    private PersonMF mother;
    private PersonMF father;

    public PersonMF(PersonMF mother, PersonMF father){
        this.mother = mother;
        this.father = father;
    }

    public PersonMF getFather() {
        return father;
    }

    public PersonMF getMother() {
        return mother;
    }

    public PersonMF getMothersMotherFather(){
        return getMother() != null ?
                        getMother().getMother() != null ?
                                getMother().getMother().getFather() : null : null;
    }
}
