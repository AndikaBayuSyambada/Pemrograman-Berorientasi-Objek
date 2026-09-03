public class ExamDemo {
    public static void main(String[] args) {
        System.out.println("--- Final Exam ---");
        FinalExam fe = new FinalExam(50, 7);
        System.out.println("Score: " + fe.getScore());
        System.out.println("Grade: " + fe.getGrade());

        System.out.println("\n--- Pass/Fail Exam ---");
        PassFailExam pfe = new PassFailExam(20, 5, 75.0);
        System.out.println("Score: " + pfe.getScore());
        System.out.println("Grade (P=Pass, F=Fail): " + pfe.getGrade());
    }
}