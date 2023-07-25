package hubs.hub.hubs;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Position;
import cn.nukkit.utils.Config;
public class main extends cn.nukkit.plugin.PluginBase implements cn.nukkit.event.Listener {
    public main() {  }

    public void onLoad() {
        this.getLogger().info("正在加载插件！");
        this.getLogger().info("作者：ALIFE");
    }

    public void onEnable() {
        this.getLogger().info("hubs 插件启动成功. by ALIFE");
        this.getLogger().info("hubs plugin. by ALIFE");
        this.getDataFolder().mkdirs();
        this.saveDefaultConfig();
    }
    public void onDisable(){
        this.getLogger().info("感谢使用！");
        this.getLogger().info("如果有问题请到Minebbs反馈Bug！！！");
    }
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 0) {
            return false;
        } else {
            if (sender.isPlayer()) {
                Player pl = (Player) sender;
                Config config = this.getConfig();
                Integer x = Integer.parseInt(config.getString("x"));
                Integer y = Integer.parseInt(config.getString("y"));
                Integer z = Integer.parseInt(config.getString("z"));
                String msg = config.getString("msg");
                String level = config.getString("level");
                pl.teleport(new Position((double) x, (double) y, (double) z, Server.getInstance().getLevelByName(level)));
                pl.sendMessage(msg);

            } else {
                System.out.println("This cmd should be used as player.");
            }

            return true;
        }
    }
    @cn.nukkit.event.EventHandler
    public void hubC(cn.nukkit.event.player.PlayerCommandPreprocessEvent event) { /* compiled code */ }

    @cn.nukkit.event.EventHandler
    public void hubS(cn.nukkit.event.player.PlayerChatEvent event) { /* compiled code */ }
}