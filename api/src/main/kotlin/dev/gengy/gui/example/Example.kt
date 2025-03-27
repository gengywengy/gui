package dev.gengy.gui.example

import dev.gengy.gui.BasicInventory
import dev.gengy.gui.Inventory.Size
import dev.gengy.gui.item.InventoryItem
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType

// Purely here for testing DSL to make sure I'm happy with the format.
internal class Example : BasicInventory() {
    override fun onOpen(player: Player) {
        inventory {
            size = Size.THREE_ROWS

            item {
                material = Material.REDSTONE_LAMP
                displayName = "Gengy GUI"
                slot = 5
                amount = 32

                onClick {
                    if (it.clickType == ClickType.LEFT) {
                        player.sendMessage("yur")
                    }
                }
            }

            item {
                material = Material.GLOWSTONE
                slot = 9
                amount = 4
            }
        }
    }

}