package Dictionary;

import java.util.HashMap;
import java.util.Map;

public class Phrases extends PartOfWord {
    public Map<String, String> dictionary() {
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
        phrasesDictionary.put("ho paura", "i am scared");
        phrasesDictionary.put("sono sicuro", "i am sure");
        phrasesDictionary.put("vicino al", "near the");
        phrasesDictionary.put("su questo sito", "on this website");
        phrasesDictionary.put("non sono d'accordo", "i disagree");
        phrasesDictionary.put("sono malato", "i am sick");
        phrasesDictionary.put("io ho sonno", "i am sleepy");
        phrasesDictionary.put("parlo un po ", "speak a little");
        phrasesDictionary.put("piu tarde", "later");
        phrasesDictionary.put("quanto costa", "how much doest it cost");
        return phrasesDictionary;
    }
}
