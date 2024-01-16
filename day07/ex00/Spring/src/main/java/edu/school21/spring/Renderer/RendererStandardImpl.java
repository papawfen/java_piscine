package edu.school21.spring.Renderer;

import edu.school21.spring.PreProcessor.PreProcessor;

public class RendererStandardImpl implements Renderer {
    PreProcessor preProcessor;

    public RendererStandardImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void print(String input) {
        input = preProcessor.changeCase(input);
        System.out.println(input);
    }
}
