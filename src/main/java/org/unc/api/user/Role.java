package org.unc.api.user;

public enum Role {

    STUDENT("STUDENT"),
    DEAN("DEAN"),
    PROGRAMHEAD("PROGRAM HEAD");

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
