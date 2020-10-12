package items;

public abstract class Item {

    protected String nameOfItem;
    protected int requiredLevel;

    protected ItemType itemType;

    public ItemType getItemType(){
        return itemType;
    }

    public void setItemType( ItemType itemtype){
        this.itemType = itemtype;
    }

    public String getNameOfItem(){
        return nameOfItem;
    }

    public void setNameOfItem(String nameOfItem){
        this.nameOfItem = nameOfItem;
    }

    public int getRequiredLevel(){
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel){
        this.requiredLevel = requiredLevel;
    }


    /*As armor have more properties than weapon, get methods are used in item,
     but are overridden by get methods in armor which returns a value (other than zero) */
    public int getDexterity(){
        return 0;
    }

    public int getHealth(){
        return 0;
    }

    public int getIntelligence(){
        return 0;
    }

    public int getStrength(){
        return 0;
    }

    public int getDamage(){
        return 0;
    }
}