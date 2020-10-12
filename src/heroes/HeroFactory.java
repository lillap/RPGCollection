package heroes;

public class HeroFactory {

    /*Factor pattern to decouple construction of objects, possible to easily add new hero types*/
    public static Hero createHero(HeroType type, String name){
        switch(type){
            case Mage:
                return new Mage(type, name);
            case Ranger:
                return new Ranger(type, name);
            case Warrior:
                return new Warrior(type, name);
            default:
                return null;
        }
    }

}
