package Dictionary;

import java.util.HashMap;
import java.util.Map;

public class AllWords extends PartOfWord {
    private Map<String, String> dictionary = new HashMap<>();
    PartOfWord adjectives = new Adjectives();
    PartOfWord nouns = new Nouns();
    PartOfWord phrases = new Phrases();
    PartOfWord pronouns = new Pronouns();
    PartOfWord verbs = new Verbs();
    public AllWords() {
        dictionary.putAll(adjectives.getDictionary());
        dictionary.putAll(nouns.getDictionary());
        dictionary.putAll(phrases.getDictionary());
        dictionary.putAll(pronouns.getDictionary());
        dictionary.putAll(verbs.getDictionary());
    }
    public Map<String, String> getDictionary() {
        return dictionary;
    }
}
