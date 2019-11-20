package ICTProject.CistPortal;

public enum Roles {
    ADMIN(0),
    TEACHER(1),
    STUDENT(2);

    private final int code;

    private Roles(final int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
