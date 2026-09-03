public class PassFailExam extends PassFailActivity {
    private int numberOfQuestions;
    private double pointsPerQuestion;
    private int numberMissed;

    public PassFailExam(int questions, int missed, double minPassing) {
        super(minPassing);
        this.numberOfQuestions = questions;
        this.numberMissed = missed;
        this.pointsPerQuestion = 100.0 / questions;
        
        setScore(100.0 - (missed * pointsPerQuestion));
    }

    public double getPointsEach() {
        return pointsPerQuestion;
    }

    public int getNumMissed() {
        return numberMissed;
    }
}