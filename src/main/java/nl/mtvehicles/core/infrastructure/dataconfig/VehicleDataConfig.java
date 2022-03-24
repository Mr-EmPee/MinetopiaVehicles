package nl.mtvehicles.core.infrastructure.dataconfig;

import nl.mtvehicles.core.infrastructure.enums.ConfigType;
import nl.mtvehicles.core.infrastructure.models.Config;
import nl.mtvehicles.core.infrastructure.models.VehicleUtils;
import org.bukkit.entity.Player;

import java.util.Map;

public class VehicleDataConfig extends Config {
    public VehicleDataConfig() {
        super(ConfigType.VEHICLE_DATA);
    }

    public int getDamage(String license){
        return getConfig().getInt("vehicle." + license + ".skinDamage");
    }

    public boolean isHornEnabled(String license){
        final String path = "vehicle." + license + ".hornEnabled";
        if (!isHornSet(license)) setInitialHorn(license);
        return getConfig().getBoolean(path);
    }

    public boolean isHornSet(String license){
        final String path = "vehicle." + license + ".hornEnabled";
        return getConfig().isSet(path);
    }

    public void setInitialHorn(String license){
        final String path = "vehicle." + license + ".hornEnabled";
        boolean state = VehicleUtils.getHornByDamage(getDamage(license));
        getConfig().set(path, state);
        save();
    }


    public double getHealth(String license){
        final String path = "vehicle." + license + ".health";
        if (!isHealthSet(license)) setInitialHealth(license);
        return getConfig().getDouble(path);
    }

    public boolean isHealthSet(String license){
        final String path = "vehicle." + license + ".health";
        return getConfig().isSet(path);
    }

    public void setInitialHealth(String license){
        final String path = "vehicle." + license + ".health";
        final int damage = getConfig().getInt("vehicle." + license + ".skinDamage");
        double state = VehicleUtils.getMaxHealthByDamage(damage);
        getConfig().set(path, state);
        save();
    }

    public void damageVehicle(String license, double damage){
        final String path = "vehicle." + license + ".health";
        double h = getHealth(license) - damage;
        final double health = (h > 0) ? h : 0.0;
        getConfig().set(path, health);
        save();
    }

    public void setHealth(String license, double health){
        final String path = "vehicle." + license + ".health";
        getConfig().set(path, health);
        save();
    }

    public int getNumberOfOwnedVehicles(Player p){
        final String playerUUID = p.getUniqueId().toString();
        int owned;
        Map<String, Object> vehicleData = getConfig().getValues(true);
        owned = (int) vehicleData.keySet().stream().filter(key -> key.contains(".owner") && String.valueOf(vehicleData.get(key)).equals(playerUUID)).count();
        return owned;
    }
}
