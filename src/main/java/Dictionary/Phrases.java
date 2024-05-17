package Dictionary;

import java.util.HashMap;
import java.util.Map;

public class Phrases {
    public static Map<String, String> phrases() {
        Map<String, String> phrasesDictionary = new HashMap<>();
        phrasesDictionary.put("buon giorno", "good morning");
        phrasesDictionary.put("buona sera", "good evening");
        phrasesDictionary.put("hai ragione", "you are right");
        phrasesDictionary.put("ho sete", "i am thirsty");
        phrasesDictionary.put("in ritardo", "late");
        phrasesDictionary.put("io devo fare", "i have to do");
        phrasesDictionary.put("mi chiamo", "my name is");
        phrasesDictionary.put("mi piace", "I like");
        phrasesDictionary.put("piacere", "nice to meet you");
        return phrasesDictionary;
    }
}
