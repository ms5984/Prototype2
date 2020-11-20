package com.github.ms5984.economy.prototype2.api;

import org.jetbrains.annotations.NotNull;

public final class Prototype2Provider {
    private static Prototype2 instance = null;

    private Prototype2Provider() {
// No instantiation!
    }

    /**
     * Gets an instance of the {@link Prototype2} service,
     * throwing {@link IllegalStateException} if an instance is not yet loaded.
     *
     * <p>Will never return null.</p>
     *
     * @return an api instance
     * @throws IllegalStateException if the api is not loaded
     */
    public static @NotNull Prototype2 getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Prototype2 is not loaded.");
        }
        return instance;
    }

    static void register(Prototype2 instance) {
        Prototype2Provider.instance = instance;
    }
    static void unregister() {
        Prototype2Provider.instance = null;
    }
}
