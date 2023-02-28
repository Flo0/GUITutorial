package com.gestankbratwurst.guitutorial;

import co.aikar.commands.BukkitCommandManager;
import com.gestankbratwurst.guitutorial.command.GUICommand;
import com.gestankbratwurst.guitutorial.gui.GUIListener;
import com.gestankbratwurst.guitutorial.gui.GUIManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class GUITutorial extends JavaPlugin {

  @Override
  public void onEnable() {
    GUIManager guiManager = new GUIManager();

    GUIListener guiListener = new GUIListener(guiManager);
    Bukkit.getPluginManager().registerEvents(guiListener, this);

    // For debug purposes only
    BukkitCommandManager commandManager = new BukkitCommandManager(this);
    GUICommand guiCommand = new GUICommand(guiManager);
    commandManager.registerCommand(guiCommand);
  }

}
