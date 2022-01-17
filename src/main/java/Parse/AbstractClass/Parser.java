package Parse.AbstractClass;

public abstract class Parser{
    private String targetPath;

    protected String getTargetPath() {
        return targetPath;
    }
    protected void setTargetPath(String targetPath) {
        this.targetPath = targetPath;
    }

    protected abstract void parseData();
}
