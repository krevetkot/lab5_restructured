package objects.forms;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;
import objects.Dragon;

import java.util.ArrayList;

/**
 * Класс для обертки объектов {@link objects.Dragon} в массив при парсинге из файла.
 * @author Kseniya
 */
@Getter
@Setter
@XmlRootElement(name = "dragons")
@XmlAccessorType(XmlAccessType.FIELD)
public class DragonsForParsing {
    /** Массив драконов */
    @XmlElement(name="dragon", type = Dragon.class)
    private ArrayList<Dragon> collectionOfDragons;

}
