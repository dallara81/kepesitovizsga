package hu.nive.ujratervezes.kepesitovizsga.army;

// A kardforgató életereje 100 pont, sebzése 10. Vagy van páncélja vagy nincs.
// Minden kardforgatónak van pajzsa, amivel kivédi az első őt ért csapást. A pajzs az első kapott sebzés 100%-át felfogja,
// majd összetörik, tovább nem használható.
// (Tárold le attribútumban, hogy a pajzsa ép-e vagy sem! Ez alapján dönts a sebzésről!
// Az első sufferDamage hívás után módosítsd az attribútum értékét!)

public class Swordsman extends MilitaryUnit {

    private boolean shield = true;

    public Swordsman(boolean armory) {
        super(100, 10, armory);
    }

    @Override
    public void sufferDamage(int damage) {
        if (shield) {
            shield = false;
        } else {
            if (this.armory) {
                hitPoints -= damage / 2;
            } else {
                hitPoints -= damage;
            }
        }
    }

    @Override
    public int doDamage() {
        return damage;
    }
}