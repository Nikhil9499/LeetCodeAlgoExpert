package singleton;

import lombok.Getter;

@Getter
public enum SingletonApproach2 {
    INSTANCE;

    @Override
    public String toString() {
        return "" + INSTANCE.hashCode();
    }
}
