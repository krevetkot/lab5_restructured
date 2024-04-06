package com.secondSemester.commands;

import com.secondSemester.exceptions.IllegalValueException;
import com.secondSemester.managers.CollectionManager;
import com.secondSemester.managers.Console;
import com.secondSemester.objects.Dragon;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Команда filter_less_than_killer: killer: выводит элементы, значение поля killer которых меньше заданного.
 *
 * @author Kseniya
 */
public class FilterLessThanKiller extends Command {
    public FilterLessThanKiller() {
        super("filter_less_than_killer", "killer: вывести элементы, значение поля killer которых меньше заданного", true);
    }

    @Override
    public void execute(String argument, boolean fileMode, Scanner scanner) throws IllegalValueException, NumberFormatException, NoSuchElementException {
        if (CollectionManager.getCollection().isEmpty()) {
            Console.print("Коллекция пуста.", fileMode);
        } else {
            Long killer = Long.parseLong(argument);

            if (killer <= 0) {
                throw new NoSuchElementException("Агрумент killer должен быть больше нуля.");
            }
            boolean flag = true;
            for (Dragon element : CollectionManager.getCollection()) {
                if (element.getKiller() != null) {
                    if (element.getKiller().getCountKilledDragons() < killer) {
                        System.out.println(element);
                        flag = false;
                    }
                }
            }
            if (flag) {
                Console.print("Нет подходящих элементов.", fileMode);
            }
        }
    }

}
