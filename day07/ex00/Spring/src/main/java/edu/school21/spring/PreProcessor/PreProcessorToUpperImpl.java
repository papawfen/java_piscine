package edu.school21.spring.PreProcessor;

public class PreProcessorToUpperImpl implements PreProcessor {
    @Override
    public String changeCase(String input) {
        return input.toUpperCase();
    }
}
