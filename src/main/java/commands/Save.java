package commands;

import exceptions.IllegalValueException;
import jakarta.xml.bind.JAXBException;
import managers.CollectionManager;

import java.io.IOException;
import java.util.Scanner;

public class Save extends Command{
    public Save(){
        super("save", "сохранить коллекцию в файл", false);
    }
    @Override
    public void execute(String argument, boolean fileMode, Scanner scanner) throws IllegalValueException {
        try {
            CollectionManager.saveCollection();
        }
        catch (JAXBException | IOException e){
            System.out.println(e.getMessage());
        }
    }
}
