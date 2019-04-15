package sk96.dev.kik.bot.message;

public class TextMessage extends Message {
    public final String to;
    public final String body;

    public TextMessage(String chatId, String to, String body, MessageChatType type) {
        super(MessageType.TEXT, chatId, to, type);
        this.to = to;
        this.body = body;
    }

    public TextMessage(String chatId, String to, String body) {
        super(MessageType.TEXT, chatId, to, MessageChatType.DIRECT);
        this.to = to;
        this.body = body;
    }
}