import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    private enum Ranges {UNITS, DECADES, HUNDREDS, THOUSANDS, MILLIONS, BILLIONS};

    private static Stack <ThreeChar> threeChars;

    private static class ThreeChar {
        char h, d, u;
        Ranges range;
    }

    public static String digits2Text(Double d){
        if(d == null || d < 0.0) return null;
        String s = d.toString();
        int n = s.length() - s.lastIndexOf('.');
        if(n > 3) return null;
        if(n == 2) s += "0";
        String[] sa = s.split("\\.");
        threeChars = new Stack <ThreeChar> ();
        threeChars.push(new ThreeChar());
        threeChars.peek().range = Ranges.UNITS;
        StringBuilder sb = new StringBuilder(sa[0]).reverse();
        for(int i = 0; i < sb.length(); i++){
            if(i > 0 && i % 3 == 0){
                threeChars.push(new ThreeChar());
            }
            ThreeChar threeChar = threeChars.peek();
            switch(i){
                case 0:
                    threeChar.u = sb.charAt(i);
                    break;
                case 3:
                    threeChar.range = Ranges.THOUSANDS;
                    threeChar.u = sb.charAt(i);
                    break;
                case 6:
                    threeChar.range = Ranges.MILLIONS;
                    threeChar.u = sb.charAt(i);
                    break;
                case 9:
                    threeChar.range = Ranges.BILLIONS;
                    threeChar.u = sb.charAt(i);
                    break;
                case 2:
                case 5:
                case 8:
                    threeChar.h = sb.charAt(i);
                    break;
                default:
                    threeChar.d = sb.charAt(i);
            }
        }
        StringBuilder result = new StringBuilder();
        while(!threeChars.isEmpty()){
            ThreeChar thch = threeChars.pop();
            if(thch.h > 0  ){
                result.append(getHundreds(thch.h));
                result.append(' ');
            }
            if(thch.d > '0'){
                if(thch.d > '1' || (thch.d == '1' && thch.u == '0')) result.append(getDecades(thch.d));
                else if(thch.d > '0') result.append(getTeens(thch.d));
                result.append(' ');
            }
            if(thch.u > '0' && thch.d != '1'){
                result.append(getUnits(thch.u, thch.range == Ranges.THOUSANDS));
                result.append(' ');
            }
            switch(thch.range){
                case BILLIONS:
                    if(thch.d == '1' || thch.u == '0') result.append("міліардів");
                    else if(thch.u > '4')result.append("міліардів");
                    else if(thch.u > '1')result.append("міліарди");
                    else result.append("міліард");
                    break;
                case MILLIONS:
                    if(thch.d == '1' || thch.u == '0') result.append("мільйонів");
                    else if(thch.u > '4')result.append("мільонів");
                    else if(thch.u > '1')result.append("мільйони");
                    else result.append("мільйон");
                    break;
                case THOUSANDS:
                    if(thch.d == '1' || thch.u == '0') result.append("тисяч");
                    else if(thch.u > '4')result.append("тисяч");
                    else if(thch.u > '1')result.append("тисячі");
                    else result.append("тисяча");
                    break;
                default:
                    if(thch.d == '1' || thch.u == '0' || thch.u > '4')result.append("гривень");
                    else if(thch.u > '1')result.append("гривня");
                    else result.append("гривень");
            }
            result.append(' ');
        }
        result.append(sa[1] + ' ');
        switch(sa[1].charAt(1)){
            case '1':
                result.append(sa[1].charAt(0) != '1' ? "копейка" : "копеек");
                break;
            case '2':
            case '3':
            case '4':
                result.append(sa[1].charAt(0) != '1' ? "копейки" : "копеек");
                break;
            default:
                result.append("копеек");
        }
        char first = Character.toUpperCase(result.charAt(0));
        result.setCharAt(0, first);
        return result.toString();
    }

    private static String getHundreds(char dig){
        switch(dig){
            case '1':
                return "сто";
            case '2':
                return "двісті";
            case '3':
                return "тристо";
            case '4':
                return "чотиристо";
            case '5':
                return "пятсот";
            case '6':
                return "шісот";
            case '7':
                return "сімсот";
            case '8':
                return "вісімсот";
            case '9':
                return "дев'ятсот";
            default: return null;
        }
    }

    private static String getDecades(char dig){
        switch(dig){
            case '1':
                return "десять";
            case '2':
                return "двадцать";
            case '3':
                return "тридцать";
            case '4':
                return "сорок";
            case '5':
                return "пятдесят";
            case '6':
                return "шістдесят";
            case '7':
                return "сімдесят";
            case '8':
                return "вісімдесят";
            case '9':
                return "девяносто";
            default: return null;
        }
    }

    private static String getUnits(char dig, boolean female){
        switch(dig){
            case '1':
                return female ? "одна" : "один";
            case '2':
                return female ? "две"  : "два";
            case '3':
                return "три";
            case '4':
                return "чотири";
            case '5':
                return "п'ять";
            case '6':
                return "шість";
            case '7':
                return "сім";
            case '8':
                return "вісім";
            case '9':
                return "дев'ять";
            default: return null;
        }
    }

    private static String getTeens(char dig){
        String s = "";
        switch(dig){
            case '1':
                s = "один"; break;
            case '2':
                s = "два"; break;
            case '3':
                s = "три"; break;
            case '4':
                s = "чотир"; break;
            case '5':
                s = "п'ят"; break;
            case '6':
                s = "шіст"; break;
            case '7':
                s = "сім"; break;
            case '8':
                s = "вісім"; break;
            case '9':
                s = "дев'ят"; break;
        }
        return s + "надцять";
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.print("Enter a number: ");
        double number = scanner.nextDouble();
        System.out.println("Your number is: " + number);
        System.out.println("In words it will be: " + Main.digits2Text(number));
    }
}