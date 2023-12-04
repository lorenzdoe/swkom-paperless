package at.fhtw.services.ocr;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface OCRInputChannel {
    @Input
    SubscribableChannel input();
}
