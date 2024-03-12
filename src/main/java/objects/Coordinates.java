package objects;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;

import java.util.Objects;

@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class Coordinates {
    @XmlElement(name="x")
    private Long x; //Поле не может быть null
    @XmlElement(name="y")
    private float y;

    public Coordinates(Long x, float y){
        this.x = x;
        this.y = y;
    }

    public Coordinates(){}

    @Override
    public String toString(){
        return this.getClass().getName() + '{'
                + "x= " + this.x
                + ", y= " + this.y
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
        Coordinates coords = (Coordinates) obj;
        return Objects.equals(this.x, coords.getX()) && this.y == coords.getY();
    }

    @Override
    public int hashCode(){
        int hash = 31;
        hash = hash * 17 + x.hashCode();
        hash = hash * 17 + (int) y;
        return hash;
    }
}
