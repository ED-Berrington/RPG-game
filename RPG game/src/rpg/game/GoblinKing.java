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
public class GoblinKing extends Enemy {
    private int health;
    private int damage;
    private double critChance=0.3;
    private String weaponName;
    private int weaponDamage;
    
    public GoblinKing(String name) {
        super(name);
        this.health=70;
        weaponName = "Goblin King Sword";
        weaponDamage=35;
        setWeapon(new Weapon(weaponName,weaponDamage));
        
    }
    
    private boolean performCrit(){
    return new Random().nextDouble()<critChance;
    }
    
    @Override
    public void useWeapon(Player player){
        if(performCrit()){
            int critDamage=(int)(getWeapon().getDamage()*1.5);
            System.out.println("Critical Hit! " + getName() + " deals " + critDamage + " damage to " + player.getName());
            player.takeDamage(critDamage);
        }else{getWeapon().attack(player);}
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
}
