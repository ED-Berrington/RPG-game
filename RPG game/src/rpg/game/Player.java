/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpg.game;

import java.util.Random;
import rpg.ArrayUtil;

/**
 *
 * @author edoua
 */
public class Player extends Character {
    private Weapon weapon;
    private int manapoints;
    private HealingItem[] healingItems;
    private int healingItemCount;
    private Quest[] quests;
    private int questCount;
    private int health;
    private Magic[] spells;
    private int spellCount;
    
    public Player(String name, String weaponName,int weaponDamage,int manapoints,int health) {
        super(name);
        this.weapon=new Weapon(weaponName,weaponDamage);
        this.manapoints=100;
        this.healingItems=new HealingItem[]{new HealingItem("Potion",40),new HealingItem("Potion",40),new HealingItem("Potion",40)};
        this.healingItemCount=3;
        this.quests=new Quest[5];
        this.questCount=0;
        this.health=100;
        this.spells=new Magic[3];
        this.spellCount=0;
        initializeSpells();
    }
    // the player attacks witht he weapon they chose
    public void useWeapon(Enemy enemy){
    weapon.attack(enemy);
    }
    //the player uses a healing item it removes from the healing array
    public void useHealingItem(){
    if(healingItemCount>0){
    HealingItem healingItem=healingItems[0];
    healingItem.use(this);
    healingItems=ArrayUtil.removeElement(healingItems,0);
    healingItemCount--;
    System.out.println(getName() + " has used a healing item. " +"Remaining healing items: " + healingItemCount);
    }else{
    System.out.println(getName()+" has no healing items left");
    }
    }
    //adds a healing item to the array
    public void addHealingItem(HealingItem healingItem){
    healingItems=ArrayUtil.addElement(healingItems,healingItem);
    healingItemCount++;
    }
    //player uses their special ability has a chance to be one of two spells that can cause some serious damage
public void useSpecialAbility(Enemy enemy) {
    Random rand = new Random();

    if (spellCount > 0) {
        int randomSpell = rand.nextInt(spellCount);
        Magic selectedSpell = spells[randomSpell];

        // Check if the player has enough mana to cast the selected spell
        if (selectedSpell.getManaCost() <= getManapoints()) {
            selectedSpell.cast(enemy, this);
        } else {
            System.out.println("Not enough mana to cast the spell.");
        }
    } else {
        System.out.println("No spells available.");
    }
}
    @Override
    public void levelUp() {
        setLevel(getLevel()+1);
        setHealth(getHealth()+20);
        setManapoints(getManapoints()+20);
        int newWeaponDamage=weapon.getDamage()+20;
        weapon.setDamage(newWeaponDamage);
        System.out.println(getName()+" has leveled up! They are now level "+getLevel());
    }

    @Override
    public void gainExperience(int amount) {
        setExperiencePoints(getExperiencePoints()+amount);
        System.out.println(getName()+" has gained some experience points. They have got : "+amount+" experience");
        while (getExperiencePoints()>=100){
        levelUp();
        setExperiencePoints(getExperiencePoints()-100);
        }
    }

    @Override
    public void takeDamage(int damage) {
        setHealth(Math.max(0, getHealth()-damage));
        if(getHealth()<=0){
            setHealth(0);
            System.out.println(getName()+" has been vanquished");
        }
    }
    public int getManapoints() {
        return manapoints;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public int getHealth() {
        return health;
    }

    public void setManapoints(int manapoints) {
        this.manapoints = manapoints;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public Quest[] getQuests() {
        return quests;
    }

    public Weapon getWeapon() {
        return weapon;
    }
    
public void addQuest(Quest quest){
    if(questCount<quests.length){
        quests[questCount]=quest;
        questCount++;
    }
}
//remove the quest from the quest array
    void completeQuest(Quest quest) {
               quest.complete();
        gainExperience(quest.getRewardExperience());
        quests=ArrayUtil.removeElement(quests, indexOfQuest(quest));
    }
        private int indexOfQuest(Quest quest) {
        for (int i = 0; i < quests.length; i++) {
            if (quests[i] == quest) {
                return i;
            }
        }
        return -1; 
    }

    private void initializeSpells() {
        Magic fireball=new Magic(30,"Fireball",15);
        Magic lightning=new Magic(45,"Lightning",35);
        addSpell(fireball);
        addSpell(lightning);
    }

    public Magic[] getSpells() {
        return spells;
    }

    private void addSpell(Magic spell) {
        if(spellCount<spells.length){
        spells[spellCount]=spell;
        spellCount++;
        }
    }

    boolean isDead() {
        return getHealth()<=0;
    }
    
    
}
