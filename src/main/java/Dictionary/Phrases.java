package Dictionary;

import java.util.HashMap;
import java.util.Map;

public class Phrases extends PartOfWord {
    private Map<String, String> dictionary = new HashMap<>();

    public Phrases() {
        dictionary.put("buon giorno", "good morning");
        dictionary.put("buona sera", "good evening");
        dictionary.put("hai ragione", "you are right");
        dictionary.put("ho sete", "i am thirsty");
        dictionary.put("in ritardo", "late");
        dictionary.put("io devo fare", "i have to do");
        dictionary.put("mi chiamo", "my name is");
        dictionary.put("mi piace", "I like");
        dictionary.put("piacere", "nice to meet you");
        dictionary.put("ho paura", "i am scared");
        dictionary.put("sono sicuro", "i am sure");
        dictionary.put("vicino al", "close to");
        dictionary.put("su questo sito", "on this website");
        dictionary.put("non sono d'accordo", "i disagree");
        dictionary.put("sono malato", "i am sick");
        dictionary.put("io ho sonno", "i am sleepy");
        dictionary.put("parlo un po ", "speak a little");
        dictionary.put("piu tarde", "later");
        dictionary.put("quanto costa", "how much does it cost");
        dictionary.put("Non lo so", "I don't know");
        dictionary.put("ma certò", "Of course");
        dictionary.put("Come stai", "How are you");
        dictionary.put("Sto bene", "I am fine ");
        dictionary.put("in contanti", "In cash");
        dictionary.put("gli piace", "he likes");
        dictionary.put("le piace", "She likes");
        dictionary.put("Buona fortuna", "Good luck");
    }

    public Map<String, String> getDictionary() {

        return dictionary;
    }
}
