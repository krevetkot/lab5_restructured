package com.secondSemester.commands;

import com.secondSemester.exceptions.IllegalValueException;
import com.secondSemester.managers.CollectionManager;

import java.util.Collections;
import java.util.Scanner;

/**
 * Команда reorder: отсортировывает коллекцию в порядке, обратном нынешнему.
 *
 * @author Kseniya
 */
public class Reorder extends Command {
    public Reorder() {
        super("reorder", "отсортировать коллекцию в порядке, обратном нынешнему", false);
    }

    @Override
    public void execute(String argument, boolean fileMode, Scanner scanner) throws IllegalValueException {
        Collections.reverse(CollectionManager.getCollection());
        System.out.println("Коллекция отсортирована в обратном порядке.");
    }


}
