package ru.job4j.task1;

/**
 * DummyBot.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class DummyBot {

    /**
     * Answer the question.
     * @param question from client.
     * @return answer.
     */
    public String answer(String question) {
        String result = "This confuses me. Ask another question.";
        if ("Hello, Bot.".equals(question)) {
            result = "Hi, wise guy.";
        } else if ("Bye.".equals(question)) {
            result = "See you soon.";
        }
        return result;
    }
}
