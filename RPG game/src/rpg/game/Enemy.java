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
class Enemy extends Character {
    Weapon weapon;


    private int health;
    private int experiencePoints;
    
    public Enemy(String name) {
        super(name);
        health=50;
        this.weapon=new Weapon("Claws",4);
        this.experiencePoints=20;
    }

    
    public int getExperiencePoints() {
        return experiencePoints;
    }
    
    public int getWeaponDamage() {
        return weapon.getDamage();
    }

    public int getHealth() {
        return health;
    }

    @Override
    public void levelUp() {
        //enemies should not be able to level up
    }
    public void useWeapon(Player player){
    weapon.attack(player);
    }
    
    @Override
    public void takeDamage(int damage){
    health-=damage;
    if(health<=0){
    health=0;
    System.out.println("The enemy is slain");
    }
    }
        public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
        
         public HealingItem dropItem() {
        
        if (shouldDropItem()) {
            return new HealingItem("Health Potion", 20);
        } else {
            return null;
        }
    }

    private boolean shouldDropItem() {
        
        return new Random().nextInt(100) < 30;
    }
}

