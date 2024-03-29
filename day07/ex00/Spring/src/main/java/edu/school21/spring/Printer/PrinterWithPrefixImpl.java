package edu.school21.spring.Printer;

import edu.school21.spring.Renderer.Renderer;

public class PrinterWithPrefixImpl implements Printer {
    private String prefix;
    Renderer renderer;

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
        prefix = "";
    }

    public void setPrefix(String prefix) { this.prefix = prefix; }

    public void print(String input) { renderer.print(this.prefix + " " + input); }
}
