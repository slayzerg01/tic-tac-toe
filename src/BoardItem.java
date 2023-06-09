/**
 * Элемент игровой доски для игры в крестики нолики
 *
 */
public enum BoardItem {

    UNDEFINED(""),
    X("X"),
    O("0"),
    X_WIN_FIELD("X"),
    O_WIN_FIELD("0");

    private String name;

    private BoardItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}