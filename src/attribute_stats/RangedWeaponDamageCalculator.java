package attribute_stats;

public class RangedWeaponDamageCalculator implements StatCalculator {

    @Override
    public double calculateWeaponDamage(double damage, int dexterity){
        damage += dexterity * 2;
        return damage;
    }
}
