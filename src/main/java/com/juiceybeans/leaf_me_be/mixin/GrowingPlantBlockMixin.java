package com.juiceybeans.leaf_me_be.mixin;

import com.juiceybeans.leaf_me_be.ModTags;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.GrowingPlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(GrowingPlantBlock.class)
public abstract class GrowingPlantBlockMixin {
    @WrapOperation(
            method = "canSurvive",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockState;isFaceSturdy(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/Direction;)Z")
    )
    private boolean leaf_me_be$cave_vine_placement(BlockState instance, BlockGetter blockGetter, BlockPos pos, Direction direction, Operation<Boolean> original) {
        return original.call(instance, blockGetter, pos, direction) || blockGetter.getBlockState(pos.above()).is(ModTags.SUPPORTS_CAVE_VINES);
    }
}
