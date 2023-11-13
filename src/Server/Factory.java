package Server;

public interface Factory <T extends Data> {
    T create();
}