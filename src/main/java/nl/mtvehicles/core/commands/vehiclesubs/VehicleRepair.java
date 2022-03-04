package nl.mtvehicles.core.commands.vehiclesubs;

import de.tr7zw.changeme.nbtapi.NBTItem;
import nl.mtvehicles.core.infrastructure.helpers.TextUtils;
import nl.mtvehicles.core.infrastructure.models.MTVehicleSubCommand;
import nl.mtvehicles.core.infrastructure.models.Vehicle;
import nl.mtvehicles.core.infrastructure.modules.ConfigModule;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;

public class VehicleRepair extends MTVehicleSubCommand {
    public VehicleRepair() {
        this.setPlayerCommand(true);
    }

    @Override
    public boolean execute(CommandSender sender, Command cmd, String s, String[] args) {
        if (!checkPermission("mtvehicles.repair")) return true;

        final ItemStack item = player.getInventory().getItemInMainHand();

        if (!item.hasItemMeta() || !(new NBTItem(item)).hasKey("mtvehicles.kenteken")) {
            sendMessage(TextUtils.colorize(ConfigModule.messagesConfig.getMessage("noVehicleInHand")));
            return true;
        }

        final String license = Vehicle.getLicensePlate(item);
        final int damage = ConfigModule.vehicleDataConfig.getDamage(license);
        final double maxHealth = Vehicle.getMaxHealthByDamage(damage);

        ConfigModule.vehicleDataConfig.setHealth(license, maxHealth);
        sendMessage(ConfigModule.messagesConfig.getMessage("actionSuccessful"));
        return true;
    }
}