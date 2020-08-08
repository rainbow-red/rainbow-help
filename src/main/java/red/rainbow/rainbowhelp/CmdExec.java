package red.rainbow.rainbowhelp;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.command.CommandExecuteEvent;
import com.velocitypowered.api.proxy.Player;
import net.kyori.adventure.text.TextComponent;

import java.util.Arrays;

import static red.rainbow.rainbowhelp.StringProvider.*;

public class CmdExec {

    CommandExecuteEvent.CommandResult result;

    @Subscribe
    public void onCommandExecution(CommandExecuteEvent event) {

        CommandSource source = event.getCommandSource();
        if (!(source instanceof Player)) {
            return;
        }

        String[] args = event.getCommand().split(" ");
        String label = args[0];
        if (!label.equalsIgnoreCase("help")) {
            return;
        }

        if (args.length == 2) {

            String category = args[1];

            if (Arrays.stream(getAllCategories()).anyMatch(cat -> cat.equalsIgnoreCase(category))) {

                if (getScreenForCategory(category) == null) {
                    String replacementCommand = getReplacementCommand(category);
                    event.setResult(result.command(replacementCommand));

                } else {
                    source.sendMessage(TextComponent.of(getScreenForCategory(category)));
                    event.setResult(result.denied());

                }
            } else {
                source.sendMessage(TextComponent.of(getMainscreen()));
                event.setResult(result.denied());
            }

        } else {
            source.sendMessage(TextComponent.of(getMainscreen()));

        }
    }
}