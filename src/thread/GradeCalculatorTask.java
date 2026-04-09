package thread;
import model.Student;
import java.util.concurrent.ConcurrentHashMap;
public class GradeCalculatorTask implements Runnable
{
    private Student student;
    private ConcurrentHashMap<String, String> results; // shared collection
    public GradeCalculatorTask(Student student, ConcurrentHashMap<String, String> results)
    {
        this.student = student;
        this.results = results;
    }
    @Override
    public void run()
    {
        double avg = student.calculateAverage();
        String letterGrade  = student.getLetterGrade();
        String result = String.format("  Avg:  Letter: ",
                student.getStudentId(),
                student.getName(),
                avg,
                letterGrade);
        results.put(student.getStudentId(), result);
        System.out.println("Done: " + student.getName());
    }
}
