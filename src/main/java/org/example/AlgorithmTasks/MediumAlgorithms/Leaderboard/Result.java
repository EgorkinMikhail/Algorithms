package org.example.AlgorithmTasks.MediumAlgorithms.Leaderboard;

import java.util.*;
import java.util.stream.Collectors;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        List<Integer> returnListLeaderboard = new ArrayList<>();
        ranked = ranked.stream().distinct().sorted(Comparator.naturalOrder()).collect(Collectors.toList());

        int playerCounter = 0;
        int rankCounter = 0;

        // 10 20 40 50 100 - ranked (size = 5)
        // 5 25 50 120     - player (size = 4)

        while ( (playerCounter < player.size()) && (rankCounter < ranked.size()) ) {
            if ( player.get(playerCounter).compareTo(ranked.get(rankCounter)) < 0 ) { // if 5 < 10
                returnListLeaderboard.add(ranked.size() - rankCounter + 1); // 5 + 0 + 1 = 6
                playerCounter++; // 0 -> 1
            }
            else {
                if ( rankCounter == ranked.size() - 1 ) {
                    returnListLeaderboard.add(1);
                    playerCounter++;
                } else {
                    rankCounter++;
                }
            }
        }

        return returnListLeaderboard;

    }

//    List<Integer> results = new ArrayList<>();
//    int playerCounter = 0;
//    int rankCounter = 0;
//    ranked = ranked
//            .stream()
//            .distinct()
//.sorted(Comparator.naturalOrder())
//            .collect(Collectors.toList());
//
//while((playerCounter < player.size()) && (rankCounter < ranked.size()) ){
//        if(player.get(playerCounter).compareTo(ranked.get(rankCounter))<0){
//            results.add(ranked.size()-rankCounter+1);
//            playerCounter++;
//        }
//        else{
//            if(rankCounter == ranked.size()-1){
//                results.add(1);
//                playerCounter++;
//            }else{
//                rankCounter++;
//            }
//        }
//    }
//return results;
}
