package net.lilithsdemon.beanzz.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class BeanBlock extends Block {
    public BeanBlock(Properties pProperties)
    {
        super(pProperties);
    }



    @Override
    public void fallOn(Level pLevel, BlockState pState, BlockPos pPos, Entity pEntity, float pFallDistance) {
        if (pEntity.isSuppressingBounce()) {
            super.fallOn(pLevel, pState, pPos, pEntity, pFallDistance);
        } else {
            pEntity.causeFallDamage(pFallDistance, 0.0F, pLevel.damageSources().fall());
        }

    }

    @Override
    public void updateEntityAfterFallOn(BlockGetter pLevel, Entity pEntity) {
        if (pEntity.isSuppressingBounce()) {
            super.updateEntityAfterFallOn(pLevel, pEntity);
        } else {
            this.bounceUp(pEntity);
        }
    }

    private void bounceUp(Entity pEntity) {
        Vec3 $$1 = pEntity.getDeltaMovement();
        if ($$1.y < (double)0.0F) {
            double $$2 = pEntity instanceof LivingEntity ? (double)1.0F : 0.8;
            pEntity.setDeltaMovement($$1.x, -$$1.y * $$2, $$1.z);
        }

    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        double $$4 = Math.abs(pEntity.getDeltaMovement().y);
        if ($$4 < 0.1 && !pEntity.isSteppingCarefully()) {
            double $$5 = 1.5 + $$4 * 0.2;
            pEntity.setDeltaMovement(pEntity.getDeltaMovement().multiply($$5, (double)1.0F, $$5));
        }else
        {
            double $$5 = 1.2 + $$4 * 0.2;
            pEntity.setDeltaMovement(pEntity.getDeltaMovement().multiply($$5, (double)1.0F, $$5));
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
