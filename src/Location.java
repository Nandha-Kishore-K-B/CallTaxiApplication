public enum Location {
    A(0), B(1), C(2), D(3), E(4), F(5);

    private final int index;

    Location(int index) {
        this.index = index;
    }
    public int distanceTo(Location other) {
        return Math.abs(this.index - other.index) * 15;
    }

    public int hoursTo(Location other) {
        return Math.abs(this.index - other.index);
    }
}
