package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "pc")
@XmlAccessorType(XmlAccessType.FIELD)
public class PC {
    @XmlAttribute
    private boolean videoCard;
    private int frequencyCPU;
    private String collector;
    private Peripherals peripherals;
    @XmlElementWrapper(name = "accessories")
    @XmlElement(name = "accessory")
    private String[] accessories;

    public PC() {

    }

    public PC(boolean videoCard, int frequencyCPU, String collector, Peripherals peripherals, String[] accessories) {
        this.videoCard = videoCard;
        this.frequencyCPU = frequencyCPU;
        this.collector = collector;
        this.peripherals = peripherals;
        this.accessories = accessories;
    }

    @Override
    public String toString() {
        return "PC{"
                + "videoCard=" + videoCard
                + ", frequencyCPU=" + frequencyCPU
                + ", collector='" + collector + '\''
                + ", peripherals=" + peripherals
                + ", accessories=" + Arrays.toString(accessories)
                + '}';
    }

    public boolean isVideoCard() {
        return videoCard;
    }

    public int getFrequencyCPU() {
        return frequencyCPU;
    }

    public String getCollector() {
        return collector;
    }

    public Peripherals getPeripherals() {
        return peripherals;
    }

    public String[] getAccessories() {
        return accessories;
    }

    public static void main(String[] args) throws JAXBException {
        PC pc = new PC(true, 5000, "DNS",
                new Peripherals("Samsung HRG570", "Logitech MK220",
                        "Logitech RX340", "Edifier S550"),
                new String[]{"CPU", "Motherboard", "RAM memory", "Video card",
                        "Hard disk", "Power supply unit", "PC case"});
        Gson gson = new GsonBuilder().create();
        String pcJson = gson.toJson(pc);
        System.out.println(pcJson);
        PC pcMod = gson.fromJson(pcJson, PC.class);
        System.out.println(pcMod);
        JAXBContext context = JAXBContext.newInstance(PC.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(pc, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {

        }
        JSONObject jsonPeripherals = new JSONObject("{\"peripherals\":"
                + "{\"monitor\":\"Samsung HRG570\",\"keyboard\":\"Logitech MK220\","
                + "\"mouse\":\"Logitech RX340\",\"columns\":\"Edifier S550\"}}");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("videoCard", pc.isVideoCard());
        jsonObject.put("frequencyCPU", pc.getFrequencyCPU());
        jsonObject.put("collector", pc.getCollector());
        jsonObject.put("peripherals", pc.getPeripherals());
        jsonObject.put("accessories", pc.getAccessories());
        System.out.println(jsonPeripherals.toString());
        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(pc).toString());


    }
}

