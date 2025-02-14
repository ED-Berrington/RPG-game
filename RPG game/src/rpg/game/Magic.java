
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpg.game;

/**
 *
 * @author edoua
 */
public class Magic {
    private int manaCost;
    private String name;
    private int damage;

    public Magic(int manaCost, String name, int damage) {
        this.manaCost = manaCost;
        this.name = name;
        this.damage = damage;
    }
    public void cast(Character target, Player caster){
        if(manaCost>0&&caster.getManapoints()>=manaCost){
    System.out.println("Casting spell: "+name);
    target.takeDamage(damage);
    caster.setManapoints(caster.getManapoints()-manaCost);
    }else{System.out.println("Not enough mana to cast spell:"+name);}
    }

    public int getManaCost() {
        return manaCost;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }
    
    
}
