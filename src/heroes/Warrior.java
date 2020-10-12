package heroes;

public class Warrior extends Hero {

    public Warrior(HeroType typeOfHero, String nameOfHero) {
        super(typeOfHero, nameOfHero);
        setBaseStats();
    }

    private void setBaseStats (){
        baseDexterity = 3;
        baseHealth = 150;
        baseIntelligence = 1;
        baseStrength = 10;
        xP = 0;
    }
}


