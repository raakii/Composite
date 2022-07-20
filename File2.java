public class File2 extends Component {

    public File2(String name, int level) {
        super(name, level);
    }

    public void show() {
        int level = getLevel();
        for (int i = 0; i < level; i++) {
            System.out.print("|   ");
        }
        System.out.println(getName());
    }
}