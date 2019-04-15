package sk96.dev.kik.bot.command;

import sk96.dev.kik.bot.message.MultiTextMessage;
import sk96.dev.kik.bot.message.TextMessage;

public class HelpCommand extends Command<MultiTextMessage, TextMessage> {
    private static final String[] HELP = {
            "Here are the commands that are available:\\n" +
                    "- lookup <username>\\n" +
                    "- compare <username>, <username>\\n" +
                    "- information\\n" +
                    "- help",
            "Any issues? Join #FortniteAce or #fnstats"
    };

    @Override
    public MultiTextMessage run(TextMessage message) {
        return new MultiTextMessage(message.chatId, message.to, HELP);
    }
}