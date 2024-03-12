package commands;

import exceptions.IllegalValueException;
import objects.Dragon;
import managers.CollectionManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Show extends Command {
    public Show(){
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении", false);
    }

    @Override
    public void execute(String argument, boolean fileMode, Scanner scanner) throws IllegalValueException {
        ArrayList<Dragon> collection = CollectionManager.getCollection();
        if (collection.isEmpty()){
            System.out.println("Коллекция пуста.");
        }
        for (Dragon element: collection){
            try {
                System.out.println(element.toString());
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
