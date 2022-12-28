package compositePattern.withoutPattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class File {
    private String name;

    public void ls() {
        System.out.print(this.getName() + " ");
    }
}
