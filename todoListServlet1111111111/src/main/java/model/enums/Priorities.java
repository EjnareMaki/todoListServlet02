package model.enums;

public enum Priorities {
    LOW,
    MEDIUM,
    HIGH;

  public static Priorities getPriorityFromString(String string) {
        try {
            return Priorities.valueOf(string.toUpperCase());
        } catch (IllegalArgumentException exception) {
            throw new RuntimeException(
                    "Invalid value for enum: " + string);
        }
    }
}
