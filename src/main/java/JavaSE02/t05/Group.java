package JavaSE02.t05;

import java.util.HashMap;
import java.util.Map;

enum Discipline {PHILOSOPHY, PHYSICS, ECONOMY}

public class Group {
  private Discipline discipline;
  private Map<Student, Mark> group = new HashMap<Student, Mark>();

  Group(Discipline discipline) {
    this.discipline = discipline;
  }

  void addStudentToGroup(Student student, Mark mark) {
    group.put(student, mark);
    student.discAndMarks.put(this.discipline, mark);
  }

  void removeStudentFromGroup(Student student){
    group.remove(student);
    student.discAndMarks.remove(this.discipline);
  }

  void printAllStudentsWithMarks() {
    System.out.println("Список студентов по " + discipline.toString() + ":");
    for (Map.Entry<Student,Mark> entry : group.entrySet())
      System.out.println(entry.getKey().toString() + ": " + entry.getValue().toString());
  }
}