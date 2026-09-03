public class FinalExam extends GradedActivity {
    private int numberOfQuestions;
    private int numberMissed;
    private double pointsPerQuestion;

    public FinalExam(int questions, int missed) {
        this.numberOfQuestions = questions;
        this.numberMissed = missed;
        this.pointsPerQuestion = 100.0 / questions;
        
        setScore(100.0 - (missed * pointsPerQuestion));
    }

    public double getPointsPerQuestion() {
        return pointsPerQuestion;
    }

    public int getNumberMissed() {
        return numberMissed;
    }
}