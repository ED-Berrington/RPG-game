/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpg.game;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author edoua
 */
public class CombatSystem {
    private Player player;
    private Enemy enemy;
    private int healGainedByFlee;
    Scanner scan=new Scanner(System.in);
    boolean combatOver=false;
    
    public CombatSystem(Player player, Enemy enemy){
    this.player=player;
    this.enemy=enemy;
    }
    
    // the combat loop user will choose what they want their player character to do such as attack, flee from combat, use a special ability, use a healing item
    public void initiateTurnBasedCombat(){
    System.out.println("A "+enemy.getName()+" wielding a "+enemy.weapon.getName()+ " appears!");
    
    while(!combatOver && !player.isDead()){
    displayCombatOptions();
    String playerChoice=getPlayerChoice();
        if(!player.isDead()){
        switch(playerChoice){
            case "1":
                resolveAttack();
                break;
            case "2": 
                resolveDefense();
                break;
            case "3":
                useHealingItem();
                System.out.println("you choose to heal");
                break;
            case "4":
                useSpecialAbility(enemy);
                
                break;
            case "5":
                flee();
                break;
            default:
                System.out.println("Invalid option. please choose again");
        }
        }
        if (player.isDead()) {
            System.out.println("Game over. You have been vanquished.");
            break;
                    }
        if(!combatOver){
            enemyAttack();
            health_check();
            combatOver=checkCombatEnd();
        }
        }
    }

    private void displayCombatOptions() {
        System.out.println("1. Attack");
        System.out.println("2. Defend");
        System.out.println("3. Heal");
        System.out.println("4. Special Ability");
        System.out.println("5. Flee");
    }

    private String getPlayerChoice() {
        String choice=scan.nextLine();
        return choice;
    }
        //the attack method, as well as giving healing item to the player and xp
private void resolveAttack() {
    player.useWeapon(enemy);
    System.out.println("You deal " + player.getWeapon().getDamage() + " against " + enemy.getName());

    if (enemy.getHealth() <= 0 && player.getHealth() > 0) {
        combatOver=true;
        int enemyExperiencePoints = enemy.getExperiencePoints();
        player.gainExperience(enemyExperiencePoints);
        System.out.println("Gained " + enemyExperiencePoints + " experience points");

        // Find and complete the quest related to the defeated enemy
        for (Quest quest : player.getQuests()) {
            if (quest.getName().equalsIgnoreCase("Defeat " + enemy.getName())) {
                player.completeQuest(quest);
                break; // Break out of the loop once the quest is found and completed
            }
        }
        //  
        HealingItem droppedItem = enemy.dropItem();
        if (droppedItem != null) {
            System.out.println("You found a " + droppedItem.getName() + "!");
            player.addHealingItem(droppedItem);
        }
    }


}
//has a chance to defend 30,50,75 or 100 of the damage taken
private void resolveDefense() {
    int[] defenseChance = {30, 50, 75};
    int randomIndex = new Random().nextInt(defenseChance.length);
    int chance = defenseChance[randomIndex];
    if (new Random().nextInt(100) < chance) {
        int originalDamage = player.getWeapon().getDamage();
        int reducedDamage = Math.min(originalDamage,enemy.getWeaponDamage() * chance / 100);
        
        int finalDamage = originalDamage - reducedDamage;

        player.takeDamage(finalDamage);
        player.setManapoints(player.getManapoints()+25);
        System.out.println("You successfully defended damage: " + reducedDamage+" and received "+finalDamage+" damage");
        
    }else{System.out.println("You failed to defend");}

}
//  use healing item method
    private void useHealingItem() {
        player.useHealingItem();
        health_check();
    }
//the enemy attack will attack as long as player heatlh is above 0 once player health reaches 0 
private void enemyAttack() {
    if (player.getHealth() > 0) {
        if (enemy instanceof GoblinKing) {
            GoblinKing goblinKing = (GoblinKing) enemy;
            goblinKing.useWeapon(player); // This will call the overridden method in GoblinKing
        } else {
            enemy.useWeapon(player); // For other enemies
        }

        if (player.getHealth() <= 0) {
            System.out.println("You have been vanquished by " + enemy.getName());
            combatOver = true;
        }
    }
}

    private boolean checkCombatEnd() {
        return player.getHealth()<=0||enemy.getHealth()<=0||combatOver;
    }
//if player flees what should happen
    private void flee() {
        System.out.println("You flee from this battle to live another day");
        if(player.getHealth()<100){
        
        player.setHealth(player.getHealth()+healGainedByFlee);
        }
        combatOver=true;
        
        for(Quest quest:player.getQuests()){
            if(!quest.isCompleted()){
            quest.fail();
            }
        }
    }
// player uses special ability it calls the use special ability in the player class
    private void useSpecialAbility(Enemy enemy) {
        player.useSpecialAbility(enemy);
    }
  
    public void health_check(){
    // Display remaining health and mana
    System.out.println("The " + enemy.getName() + " has " + enemy.getHealth() + " health remaining.");
    System.out.println(player.getName() + " has " + player.getHealth() + " health and " + player.getManapoints() + " mana remaining.");
}
}


