package src.ru.omsu.imit.cource3.test.FirstTask;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import src.ru.omsu.imit.cource3.main.FirstTask.Trainee;
import src.ru.omsu.imit.cource3.main.FirstTask.TraineeException;

public class TraineeTest {
    @Test
    public void ConstructorTest() throws TraineeException {
        Trainee tr = new Trainee("fn", "sn", 5);
    }

    @Test (expected = TraineeException.class)
    public void ConstructorMarkExceptionTest() throws TraineeException {
        Trainee tr = new Trainee("fn", "sn", 7);
    }

    @Test (expected = TraineeException.class)
    public void ConstructorMarkExceptionTest2() throws TraineeException {
        Trainee tr = new Trainee("fn", "sn", 0);
    }

    @Test (expected = TraineeException.class)
    public void ConstructorFirstNameNullExceptionTest() throws TraineeException {
        Trainee tr = new Trainee(null, "sn", 4);
    }

    @Test (expected = TraineeException.class)
    public void ConstructorFirstNameEmptyExceptionTest() throws TraineeException {
        Trainee tr = new Trainee("", "sn", 4);
    }

    @Test (expected = TraineeException.class)
    public void ConstructorFirstNameEmptyExceptionTest2() throws TraineeException {
        Trainee tr = new Trainee(" ", "sn", 4);
    }

    @Test (expected = TraineeException.class)
    public void ConstructorSecondNameNullExceptionTest() throws TraineeException {
        Trainee tr = new Trainee("fn", null, 4);
    }

    @Test (expected = TraineeException.class)
    public void ConstructorSecondNameEmptyExceptionTest() throws TraineeException {
        Trainee tr = new Trainee("fn", "", 4);
    }

    @Test (expected = TraineeException.class)
    public void ConstructorSecondNameEmptyExceptionTest2() throws TraineeException {
        Trainee tr = new Trainee("fn", " ", 4);
    }

    @Test (expected = TraineeException.class)
    public void SetterSetFirstNameNullException() throws TraineeException {
        Trainee tr = new Trainee("fn", "sn", 4);
        tr.setFirstName(null);
    }

    @Test (expected = TraineeException.class)
    public void SetterSetFirstNameEmptyException() throws TraineeException {
        Trainee tr = new Trainee("fn", "sn", 4);
        tr.setFirstName("");
    }

    @Test (expected = TraineeException.class)
    public void SetterSetFirstNameEmptyException2() throws TraineeException {
        Trainee tr = new Trainee("fn", "sn", 4);
        tr.setFirstName(" ");
    }

    @Test (expected = TraineeException.class)
    public void SetterSetSecondNameNullException() throws TraineeException {
        Trainee tr = new Trainee("fn", "sn", 4);
        tr.setSecondName(null);
    }

    @Test (expected = TraineeException.class)
    public void SetterSetSecondNameEmptyException() throws TraineeException {
        Trainee tr = new Trainee("fn", "sn", 4);
        tr.setSecondName("");
    }

    @Test (expected = TraineeException.class)
    public void SetterSetSecondNameEmptyException2() throws TraineeException {
        Trainee tr = new Trainee("fn", "sn", 4);
        tr.setSecondName(" ");
    }

    @Test (expected = TraineeException.class)
    public void SetterSetMarkException() throws TraineeException {
        Trainee tr = new Trainee("fn", "sn", 4);
        tr.setMark(0);
    }

    @Test (expected = TraineeException.class)
    public void SetterSetMarkException2() throws TraineeException {
        Trainee tr = new Trainee("fn", "sn", 4);
        tr.setMark(6);
    }

    @Test
    public void SetterTest() throws TraineeException {
        Trainee tr = new Trainee("fn", "sn", 4);

        tr.setFirstName("fn1");
        assertEquals("fn1", tr.getFirstName());

        tr.setSecondName("sn2");
        assertEquals("sn2", tr.getSecondName());

        tr.setMark(2);
        assertEquals(2, tr.getMark());
    }
}
