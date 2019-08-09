import java.util.ArrayList;
import java.util.List;

class Student {
    private final List<Class> classes;
    private final int maxNumberOfClasses;

    Student(int maxNumberOfClasses){
        classes = new ArrayList();
        this.maxNumberOfClasses = maxNumberOfClasses;
    }

    void addClass(Class newClass){
        if(classes.size() < maxNumberOfClasses)
            classes.add(newClass);
    }

    List<Class> getClasses(){
        return classes;
    }

    String getFormattedSchedule(){
        if(classes.size() == 0)
            return "No classes added.";

        String schedule = "";
        for (Class studentClass : classes) {
            schedule += studentClass.getName() + "\r\n";
        }

        return schedule;
    }
}