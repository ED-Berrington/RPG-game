/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpg.game;

/**
 *
 * @author edoua
 */
class Weapon {
String name;
int damage;

public Weapon(String name, int damage){
this.name=name;
this.damage=damage;
}
    void attack(Character target) {
        target.takeDamage(damage);
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }
    
}
