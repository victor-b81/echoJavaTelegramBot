package org.echoJavaTelegramBot;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class EchoJavaTelegramBot extends TelegramLongPollingBot {
    final String botName;
    final String botToken;

    public EchoJavaTelegramBot(String botName, String botToken) {
        this.botName = botName;
        this.botToken = botToken;
    }

    @Override
    public String getBotUsername() {
        // ������ ����� ����, ������� ��� ��� �������
        return this.botName;
    }

    @Override
    public String getBotToken() {
        // ������ ������ ����, ������� ��� ��� �������
        return this.botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        // ��������� ��������� ������ ��������� � ����, � ���� ��� �����
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();            // ������� ���������� ������ ������ ����������� ���������
            String chat_id = update.getMessage().getChatId().toString();    // ������� ���������� ������ �� ���� ����������� ���������

            SendMessage message = new SendMessage(); // ������� �����-���������
            message.setChatId(chat_id);              // �������� ��� ��
            message.setText(message_text);           // �������� ��� ���������

            try {
                execute(message);                   // ���������� �����-��������� ������������
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
