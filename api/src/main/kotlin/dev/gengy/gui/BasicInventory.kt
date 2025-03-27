package dev.gengy.gui

import dev.gengy.gui.item.InventoryItem
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryType
import org.bukkit.inventory.InventoryView

abstract class BasicInventory : Inventory {
    var meta: BasicInventoryMeta = BasicInventoryMeta()
    val items: MutableList<InventoryItem> = mutableListOf()

    abstract fun onOpen(player: Player)
    open fun onClose(player: Player) {}
    open fun onTick(player: Player) {}

    inner class BasicInventoryMeta(
        var size: Inventory.Size = Inventory.Size.ONE_ROW,
    )

    inline fun inventory(meta: BasicInventoryMeta.() -> Unit) {
        this.meta = BasicInventoryMeta().apply(meta)
    }

    inline fun item(material: Material = Material.AIR, itemData: InventoryItem.() -> Unit) {
        items.add(InventoryItem(
            material = material
        ).apply(itemData))
    }
    fun item(item: InventoryItem) {
        items.add(item)
    }

    internal fun show(player: Player): InventoryView? {
        onOpen(player)
        val inventory = Bukkit.createInventory(null, meta.size.invSize)

        items.forEach {
            it.fill(inventory)
        }

        return player.openInventory(inventory)
    }
}