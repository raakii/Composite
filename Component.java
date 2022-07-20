public abstract class Component {
    private String name;
    private int level;

    public abstract void show();

    public void add(Component c) {
    };

    public Component(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

}