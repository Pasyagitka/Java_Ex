package meow.pasyagitka;

public class StringCheck {
    public static boolean stringCheck(String input) {
        return input.matches("[0-9]{4,6}/21-[A-Z]{4}");
    }
}
