package org.azimjon.project.core.utils.enums;

public enum BrowserType {
    CHROME("chrome"), EDGE("edge"), FIREFOX("firefox");

    private String type;

    BrowserType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static BrowserType fromString(String browserName) {
        for (BrowserType type: BrowserType.values()) {
            if (browserName.equalsIgnoreCase(type.getType())) {
                return type;
            }
        }
        throw new IllegalArgumentException("Browser is not supported");
    }
}
