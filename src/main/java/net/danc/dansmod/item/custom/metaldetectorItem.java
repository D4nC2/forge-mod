package net.danc.dansmod.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class metaldetectorItem extends Item {

    public metaldetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            BlockPos posclicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;
            BlockPos pos = null;
            BlockState state = null;
            for (int iY = -60; iY < 321; iY++) {
                for (int iZ = posclicked.getZ() - 1; iZ <= posclicked.getZ() + 1; iZ++) {
                    for (int iX = posclicked.getX() - 1; iX <= posclicked.getX() + 1; iX++) {
                        BlockPos tempPos = new BlockPos(iX, iY, iZ);
                        BlockState tempstate = pContext.getLevel().getBlockState(tempPos);
                        if (tempstate.is(Blocks.IRON_ORE)) {
                            pos = tempPos;
                            state = tempstate;
                            foundBlock = true;


                            break;
                        }
                    };
                }
            }
            if (foundBlock == true) {
                player.sendSystemMessage(Component.literal((I18n.get(state.getBlock().getDescriptionId())).toUpperCase()+ " SPOTTED AT " +
                        "(" + pos.getX() + ", " + pos.getY() + ", " + pos.getZ() + ")"));

            }
            if (foundBlock == false) {
                player.sendSystemMessage(Component.literal("READINGS NEGATIVE"));
            }
        }
            pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                    player -> player.broadcastBreakEvent((player.getUsedItemHand())));

        return InteractionResult.SUCCESS;
    }


}
