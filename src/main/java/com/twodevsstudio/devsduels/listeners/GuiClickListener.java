package com.twodevsstudio.devsduels.listeners;

import com.twodevsstudio.devsduels.base.DuelPlayer;
import com.twodevsstudio.devsduels.inventory.BaseGui;
import com.twodevsstudio.devsduels.repository.DuelPlayerRepository;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

import java.util.Map;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class GuiClickListener implements Listener {
    private final DuelPlayerRepository repository;
    
    @EventHandler
    public void onGuiClick(InventoryClickEvent event) {
        
        Inventory inventory = event.getClickedInventory();
        if (inventory == null || !(inventory.getHolder() instanceof BaseGui)) {
            return;
        }
        event.setCancelled(true);
        
        int clickedSlot = event.getSlot();
        BaseGui gui = (BaseGui) inventory.getHolder();
        HumanEntity whoClicked = event.getWhoClicked();
        
        Map<Integer, Consumer<DuelPlayer>> actions = gui.getActions();
        if (actions.containsKey(clickedSlot)) {
            actions.get(clickedSlot).accept(repository.findDuelPlayerByUUID(whoClicked.getUniqueId()));
        }
        
    }
    
    @EventHandler
    public void onDrag(InventoryDragEvent event) {
        
        InventoryView view = event.getView();
        Inventory inventory = view.getTopInventory();
        if (!(inventory.getHolder() instanceof BaseGui)) {
            return;
        }
        event.setCancelled(true);
    }
}
