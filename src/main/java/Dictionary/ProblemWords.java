package Dictionary;

import java.util.HashMap;
import java.util.Map;

public class ProblemWords extends PartOfWord {
    private Map<String, String> dictionary = new HashMap<>();

    public Map<String, String> getDictionary() {
        return dictionary;
    }

    public void setDictionary(String key, String value) {
        dictionary.put(key, value);
    }
}
