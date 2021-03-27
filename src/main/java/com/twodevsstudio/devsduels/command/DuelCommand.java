package com.twodevsstudio.devsduels.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import com.twodevsstudio.devsduels.configuration.BaseConfiguration;
import com.twodevsstudio.devsduels.util.BaseUtil;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;

@CommandAlias( "duel|duels" )
@CommandPermission( "duels.user" )
@RequiredArgsConstructor
public class DuelCommand extends BaseCommand {
    
    private final BaseConfiguration baseConfiguration;
    
    @Default
    public void onHelp(Player player) {
        
        player.sendMessage(BaseUtil.colorComponent(baseConfiguration.getDuelsCommandUsage()));
    }
    
}
