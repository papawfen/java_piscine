package edu.school21.spring.PreProcessor;

public class PreProcessorToLowerImpl implements PreProcessor {

    @Override
    public String changeCase(String input) {
        return input.toLowerCase();
    }
}
