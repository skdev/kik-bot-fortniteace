package sk96.dev.kik.bot.command;

import sk96.dev.kik.bot.message.MultiTextMessage;
import sk96.dev.kik.bot.message.TextMessage;

public class InformationCommand extends Command<MultiTextMessage, TextMessage> {
    private static final String[] INFORMATION = {
            "This bot was created by Suraj and stolen by Ashi ; for more, join #FortniteAce or (if full) join #fnstats",
            "A bit of history:\\n"
                    + "FortniteAce was originally created on the 29th June 2018 and maintained by Suraj. On the 2nd January 2019 was when the bot 'officially' went offline. "
                    + "\\n\\nAshi acquired the sourcecode, developed with a team of programmers and re-launched FortniteAce on the 10th April 2019. "
                    + "The bot went offline due to personal issues with the previous owner including maintenance costs. This bot isn't free and costs us money to keep online. "
                    + "\\n\\nIf you want to sponsor us, speak to Ashi who can be found in either #FortniteAce or #fnstats",
            "Hope you're enjoying the bot ♥"
    };

    @Override
    public MultiTextMessage run(TextMessage message) {
        return new MultiTextMessage(message.chatId, message.to, INFORMATION);
    }
}