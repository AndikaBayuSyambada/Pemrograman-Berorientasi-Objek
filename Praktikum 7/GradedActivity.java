public class GradedActivity {
    protected double score;
    private String name;

    public GradedActivity() {}
    
    public GradedActivity(String n) {
        this.name = n;
    }

    public void setScore(double s) {
        this.score = s;
    }
    
    public double getScore() {
        return score;
    }

    public char getGrade() {
        if (score >= 80) return 'A';
        else if (score >= 70) return 'B';
        else if (score >= 60) return 'C';
        else return 'D';
    }
}