package task;
import java.util.UUID;

public class UserIdsGenerator {
    public static UserIdsGenerator getInstance() {
        if (instance == null) instance = new UserIdsGenerator();
        return instance;
    }

    protected UUID generateUUID() {
        if (lastUUID == null) {
            lastUUID = new UUID(0, 0);
            return lastUUID;
        }
        long lsb = lastUUID.getLeastSignificantBits() + 1;
        lastUUID = new UUID(lastUUID.getLeastSignificantBits(), lsb);
        return lastUUID;
    }
    protected UUID generateTranscationUUID() {
        if (lastTransactionUUID == null) {
            lastTransactionUUID = new UUID(0, 0);
            return lastTransactionUUID;
        }
        long lsb = lastTransactionUUID.getLeastSignificantBits() + 1;
        lastTransactionUUID = new UUID(lastTransactionUUID.getLeastSignificantBits(), lsb);
        return lastTransactionUUID;
    }
    private UUID lastUUID;
    private UUID lastTransactionUUID;
    private static UserIdsGenerator instance;
}
