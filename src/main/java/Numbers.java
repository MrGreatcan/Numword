import java.util.HashMap;
import java.util.Map;

/**
 * Responsible for getting a word from the number
 */
public class Numbers {

    private Map<Character, String> hmHundreds = new HashMap<Character, String>() {{
        put('1', "сто");
        put('2', "двісті");
        put('3', "тристо");
        put('4', "чотиристо");
        put('5', "пятсот");
        put('6', "шісот");
        put('7', "сімсот");
        put('8', "вісімсот");
        put('9', "дев'ятсот");
    }};

    private Map<Character, String> hmDecades = new HashMap<Character, String>() {{
        put('1', "десять");
        put('2', "двадцать");
        put('3', "тридцать");
        put('4', "сорок");
        put('5', "пятдесят");
        put('6', "шістдесят");
        put('7', "сімдесят");
        put('8', "вісімдесят");
        put('9', "девяносто");
    }};


    private Map<Character, String> hmTeens = new HashMap<Character, String>() {{
        put('1', "один");
        put('2', "два");
        put('3', "три");
        put('4', "чотир");
        put('5', "п'ят");
        put('6', "шіст");
        put('7', "сім");
        put('8', "вісім");
        put('9', "дев'ят");
    }};

    /**
     * Get hundreds numbers
     * @param dig
     * @return
     */
    public String getHundreds(char dig) {
        return hmHundreds.containsKey(dig) ? hmHundreds.get(dig) : null;
    }

    /**
     * Get decades numbers
     * @param dig
     * @return
     */
    public String getDecades(char dig) {
        return hmDecades.containsKey(dig) ? hmDecades.get(dig) : null;
    }

    /**
     * Get teens number
     * @param dig
     * @return
     */
    public String getTeens(char dig) {
        return hmTeens.containsKey(dig) ? hmTeens.get(dig) + "надцять" : null;
    }

    public String getUnits(char dig, final boolean female) {
        Map<Character, String> hmUnits = new HashMap<Character, String>() {{
            put('1', female ? "один" : "одна");
            put('2', "дві");
            put('3', "три");
            put('4', "чотири");
            put('5', "п'ять");
            put('6', "шість");
            put('7', "сім");
            put('8', "вісім");
            put('9', "дев'ять");
        }};
        return hmUnits.containsKey(dig) ? hmUnits.get(dig) : null;
    }
}
