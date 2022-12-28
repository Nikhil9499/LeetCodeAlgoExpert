package compositePattern.withPattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class File implements FileSystem {
    private String name;

    @Override
    public void ls() {
        System.out.print(this.getName() + " ");
    }
}
