package dev.gengy.gui.item

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

open class InventoryItem(
    var material: Material = Material.AIR,
    var displayName: String? = null,
    var amount: Int = 1,
    var slots: MutableSet<Int> = mutableSetOf<Int>(),
    var lore: List<String> = emptyList<String>(),
) {
    private val clickListeners: MutableSet<(InventoryItemClick) -> Unit> = mutableSetOf()

    data class InventoryItemClick(
        val player: Player,
        val clickType: ClickType,
    )

    fun onClick(onClick: (event: InventoryItemClick) -> Unit) {
        clickListeners.add(onClick)
    }

    fun slots(vararg slots: Int) {
        this.slots.addAll(slots.asList())
    }

    var slot: Int
        get() = slots.first()
        set(value) {
            slots.add(value)
        }

    private fun buildItemStack(): ItemStack {
        val item = ItemStack(material)
        val meta = item.itemMeta!!
        if (displayName != null) meta.setDisplayName(displayName)
        if (lore.isNotEmpty()) meta.lore = lore
        item.itemMeta = meta
        item.amount = amount
        return item
    }

    internal fun fill(inventory: Inventory) {
        val item = buildItemStack()
        slots.forEach {
            inventory.setItem(it, item)
        }
    }
}