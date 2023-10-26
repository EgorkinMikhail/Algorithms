package org.example.AlgorithmTasks.EasyAlgorithms.part3.GradingStudents;

import java.util.LinkedList;
import java.util.List;

public class StudentsAndGradesUtil {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> outGradesList = new LinkedList<>();
        // Write your code here
        for (Integer element: grades) {
            if (element < 38) {
                outGradesList.add(element);
                continue;
            }
            if (element%5==0) {
                outGradesList.add(element);
                continue;
            }

            if ((((element/5+1)*5) - element) < 3) {
                outGradesList.add((element/5+1)*5);
            } else outGradesList.add(element);
        }
        return outGradesList;
    }

}
