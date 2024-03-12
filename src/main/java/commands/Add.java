package commands;

import exceptions.FailedBuildingException;
import exceptions.IllegalValueException;
import managers.CollectionManager;
import managers.Console;
import managers.Validator;
import objects.Dragon;
import objects.forms.DragonForm;

import java.util.Collections;
import java.util.Scanner;

public class Add extends Command {

    public Add(){
        super("add", "добавить новый элемент в коллекцию", false);
    }
    @Override
    public void execute(String argument, boolean fileMode, Scanner scanner) throws IllegalValueException {
        DragonForm newDragon = new DragonForm();
        try {
            Dragon buildedDragon = newDragon.build(scanner, fileMode);
            if (!CollectionManager.getCollection().contains(buildedDragon)){
                CollectionManager.getCollection().add(buildedDragon);
                Collections.sort(CollectionManager.getCollection());
                Console.print("Спасибо, ваши данные приняты!", fileMode);
            }
            else {
                Console.print("Такой дракон уже есть в коллекции.", false);
            }
        } catch (FailedBuildingException e){
            Console.print(e.getMessage(), false);
        }
    }
}
