package nl.mtvehicles.core.movement;

import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import nl.mtvehicles.core.Main;
import nl.mtvehicles.core.movement.versions.*;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.util.NoSuchElementException;

import static nl.mtvehicles.core.infrastructure.modules.VersionModule.getServerVersion;

public class PacketHandler {

    public static void movement_1_18(Player player) {
        ChannelDuplexHandler channelDuplexHandler = new ChannelDuplexHandler() {
            public void channelRead(ChannelHandlerContext channelHandlerContext, Object packet) throws Exception {
                super.channelRead(channelHandlerContext, packet);
                if (packet instanceof net.minecraft.network.protocol.game.PacketPlayInSteerVehicle) {
                    net.minecraft.network.protocol.game.PacketPlayInSteerVehicle ppisv = (net.minecraft.network.protocol.game.PacketPlayInSteerVehicle) packet;
                    VehicleMovement movement = new VehicleMovement();
                    movement.vehicleMovement(player, ppisv);
                }
            }
        };
        ChannelPipeline pipeline;
        try {
            Object networkManager = ((org.bukkit.craftbukkit.v1_18_R2.entity.CraftPlayer) player).getHandle().b.a;
            Field m = networkManager.getClass().getField("m");
            Channel channel = (Channel) m.get(networkManager);
            pipeline = channel.pipeline();
        } catch (Exception e){
            e.printStackTrace();
            Main.disablePlugin();
            return;
        }
        try {
            pipeline.remove(player.getName());
        } catch (NoSuchElementException e) {
        }
        try {
            pipeline.addBefore("packet_handler", player.getName(), channelDuplexHandler);
        } catch (NoSuchElementException e) {
        }
    }

    public static void movement_1_17(Player player) {
        ChannelDuplexHandler channelDuplexHandler = new ChannelDuplexHandler() {
            public void channelRead(ChannelHandlerContext channelHandlerContext, Object packet) throws Exception {
                super.channelRead(channelHandlerContext, packet);
                if (packet instanceof net.minecraft.network.protocol.game.PacketPlayInSteerVehicle) {
                    net.minecraft.network.protocol.game.PacketPlayInSteerVehicle ppisv = (net.minecraft.network.protocol.game.PacketPlayInSteerVehicle) packet;
                    VehicleMovement movement = new VehicleMovement();
                    movement.vehicleMovement(player, ppisv);
                }
            }
        };
        ChannelPipeline pipeline = ((org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer) player).getHandle().b.a.k.pipeline();
        try {
            pipeline.remove(player.getName());
        } catch (NoSuchElementException e) {
        }
        try {
            pipeline.addBefore("packet_handler", player.getName(), channelDuplexHandler);
        } catch (NoSuchElementException e) {
        }
    }

    public static void movement_1_16(Player player) {
        ChannelDuplexHandler channelDuplexHandler = new ChannelDuplexHandler() {
            @Override
            public void channelRead(ChannelHandlerContext channelHandlerContext, Object packet) throws Exception {
                super.channelRead(channelHandlerContext, packet);
                if (packet instanceof net.minecraft.server.v1_16_R3.PacketPlayInSteerVehicle) {
                    net.minecraft.server.v1_16_R3.PacketPlayInSteerVehicle ppisv = (net.minecraft.server.v1_16_R3.PacketPlayInSteerVehicle) packet;
                    VehicleMovement movement = new VehicleMovement();
                    movement.vehicleMovement(player, ppisv);
                }
            }
        };
        ChannelPipeline pipeline = ((org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer) player).getHandle().playerConnection.networkManager.channel.pipeline();
        try {
            pipeline.remove(player.getName());
        } catch (NoSuchElementException e) { //It isn't good practice to ignore exceptions, but I'll keep it like this for now :)
        }
        try {
            pipeline.addBefore("packet_handler", player.getName(), channelDuplexHandler);
        } catch (NoSuchElementException e) { //It isn't good practice to ignore exceptions, but I'll keep it like this for now :)
        }
    }

    public static void movement_1_15(Player player) {
        ChannelDuplexHandler channelDuplexHandler = new ChannelDuplexHandler() {
            @Override
            public void channelRead(ChannelHandlerContext channelHandlerContext, Object packet) throws Exception {
                super.channelRead(channelHandlerContext, packet);
                if (packet instanceof net.minecraft.server.v1_15_R1.PacketPlayInSteerVehicle) {
                    net.minecraft.server.v1_15_R1.PacketPlayInSteerVehicle ppisv = (net.minecraft.server.v1_15_R1.PacketPlayInSteerVehicle) packet;
                    VehicleMovement movement = new VehicleMovement();
                    movement.vehicleMovement(player, ppisv);
                }
            }
        };
        ChannelPipeline pipeline = ((org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer) player).getHandle().playerConnection.networkManager.channel.pipeline();
        try {
            pipeline.remove(player.getName());
        } catch (NoSuchElementException e) { //It isn't good practice to ignore exceptions, but I'll keep it like this for now :)
        }
        try {
            pipeline.addBefore("packet_handler", player.getName(), channelDuplexHandler);
        } catch (NoSuchElementException e) { //It isn't good practice to ignore exceptions, but I'll keep it like this for now :)
        }
    }

    public static void movement_1_13(Player player) {
        ChannelDuplexHandler channelDuplexHandler = new ChannelDuplexHandler() {
            @Override
            public void channelRead(ChannelHandlerContext channelHandlerContext, Object packet) throws Exception {
                super.channelRead(channelHandlerContext, packet);
                if (packet instanceof net.minecraft.server.v1_13_R2.PacketPlayInSteerVehicle) {
                    net.minecraft.server.v1_13_R2.PacketPlayInSteerVehicle ppisv = (net.minecraft.server.v1_13_R2.PacketPlayInSteerVehicle) packet;
                    VehicleMovement movement = new VehicleMovement();
                    movement.vehicleMovement(player, ppisv);
                }
            }
        };
        ChannelPipeline pipeline = ((org.bukkit.craftbukkit.v1_13_R2.entity.CraftPlayer) player).getHandle().playerConnection.networkManager.channel.pipeline();
        try {
            pipeline.remove(player.getName());
        } catch (NoSuchElementException e) { //It isn't good practice to ignore exceptions, but I'll keep it like this for now :)
        }
        try {
            pipeline.addBefore("packet_handler", player.getName(), channelDuplexHandler);
        } catch (NoSuchElementException e) { //It isn't good practice to ignore exceptions, but I'll keep it like this for now :)
        }
    }

    public static void movement_1_12(Player player) {
        ChannelDuplexHandler channelDuplexHandler = new ChannelDuplexHandler() {
            @Override
            public void channelRead(ChannelHandlerContext channelHandlerContext, Object packet) throws Exception {
                super.channelRead(channelHandlerContext, packet);
                if (packet instanceof net.minecraft.server.v1_12_R1.PacketPlayInSteerVehicle) {
                    net.minecraft.server.v1_12_R1.PacketPlayInSteerVehicle ppisv = (net.minecraft.server.v1_12_R1.PacketPlayInSteerVehicle) packet;
                    VehicleMovement1_12 movement = new VehicleMovement1_12();
                    movement.vehicleMovement(player, ppisv);
                }
            }
        };
        ChannelPipeline pipeline = ((org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer) player).getHandle().playerConnection.networkManager.channel.pipeline();
        try {
            pipeline.remove(player.getName());
        } catch (NoSuchElementException e) { //It isn't good practice to ignore exceptions, but I'll keep it like this for now :)
        }
        try {
            pipeline.addBefore("packet_handler", player.getName(), channelDuplexHandler);
        } catch (NoSuchElementException e) { //It isn't good practice to ignore exceptions, but I'll keep it like this for now :)
        }
    }

    public static boolean isObjectPacket(Object object) {
        final String errorMessage = "An unexpected error occurred. Try reinstalling the plugin or contact the developer: https://discord.gg/vehicle";

        if (getServerVersion().is1_12()) {
            if (!(object instanceof net.minecraft.server.v1_12_R1.PacketPlayInSteerVehicle)) {
                Main.logSevere(errorMessage);
                return false;
            }
        } else if (getServerVersion().is1_13()) {
            if (!(object instanceof net.minecraft.server.v1_13_R2.PacketPlayInSteerVehicle)){
                Main.logSevere(errorMessage);
                return false;
            }
        } else if (getServerVersion().is1_15()) {
            if (!(object instanceof net.minecraft.server.v1_15_R1.PacketPlayInSteerVehicle)){
                Main.logSevere(errorMessage);
                return false;
            }
        } else if (getServerVersion().is1_16()) {
            if (!(object instanceof net.minecraft.server.v1_16_R3.PacketPlayInSteerVehicle)){
                Main.logSevere(errorMessage);
                return false;
            }
        } else if (getServerVersion().is1_17() || getServerVersion().is1_18()) {
            if (!(object instanceof net.minecraft.network.protocol.game.PacketPlayInSteerVehicle)){
                Main.logSevere(errorMessage);
                return false;
            }
        }
        return true;
    }

}
