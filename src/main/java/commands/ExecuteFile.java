package commands;

import exceptions.IllegalValueException;
import managers.CommandManager;
import managers.Console;
import managers.RuntimeManager;
import managers.ScriptManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ExecuteFile extends Command{
    private CommandManager commandManager;
    public ExecuteFile(CommandManager commandManager){
        super("execute_file", "считать и исполнить скрипт из указанного файла", true);
        this.commandManager = commandManager;
    }


    @Override
    public void execute(String argument, boolean fileMode, Scanner scanner) throws IllegalValueException {
        try {

            ScriptManager.addFile(argument);
            BufferedReader br = ScriptManager.getBufferedReaders().getLast();
            Scanner fileScanner = new Scanner(br);
            String line;

            Console.print("------ Выполняется файл " + argument  + " ------", false);
            while (!(line = ScriptManager.nextLine(fileScanner)).isBlank()) {
                String[] command = line.split(" ");
                if (command[0].equals("execute_file")) {
                    if (ScriptManager.isRecursive(command[1])) {
                        throw new RuntimeException("Найдена рекурсия! Повторно вызывается файл " + command[1]);
                    }
                }

                try {
                    RuntimeManager.commandProcessing(command, true, fileScanner);
                } catch (Exception e){
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

        System.out.println("------ Выполнение файла " + argument +  " завершено ------");
    }

}
