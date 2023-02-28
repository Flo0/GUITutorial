package com.gestankbratwurst.guitutorial.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Subcommand;
import com.gestankbratwurst.guitutorial.gui.GUIManager;
import com.gestankbratwurst.guitutorial.gui.impl.PianoInventory;
import org.bukkit.entity.Player;

@CommandAlias("gui")
public class GUICommand extends BaseCommand {

  private final GUIManager guiManager;

  public GUICommand(GUIManager guiManager) {
    this.guiManager = guiManager;
  }

  @Subcommand("open piano")
  public void onOpen(Player player) {
    this.guiManager.openGUI(new PianoInventory(), player);
  }

}
