package Load.AbstractClass;

import java.io.IOException;

public abstract class Loader {
    private String path;
    private String target;

    //getters & setters
    protected String getPath() {
        return path;
    }
    protected String getTarget() {
        return target;
    }
    protected void setPath(String path) {
        this.path = path;
    }
    protected void setTarget(String target) {
        this.target = target;
    }

    public abstract void LoadToDir() throws IOException;
}
