package hu.nive.ujratervezes.kepesitovizsga.army;

// Az íjász életereje (power) 50 pont, sebzése (damage) 20. Nem rendelkezik páncéllal.

public class Archer extends MilitaryUnit {

    public Archer() {
        // életereje 50 pont, sebzése 20. NEM rendelkezik páncéllal!
        super(50, 20, false);
    }

    @Override
    public int doDamage() {
        return damage;
    }

    @Override
    public void sufferDamage(int damage) {
        hitPoints -= damage;
    }
}