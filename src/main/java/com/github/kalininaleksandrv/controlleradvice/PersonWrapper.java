package com.github.kalininaleksandrv.controlleradvice;

public class PersonWrapper {
    private final Person result;
    private final boolean IsAdmin;

    public PersonWrapper(Person result, boolean isAdmin) {
        this.result = result;
        IsAdmin = isAdmin;
    }

    public Person getResult() {
        return result;
    }

    public boolean isAdmin() {
        return IsAdmin;
    }

}
