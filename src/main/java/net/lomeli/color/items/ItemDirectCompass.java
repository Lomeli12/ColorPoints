package net.lomeli.color.items;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import net.lomeli.color.ColorPoints;
import net.lomeli.color.blocks.ModBlocks;
import net.lomeli.color.core.ModTab;
import net.lomeli.color.core.helper.WayPointHelper;
import net.lomeli.color.lib.MCColors;
import net.lomeli.color.lib.WayPoint;

public class ItemDirectCompass extends Item {

    public ItemDirectCompass() {
        super();
        this.setMaxStackSize(1);
        this.setCreativeTab(ModTab.modTab);
        this.setUnlocalizedName(ColorPoints.MOD_ID + ".triCompass");
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player) {
        return true;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        return true;
    }

    @Override
    public boolean canItemEditBlocks() {
        return false;
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
        if (!world.isRemote && world.getTotalWorldTime() % 200L == 0) {
            for (int i = 0; i < 16; i++) {
                WayPoint wayPoint = WayPointHelper.getWaypoint(stack, i);
                if (wayPoint != null && world.provider.getDimensionId() == wayPoint.getDimension()) {
                    IBlockState state = world.getBlockState(wayPoint.getPos());
                    if (state == null || state.getBlock() != ModBlocks.waypointBlock) {
                        WayPointHelper.removeWaypoint(stack, i);
                    }
                }
            }
        }
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        if (stack.getItemDamage() > 0)
            return String.format(super.getItemStackDisplayName(stack) + " - " + MCColors.getColor(stack.getItemDamage() - 1).getColorName());
        return super.getItemStackDisplayName(stack);
    }
}
