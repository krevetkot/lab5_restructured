package managers;

import objects.Coordinates;
import objects.Dragon;
import objects.Person;

public class Validator {
    public static boolean dragonValidation(Dragon dragon){
        if (dragon == null){
            return false;
        }
        return !dragon.getName().isBlank() && dragon.getCoordinates() != null
                && dragon.getAge() != null
                && dragon.getWeight() != null
                && personValidation(dragon.getKiller())
                && coordValidation(dragon.getCoordinates());
    }

    public static boolean personValidation(Person person){
        if (person == null){
            return true;
        }
        return !person.getName().isBlank() && person.getEyeColor() != null
                && person.getNationality() != null;
    }

    public static boolean coordValidation(Coordinates coords){
        if (coords == null){
            return false;
        }
        return coords.getX() != null;
    }

//    public static boolean dragonIsUnique(Dragon dragon){
//        return CollectionManager.getCollection().contains(dragon) &&
//    }


}
