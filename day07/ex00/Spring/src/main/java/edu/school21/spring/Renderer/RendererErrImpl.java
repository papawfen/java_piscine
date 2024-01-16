package edu.school21.spring.Renderer;

import edu.school21.spring.PreProcessor.PreProcessor;

public class RendererErrImpl implements Renderer {
    PreProcessor preProcessor;

    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void print(String input) {
        input = preProcessor.changeCase(input);
        System.err.println(input);
    }
}
