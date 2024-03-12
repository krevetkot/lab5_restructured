package objects;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;

import java.util.Objects;

@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    @XmlElement(name="name")
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement(name="passportID")
    private String passportID; //Значение этого поля должно быть уникальным, Поле может быть null
    @XmlElement(name="eyeColor")
    private Color eyeColor; //Поле не может быть null
    @XmlElement(name="hairColor")
    private Color hairColor; //Поле может быть null
    @XmlElement(name="nationality")
    private Country nationality; //Поле не может быть null
    @XmlElement(name="countKilledDragons")
    private Long countKilledDragons; //Поле должно быть больше 0

    public Person(String name, String passportID, Color eyeColor, Color hairColor, Country nationality, Long countKilledDragons){
        this.name = name;
        this.passportID = passportID;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.countKilledDragons = countKilledDragons;
    }

    public Person(){}

    @Override
    public String toString(){
        return this.getClass().getName() + '{'
                + ", name=" + this.name
                + ", pasport id=" + this.passportID
                + ", eye color=" + this.eyeColor
                + ", hair color=" + this.hairColor
                + ", nationality=" + this.nationality
                + ", count of killed dragons=" + this.countKilledDragons
                + '}';
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Person person = (Person) obj;
        return this.name.equals(person.getName())
                && Objects.equals(this.passportID, person.getPassportID())
                && this.eyeColor == person.getEyeColor()
                && this.hairColor == person.getHairColor()
                && this.nationality == person.getNationality()
                && Objects.equals(this.countKilledDragons, person.getCountKilledDragons());
    }

    @Override
    public int hashCode(){
        int hash = 31;
        hash = hash * 17 + name.hashCode();
        hash = hash * 17 + passportID.hashCode();
        hash = hash * 17 + eyeColor.hashCode();
        hash = hash * 17 + hairColor.hashCode();
        hash = hash * 17 + nationality.hashCode();
        hash = hash * 17 + countKilledDragons.hashCode();
        return hash;
    }
}
