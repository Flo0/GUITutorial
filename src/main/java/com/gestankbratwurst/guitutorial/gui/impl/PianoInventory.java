package com.gestankbratwurst.guitutorial.gui.impl;

import com.gestankbratwurst.guitutorial.gui.InventoryButton;
import com.gestankbratwurst.guitutorial.gui.InventoryGUI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PianoInventory extends InventoryGUI {

  @Override
  protected Inventory createInventory() {
    return Bukkit.createInventory(null, 3 * 9, "Piano");
  }

  @Override
  public void decorate(Player player) {
    int inventorySize = this.getInventory().getSize();
    float basePitch = 0.5f;

    for (int i = 0; i < inventorySize; i++) {
      Material material = i % 2 == 0 ? Material.WHITE_STAINED_GLASS_PANE : Material.BLACK_STAINED_GLASS_PANE;
      final float pitchOffset = i * 0.033f;
      this.addButton(i, this.createPianoButton(basePitch + pitchOffset, material));
    }

    super.decorate(player);
  }

  private InventoryButton createPianoButton(float pitch, Material material) {
    return new InventoryButton()
            .creator(player -> new ItemStack(material))
            .consumer(event -> {
              Player player = (Player) event.getWhoClicked();
              Location loc = player.getEyeLocation();
              player.playSound(loc, Sound.BLOCK_NOTE_BLOCK_PLING, 1f, pitch);
            });
  }

}
