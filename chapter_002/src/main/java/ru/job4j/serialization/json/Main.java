package ru.job4j.serialization.json;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;


public class Main {
    public static void main(String[] args) throws Exception {
        PC pc = new PC(true, 5000, "DNS",
                new Peripherals("Samsung HRG570", "Logitech MK220",
                        "Logitech RX340", "Edifier S550"),
                new String[]{"CPU", "Motherboard", "RAM memory", "Video card",
                        "Hard disk", "Power supply unit", "PC case"});
        // Получаем контекст для доступа к АПИ
        JAXBContext context = JAXBContext.newInstance(PC.class);
        // Создаем сериализатор
        Marshaller marshaller = context.createMarshaller();
        // Указываем, что нам нужно форматирование
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            // Сериализуем
            marshaller.marshal(pc, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        // Для сериализации нам нужно создать десериализатор
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            // десериализуем
            PC result = (PC) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }

    }
}
