
public class Main {

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        while (true){
            mainMenu.mainMenu();
        }

    }

    private static void example(){
        System.out.println(NumToWords.getWordFromNumber(Double.valueOf(1)));
        System.out.println(NumToWords.getWordFromNumber(Double.valueOf(2)));
        System.out.println(NumToWords.getWordFromNumber(Double.valueOf(3)));
        System.out.println(NumToWords.getWordFromNumber(Double.valueOf(4)));
        System.out.println(NumToWords.getWordFromNumber(Double.valueOf(5)));
        System.out.println(NumToWords.getWordFromNumber(Double.valueOf(6)));
        System.out.println(NumToWords.getWordFromNumber(Double.valueOf(7)));
        System.out.println(NumToWords.getWordFromNumber(Double.valueOf(8)));
        System.out.println(NumToWords.getWordFromNumber(Double.valueOf(9)));
        System.out.println(NumToWords.getWordFromNumber(Double.valueOf(24)));
        System.out.println(NumToWords.getWordFromNumber(Double.valueOf(11)));
        System.out.println(NumToWords.getWordFromNumber(Double.valueOf(432)));
        System.out.println(NumToWords.getWordFromNumber(Double.valueOf(18)));
        System.out.println(NumToWords.getWordFromNumber(Double.valueOf(2523)));
        System.out.println(NumToWords.getWordFromNumber(Double.valueOf(73497)));
        System.out.println(NumToWords.getWordFromNumber(Double.valueOf(955)));
        System.out.println(NumToWords.getWordFromNumber(Double.valueOf(9543)));
        System.out.println(NumToWords.getWordFromNumber(Double.valueOf(634890)));
        System.out.println(NumToWords.getWordFromNumber(Double.valueOf(246)));
    }
}
