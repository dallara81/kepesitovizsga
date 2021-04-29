package hu.nive.ujratervezes.kepesitovizsga.army;

// Hozzunk létre egy egyszerű (WTF??? When someone starts acting funny...) alkalmazást,
// amivel egy középkori hadsereg működését modellezhetjük.

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Army {

    private final List<MilitaryUnit> forces = new ArrayList<>();

    public void addUnit(MilitaryUnit militaryUnit) {
        forces.add(militaryUnit);
    }

    public void damageAll(int damage) {
        for (MilitaryUnit militaryUnit : forces) {
            militaryUnit.sufferDamage(damage);
        }
        Iterator<MilitaryUnit> iterator = forces.iterator();
        while (iterator.hasNext()) {

            if (iterator.next().hitPoints < 25) {
                iterator.remove();
            }
        }
    }

    public int getArmySize() {
        return forces.size();
    }

    public int getArmyDamage() {
        int result = 0;
        for (MilitaryUnit militaryUnit : forces) {
            result += militaryUnit.doDamage();
        }
        return result;
    }
}