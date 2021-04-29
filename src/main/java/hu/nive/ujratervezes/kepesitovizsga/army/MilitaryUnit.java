package hu.nive.ujratervezes.kepesitovizsga.army;

// Minden egységnek (MilitaryUnit absztrakt ősosztály) vannak életerő pontjai (int) és támadási sebzése (int).
// Az egységeknek lehet páncéljuk (vagy van, vagy nincs).
// Minden katonai egység számára elérhetőek az alábbi metódusok:
// doDamage(): adja vissza az egység sebzését int értékként.
// sufferDamage(int damage): a paraméterül kapott értéket levonja az egység életerő pontjaiból, ha az egység páncélozott,
// akkor csak az érték felét vonjuk le.

public class MilitaryUnit {

    protected int hitPoints;
    protected boolean armory;
    protected int damage;

    protected MilitaryUnit(boolean armory, int damage, int hitPoints) {
        this.hitPoints = hitPoints;
        this.armory = armory;
        this.damage = damage;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public abstract int doDamage();

    public abstract void sufferDamage(int damage);
}
