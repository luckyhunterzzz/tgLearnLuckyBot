package Main;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import Dictionary.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MyTelegramBot extends TelegramLongPollingBot {
    private PartOfWord partOfWord;
    private int correctAnswers;
    private Long chatId;
    private int wordsToRepeat;
    private int quantityUserToRepeat;
    private String correctWord;
    private boolean isWork = false;
    private int userRightAnswersStats;
    private int userAllQuantityQuestionsStats;
    private final ProblemWords problemWords = new ProblemWords();
    private Map<String, String> dictionaryForMethod = new HashMap<>();

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            chatId = update.getMessage().getChatId();

            if ("/start".equals(messageText)) {
                sendTextMessage(chatId, """
                        Привет! Давай проверим твои знания итальянского языка.
                        Тебе нужно будет переводить слова на английский язык!
                        Если хочешь выйти, введи /exit
                        Если хочешь посмотреть список команд, введи /help""");
                askForCategory();
            } else if ("/exit".equalsIgnoreCase(messageText)) {
                sendTextMessage(chatId, "До свидания! \nЧтобы начать работу, напиши /start");
                wordsToRepeat = 0;
                correctAnswers = 0;
                quantityUserToRepeat = 0;
                isWork = false;
            } else if ("/stats".equalsIgnoreCase(messageText)) {
                sendTextMessage(chatId, "На данный момент ты дал " +
                        userRightAnswersStats +
                        " правильных ответов из " +
                        userAllQuantityQuestionsStats);
            } else if ("/wordsleft".equalsIgnoreCase(messageText)) {
                sendTextMessage(chatId, "На данный момент осталось слов для повторения " +
                        wordsToRepeat);
            } else if ("/help".equalsIgnoreCase(messageText)) {
                sendTextMessage(chatId, """
                        /start - Начало работы
                        /exit - Выход
                        /stats - Статистика
                        /wordsleft - Осталось слов
                        /help - Помощь
                        /clean - Очистить список слов, требующих повторения""");
            } else if ("/clean".equalsIgnoreCase(messageText)) {
                sendTextMessage(chatId, "Список слов, требующих повторения, очищен!" +
                        "\nЧтобы начать работу, напиши /start");
                problemWords.cleanDictionary();
            } else if (isWork) {
                if (partOfWord.getDictionary().get(correctWord).equalsIgnoreCase(messageText)) {
                    sendTextMessage(chatId, "Верно!");
                    correctAnswers++;
                    userRightAnswersStats++;
                    askNextWord();
                } else {
                    sendTextMessage(chatId, "Неверно! \nПравильный ответ: \"*" +
                            partOfWord.getDictionary().get(correctWord).toLowerCase() + "*\"!");
                    if (!problemWords.getDictionary().containsKey(correctWord)) {
                        problemWords.setDictionary(correctWord, partOfWord.getDictionary().get(correctWord));
                        askNextWord();
                    } else {
                        askNextWord();
                    }
                }
            }
        }  else if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();
            if (data.matches("\\d+")) {
                handlerUserChoiceOfQuantityOfQuestions(data);
                isWork = true;
            } else {
                handlerUserChoiceOfCategory(data);
            }
        }
    }

    private void handlerUserChoiceOfCategory(String data) {
        switch (data) {
            case "verbs" -> {
                sendTextMessage(chatId, "Ты выбрал глаголы!");
                partOfWord = new Verbs();
            }
            case "nouns" -> {
                sendTextMessage(chatId, "Ты выбрал существительные!");
                partOfWord = new Nouns();
            }
            case "adjectives" -> {
                sendTextMessage(chatId, "Ты выбрал прилагательные и наречия!");
                partOfWord = new Adjectives();
            }
            case "pronouns" -> {
                sendTextMessage(chatId, "Ты выбрал местоимения!");
                partOfWord = new Pronouns();
            }
            case "phrases" -> {
                sendTextMessage(chatId, "Ты выбрал фразы!");
                partOfWord = new Phrases();
            }
            case "allWords" -> {
                sendTextMessage(chatId, "Ты выбрал все слова!");
                partOfWord = new AllWords();
            }
            case "problemWords" -> {
                sendTextMessage(chatId, "Ты выбрал слова, требующие повторения!");
                partOfWord = problemWords;
            }
            default -> {
            }
        }
        dictionaryForMethod.putAll(partOfWord.getDictionary());
        askForQuantityOfQuestions();
    }
    private void handlerUserChoiceOfQuantityOfQuestions(String data) {
        sendTextMessage(chatId, "Отлично! приступим!");
        correctAnswers = 0;
        wordsToRepeat = Integer.parseInt(data);
        quantityUserToRepeat = Integer.parseInt(data);
        askNextWord();
    }
    private void askNextWord() {
        if (wordsToRepeat == 0) {
            showQuizResult();
            isWork = false;
            return;
        }

        String word = getRandomWordWithoutRepeat();
        if (!word.isEmpty()) {
            sendTextMessage(chatId, "Как переводится слово \"*" + word.toLowerCase() + "*\"?");
            correctWord = word;
            wordsToRepeat--;
            userAllQuantityQuestionsStats++;
        } else {
            sendTextMessage(chatId, "Произошла ошибка при выборе слова. Пожалуйста, попробуй еще раз.");
        }
    }

    private String getRandomWordWithoutRepeat() {
        String[] keys = dictionaryForMethod.keySet().toArray(new String[0]);
        String randomWord = keys[new Random().nextInt(keys.length)];
        dictionaryForMethod.remove(randomWord);
        return randomWord;
    }

    private void showQuizResult() {
        sendTextMessage(chatId, "Тест завершен. Правильных ответов: " +
                correctAnswers +
                " из " +
                quantityUserToRepeat +
                "\nЧтобы начать работу, напиши /start");
        dictionaryForMethod = new HashMap<>();
    }

    private void askForCategory() {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Выбери категорию слов:");

        List<String[]> buttonData = List.of(
                new String[]{"Глаголы", "verbs"},
                new String[]{"Существительные", "nouns"},
                new String[]{"Прилагательные и наречия", "adjectives"},
                new String[]{"Местоимения", "pronouns"},
                new String[]{"Фразы", "phrases"},
                new String[]{"Все слова", "allWords"},
                new String[]{"Слова, требующие повторения", "problemWords"}
        );

        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        List<InlineKeyboardButton> currentRow = new ArrayList<>();

        for (int i = 0; i < buttonData.size(); i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(buttonData.get(i)[0]);
            button.setCallbackData(buttonData.get(i)[1]);
            currentRow.add(button);
            if (currentRow.size() == 2) {
                rows.add(currentRow);
                currentRow = new ArrayList<>();
            }
        }

        if (!currentRow.isEmpty() && !problemWords.getDictionary().isEmpty()) {
            rows.add(currentRow);
        }

        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        keyboardMarkup.setKeyboard(rows);
        message.setReplyMarkup(keyboardMarkup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    private void askForQuantityOfQuestions() {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Выбери количество слов для повторения:");

        String randomNumber = String.valueOf(new Random().nextInt(partOfWord.getDictionary().size()) + 1);
        String maxDictionaryNumber = String.valueOf(partOfWord.getDictionary().size());

        List<String[]> buttonData = List.of(
                new String[]{"5", "5"},
                new String[]{"20", "20"},
                new String[]{"Случайное число", randomNumber},
                new String[]{"Все слова словаря", maxDictionaryNumber}
                );

        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        List<InlineKeyboardButton> currentRow = new ArrayList<>();

        if (partOfWord instanceof ProblemWords) {
            for (int i = 2; i < buttonData.size(); i++) {
                InlineKeyboardButton button = new InlineKeyboardButton();
                button.setText(buttonData.get(i)[0]);
                button.setCallbackData(buttonData.get(i)[1]);
                currentRow.add(button);
            }
            rows.add(currentRow);
        } else {
            for (int i = 0; i < buttonData.size(); i++) {
                InlineKeyboardButton button = new InlineKeyboardButton();
                button.setText(buttonData.get(i)[0]);
                button.setCallbackData(buttonData.get(i)[1]);
                currentRow.add(button);

                if (currentRow.size() == 2) {
                    rows.add(currentRow);
                    currentRow = new ArrayList<>();
                }
            }
        }
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        keyboardMarkup.setKeyboard(rows);
        message.setReplyMarkup(keyboardMarkup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendTextMessage(Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);
        message.setParseMode("Markdown");
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users" +
                "\\User" +
                "\\IdeaProjects" +
                "\\tglearnluckybot" +
                "\\src" +
                "\\main" +
                "\\resources" +
                "\\tgBotInfo" +
                "\\tgBotName.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            sendTextMessage(chatId, "Файл не найден");
        }
        String botUsername = content.toString();
        return botUsername;
    }

    @Override
    public String getBotToken() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users" +
                "\\User" +
                "\\IdeaProjects" +
                "\\tglearnluckybot" +
                "\\src" +
                "\\main" +
                "\\resources" +
                "\\tgBotInfo" +
                "\\tgBotToken.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            sendTextMessage(chatId, "Файл не найден");
        }
        String botToken = content.toString();
        return botToken;
    }
}
