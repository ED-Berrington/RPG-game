/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpg.game;

import java.util.Random;

/**
 *
 * @author edoua
 */
// subclass of enemy uses random generator to give enmy a random number then they get assigned a certain weapon that deals a certain amount of damage
public class Duergar extends Enemy {
    
    private int health;
    private int experiencePoints;
    private String weaponName;
    private int weaponDamage;
    
    public Duergar(String name) {
        super(name);
        this.health=56;
        this.experiencePoints=65;
        weaponName = getRandomWeapon();
        weaponDamage=getWeaponDamage(weaponName);
        setWeapon(new Weapon(weaponName,weaponDamage));
    }
    
        @Override
    public void useWeapon(Player player){
    getWeapon().attack(player);
    }
    
    @Override
    public void takeDamage(int damage){
    health-=damage;
    if(health<=0){
    health=0;
    System.out.println("The enemy is slain");
    }
    }
    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getExperiencePoints() {
        return experiencePoints;
    }
    
private String getRandomWeapon(){
String[] availableWeapons={"Axe", "Sword", "Mattock", "Hammer"};
    Random random=new Random();
    int index=random.nextInt(availableWeapons.length);
    String randomWeaponName=availableWeapons[index];
    return randomWeaponName;
}

    private int getWeaponDamage(String weaponName) {
        switch(weaponName){
            case "Axe":
                return 20;
            case "Sword":
                return 18;
            case "Mattock":
                return 15;
            case "Hammer":
                return 23;
            default:
                return 0;
        }
    }
    @Override
        public HealingItem dropItem() {
        
        if (shouldDropItem()) {
            return new HealingItem("Dwarven ale", 50);
        } else {
            return null;
        }
    }

    private boolean shouldDropItem() {
        
        return new Random().nextInt(100) < 50;
    }
}
