package dev.gengy.gui

import org.bukkit.entity.Player
import org.bukkit.inventory.InventoryView

fun Player.openInventory(inventory: BasicInventory): InventoryView? {
    return inventory.show(this)
}