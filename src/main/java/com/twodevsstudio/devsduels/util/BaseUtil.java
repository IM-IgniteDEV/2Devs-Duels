package com.twodevsstudio.devsduels.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor( access = AccessLevel.PRIVATE )
public class BaseUtil {
    
    public static Component colorComponent(String toColor) {
        
        return LegacyComponentSerializer.legacyAmpersand().deserialize(toColor).asComponent();
    }
    
    public static List<Component> colorComponent(List<String> toColor) {
        
        return toColor.stream().map(BaseUtil::colorComponent).collect(Collectors.toList());
    }
    
}
