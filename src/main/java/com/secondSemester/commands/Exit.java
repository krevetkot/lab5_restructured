package com.secondSemester.commands;

import com.secondSemester.exceptions.IllegalValueException;

import java.util.Scanner;

/**
 * Команда exit: завершает программу без сохранения в файл.
 *
 * @author Kseniya
 */
public class Exit extends Command {
    public Exit() {
        super("exit", "завершить программу (без сохранения в файл)", false);
    }

    @Override
    public void execute(String argument, boolean fileMode, Scanner scanner) throws IllegalValueException {
        System.exit(0);
    }
}
