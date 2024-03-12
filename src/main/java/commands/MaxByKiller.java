package commands;

import exceptions.IllegalValueException;
import managers.CollectionManager;
import objects.Dragon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MaxByKiller extends Command{
    public MaxByKiller(){
        super("max_by_killer", "вывести любой объект из коллекции, значение поля killer которого является максимальным", false);
    }

    @Override
    public void execute(String argument, boolean fileMode, Scanner scanner) throws IllegalValueException {
        if (CollectionManager.getCollection().isEmpty()){
            System.out.println("Коллекция пуста.");
        }
        else {
            ArrayList<Dragon> dragons = CollectionManager.getCollection();

            Collections.sort(dragons, new Comparator<Dragon>() {
                public int compare(Dragon d1, Dragon d2) {
                    if (d1.getKiller() == null){
                        return 1;
                    }
                    if (d2.getKiller() == null){
                        return -1;
                    }
                    return Long.valueOf(d1.getKiller().getCountKilledDragons() - d2.getKiller().getCountKilledDragons()).intValue();
                }
            });

            System.out.println(dragons.getLast().toString());
        }
    }
}
