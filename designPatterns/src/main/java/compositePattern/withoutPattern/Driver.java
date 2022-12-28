package compositePattern.withoutPattern;

public class Driver {
    public static void main(String[] args) {
        File f1 = new File("test1.txt");
        File f2 = new File("test2.txt");

        Directory d1 = new Directory("dir1");
        Directory d2 = new Directory("dir2");
        d1.add(f1);
        d1.add(d2);
        d2.add(f2);

        d1.ls();
    }
}
