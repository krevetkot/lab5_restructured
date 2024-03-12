package managers;


import lombok.Getter;

import java.io.*;
import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class ScriptManager {
    @Getter
    private static final ArrayDeque<String> pathQueue = new ArrayDeque<>();
    @Getter
    private static final ArrayDeque<BufferedReader> bufferedReaders = new ArrayDeque<>();

    public static void addFile(String fileName) throws FileNotFoundException {
        pathQueue.add(new File(fileName).getAbsolutePath());
        bufferedReaders.add(new BufferedReader(new FileReader(fileName)));
    }

    public static boolean isRecursive(String path){
        return pathQueue.contains(new File(path).getAbsolutePath());
    }

    public static String nextLine(Scanner scanner) {
        try{
            return scanner.nextLine();
        } catch (NoSuchElementException e){
            return "";
        }
    }


}
