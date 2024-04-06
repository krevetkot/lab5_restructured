package com.secondSemester.commands;

import com.secondSemester.exceptions.FailedBuildingException;
import com.secondSemester.exceptions.IllegalValueException;
import com.secondSemester.managers.CollectionManager;
import com.secondSemester.managers.Console;
import com.secondSemester.objects.Dragon;
import com.secondSemester.objects.forms.DragonForm;

import java.util.Collections;
import java.util.Scanner;

/**
 * Команда add {element}: добавляет новый элемент в коллекцию.
 *
 * @author Kseniya
 */
public class Add extends Command {
    public Add() {
        super("add", " {element}: добавить новый элемент в коллекцию", false);
    }

    @Override
    public void execute(String argument, boolean fileMode, Scanner scanner) throws IllegalValueException {
        DragonForm newDragon = new DragonForm();
        try {
            Dragon buildedDragon = newDragon.build(scanner, fileMode);
            if (!CollectionManager.getCollection().contains(buildedDragon)) {
                CollectionManager.getCollection().add(buildedDragon);
                Collections.sort(CollectionManager.getCollection());
                Console.print("Спасибо, ваши данные приняты!", fileMode);
            } else {
                Console.print("Такой дракон уже есть в коллекции.", false);
            }
        } catch (FailedBuildingException e) {
            Console.print(e.getMessage(), false);
        }
    }
}
