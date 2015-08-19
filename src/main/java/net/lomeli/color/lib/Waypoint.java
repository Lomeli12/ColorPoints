package net.lomeli.color.lib;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;

public class WayPoint {
    private int dimension;
    private BlockPos pos;

    public WayPoint(BlockPos pos, int dim) {
        this.pos = pos;
        this.dimension = dim;
    }

    public WayPoint(int x, int y, int z, int dim) {
        this(new BlockPos(x, y, z), dim);
    }

    public WayPoint(WayPoint wayPoint) {
        this(wayPoint.getPos(), wayPoint.getDimension());
    }

    public BlockPos getPos() {
        return pos;
    }

    public int getDimension() {
        return dimension;
    }

    public void writeToNBT(NBTTagCompound tag) {
        if (tag != null) {
            tag.setInteger("x", pos.getX());
            tag.setInteger("y", pos.getY());
            tag.setInteger("z", pos.getZ());
            tag.setInteger("dim", dimension);
        }
    }

    public static WayPoint readFromNBT(NBTTagCompound tag) {
        WayPoint point = null;
        if (tag != null) {
            int x = tag.getInteger("x");
            int y = tag.getInteger("y");
            int z = tag.getInteger("z");
            int dim = tag.getInteger("dim");
            point = new WayPoint(x, y, z, dim);
        }
        return point;
    }

    public WayPoint clone() {
        return new WayPoint(this);
    }
}
