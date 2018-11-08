package me.ckhks.Particlaric;

import com.comphenix.protocol.ProtocolLib;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Particlaric extends JavaPlugin implements Listener {

    @Override
    public void onEnable(){
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable(){

    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        final Player player = event.getPlayer();
        if(event.getAction() == Action.LEFT_CLICK_AIR){
            new BukkitRunnable(){
                Location loc = player.getLocation();

                double t1 = 0;
                double t2 = (2 * Math.PI)/3;
                double t3 = (4 * Math.PI)/3;
                double r = 2;
                public void run(){
                    {
                        t1 = t1 + Math.PI/64;
                        double x = r * Math.cos(4*t1)*Math.cos(t1);
                        double y = 1.5;
                        double z = r * Math.cos(4*t1)*Math.sin(t1);
                        loc.add(x, y, z);
                        player.getWorld().spawnParticle(Particle.DRIP_WATER, loc, 1, 0, 0,0);
                        //ParticleEffect.DRIP_WATER.display(loc, 0, 0, 0, 0, 1);
                        loc.subtract(x, y, z);
                        if (t1 > Math.PI*2){
                            this.cancel();
                        }
                    }
                    {
                        t2 = t2 + Math.PI/64;
                        double x = r * Math.cos(4*t2)*Math.cos(t2);
                        double y = 1.5;
                        double z = r * Math.cos(4*t2)*Math.sin(t2);
                        loc.add(x, y, z);
                        player.getWorld().spawnParticle(Particle.DRIP_WATER, loc, 1, 0, 0,0);
                        //ParticleEffect.DRIP_WATER.display(loc, 0, 0, 0, 0, 1);
                        loc.subtract(x, y, z);
                    }
                    {
                        t3 = t3 + Math.PI/64;
                        double x = r * Math.cos(4*t3)*Math.cos(t3);
                        double y = 1.5;
                        double z = r * Math.cos(4*t3)*Math.sin(t3);
                        loc.add(x, y, z);
                        player.getWorld().spawnParticle(Particle.DRIP_WATER, loc, 1, 0, 0,0);
                        //ParticleEffect.DRIP_WATER.display(loc, 0, 0, 0, 0, 1);
                        loc.subtract(x, y, z);
                    }
                }

            }.runTaskTimer(this, 0, 1);
        } else if(event.getAction() == Action.RIGHT_CLICK_AIR){
            new BukkitRunnable(){
                Location loc = player.getLocation();
                double side = 2;
                double t = 2.5;
                double theta = 0;
                public void run(){
                    t = t - .1;
                    for(double i = 0; i < 1; i = i + .1){
                        double xt = (side * i) - 1;
                        double y = t;
                        double zt = side/2;

                        double x = xt*Math.cos(theta) - zt*Math.sin(theta);
                        double z = xt*Math.sin(theta) + zt*Math.cos(theta);
                        loc.add(x, y, z);
                        player.getWorld().spawnParticle(Particle.FLAME, loc, 1, 0, 0, 0, 0);
                        loc.subtract(x, y, z);
                    }
                    for(double i = 0; i < 1; i = i + .1){
                        double xt = (side * i) - 1;
                        double y = t;
                        double zt = -side/2;
                        double x = xt*Math.cos(theta) - zt*Math.sin(theta);
                        double z = xt*Math.sin(theta) + zt*Math.cos(theta);
                        loc.add(x, y, z);
                        player.getWorld().spawnParticle(Particle.FLAME, loc, 1, 0, 0, 0, 0);
                        loc.subtract(x, y, z);
                    }
                    for(double i = 0; i < 1; i = i + .1){
                        double xt = side/2;
                        double y = t;
                        double zt = (side * i) - 1;
                        double x = xt*Math.cos(theta) - zt*Math.sin(theta);
                        double z = xt*Math.sin(theta) + zt*Math.cos(theta);
                        loc.add(x, y, z);
                        player.getWorld().spawnParticle(Particle.FLAME, loc, 1, 0, 0, 0, 0);
                        loc.subtract(x, y, z);
                    }
                    for(double i = 0; i < 1; i = i + .1){
                        double xt = -side/2;
                        double y = t;
                        double zt = (side * i) - 1;
                        double x = xt*Math.cos(theta) - zt*Math.sin(theta);
                        double z = xt*Math.sin(theta) + zt*Math.cos(theta);
                        loc.add(x, y, z);
                        player.getWorld().spawnParticle(Particle.FLAME, loc, 1, 0, 0, 0, 0);
                        loc.subtract(x, y, z);
                    }
                    /*

                    Just makes a square
                    for(double i = 0; i < 1; i = i + .1){
                        double x = (side * i) - 1;
                        double y = t;
                        double z = side/2;
                        loc.add(x, y, z);
                        player.getWorld().spawnParticle(Particle.FLAME, loc, 1, 0, 0, 0, 0);
                        loc.subtract(x, y, z);
                    }
                    for(double i = 0; i < 1; i = i + .1){
                        double x = (side * i) - 1;
                        double y = t;
                        double z = -side/2;
                        loc.add(x, y, z);
                        player.getWorld().spawnParticle(Particle.FLAME, loc, 1, 0, 0, 0, 0);
                        loc.subtract(x, y, z);
                    }
                    for(double i = 0; i < 1; i = i + .1){
                        double x = side/2;
                        double y = t;
                        double z = (side * i) - 1;
                        loc.add(x, y, z);
                        player.getWorld().spawnParticle(Particle.FLAME, loc, 1, 0, 0, 0, 0);
                        loc.subtract(x, y, z);
                    }
                    for(double i = 0; i < 1; i = i + .1){
                        double x = -side/2;
                        double y = t;
                        double z = (side * i) - 1;
                        loc.add(x, y, z);
                        player.getWorld().spawnParticle(Particle.FLAME, loc, 1, 0, 0, 0, 0);
                        loc.subtract(x, y, z);
                    }*/
                    if(t < 0){
                        this.cancel();
                    }
                    theta = theta + ((double) (Math.PI/2)/25);
                }

            }.runTaskTimer(this, 0, 1);
        }
    }
}
