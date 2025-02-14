/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpg.game;

import java.util.Scanner;

/**
 *
 * @author edoua
 */
public class runGame {
    public static void  main(String[] args){
         String name;
        Scanner scan=new Scanner(System.in);
        String weaponOption;        
        System.out.println("Enter the name of your hero: ");
        name=scan.nextLine();
        weaponList();
        

         weaponOption=scan.nextLine();

        Weapon selectedWeapon=selectWeapon(weaponOption);
        Player player=new Player(name,selectedWeapon.getName(),selectedWeapon.getDamage(),100,100);
    
        Enemy enemy1=new Goblin("Goblin");
        Enemy enemy2=new Orc("Orc");
        Enemy enemy3=new Duergar("Duergar");
        Enemy enemy4=new Bugbear("Bugbear");
        Enemy enemy5=new GoblinKing("Goblin King");
    
        Quest killGoblinQuest=new Quest("Defeat the goblin",50);
        Quest killOrcQuest=new Quest("Defeat the Orc",100);
        Quest killDuergarQuest=new Quest("Defeat the Duergar",150);
        Quest killBugbearQuest=new Quest("Defeat the Bugbear",200);
        Quest killGoblinKingQuest=new Quest("Defeat the Goblin King",300);
        
        player.addQuest(killGoblinQuest);
        player.addQuest(killOrcQuest);
        player.addQuest(killDuergarQuest);
        player.addQuest(killBugbearQuest);
        player.addQuest(killGoblinKingQuest);
        
        CombatSystem combatSystem=new CombatSystem(player,enemy1);
        combatSystem.initiateTurnBasedCombat();
         completeQuest(player,killGoblinQuest);

        
        combatSystem=new CombatSystem(player,enemy2);       
        if(killGoblinQuest.isCompleted()){
        combatSystem.initiateTurnBasedCombat();
        completeQuest(player,killOrcQuest);
        }else{
            System.out.println("You need to defeat the Goblin first.");
        }
        
        combatSystem=new CombatSystem(player,enemy3);
        
        if(killOrcQuest.isCompleted()){
        combatSystem.initiateTurnBasedCombat();
        completeQuest(player,killDuergarQuest);
        }else{
        System.out.println("You need to defeat the Orc first.");
        }
        
        
        combatSystem=new CombatSystem(player,enemy4);
        
        if(killDuergarQuest.isCompleted()){
        combatSystem.initiateTurnBasedCombat();
        completeQuest(player,killBugbearQuest);
        }else{
        System.out.println("You need to defeat the Duergar first.");
        }
        
        
        combatSystem=new CombatSystem(player,enemy5);
        
        if(killDuergarQuest.isCompleted()){
        combatSystem.initiateTurnBasedCombat();
        completeQuest(player,killGoblinKingQuest);
        }else{
        System.out.println("You need to defeat all the enemies first.");
        }
    
    }
    
    
    public static void weaponList(){
    System.out.println("Select the option for the weapon you want to wield.");
    System.out.println("1. Sword");
    System.out.println("2. Axe");
    System.out.println("3. Warhammer");
    System.out.println("4. Boxing glove");
    System.out.println("5. Fist");
    System.out.println("6. Spear");
    }
    
    public static Weapon selectWeapon(String weaponOption){
        
        
    switch(weaponOption){
        case "1": 
            return new Weapon("Sword",15);
        case "2":
            return new Weapon("Axe",20);
        case "3": 
            return new Weapon("Warhammer",27);
        case "4":
            return new Weapon("Boxing glove",10);
        case "5":
            return new Weapon("Fist",5);
        case "6":
            return new Weapon("Spear",15);
        default:
            //if user gives an option that is not there
            System.out.println("not a valid weapon. Giving you fist");
            return new Weapon("Fist",5);
            
    }
        
    }
//completes the quest for the player will reward the player once the quest is successfull
    private static void completeQuest(Player player, Quest quest) {
        for (Quest q:player.getQuests()){
        if(q != null &&q.equals(quest)&& !q.isCompleted()){
        player.completeQuest(quest);
        break;
        }
    }
    }
}
