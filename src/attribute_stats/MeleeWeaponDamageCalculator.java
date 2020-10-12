package attribute_stats;

public class MeleeWeaponDamageCalculator implements StatCalculator {

    @Override
    public double calculateWeaponDamage(double damage, int strength){
        damage += strength * 1.5;
        return damage;
    }
}
