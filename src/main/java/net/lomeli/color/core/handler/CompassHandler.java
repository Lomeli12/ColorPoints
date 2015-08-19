package net.lomeli.color.core.handler;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import net.lomeli.color.blocks.ModBlocks;
import net.lomeli.color.core.helper.WayPointHelper;
import net.lomeli.color.items.ModItems;
import net.lomeli.color.lib.MCColors;
import net.lomeli.color.lib.WayPoint;

public class CompassHandler {

    @SubscribeEvent
    public void playerInteract(PlayerInteractEvent event) {
        EntityPlayer player = event.entityPlayer;
        World world = event.world;
        BlockPos pos = event.pos;
        ItemStack stack = player.getCurrentEquippedItem();
        if (!world.isRemote && stack != null && stack.getItem() == ModItems.triCompass) {
            if (event.action == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK) {
                IBlockState state = world.getBlockState(pos);
                if (state != null) {
                    Block block = state.getBlock();
                    if (block != null) {
                        if (block == ModBlocks.waypointBlock && stack.getItemDamage() > 0) {
                            WayPointHelper.setWaypoint(stack, new WayPoint(pos, world.provider.getDimensionId()));
                            player.addChatComponentMessage(new ChatComponentTranslation("chat.colorpoints.setPoint", MCColors.getColor(stack.getItemDamage() - 1).getColorName(), pos.getX(), pos.getY(), pos.getZ()));
                        } else if (block == ModBlocks.resetBlock) {
                            if (stack.getItemDamage() == 0) {
                                for (int i = 0; i < 16; i++) {
                                    WayPointHelper.removeWaypoint(stack, i);
                                }
                                player.addChatComponentMessage(new ChatComponentTranslation("chat.colorpoints.clearAll"));
                            } else {
                                WayPointHelper.removeWaypoint(stack);
                                player.addChatComponentMessage(new ChatComponentTranslation("chat.colorpoints.clearPoint", MCColors.getColor(stack.getItemDamage() - 1).getColorName()));
                            }
                        }
                    }
                }
            } else if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_AIR) {
                int damage = stack.getItemDamage() + (player.isSneaking() ? -1 : 1);
                if (damage < 0)
                    damage = 16;
                if (damage > 16)
                    damage = 0;
                stack.setItemDamage(damage);
                WayPoint wayPoint = WayPointHelper.getWaypoint(stack);
                if (wayPoint != null)  {
                    if (wayPoint.getDimension() != world.provider.getDimensionId())
                        player.addChatComponentMessage(new ChatComponentTranslation("chat.colorpoints.wrongDim"));
                    else {
                        IBlockState state = world.getBlockState(wayPoint.getPos());
                        if (state == null || state.getBlock() != ModBlocks.waypointBlock)
                            WayPointHelper.removeWaypoint(stack);
                    }
                }

            }
        }
    }
}
