package put.iosort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IoSortApplication {

    private static final Logger logger = LoggerFactory.getLogger(IoSortApplication.class);

    public static void main(String[] args) {
        logger.info("Rozpoczynanie uruchamiania aplikacji IoSort...");

        SpringApplication.run(IoSortApplication.class, args);

        logger.info("Aplikacja IoSort została uruchomiona.");
        if (logger.isDebugEnabled()) {
            logger.debug("Tryb DEBUG jest włączony. Szczegółowe logi zostaną wyświetlone.");
        }
    }
}
