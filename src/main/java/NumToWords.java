import java.util.Stack;

public class NumToWords {

    private static Stack<Symbols> symbols;
    private static Numbers numbers = new Numbers();

    private static class Symbols {
        char h, d, u;
        Ranges range;
    }

    public static String getWordFromNumber(Double d) {
        if (d == null || d < 0.0) return null;
        String s = d.toString();
        int n = s.length() - s.lastIndexOf('.');
        if (n > 3) return null;
        if (n == 2) s += "0";
        String[] sa = s.split("\\.");
        symbols = new Stack<Symbols>();
        symbols.push(new Symbols());
        symbols.peek().range = Ranges.UNITS;
        StringBuilder sb = new StringBuilder(sa[0]).reverse();
        for (int i = 0; i < sb.length(); i++) {
            if (i > 0 && i % 3 == 0) {
                symbols.push(new Symbols());
            }
            Symbols symbols = NumToWords.symbols.peek();
            switch (i) {
                case 0:
                    symbols.u = sb.charAt(i);
                    break;
                case 3:
                    symbols.range = Ranges.THOUSANDS;
                    symbols.u = sb.charAt(i);
                    break;
                case 6:
                    symbols.range = Ranges.MILLIONS;
                    symbols.u = sb.charAt(i);
                    break;
                case 9:
                    symbols.range = Ranges.BILLIONS;
                    symbols.u = sb.charAt(i);
                    break;
                case 2:
                case 5:
                case 8:
                    symbols.h = sb.charAt(i);
                    break;
                default:
                    symbols.d = sb.charAt(i);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!symbols.isEmpty()) {
            Symbols thch = symbols.pop();
            if (thch.h > 0) {
                result.append(numbers.getHundreds(thch.h));
                result.append(' ');
            }
            if (thch.d > '0') {
                if (thch.d > '1' || (thch.d == '1' && thch.u == '0')) result.append(numbers.getDecades(thch.d));
                else if (thch.d > '0') result.append(numbers.getTeens(thch.d));
                result.append(' ');
            }
            if (thch.u > '0' && thch.d != '1') {
                result.append(numbers.getUnits(thch.u, thch.range == Ranges.THOUSANDS));
                result.append(' ');
            }
            switch (thch.range) {
                case BILLIONS:
                    if (thch.d == '1' || thch.u == '0') result.append("міліардів");
                    else if (thch.u > '4') result.append("міліардів");
                    else if (thch.u > '1') result.append("міліарди");
                    else result.append("міліард");
                    break;
                case MILLIONS:
                    if (thch.d == '1' || thch.u == '0') result.append("мільйонів");
                    else if (thch.u > '4') result.append("мільонів");
                    else if (thch.u > '1') result.append("мільйони");
                    else result.append("мільйон");
                    break;
                case THOUSANDS:
                    if (thch.d == '1' || thch.u == '0') result.append("тисяч");
                    else if (thch.u > '4') result.append("тисяч");
                    else if (thch.u > '1') result.append("тисячі");
                    else result.append("тисяча");
                    break;
                default:
                    if (thch.d == '1' || thch.u == '0' || thch.u > '4') result.append("гривень");
                    else if (thch.u > '1') result.append("гривні");
                    else result.append("гривня");
            }
            result.append(' ');
        }
        result.append(sa[1] + ' ');
        switch (sa[1].charAt(1)) {
            case '1':
                result.append(sa[1].charAt(0) != '1' ? "копійка" : "копійок");
                break;
            case '2':
            case '3':
            case '4':
                result.append(sa[1].charAt(0) != '1' ? "копійки" : "копійок");
                break;
            default:
                result.append("копійок");
        }
        char first = Character.toUpperCase(result.charAt(0));
        result.setCharAt(0, first);
        return result.toString();
    }
}
