public class UniversitySystemDemo {
    static class Person {
        private String name;
        private int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }

    static class Student extends Person {
        private final int studentId;
        private double gpa;

        Student(String name, int age, int studentId, double gpa) {
            super(name, age);
            this.studentId = studentId;
            this.gpa = gpa;
        }

        public int getStudentId() {
            return studentId;
        }

        @Override
        public String toString() {
            return "Student{" + super.toString() + ", studentId=" + studentId + ", gpa=" + gpa + "}";
        }
    }

    static class GradStudent extends Student {
        private String thesis;

        GradStudent(String name, int age, int studentId, double gpa, String thesis) {
            super(name, age, studentId, gpa);
            this.thesis = thesis;
        }

        @Override
        public String toString() {
            return "GradStudent{" + super.toString() + ", thesis='" + thesis + "'}";
        }
    }

    public static void main(String[] args) {
        GradStudent gradStudent = new GradStudent("Aarav", 24, 1001, 8.9, "Machine Learning");

        System.out.println(gradStudent);
        System.out.println("GradStudent IS-A Student: " + (gradStudent instanceof Student));
        System.out.println("Student IS-A Person: " + (gradStudent instanceof Person));
        System.out.println("Final Student ID: " + gradStudent.getStudentId());
    }
}
