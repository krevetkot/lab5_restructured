package objects;

import lombok.Getter;

public enum DragonType {
    WATER("WATER"),
    UNDERGROUND("UNDERGROUND"),
    AIR("AIR"),
    FIRE("FIRE");

    @Getter
    private final String name;

    DragonType(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return this.name;
    }
}
