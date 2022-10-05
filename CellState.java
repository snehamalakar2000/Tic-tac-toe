enum CellState {
    BLANK, X, O;

    @Override
    public String toString() {
        if (this.name().equals("BLANK")) {
            return " ";
        } else {
            return this.name();
        }
    }

    /**
     * Compares two cell states to see if they're equal but not blank.
     *
     * @param state2 Compared cell state
     * @return True if matching and not blank
     */
    public boolean matches(CellState state2) {
        return this == state2 && state2 != BLANK;
    }
}