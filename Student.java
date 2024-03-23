public class Student {
    String gender;
    String group;
    String parentalLevel;
    String lunch;
    String testPreparationCourse;
    int mathScore;
    int readingScore;
    int writingScore;
    double averageScore;


    public Student(String gender, String group, String parentalLevel, String lunch, String testPreparationCourse,
                   int mathScore, int readingScore, int writingScore) {
        this.gender = gender;
        this.group = group;
        this.parentalLevel = parentalLevel;
        this.lunch = lunch;
        this.testPreparationCourse = testPreparationCourse;
        this.mathScore = mathScore;
        this.readingScore = readingScore;
        this.writingScore = writingScore;
        averageScore = (mathScore+writingScore+readingScore)/3.0;
    }


    public double averageMarks(){

        return averageScore;



    }

    @Override
    public String toString(){
        return ("Gender : " + gender +  "  Group  " + group + " Parental Level : " + " Lunch : " + lunch +
                " TestPreparationCourse "+ testPreparationCourse +" Math Score : " + mathScore + "  Reading Score : " +
                readingScore + " , Writing Score : " + writingScore + " Average Score : " + averageMarks()) ;
    }
}