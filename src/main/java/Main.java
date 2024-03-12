import commands.Info;
import commands.Save;
import exceptions.FailedBuildingException;
import exceptions.IllegalValueException;
import jakarta.xml.bind.JAXBException;
import managers.CollectionManager;
import managers.RuntimeManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println("Вы не указали имя файла. Запуск невозможен.");
            System.exit(1);
        }
        String filename = args[0];

        try {
            CollectionManager.loadCollection(filename);
        }
        catch (IOException | JAXBException | FailedBuildingException e){
            System.out.println(e.getMessage());
            System.out.println("Не удалось загрузить коллекцию.");
            System.exit(1);
        }

        RuntimeManager.launch();

        try {
            Save save = new Save();
            save.execute(filename, false, null);
        } catch (IllegalValueException e){
            System.out.println("Данные сохранены в файл (даже если вам этого не хотелось :) )");
        }

    }
}
