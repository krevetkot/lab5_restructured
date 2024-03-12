package managers;

import commands.*;

import java.util.LinkedHashMap;

public class CommandManager {

    private LinkedHashMap<String, Command> commandMap;

    public CommandManager(){
        commandMap = new LinkedHashMap<>();

        commandMap.put("help", new Help(this));
        commandMap.put("info", new Info());
        commandMap.put("add", new Add());
        commandMap.put("show", new Show());
        commandMap.put("save", new Save());
        commandMap.put("update", new Update());
        commandMap.put("execute_file", new ExecuteFile(this));
        commandMap.put("remove_by_id", new RemoveByID());
        commandMap.put("clear", new Clear());
        commandMap.put("exit", new Exit());
        commandMap.put("remove_first", new RemoveFirst());
        commandMap.put("print_field_descending_age", new PrintFieldDescendingAge());
        commandMap.put("insert_at", new InsertAt());
        commandMap.put("reorder", new Reorder());
        commandMap.put("max_by_killer", new MaxByKiller());
        commandMap.put("filter_less_than_killer", new FilterLessThanKiller());

        //переделать, чтобы чел сам узнавал, какие у нас есть команды йоу йоу
        //интересно это можно сделать так: узнать все названия классов в пакете коммандс ?
    }

    public LinkedHashMap<String, Command> getCommandMap(){
        return commandMap;
    }


}
