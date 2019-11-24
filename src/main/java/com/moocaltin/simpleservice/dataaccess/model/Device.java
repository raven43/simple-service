package com.moocaltin.simpleservice.dataaccess.model;

public enum Device {
    SMARTPHONE("Smartphone"),
    IPHONE("IPhone"),
    TABLET("Tablet"),
    NOTEBOOK("Notebook"),
    PRINTER("Printer");

    private final String displayName;

    Device(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
