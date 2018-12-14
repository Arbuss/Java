package ru.omsu.imit.course3.main.first.task.trainee;

import java.io.Serializable;

public class Trainee implements Serializable, Comparable<Trainee> {
    private String firstName;
    private String secondName;
    private int mark;

    public Trainee(String firstName, String secondName, int mark) throws TraineeException {

        setFirstName(firstName);
        setSecondName(secondName);
        setMark(mark);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws TraineeException {
        if(firstName == null || firstName.trim().length() == 0)
            throw new TraineeException(TraineeErrorCodes.EMPTY_FIRST_NAME.getErrorText());

        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) throws TraineeException {
        if(secondName == null || secondName.trim().length() == 0)
            throw new TraineeException(TraineeErrorCodes.EMPTY_SECOND_NAME.getErrorText());

        this.secondName = secondName;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) throws TraineeException {
        if(mark > 5 || mark < 1)
            throw new TraineeException(TraineeErrorCodes.INCORRECT_MARK.getErrorText());

        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trainee)) return false;

        Trainee trainee = (Trainee) o;

        if (getMark() != trainee.getMark()) return false;
        if (!getFirstName().equals(trainee.getFirstName())) return false;
        return getSecondName().equals(trainee.getSecondName());
    }

    @Override
    public int hashCode() {
        int result = getFirstName().hashCode();
        result = 31 * result + getSecondName().hashCode();
        result = 31 * result + getMark();
        return result;
    }

    @Override
    public String toString() {
        return "fN:" + firstName + ";sN:" + secondName + ";m:" + mark;
    }

    @Override
    public int compareTo(Trainee o) {
        return firstName.compareTo(o.getFirstName());
    }
}
