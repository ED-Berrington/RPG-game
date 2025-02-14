/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Testers;
import static org.junit.Assert.*;
import org.junit.Test;
import rpg.game.GoblinKing;
import rpg.game.Player;

/**
 *
 * @author edoua
 */
public class GoblinKingTester {
    
    @Test
    public void testAttack(){
    Player player=new Player("test dummy","",15,30,100);
    
    GoblinKing enemy1=new GoblinKing("The Goblin King");
    // player does not get hit with a critical attack
    enemy1.useWeapon(player);
    assertEquals(65,player.getHealth());
    //player gets hit with a critical attack
    player.setHealth(100);
    enemy1.useWeapon(player);
    assertEquals(48,player.getHealth());
    }
}
