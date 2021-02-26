package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class PC {
    private final boolean videoCard;
    private final int frequencyCPU;
    private final String collector;
    private final Peripherals peripherals;
    private final String[] accessories;

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

    public static void main(String[] args) {
        final PC pc = new PC(true, 5000, "DNS",
                new Peripherals("Samsung HRG570", "Logitech MK220",
                        "Logitech RX340", "Edifier S550"),
                new String[]{"CPU", "Motherboard", "RAM memory", "Video card",
                        "Hard disk", "Power supply unit", "PC case"});
        final Gson gson = new GsonBuilder().create();
        String pcJson = gson.toJson(pc);
        System.out.println(pcJson);
        final PC pcMod = gson.fromJson(pcJson, PC.class);
        System.out.println(pcMod);
    }
}
