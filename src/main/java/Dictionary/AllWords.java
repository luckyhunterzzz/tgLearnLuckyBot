package Dictionary;

import java.util.HashMap;
import java.util.Map;

public class AllWords extends PartOfWord {
    public Map<String, String> dictionary() {
        PartOfWord verbs = new Verbs();
        PartOfWord nouns = new Nouns();
        PartOfWord adjectives = new Adjectives();
        PartOfWord pronouns = new Pronouns();
        PartOfWord phrases = new Phrases();
        Map<String, String> allWordsDictionary = new HashMap<>();
        allWordsDictionary.putAll(verbs.dictionary());
        allWordsDictionary.putAll(nouns.dictionary());
        allWordsDictionary.putAll(adjectives.dictionary());
        allWordsDictionary.putAll(pronouns.dictionary());
        allWordsDictionary.putAll(phrases.dictionary());
        return allWordsDictionary;
    }
}
