package Dictionary;

import java.util.HashMap;
import java.util.Map;

public class Pronouns extends PartOfWord {
    private Map<String, String> dictionary = new HashMap<>();

    public Pronouns() {
        dictionary.put("io", "I");
        dictionary.put("io sono", "I am");
        dictionary.put("io ho", "I have");
        dictionary.put("tu", "You");
        dictionary.put("tu sei", "You are");
        dictionary.put("tu hai", "You have");
        dictionary.put("con te", "with you");
        dictionary.put("lui", "he");
        dictionary.put("lei", "she");
        dictionary.put("lui e", "he is");
        dictionary.put("lei e", "she is");
        dictionary.put("lui ha", "he has");
        dictionary.put("lei ha", "she has");
        dictionary.put("noi", "we");
        dictionary.put("noi sono", "we are");
        dictionary.put("noi abbiamo", "we have");
        dictionary.put("suo", "his");
        dictionary.put("tuo", "your");
        dictionary.put("voi", "you");
        dictionary.put("voi avete", "You have");
        dictionary.put("voi siete", "you are");
        dictionary.put("il mio", "my");
        dictionary.put("il tuo", "your");
        dictionary.put("il suo", "his");
        dictionary.put("il loro", "their");
        dictionary.put("dell", "of");
        dictionary.put("al ", "to the");
        dictionary.put("nel", "in the");
        dictionary.put("di ", "from");
        dictionary.put("Loro", "They");
        dictionary.put("Loro sono", "They are");
        dictionary.put("Loro hanno", "They have");
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }
}
