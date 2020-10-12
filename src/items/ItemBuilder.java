package items;

public class ItemBuilder {
    private int bonusDexterity;
    private int bonusHP;
    private int bonusIntelligence;
    private int bonusStrength;
    private int requiredLevel;

    private ArmorType armorType;
    private String nameOfItem;

    private ItemType itemType;

    /*Using the design pattern item builder to easily create new item objects.
    The pattern makes the code more verbose.
    Each enum of itemtype has its own method which sets and returns the type*/
    public ItemBuilder withArmorTypeCloth(){
        this.armorType = ArmorType.Cloth;
        return this;
    }

    public ItemBuilder withArmorTypeLeather(){
        this.armorType = ArmorType.Leather;
        return this;
    }

    public ItemBuilder withArmorTypePlate(){
        this.armorType = ArmorType.Plate;
        return this;
    }

    public ItemBuilder withItemTypeBodyArmor(){
        this.itemType = ItemType.Body;
        return this;
    }

    public ItemBuilder withItemTypeHeadArmor(){
        this.itemType = ItemType.Head;
        return this;
    }

    public ItemBuilder withItemTypeLegsArmor(){
        this.itemType = ItemType.Legs;
        return this;
    }

    public ItemBuilder withItemTypeMelee(){
        this.itemType = ItemType.Melee;
        return this;
    }

    public ItemBuilder withItemTypeRanged(){
        this.itemType = ItemType.Ranged;
        return this;
    }

    public ItemBuilder withName(String nameOfItem){
        this.nameOfItem = nameOfItem;
        return this;
    }

    public ItemBuilder withBonusDexterity(int bonusDexterity){
        this.bonusDexterity = bonusDexterity;
        return this;
    }

    public ItemBuilder withRequiredLevel (int requiredLevel){
        this.requiredLevel = requiredLevel;
        return this;
    }

    public Item buildArmor(){
        Item armor = new Armor();
        armor.setNameOfItem(this.nameOfItem);
        ((Armor) armor).setArmorType(this.armorType);
        armor.setItemType(this.itemType);
        armor.setRequiredLevel(this.requiredLevel);
        ((Armor) armor).calculateArmorStats();
        ((Armor) armor).calculateSlotBonus();
        return armor;
    }

    public Item buildWeapon(){
        Item weapon = new Weapon();
        weapon.setNameOfItem(this.nameOfItem);
        weapon.setItemType(this.itemType);
        weapon.setRequiredLevel(this.requiredLevel);
        ((Weapon) weapon).calculateWeaponDamage();
        return weapon;
    }
}

