package com.twodevsstudio.devsduels.configuration;

import com.twodevsstudio.devsduels.util.SlotItemStack;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Properties {
    
    private boolean deathMessages;
    private boolean giveDuelItemsOnJoin;
    private boolean inventoryLockDuelItems;
    
    private SlotItemStack duelJoinItemStack;
    private SlotItemStack duelCreateItemStack;
    
}
