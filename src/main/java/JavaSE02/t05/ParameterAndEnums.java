package JavaSE02.t05;

public class ParameterAndEnums {
  public static void main(String[] args) {
    Group philosophia = new Group(Discipline.PHILOSOPHY);
    Student ivanov = new Student("Ivanov");
    Student petrov = new Student("Petrov");
    Student sidorov = new Student("Sidorov");
    Student dzuba = new Student("Dzuba");
    Student cherchesov = new Student("Cherchesov");


    philosophia.addStudentToGroup(ivanov, new Mark(5));
    philosophia.addStudentToGroup(petrov, new Mark(4));
    philosophia.addStudentToGroup(sidorov, new Mark(3));
    philosophia.addStudentToGroup(dzuba, new Mark(3));

    Group physics = new Group(Discipline.PHYSICS);
    physics.addStudentToGroup(ivanov,new Mark(4.0));
    physics.addStudentToGroup(petrov,new Mark(3.2));
    physics.addStudentToGroup(sidorov,new Mark(2.1));
    physics.addStudentToGroup(dzuba,new Mark(1.6));
    physics.addStudentToGroup(cherchesov,new Mark(4.8));

    //philosophia.printAllStudentsWithMarks();
    //physics.printAllStudentsWithMarks();

    ivanov.printAllDiscWithMarks();
    dzuba.compareMarks(Discipline.PHILOSOPHY, Discipline.PHYSICS);
  }
}
