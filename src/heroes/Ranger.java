package heroes;

public class Ranger extends Hero {

    public Ranger(HeroType typeOfHero, String nameOfHero) {
        super(typeOfHero, nameOfHero);
        setBaseStats();
    }

    private void setBaseStats(){
        baseDexterity = 10;
        baseHealth = 120;
        baseIntelligence = 2;
        baseStrength = 5;
        xP = 0;
    }
}


