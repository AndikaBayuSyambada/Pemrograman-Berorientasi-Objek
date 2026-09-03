public class PassFailActivity extends GradedActivity {
    private double minimumPassingScore;

    public PassFailActivity(double min) {
        this.minimumPassingScore = min;
    }

    @Override
    public char getGrade() {
        return (score >= minimumPassingScore) ? 'P' : 'F';
    }
}