package attribute_stats;

public class SpellDamageCalculator implements StatCalculator {

    @Override
    public double calculateWeaponDamage(double damage, int intelligence) {
        damage = intelligence * 5;
        return damage;
    }
}
