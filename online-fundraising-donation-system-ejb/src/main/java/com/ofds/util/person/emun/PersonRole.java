package com.ofds.util.person.emun;

/**
 * Manage the Person Role.
 */
public enum PersonRole {

    FUNDRAISER(1, "fundraiser"),
    ADMIN(2, "admin"),
    CHARITY(3, "charity");

    private int id;
    private String value;

    private PersonRole(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    public int getId() {
        return id;
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
