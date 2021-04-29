package hu.nive.ujratervezes.kepesitovizsga.addigits;

// Hozd létre az AddDigits osztályt, és annak az addDigits(String input) metódusát.
// A metódus feladata, hogy a paraméterben kapott Stringben található összes számjegyet adja össze,
// és ennek az összegét adja vissza. Ha a bemeneti String üres, vagy null, adjon vissza -1 értéket.

public class AddDigits {

    public int addDigits(String input) {

        if (input == null || input.isEmpty()) {
            return -1;
        }

        int result = 0;

        for (Character character : input.toCharArray()) {

            if (Character.isDigit(character)) {
                result += Integer.parseInt(String.valueOf(character));
            }
        }
        return result;
    }
}