package net.lomeli.color.core.helper;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import net.lomeli.color.lib.WayPoint;

public class WayPointHelper {
    public static final String WAYPOINT_TAG = "colored_waypoints";

    public static void setWaypoint(ItemStack stack, WayPoint point) {
        if (stack != null && point != null) {
            NBTTagCompound tag = stack.hasTagCompound() ? stack.getTagCompound() : new NBTTagCompound();
            NBTTagList waypointList = new NBTTagList();
            if (tag.hasKey(WAYPOINT_TAG, 9))
                waypointList = tag.getTagList(WAYPOINT_TAG, 10);
            else {
                for (int i = 0; i < 16; i++)
                    waypointList.appendTag(new NBTTagCompound());
            }
            int index = stack.getItemDamage() - 1;
            if (index < 0 || index > 15)
                index = 0;

            NBTTagCompound waypointTag = new NBTTagCompound();
            point.writeToNBT(waypointTag);

            waypointList.set(index, waypointTag);
            tag.setTag(WAYPOINT_TAG, waypointList);
            stack.setTagCompound(tag);
        }
    }

    public static void removeWaypoint(ItemStack stack, int index) {
        if (stack != null && stack.hasTagCompound()) {
            NBTTagCompound tag = stack.getTagCompound();
            if (tag.hasKey(WAYPOINT_TAG, 9)) {
                NBTTagList waypointList = tag.getTagList(WAYPOINT_TAG, 10);
                if (index < 0 || index > 15)
                    index = 0;
                waypointList.set(index, new NBTTagCompound());
                tag.setTag(WAYPOINT_TAG, waypointList);
                stack.setTagCompound(tag);
            }
        }
    }

    public static void removeWaypoint(ItemStack stack) {
        removeWaypoint(stack, stack.getItemDamage() - 1);
    }

    public static WayPoint getWaypoint(ItemStack stack, int index) {
        if (stack != null && stack.hasTagCompound()) {
            NBTTagCompound tag = stack.getTagCompound();
            if (tag.hasKey(WAYPOINT_TAG, 9)) {
                NBTTagList waypointList = tag.getTagList(WAYPOINT_TAG, 10);
                if (index < 0 || index > 15)
                    index = 0;
                NBTTagCompound waypointTag = waypointList.getCompoundTagAt(index);
                WayPoint wayPoint = WayPoint.readFromNBT(waypointTag);
                return wayPoint;
            }
        }
        return null;
    }

    public static WayPoint getWaypoint(ItemStack stack) {
        return getWaypoint(stack, stack.getItemDamage() - 1);
    }
}
