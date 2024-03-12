package objects.forms;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;
import objects.Dragon;

import java.util.ArrayList;

@Getter
@Setter
@XmlRootElement(name = "dragons")
@XmlAccessorType(XmlAccessType.FIELD)
public class DragonsForParsing {
    @XmlElement(name="dragon", type = Dragon.class)
    private ArrayList<Dragon> collectionOfDragons;

}
