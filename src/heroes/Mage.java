package heroes;

public class Mage extends Hero {

    public Mage(HeroType typeOfHero, String nameOfHero) {
        super(typeOfHero, nameOfHero);
        setBaseStats();
    }

    private void setBaseStats(){
        baseHealth = 100;
        baseDexterity = 3;
        baseIntelligence = 10;
        baseStrength = 2;
        xP = 0                         ;
    }
}



