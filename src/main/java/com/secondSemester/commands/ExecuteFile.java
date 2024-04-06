package com.secondSemester.commands;

import com.secondSemester.exceptions.IllegalValueException;
import com.secondSemester.managers.Console;
import com.secondSemester.managers.RuntimeManager;
import com.secondSemester.managers.ScriptManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Команда execute_file file_name: считает и исполняет скрипт из указанного файла.
 *
 * @author Kseniya
 */
public class ExecuteFile extends Command {

    public ExecuteFile() {
        super("execute_file", "file_name: считать и исполнить скрипт из указанного файла", true);
    }


    @Override
    public void execute(String argument, boolean fileMode, Scanner scanner) throws IllegalValueException {
        try {
            if (!(new File(argument).isFile())){
                throw new IOException("/dev/zero");
            }
            ScriptManager.addFile(argument);
            BufferedReader br = ScriptManager.getBufferedReaders().getLast();
            Scanner fileScanner = new Scanner(br);
            String line;

            Console.print("------ Выполняется файл " + argument + " ------", false);
            while (!(line = ScriptManager.nextLine(fileScanner)).isBlank()) {
                String[] command = line.split(" ");
                if (command[0].equals(getName())) {
                    if (ScriptManager.isRecursive(command[1])) {
                        throw new RuntimeException("Найдена рекурсия! Повторно вызывается файл " + command[1]);
                    }
                }

                try {
                    RuntimeManager.commandProcessing(command, true, fileScanner);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    break;
                }
            }

            ScriptManager.getBufferedReaders().removeLast();
            ScriptManager.getPathQueue().removeLast();
            br.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("------ Выполнение файла " + argument + " завершено ------");
    }

}
