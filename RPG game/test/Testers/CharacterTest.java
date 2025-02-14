/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Testers;
import static org.junit.Assert.*;
import org.junit.Test;
import rpg.game.Player;
/**
 *
 * @author edoua
 */

public class CharacterTest {
    
    @Test
    public void testTakeDamage(){
    Player player=new Player("Nick","Sword",3,100,100);
    
    player.takeDamage(50);
    assertEquals(player.getHealth(),50);
    
    player.takeDamage(100);
    assertEquals(player.getHealth(),-50);
    
    player.takeDamage(0);
    assertEquals(player.getHealth(),-50);
    
    player.takeDamage(-10);
    assertEquals(player.getHealth(),-40);
    }
}
