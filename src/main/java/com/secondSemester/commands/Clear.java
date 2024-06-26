package com.secondSemester.commands;

import com.secondSemester.exceptions.IllegalValueException;
import com.secondSemester.managers.CollectionManager;
import com.secondSemester.managers.Console;

import java.util.Scanner;

/**
 * Команда clear: очищает коллекцию.
 *
 * @author Kseniya
 */
public class Clear extends Command {
    public Clear() {
        super("clear", "очистить коллекцию", false);
    }

    @Override
    public void execute(String argument, boolean fileMode, Scanner scanner) throws IllegalValueException {
        if (CollectionManager.getCollection().isEmpty()) {
            Console.print("Коллекция и так пуста.", fileMode);
        } else {
            CollectionManager.getCollection().clear();
            Console.print("Коллекция очищена.", fileMode);
        }
    }
}
