package org.echoJavaTelegramBot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        String botName = "***"; //Укажите имя созданного вами Бота в телеграм
        String botToken = "***"; //Укажите токен созданного вами Бота в телеграм
        TelegramBotsApi telegramBotsApi = null;
        try {
            telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new EchoJavaTelegramBot(botName, botToken));
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}