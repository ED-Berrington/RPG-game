/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpg.game;

/**
 *
 * @author edoua
 */
public class Quest {
    private String name;
    private int rewardExperience;
    private boolean completed;
    
    public Quest(String name, int rewardExperience){
        this.name=name;
        this.rewardExperience=rewardExperience;
        this.completed=false;
    }
    public void complete(){
    if(!completed){
        System.out.println("Quest completed "+name);
        System.out.println("Rewards: "+rewardExperience+" experience points");
        completed=true;
    }else{
        fail();
    }
    }

    public String getName() {
        return name;
    }

    public int getRewardExperience() {
        return rewardExperience;
    }

    public boolean isCompleted() {
        return completed;
    }

    void fail() {
        if(!completed){
        System.out.println("Quest failed: "+name);
        completed=true;
        }else{System.out.println("Quest already failed: "+name);}
    }
    
}
