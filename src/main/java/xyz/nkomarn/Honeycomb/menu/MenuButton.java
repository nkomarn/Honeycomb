package xyz.nkomarn.Honeycomb.menu;

import org.bukkit.Material;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Represents a button on a GUI Inventory.
 * Code can be bound to the button to execute when it is pressed in its GUI.
 */
public class MenuButton {
    private final Menu inventory;
    private ItemStack item;
    private final int slot;
    private final GuiButtonCallback callback;

    /**
     * Creates a new GuiButton and binds it to the provided Inventory.
     *
     * @param inventory The Gui Inventory to bind the button to.
     * @param item      The ItemStack to represent the button in the Gui Inventory.
     * @param slot      The slot of the Gui Inventory in which to place the button.
     * @param callback  The callback to code which should be executed on button click in the Gui Inventory.
     */
    public MenuButton(Menu inventory, ItemStack item, int slot, GuiButtonCallback callback) {
        this.inventory = inventory;
        this.item = item;
        this.slot = slot;
        this.callback = callback;
    }

    /**
     * Returns the ItemStack which represents the GuiButton in the Gui Inventory.
     *
     * @return The ItemStack that is bound to this GuiButton.
     */
    public ItemStack getItem() {
        return this.item;
    }

    /**
     * Returns the slot of the Gui Inventory that this button is in.
     *
     * @return The Gui Inventory slot of this button.
     */
    public int getSlot() {
        return this.slot;
    }

    /**
     * Returns the callback for this GuiButton.
     *
     * @return The callback with code to run on click.
     */
    public GuiButtonCallback getCallback() {
        return this.callback;
    }

    /**
     * Updates the ItemStack of the GuiButton and then updates the inventory.
     *
     * @param item The new ItemStack for the GuiButton.
     */
    public void setItem(ItemStack item) {
        this.item = item;
        update();
    }

    /**
     * Updates the Material type of the GuiButton and then updates the inventory.
     *
     * @param material The new Material for the GuiButton.
     */
    public void setMaterial(Material material) {
        item.setType(material);
        update();
    }

    /**
     * Updates the ItemMeta of the GuiButton and then updates the inventory.
     *
     * @param meta The new ItemMeta for the GuiButton.
     */
    public void setItemMeta(ItemMeta meta) {
        item.setItemMeta(meta);
        update();
    }

    /**
     * Refreshes the Gui Inventory for the viewing player without reopening.
     */
    public void update() {
        inventory.getInventory().setItem(slot, item);
        inventory.getPlayer().updateInventory();
    }

    /**
     * Represents a callback for GuiButton click in the Gui Inventory.
     */
    @FunctionalInterface
    public interface GuiButtonCallback {
        void handle(MenuButton button, ClickType clickType);
    }
}
