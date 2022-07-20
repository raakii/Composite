import java.util.ArrayList;

public class Directory extends Component {
    ArrayList<Component> components = new ArrayList<Component>();

    public Directory(String name, int level) {
        super(name, level);
    }

    public void add(Component c) {
        components.add(c);
    }

    public void show() {
        int level = getLevel();
        for (int i = 0; i < level; i++) {
            System.out.print("|   ");
        }
        System.out.println("|---" + getName());
        for (Component c : components) {
            c.show();
        }
    }
}