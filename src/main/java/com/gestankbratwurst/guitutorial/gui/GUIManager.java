package com.gestankbratwurst.guitutorial.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public class GUIManager {

  private final Map<Inventory, InventoryHandler> activeInventories = new HashMap<>();

  public void openGUI(InventoryGUI gui, Player player) {
    this.registerHandledInventory(gui.getInventory(), gui);
    player.openInventory(gui.getInventory());
  }

  public void registerHandledInventory(Inventory inventory, InventoryHandler handler) {
    this.activeInventories.put(inventory, handler);
  }

  public void unregisterInventory(Inventory inventory) {
    this.activeInventories.remove(inventory);
  }

  public void handleClick(InventoryClickEvent event) {
    InventoryHandler handler = this.activeInventories.get(event.getInventory());
    if (handler != null) {
      handler.onClick(event);
    }
  }

  public void handleOpen(InventoryOpenEvent event) {
    InventoryHandler handler = this.activeInventories.get(event.getInventory());
    if (handler != null) {
      handler.onOpen(event);
    }
  }

  public void handleClose(InventoryCloseEvent event) {
    Inventory inventory = event.getInventory();
    InventoryHandler handler = this.activeInventories.get(inventory);
    if (handler != null) {
      handler.onClose(event);
      this.unregisterInventory(inventory);
    }
  }

}
