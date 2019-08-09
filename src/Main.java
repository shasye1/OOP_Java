class Main {
    public static void main(String[] args) {
        Student student = new Student(2);
        student.addClass(new Class("SE 450"));
        student.addClass(new Class("SE 550"));

        System.out.println(student.getFormattedSchedule());
    }
}