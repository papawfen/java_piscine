package edu.school21.spring;

import edu.school21.spring.PreProcessor.*;
import edu.school21.spring.Printer.*;
import edu.school21.spring.Renderer.*;

public class Program {
    PreProcessor preProcessor = new PreProcessorToUpperImpl();
    Renderer renderer = new RendererErrImpl(preProcessor);
    PrinterWithPrefixImpl printer = new PrinterWithPrefixImpl(renderer);

}
