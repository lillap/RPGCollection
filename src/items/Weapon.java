package items;

public class Weapon extends Item {
    private int damage;
    private int meleeBaseDamage = 15;
    private int rangedBaseDamage = 5;


    public int calculateWeaponDamage (){
        if( itemType == ItemType.Melee) {
            damage = meleeBaseDamage + (2 * requiredLevel);
        } else {
            damage = rangedBaseDamage + (3 * requiredLevel);
        }
        return damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString(){
        return "Item stats for:\t" + nameOfItem +
                "\n Weapon Type:\t"  + itemType +
                "\n Weapon Level:\t" + requiredLevel +
                "\n Damage:\t\t" + damage;

    }
}
