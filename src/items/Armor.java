package items;

public class Armor extends Item {

    private ArmorType armorType;
    private int dexterity;
    private int health;
    private int intelligence;
    private int strength;

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    /*Calculates the base bonus for each type of armor - cloth, leather and plate */
    public void calculateArmorStats() {
        if (armorType == ArmorType.Cloth) {
            health = 10 + 5 * requiredLevel;
            intelligence = 3 + 2 * requiredLevel;
            dexterity = 1 + 1 * requiredLevel;
        } else if (armorType == ArmorType.Leather) {
            health = 20 + 8 * requiredLevel;
            dexterity = 3 + 2 * requiredLevel;
            strength = 1 + 1 * requiredLevel;
        } else {
            health = 30 + 12 * requiredLevel;
            strength = 3 + 2 * requiredLevel;
            dexterity = 1 + 1 * requiredLevel;
        }
    }
    /*Calculates the bonus depending on slot, default is body as it gives 100% of the bonus*/
    public void calculateSlotBonus(){
        switch(itemType){
            case Head:
                dexterity = (int) Math.floor(dexterity * 0.8);
                health = (int) Math.floor(health * 0.8);
                intelligence = (int) Math.floor(intelligence * 0.8);
                strength = (int) Math.floor(strength * 0.8);
                break;
            case Legs:
                dexterity = (int) Math.floor(dexterity * 0.6);
                health = (int) Math.floor(health * 0.6);
                intelligence = (int) Math.floor(intelligence * 0.6);
                strength = (int) Math.floor(strength * 0.6);
                break;
            default:
                break;
        }

    }

    public int getDexterity(){
        return dexterity;
    }

    public int getHealth(){
        return health;
    }

    public int getIntelligence(){
        return intelligence;
    }

    public int getStrength(){
        return strength;
    }

    @Override
    public String toString(){
        return "Item stats for:\t" + nameOfItem +
                "\n Armor Type:\t" + armorType +
                "\n Slot:\t\t\t" + itemType +
                "\n Armor Level:\t" + requiredLevel +
                "\n Bonus HP:\t\t" + health +
                "\n Bonus Str:\t\t" + strength +
                "\n Bonus Dex:\t\t" + dexterity;
    }
}
