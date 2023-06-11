package Ameaca.Types;

public enum TypeThreatLevel {
    LOW,
    MEDIUM,
    HIGH;

    private static TypeThreatLevel[] values = null;

    public static TypeThreatLevel fromInt(int i) {
        if (TypeThreatLevel.values == null) {
            TypeThreatLevel.values = TypeThreatLevel.values();
        }
        return TypeThreatLevel.values[i];
    }
}
