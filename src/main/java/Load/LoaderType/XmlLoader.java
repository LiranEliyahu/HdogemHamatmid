package Load.LoaderType;

import Load.AbstractClass.Loader;
import java.io.IOException;

public class XmlLoader extends Loader {
    public XmlLoader(String path, String target) throws IOException {
        setPath(path);
        setTarget(target);
        LoadToDir();
    }


    @Override
    public void LoadToDir() throws IOException {

    }
}
