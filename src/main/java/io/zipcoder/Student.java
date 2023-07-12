package io.zipcoder;

import java.util.ArrayList;

public class Student {

    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores = new ArrayList<>();

    public Student(String firstName, String lastName, Double[] testScores){
        this.firstName = firstName;
        this.lastName = lastName;
        for(double x : testScores){
            examScores.add(x);
        }
    }




    //Getters and setters below this point
    public String getExamScores(){
        StringBuilder output = new StringBuilder();
        int examNum = 1;
        for(double x : examScores){
            output.append(String.format("  Exam %d -> %.0f \n", examNum, x));
            examNum++;
        }
        return output.toString();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Student name: %s %s\n", firstName, lastName));
        output.append(String.format("Average score: %.0f\n", getAverageExamScore()));
        output.append(String.format("Exam Scores:\n%s\n", getExamScores()));
        return output.toString();
    }

    public double getAverageExamScore(){
        double average = 0.0;
        for(double x: examScores){
            average+=x;
        }
        average /= examScores.size();
        return average;
    }
    public void setExamScore(int examNumber, double newScore){
        examScores.set(examNumber-1, newScore);
    }

    public void addExamScore(double examScore){
        this.examScores.add(examScore);
    }
    public int getNumberOfExamsTaken(){
        return examScores.size();
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
