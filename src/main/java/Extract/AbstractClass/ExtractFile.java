package Extract.AbstractClass;

public abstract class Parser {
    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }


    public Parser(String path){
        setPath(path);
    }
}
