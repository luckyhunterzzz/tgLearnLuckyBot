package Dictionary;

import java.util.HashMap;
import java.util.Map;

public class Adjectives extends PartOfWord {
    private Map<String, String> dictionary = new HashMap<>();

    public Adjectives() {
        dictionary.put("alto", "tall");
        dictionary.put("anche", "also");
        dictionary.put("bene", "well");
        dictionary.put("bianco", "white");
        dictionary.put("c'e", "There is");
        dictionary.put("caldo", "hot");
        dictionary.put("ci sono", "There are");
        dictionary.put("con", "with");
        dictionary.put("costa", "it costs");
        dictionary.put("costano", "they cost");
        dictionary.put("di solito", "usually");
        dictionary.put("facile", "easy");
        dictionary.put("famoso", "famous");
        dictionary.put("forse", "maybe");
        dictionary.put("invece", "instead");
        dictionary.put("nostra", "our");
        dictionary.put("li", "there");
        dictionary.put("libero", "free");
        dictionary.put("molti", "many");
        dictionary.put("molto", "very");
        dictionary.put("nero", "black");
        dictionary.put("ogni", "every");
        dictionary.put("per", "for");
        dictionary.put("perche", "because");
        dictionary.put("piccolo", "small");
        dictionary.put("prossimo", "next");
        dictionary.put("quando", "when");
        dictionary.put("qui", "here");
        dictionary.put("rosso", "red");
        dictionary.put("sempre", "always");
        dictionary.put("spesso", "often");
        dictionary.put("timido", "shy");
        dictionary.put("divertente", "fun");
        dictionary.put("purtroppo", "unfortunately");
        dictionary.put("noioso", "boring");
        dictionary.put("bello", "beautiful");
        dictionary.put("dopo", "then");
        dictionary.put("strano", "strange");
        dictionary.put("troppo", "too");
        dictionary.put("spaventoso", "frightening");
        dictionary.put("altro", "other");
        dictionary.put("subito", "immediately");
        dictionary.put("importante", "important");
        dictionary.put("caro", "expensive");
        dictionary.put("economico", "cheap");
        dictionary.put("poco", "little");
        dictionary.put("tutto", "all");
        dictionary.put("cosa (pronouns)", "what");
        dictionary.put("senza", "without");
        dictionary.put("che", "that");
        dictionary.put("meglio", "better");
        dictionary.put("cosi (adj)", "so");
        dictionary.put("costoso", "expensive");
        dictionary.put("buono", "good");
        dictionary.put("cattivo", "bad");
        dictionary.put("difficile", "difficult");
        dictionary.put("felice", "happy");
        dictionary.put("lontano", "far");
        dictionary.put("vicino al", "near to");
        dictionary.put("efficace", "effective");
        dictionary.put("vecchio", "old");
        dictionary.put("di notte", "at night");
        dictionary.put("stanco", "tired");
        dictionary.put("Piove", "It rains");
        dictionary.put("Nevica", "It snows");
        dictionary.put("Quali ", "Which");
        dictionary.put("Vostro ", "Your");
        dictionary.put("Prontò ", "Ready");
        dictionary.put("Blu", "Blue");
        dictionary.put("preferito", "favorite");
        dictionary.put("insieme", "together");
        dictionary.put("Comunque", "Anyway");
        dictionary.put("Fa freddo ", "It's cold");
        dictionary.put("C'è il sole", "It's sunny");
        dictionary.put("Fa caldo", "It's hot");
        dictionary.put("A volte ", "Sometimes");
        dictionary.put("Davanti", "In front of");
        dictionary.put("Intero", "Whole");
        dictionary.put("Mille", "Very much");
        dictionary.put("Se", "If");
        dictionary.put("simple", "Simple");
        dictionary.put("attenta ", "Careful");
        dictionary.put("Preoccupato", "Worried");
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }
}
