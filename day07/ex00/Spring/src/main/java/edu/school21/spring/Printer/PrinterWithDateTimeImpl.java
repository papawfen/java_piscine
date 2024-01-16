package edu.school21.spring.Printer;

import edu.school21.spring.Renderer.Renderer;

import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer {
    Renderer renderer;
    public PrinterWithDateTimeImpl(Renderer renderer) { this.renderer = renderer; }

    public void print(String time) { renderer.print(time); }

}
