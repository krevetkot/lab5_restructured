package commands;

import exceptions.IllegalValueException;
import managers.CollectionManager;
import managers.Console;
import objects.Dragon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PrintFieldDescendingAge extends Command{
    public PrintFieldDescendingAge(){
        super("print_field_descending_age", "вывести значения поля age всех элементов в порядке убывания", false);}
    @Override
    public void execute(String argument, boolean fileMode, Scanner scanner) throws IllegalValueException {
        if (CollectionManager.getCollection().isEmpty()){
            Console.print("Коллекция пуста.", fileMode);
        }
        else {
            ArrayList<Long> ages = new ArrayList<>();
            for (Dragon element: CollectionManager.getCollection()){
                ages.add(element.getAge());
            }
            ages.sort(Collections.reverseOrder());
            System.out.println("Возраста всех драконов в порядке убывания:");
            for (Long age: ages){
                System.out.print(age + " ");
            }
            System.out.println();
        }
    }
}
