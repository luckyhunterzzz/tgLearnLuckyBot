package Dictionary;

import java.util.HashMap;
import java.util.Map;

public class AllWords {
    public static Map<String, String> allWords() {
        Map<String, String> allWordsDictionary = new HashMap<>();
        allWordsDictionary.putAll(Verbs.verbs());
        allWordsDictionary.putAll(Nouns.nouns());
        allWordsDictionary.putAll(Adjectives.adjectives());
        allWordsDictionary.putAll(Pronouns.pronouns());
        allWordsDictionary.putAll(Phrases.phrases());
        return allWordsDictionary;
    }
}
