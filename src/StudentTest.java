import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class StudentTest {

    // Test that a class gets added to the student's Classes list
    // Create a student, add a class, and make sure the class that
    // was added exists in the student's classes.
    @Test
    public void testAddClass(){
        // Arrange
        Student student = new Student(2);
        Class class1 = new Class("SE 450");

        // Act
        student.addClass(class1);

        // Assert
        List<Class> classes = student.getClasses();
        assertEquals(1, classes.size());
        assertEquals(class1.getName(), classes.get(0).getName());
    }

    // Test that a class does not get added if maxNumberOfClasses
    // has been reached. Create a student with a max number of classes
    // of 2, add three classes, make sure the first two were added but
    // the third was not.
    @Test
    public void testAddClassDoesntAddClassesIfMaxed(){
        // Arrange
        Student student = new Student(2);
        Class class1 = new Class("SE 450");
        Class class2 = new Class("SE 550");
        Class class3 = new Class("SE 650");

        // Act
        student.addClass(class1);
        student.addClass(class2);
        student.addClass(class3);

        // Assert
        List<Class> classes = student.getClasses();
        assertEquals(2, classes.size());
        assertSame(class1.getName(), classes.get(0).getName());
        assertSame(class2.getName(), classes.get(1).getName());
    }

    // Test the formatting of the schedule when getFormattedSchedule is called.
    // Add a couple classes to student, then make sure the string returned by
    // getFormattedSchedule is in the format {ClassName1}\r\n{ClassName2}\r\n
    @Test
    public void testGetFormattedSchedule(){
        // Arrange
        Student student = new Student(2);
        Class class1 = new Class("SE 450");
        Class class2 = new Class("SE 550");
        student.addClass(class1);
        student.addClass(class2);

        // Act
        String formattedSchedule = student.getFormattedSchedule();

        // Assert
        assertEquals("SE 450\r\nSE 550\r\n", formattedSchedule);
    }

    // Test that if a student has no classes, when getFormattedSchedule is called
    // the string "No classes added." gets returned.
    @Test
    public void testGetFormattedScheduleReturnsNoClassesAddedIfNoClasses(){

        // Arrange
        Student student = new Student(2);

        // Act
        String formattedSchedule = student.getFormattedSchedule();

        // Assert
        assertEquals("No classes added.", formattedSchedule);
    }
}