package io.zipcoder;

import java.util.Arrays;

public class Classroom {
    private Student[] students;


    public Classroom(){
        students = new Student[30];
    }
    public Classroom(int numOfStudents){
        students = new Student[numOfStudents];
    }
    public Classroom(Student[] students){
        this.students = students;
    }


    //Getters Setters and fun stuff beyond this point

    public Student[] getStudents() {
        return students;
    }

    public double getAverageExamScore(){
        double average = 0.0;
        for(Student s : students){
            average+= s.getAverageExamScore();
        }
        average /= students.length;
        return average;
    }

    public void addStudent(Student student){
        Student[] hold = new Student[students.length];
        for(int i = 0; i < hold.length; i++){
            if(students[i] == null){
                hold[i] = student;
                break;
            }
            hold[i] = students[i];
        }
        this.students = hold;
    }

    public void removeStudent(String firstName, String lastName){
        for(int i = 0; i < students.length; i++){
            if(students[i].getFirstName().equals(firstName)&& students[i].getLastName().equals(lastName)){
                students[i] = null;
            }
        }
        Student[] hold = new Student[students.length];
        int position = 0;
        int endPosition = students.length-1;
        for(int i = 0; i < students.length; i++){
            if(students[i]== null){
            hold[endPosition] = students[i];
            endPosition--;
            } else{
                hold[position] = students[i];
                position++;
            }
        }
        students = hold;

    }
    public static void main(String[] args) {
        // : Given
        int maxNumberOfStudents = 4;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);
        Student student1 = new Student("James", "Jimmithy", examScores);
        Student student2 = new Student("Jame", "JimJim", examScores);
        Student student3 = new Student("Jay", "Jibs", examScores);

        // When
        classroom.addStudent(student);
        classroom.addStudent(student1);
        classroom.addStudent(student2);
        classroom.addStudent(student3);
        Student[] preEnrollment = classroom.getStudents();
        classroom.removeStudent("James", "Jimmithy");
        Student[] postEnrollment = classroom.getStudents();

        // Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);
    }

}
