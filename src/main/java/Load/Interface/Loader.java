package Load.Interface;

import org.json.simple.JSONArray;
import java.io.IOException;

public interface Loader {
    void LoadToDir(JSONArray tests) throws IOException;
}
