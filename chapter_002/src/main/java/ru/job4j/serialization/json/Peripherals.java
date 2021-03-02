package ru.job4j.serialization.json;

import com.sun.xml.txw2.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "peripherals")
public class Peripherals {
    @XmlAttribute
    private String monitor;
    private String keyboard;
    private String mouse;
    private String columns;

    public Peripherals() {

    }

    public Peripherals(String monitor, String keyboard, String mouse, String columns) {
        this.monitor = monitor;
        this.keyboard = keyboard;
        this.mouse = mouse;
        this.columns = columns;
    }

    @Override
    public String toString() {
        return "Peripherals{"
                + "monitor='" + monitor + '\''
                + ", keyboard='" + keyboard + '\''
                + ", mouse='" + mouse + '\''
                + ", columns='" + columns + '\''
                + '}';
    }
}
