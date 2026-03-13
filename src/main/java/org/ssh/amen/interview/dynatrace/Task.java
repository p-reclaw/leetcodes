package org.ssh.amen.interview.dynatrace;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task {
//    Given an English book in a text file, print the 10 most commonly occurring words in descending order.
    public static List<Map.Entry<String, Integer>> findMostCommonWords(String filePath){
        Map<String, Integer> map = new HashMap<>();
        //


        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            reader.lines().forEach(s -> {
                Arrays.stream(s.replaceAll("[,.;!?]", "")
                        .toLowerCase()
                        .split(" "))
                        .forEach(checkedWord -> {
                            if (!map.containsKey(checkedWord)){
                                map.put(checkedWord, 0);
                            }

                            map.put(checkedWord, map.get(checkedWord)+1);
                        });
            });
        }catch (IOException ie){
            System.err.println("Err " + ie.getMessage() );
        }

        return map.entrySet()
                .stream()
                .sorted((entry1, entry2) -> {
                    int compareOccurrences = Integer.compare(entry2.getValue(), entry1.getValue());
                    if(compareOccurrences == 0){
                        return entry1.getKey().compareTo(entry2.getKey());
                    }
                    return compareOccurrences;
                })
                .limit(10)
                .toList();
    }

    public static void main(String[] args) {
        findMostCommonWords(args[0]);
    }
}
