package io.github.eylexlive.discord2fa.hook.hookevent;

import fr.xephi.authme.events.LoginEvent;
import io.github.eylexlive.discord2fa.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

/*
 *	Created by EylexLive on Feb 23, 2020.
 *	Currently version: 2.5
 */

@Deprecated
public class AuthmeEvent implements Listener {
    private Main plugin;
    public AuthmeEvent() {
        this.plugin = Main.getInstance();
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void handleAuthMeLogin(LoginEvent event) {
        Player player = event.getPlayer();
        if (this.plugin.isAuthmeSupport())  {
            this.plugin.getDiscord2FAManager().checkPlayer(player);
        }
    }
}