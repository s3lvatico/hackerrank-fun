package org.gmnz.sandbox;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * LoggerPlayground
 * <p>
 * Questa è una prova stupida ma serve per valutare le possibilità di
 * differenziare i file di configurazione del log4j nel caso di applicazione
 * usuale e nel caso dei test (pare sia possibile differenziare le due cose)
 * <p>
 * vedi https://logging.apache.org/log4j/2.x/manual/configuration.html
 */
public class LoggerPlayground {

   private static final Logger logger = LogManager.getLogger(LoggerPlayground.class);

   public static void main(String[] args) {
      logger.info("oh ciao eh");
      logger.debug("debuggamo?");
   }
}