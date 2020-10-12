package attribute_stats;

public class LevelCalculator {
    final double percentIncreaser = 1.10;
    private int requiredXPToLevel = 100;
    private int currentXP;
    private int level = 1;

    /*Formula to calculate xp to next level for a hero*/
    public void levelUpFormula(){
        int currentRequiredXPToLevel = requiredXPToLevel;
        requiredXPToLevel = (int) Math.round(percentIncreaser * requiredXPToLevel);
        level++;
        currentXP -= currentRequiredXPToLevel;
    }

    public int getCurrentXP(){
        return currentXP;
    }

    public void setCurrentXP(int currentXP){
        this.currentXP = currentXP;
    }

    public int getRequiredXPToLevel(){
        return requiredXPToLevel - currentXP;
    }

    /*Calls the method increaseXP, which calculates the current xp,
     * then the method which checks how much is left until next level runs,
     * the remainder is saved in the variable requiredXPToLevel
     * if it is less or equal 0, then levelUpFormula increases the current level */
    public void increaseXP(int increaseXP){
        currentXP += increaseXP;
        while (requiredXPToLevel - currentXP <= 0){
            levelUpFormula();
            System.out.println("\nLevel Up!" +
                    "\nNow level: " + level);
        }
        System.out.println(getRequiredXPToLevel() + " XP more needed to level up. ");
    }
    /*return the level the hero currently have*/
    public int getLevel() {
        return level;
    }
}
