package com.twodevsstudio.devsduels.base;

import lombok.Data;
import org.bukkit.World;
import org.bukkit.block.BlockFace;

@Data
public class ArenaLocation {
    
    private final World world;
    private final double x;
    private final double y;
    private final double z;
    private final BlockFace blockFace;
    
}
