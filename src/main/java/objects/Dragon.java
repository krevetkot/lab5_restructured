package objects;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Getter;
import lombok.Setter;
import managers.DateAdapter;
import managers.IDManager;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@XmlRootElement(name = "dragon")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dragon implements Comparable{
    @XmlElement(name="id")
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @XmlElement(name="name")
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement(name="coordinates")
    private Coordinates coordinates; //Поле не может быть null

    @XmlElement(name = "creationDate", required = true)
    @XmlJavaTypeAdapter(DateAdapter.class)
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    @XmlElement(name="age")
    private Long age; //Значение поля должно быть больше 0, Поле не может быть null
    @XmlElement(name="weight")
    private Long weight; //Значение поля должно быть больше 0, Поле не может быть null
    @XmlElement(name="speaking")
    private boolean speaking;
    @XmlElement(name="type")
    private DragonType type; //Поле может быть null
    @XmlElement(name="killer")
    private Person killer; //Поле может быть null

    //without id and date
    public Dragon(String name, Coordinates coordinates, Long age, Long weight, boolean speaking, DragonType type, Person killer){
        this.id = IDManager.generateID();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDate.now();
        this.age = age;
        this.weight = weight;
        this.speaking = speaking;
        this.type = type;
        this.killer = killer;
    }

    //with all fields
    public Dragon(int id, String name, Coordinates coordinates, LocalDate creationDate, Long age, Long weight, boolean speaking, DragonType type, Person killer){
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.age = age;
        this.weight = weight;
        this.speaking = speaking;
        this.type = type;
        this.killer = killer;
    }

    public Dragon(){}

    @Override
    public String toString(){
        if (killer == null){
            return this.getClass().getName() + '{'
                    + "id= " + this.id
                    + ", name=" + this.name
                    + ", coordinates=" + this.coordinates
                    + ", creation date=" + this.creationDate
                    + ", age=" + this.age
                    + ", weight=" + this.weight
                    + ", speaking=" + this.speaking
                    + ", type=" + this.type
                    + ", killer=null"
                    + '}';
        }
        return this.getClass().getName() + '{'
                + "id= " + this.id
                + ", name=" + this.name
                + ", coordinates=" + this.coordinates
                + ", creation date=" + this.creationDate
                + ", age=" + this.age
                + ", weight=" + this.weight
                + ", speaking=" + this.speaking
                + ", type=" + this.type
                + ", killer=" + this.killer.toString()
                + '}';
    }

    @Override
    public int compareTo(Object o) {
        Dragon anotherDragon = (Dragon) o;
        return (int)((getCoordinates().getX()*getCoordinates().getX() + getCoordinates().getY()*getCoordinates().getY())
                        - (anotherDragon.getCoordinates().getX()*anotherDragon.getCoordinates().getX() +
                        anotherDragon.getCoordinates().getY()*anotherDragon.getCoordinates().getY()));
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Dragon dragon = (Dragon) obj;
        return this.id == dragon.getId()
                && this.name.equals(dragon.getName())
                && this.coordinates.equals(dragon.getCoordinates())
                && this.creationDate.equals(dragon.getCreationDate())
                && Objects.equals(this.age, dragon.getAge())
                && Objects.equals(this.weight, dragon.getWeight())
                && this.speaking == dragon.getSpeaking()
                && this.type == dragon.getType()
                && this.killer.equals(dragon.getKiller());
    }

    public boolean getSpeaking(){
        return this.speaking;
    }

    @Override
    public int hashCode(){
        int hash = 31;
        hash = hash * 17 + name.hashCode();
        hash = hash * 17 + id;
        hash = hash * 17 + coordinates.hashCode();
        hash = hash * 17 + creationDate.hashCode();
        hash = hash * 17 + age.hashCode();
        hash = hash * 17 + weight.hashCode();
        if (speaking){
            hash = hash * 17 + 1;
        }
        hash = hash * 17 + type.getName().hashCode();
        hash = hash * 17 + killer.hashCode();
        return hash;
    }
}