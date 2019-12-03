package ICTProject.CistPortal;

public enum MyRole {
    ADMIN(1),
    TEACHER(2),
    STUDENT(3);

    private final int id;

    private MyRole(final int id) { this.id = id; }

    public int getId() {
        return id;
    }

    public static MyRole getById(int id) {
        for (MyRole role : values()) {
            if (role.getId() == id) {
                return role;
            }
        }
        throw new IllegalArgumentException();
    }
}
