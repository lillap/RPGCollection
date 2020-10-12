import heroes.*;
import items.*;

import java.sql.SQLOutput;


public class Program {

    public static void main(String[] args) {
        /*Creates a Warrior*/
        System.out.println();
        Hero myWarrior = HeroFactory.createHero(HeroType.Warrior, "Gimli");
        System.out.println(myWarrior.toString()
                + "\n Attack damage:\t" + myWarrior.calculateDamage());

        /*Creates a Warrior*/
        System.out.println();
        myWarrior.increaseXP(630);
        System.out.println(myWarrior.toString()
                + "\n Attack damage:\t" + myWarrior.calculateDamage());



        /*Creates a melee weapon, equip warrior with it*/
        System.out.println();
        Item meleeWeapon = new ItemBuilder()
                .withName(" The Great Hangry Wolf Hammer")
                .withItemTypeMelee()
                .withRequiredLevel(4)
                .buildWeapon();
        myWarrior.equipItem(meleeWeapon);
        System.out.println(meleeWeapon.toString() +
                " \n Attack damage:\t" + myWarrior.calculateDamage());

        /*Creates a Ranger*/
        System.out.println();
        Hero myRanger = HeroFactory.createHero(HeroType.Ranger, "Aragon");
        myRanger.increaseXP(990);
        System.out.println(myRanger.toString()
                + " \n Attack damage:\t" + myRanger.calculateDamage());



        /*Create a a ranged weapon, equip ranger with it*/
        System.out.println();
        Item rangedWeapon = new ItemBuilder()
                .withName("Frosty Snake-eye Bow")
                .withItemTypeRanged()
                .withRequiredLevel(6)
                .buildWeapon();
        myRanger.equipItem(rangedWeapon);
        System.out.println(myRanger.toString() +
                " \n Attack damage:\t" + myRanger.calculateDamage());

        System.out.println();
        Hero myMage = HeroFactory.createHero(HeroType.Mage, "Gandalf");
        myMage.increaseXP(500);
        System.out.println(myMage.toString()
                + " \n Attack damage:\t" + myMage.calculateDamage() );


        /*Creates leather leg armor */
        System.out.println();
        Item leatherArmor = new ItemBuilder()
                .withName("So Soft, So Dangerous Leather Pants")
                .withArmorTypeLeather()
                .withItemTypeLegsArmor()
                .withRequiredLevel(7)
                .buildArmor();
        System.out.println(leatherArmor.toString());

        /*Creates plate leg armor*/
        System.out.println();
        Item plateLegs = new ItemBuilder()
                .withName("The Great Uncomfy Protective Plate Pants")
                .withArmorTypePlate()
                .withItemTypeLegsArmor()
                .withRequiredLevel(4)
                .buildArmor();
        System.out.println(plateLegs.toString());

        /*equip mage with leather armor*/
        System.out.println();
        myMage.equipItem(leatherArmor);
        System.out.println(myMage.toString()
                + " \n Attack damage:\t" + myMage.calculateDamage() );

        /*equip mage with plate armor*/
        System.out.println();
        myMage.equipItem(plateLegs);
        System.out.println();
        System.out.println(myMage.toString()
                + " \n Attack damage:\t" + myMage.calculateDamage() );

        System.out.println();
        Item helmet = new ItemBuilder()
                .withName("The Fabulous Protecter of a Great Mind")
                .withArmorTypePlate()
                .withItemTypeHeadArmor()
                .withRequiredLevel(5)
                .buildArmor();
        System.out.println(helmet.toString());

        System.out.println();
        Item bodyProtecter = new ItemBuilder()
                .withName("Protecter against Traitorly Backstabbing")
                .withArmorTypePlate()
                .withItemTypeBodyArmor()
                .withRequiredLevel(8)
                .buildArmor();
        System.out.println(bodyProtecter.toString());

        myRanger.equipItem(bodyProtecter);
        System.out.println(myRanger.toString() +
                " \n Attack damage:\t" + myRanger.calculateDamage());

    }



}
