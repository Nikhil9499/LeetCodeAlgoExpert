package compositePattern.withoutPattern;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Directory {
    private String name;

    // Here we are taking list of objects so we have to do if else with instanceof operator to check object
    // and call the method. Check v2 approach: composite pattern for better approach
    private List<Object> list;

    public Directory(String name) {
        this.name = name;
        list = new ArrayList<>();
    }

    public void add(Object ob) {
        list.add(ob);
    }

    public void ls() {
        System.out.println("Directory: " + this.getName());
        for (Object obj : list) {
            if (obj instanceof File) {
                ((File) obj).ls();
            } else if (obj instanceof Directory) {
                ((Directory) obj).ls();
            }
        }
    }
}
