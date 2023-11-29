package org.unc.api.student;

public enum Program {
	IT("Bachelor of Science in Information Technology"),
    IS("Bachelor of Science in Information System"),
    CS("Bachelor of Science in Computer Science"),
    ACT("ACT");

    private final String displayName;
    Program(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
