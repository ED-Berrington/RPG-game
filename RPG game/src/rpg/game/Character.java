/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpg.game;

/**
 *
 * @author edoua
 */
abstract class  Character {
    String name;
    int health;
    int level;
    int experiencePoints;

    public Character(String name) {
        this.name = name;
        this.health = 150;
        this.level = 1;
        this.experiencePoints = 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }
    
    public abstract void levelUp();
    
    public void gainExperience(int amount){
    this.experiencePoints+=amount;
    if(experiencePoints>=100){
    levelUp();
    }
    }
    
    public void takeDamage(int damage){
    this.health-=damage;
    if(health<0){
    health=0;
    }
    }
}
