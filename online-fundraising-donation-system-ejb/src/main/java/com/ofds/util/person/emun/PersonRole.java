package com.ofds.util.person.emun;

/**
 * Manage the Person Role.
 */
public enum PersonRole {

    ADMIN("admin"),
    FUNDRAISER("fundraiser"),
    CHARITY("charity");

    private String value;

    private PersonRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PersonRole getPersonRoleValue(String value) {
        if (value == null) {
            return null;
        }

        for (PersonRole personRole : PersonRole.values()) {
            if (personRole.getValue().equals(value)) {
                return personRole;
            }
        }

        return null;
    }
}
