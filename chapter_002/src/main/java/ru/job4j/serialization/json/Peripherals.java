package ru.job4j.serialization.json;

public class Peripherals {
    private final String monitor;
    private final String keyboard;
    private final String mouse;
    private final String columns;

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
