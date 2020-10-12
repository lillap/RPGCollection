package heroes;

import attribute_stats.*;
import items.*;

import java.util.HashMap;
import java.util.Map;

public abstract class Hero {
    private String nameOfHero;
    private HeroType typeOfHero;

    protected int baseDexterity;
    protected int baseHealth;
    protected int baseIntelligence;
    protected int baseStrength;
    protected int xP;

    private int equipmentDexterity;
    private int equipmentHealth;
    private int equipmentIntelligence;
    private int equipmentStrength;
    private int meleeDamage;
    private int rangedDamage;

    private Map< ItemType, Item> equipment = new HashMap<ItemType, Item>();

    private StatCalculator statCalculatorMethod;
    private LevelCalculator levelCalculator;


    /* constructor */
    public Hero(HeroType typeOfHero, String nameOfHero){
        this.nameOfHero = nameOfHero;
        this.typeOfHero = typeOfHero;
        this.levelCalculator = new LevelCalculator();
    }
/*If the required lvl of armor is less or same as lvl of hero,
*the hash map will save the armor at its matching key in the hashmap, which is the slot for the armor.
* If no match, do nothing*/
    public void equipItem(Item item){
        if (item.getRequiredLevel() > levelCalculator.getLevel()) {
            System.out.println("Sorry, " + nameOfHero + " needs to be level " + item.getRequiredLevel() + " to use item: " + item.getNameOfItem());
        } else {
            if(equipment.get(item.getItemType()) != null){
                Item currentlyWornArmor = equipment.get(item.getItemType());
                System.out.println(nameOfHero + " throws away " + currentlyWornArmor.getNameOfItem());
            }
            System.out.println(nameOfHero + " picks up " + item.getNameOfItem());
            equipment.put(item.getItemType(), item);
            calculateTotalHeroStats();
        }
        for (Item equipped : equipment.values()){
            System.out.println(equipped.toString());
        }
    }

  /*  public StatCalculator getStatCalculatorMethod(){
        return statCalculatorMethod;
    }

   */

    public void setStatCalculatorMethod(StatCalculator statCalculatorMethod){
        this.statCalculatorMethod = statCalculatorMethod;
    }
    /*Depending on type of weapon, the method for calculating damage of the instance's matching weapon will run*/
    public double calculateDamage(){
        if (equipment.get(ItemType.Ranged) != null) {
            setStatCalculatorMethod( new RangedWeaponDamageCalculator());
            return statCalculatorMethod.calculateWeaponDamage(rangedDamage, baseDexterity);
        }
        else {
            setStatCalculatorMethod(new MeleeWeaponDamageCalculator());
            return statCalculatorMethod.calculateWeaponDamage(meleeDamage, baseStrength);
        }
    }

    private void resetEquipmentStats(){
        meleeDamage = 0;
        rangedDamage = 0;
        equipmentDexterity = 0;
        equipmentHealth = 0;
        equipmentIntelligence = 0;
        equipmentStrength = 0;
    }

    /* Using the reseted stats for items, loops then through to get each item stat and adds to heros equipment stat. */

    public void calculateTotalHeroStats(){
        resetEquipmentStats();
        for (Item item : equipment.values()){

            equipmentDexterity += item.getDexterity();
            equipmentHealth += item.getHealth();
            equipmentIntelligence += item.getIntelligence();
            equipmentStrength += item.getStrength();
            if (item.getItemType() == ItemType.Melee){
                meleeDamage += item.getDamage();
            } else if (item.getItemType() == ItemType.Ranged) {
                rangedDamage += item.getDamage();
            }
        }
    }

    public HeroType getHeroType(){
        return typeOfHero;
    }


    public void increaseXP(int xp){
        System.out.println( nameOfHero + " gaining " + xp + " xp!");
        levelCalculator.increaseXP(xp);
    }

    /*Getters and Setters to access properties to modify */
    public String getNameOfHero(){
        return nameOfHero;
    }

    @Override
    public String toString(){
        return typeOfHero.toString() + " " + nameOfHero + " | " + "Details: " +
                "\n Level: \t\t " + levelCalculator.getLevel() +
                "\n Health: \t\t " + (baseHealth + equipmentHealth) +
                "\n Strength: \t\t " + (baseStrength + equipmentStrength) +
                "\n Dexterity: \t " + (baseDexterity + equipmentDexterity) +
                "\n Intelligence: \t " + (baseIntelligence + equipmentIntelligence) +
                "\n XP to next lvl: " + levelCalculator.getRequiredXPToLevel();

    }
}