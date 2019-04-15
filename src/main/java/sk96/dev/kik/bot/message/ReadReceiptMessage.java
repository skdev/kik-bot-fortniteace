package sk96.dev.kik.bot.message;

public class ReadReceiptMessage extends Message {
    public final int[] messageIds;

    public ReadReceiptMessage(String chatId, String to, int[] messageIds) {
        super(MessageType.READ_RECEIPT, chatId, to, MessageChatType.DIRECT);
        this.messageIds = messageIds;
    }
}