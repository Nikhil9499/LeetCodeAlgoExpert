package compositePattern.withPattern;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Directory implements FileSystem {

    private String name;

    // This is composite pattern
    // It has composite object(Directory) and termination condition(File)
    // In calculator, composite object(expression) and termination condition(numbers)
    private List<FileSystem> fileSystemList;

    public Directory(String name) {
        this.name = name;
        fileSystemList = new ArrayList<>();
    }

    public void add(FileSystem obj) {
        fileSystemList.add(obj);
    }

    @Override
    public void ls() {
        System.out.println("Directory: " + this.getName());
        for (FileSystem fs : fileSystemList) {
            fs.ls();
        }
    }
}
