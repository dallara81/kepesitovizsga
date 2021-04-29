package hu.nive.ujratervezes.kepesitovizsga.army;

// A nehézlovas életereje 150 pont, sebzése 20. Páncélozott (hitPoints: TRUE!!!).
// A lovasság a csatát rohammal indítja, így minden lovas első támadása háromszoros sebzést okoz, az utána következők egyszereset.
// (Azaz az első doDamage meghívása háromszoros értéket ad vissza, a többi egyszeres értéket.
// Tárold le egy attribútumban, hogy hanyadik támadás van, azaz hányszor került meghívásra a doDamage metódus, és ez alapján dönts!)

public class HeavyCavalry extends MilitaryUnit {

    private int counter = 0;

    public HeavyCavalry() {
        // életereje 150 pont, sebzése 20. Páncélozata: VAN!
        super(150, 20, true);
    }

    @Override
    public int doDamage() {
        if (counter == 0) {
            counter++;
            return damage * 3;
        } else {
            return damage;
        }
    }

    @Override
    public void sufferDamage(int damage) {
        hitPoints -= damage / 2;
    }
}