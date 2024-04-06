package com.secondSemester.commands;

import com.secondSemester.exceptions.IllegalValueException;
import com.secondSemester.managers.CollectionManager;
import com.secondSemester.objects.Dragon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Команда max_by_killer: выводит любой объект из коллекции, значение поля killer которого является максимальным.
 *
 * @author Kseniya
 */
public class MaxByKiller extends Command {
    public MaxByKiller() {
        super("max_by_killer", "вывести любой объект из коллекции, значение поля killer которого является максимальным", false);
    }

    @Override
    public void execute(String argument, boolean fileMode, Scanner scanner) throws IllegalValueException {
        if (CollectionManager.getCollection().isEmpty()) {
            System.out.println("Коллекция пуста.");
        } else {
//            ArrayList<Dragon> dragons = CollectionManager.getCollection();
            ArrayList<Dragon> dragons = new ArrayList<>(CollectionManager.getCollection().stream().filter(x -> x.getKiller() != null).collect(Collectors.toList()));

            Collections.sort(dragons, new Comparator<Dragon>() {
                public int compare(Dragon d1, Dragon d2) {
                    return Long.valueOf(d1.getKiller().getCountKilledDragons() - d2.getKiller().getCountKilledDragons()).intValue();
                }
            });

            System.out.println(dragons.get(dragons.size()-1).toString());
        }
    }
}
