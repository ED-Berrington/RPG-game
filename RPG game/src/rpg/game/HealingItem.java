/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpg.game;

/**
 *
 * @author edoua
 */
class HealingItem {
    private String name;
    private int healingAmount;

    public HealingItem(String name,int healingAmount) {
        this.name=name;
        this.healingAmount = Math.max(0, healingAmount);
    }
        public void use(Character character) {
        character.takeDamage(-healingAmount);
    }

    public String getName() {
        return name;
    }
        
}
