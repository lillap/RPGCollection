# RPG Collection - Task 3

This is a simple RPG Character system where it is possible to create 3 types of characters -
warrior, ranger and mage. It is also possible to create weapons and armor to equip the character with in this system. 
There are two types of weapon - melee weapon and ranged weapon, 
and there are three types of armor - cloth, leather and plate.
The program is set up in a way which makes it possible to expand the system by for example 
adding new types of character or new types of items. 

### Installation

### Usage
Example of how to create a hero, which is done with the HeroFactory class:

    Hero myWarrior = HeroFactory.createHero(HeroType.Warrior, "Gimli");
            System.out.println(myWarrior.toString()
                    + "\n Attack damage:\t" + myWarrior.calculateDamage());
myWarrior is the instance name. 
Choosing the type of character with HeroType.Warrior, where warrior can be substituted with Ranger or Mage.
Use toString() to print out the hero details.

 Example of how to create a weapon, which is done with the ItemBuilder: 
 
     Item helmet = new ItemBuilder()
                    .withName("The Fabulous Protecter of a Great Mind")
                    .withArmorTypePlate()
                    .withItemTypeHeadArmor()
                    .withRequiredLevel(5)
                    .buildArmor();
            System.out.println(helmet.toString());
 
Equip your character by using the following method on the instantiated character:
       
    equipItem();

### Documentation

As the size of this project is still small and simple enough, no additional documentation is available. 
