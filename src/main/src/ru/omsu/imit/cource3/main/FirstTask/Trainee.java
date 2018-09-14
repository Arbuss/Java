package src.ru.omsu.imit.cource3.main.FirstTask;

public class Trainee {
    private String firstName;
    private String secondName;
    private int mark;

    public Trainee(String firstName, String secondName, int mark) throws TraineeException {
        if(firstName == null)
            throw new TraineeException(TraineeErrorCodes.NULL_FIRST_NAME.getErrorText());
        if(firstName.trim().length() == 0)
            throw new TraineeException(TraineeErrorCodes.EMPTY_FIRST_NAME.getErrorText());
        if(secondName == null)
            throw new TraineeException(TraineeErrorCodes.NULL_SECOND_NAME.getErrorText());
        if(secondName.trim().length() == 0)
            throw new TraineeException(TraineeErrorCodes.EMPTY_SECOND_NAME.getErrorText());
        if(mark > 5 || mark < 1)
            throw new TraineeException(TraineeErrorCodes.INCORRECT_MARK.getErrorText());

        this.firstName = firstName;
        this.secondName = secondName;
        this.mark = mark;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws TraineeException {
        if(firstName == null)
            throw new TraineeException(TraineeErrorCodes.NULL_FIRST_NAME.getErrorText());
        if(firstName.trim().length() == 0)
            throw new TraineeException(TraineeErrorCodes.EMPTY_FIRST_NAME.getErrorText());

        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) throws TraineeException {
        if(secondName == null)
            throw new TraineeException(TraineeErrorCodes.NULL_SECOND_NAME.getErrorText());
        if(secondName.trim().length() == 0)
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
}
