package org.example.AlgorithmTasks.EasyAlgorithms.part3.EqualizeArray;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EqualizeArrayTask {

  /*
   * Complete the 'equalizeArray' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static int equalizeArray(List<Integer> arr) {
    // Write your code here
    if (arr == null) return 0;
    if (arr.isEmpty()) return 0;
    if (arr.size() == 1) return 0;
    if (arr.size() == 2) return 1;

    Map<Integer, Integer> resultHashMap = new HashMap<>();

    for (Integer intValue: arr) {
      if (resultHashMap.containsKey(intValue)) {
        resultHashMap.put(intValue, resultHashMap.get(intValue) + 1);
      } else {
        resultHashMap.put(intValue, 1);
      }
    }

    Optional<Integer> maxRepeatedValue = resultHashMap.values().stream().max(Integer::compareTo);
    return maxRepeatedValue.map(integer -> arr.size() - integer).orElse(0);
  }

}
