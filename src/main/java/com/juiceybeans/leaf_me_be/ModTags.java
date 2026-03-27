package com.juiceybeans.leaf_me_be;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import static com.juiceybeans.leaf_me_be.Main.MOD_ID;

public final class ModTags {
    public static final TagKey<Block> SUPPORTS_CAVE_VINES = create("supports_cave_vines");

    private ModTags() {
    }

    private static TagKey<Block> create(String name) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, name));
    }
}
