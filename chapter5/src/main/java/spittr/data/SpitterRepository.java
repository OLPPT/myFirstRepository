package spittr.data;

import spittr.Spitter;

/**
 * Created by OL-PC on 2018/04/02.
 */
public interface SpitterRepository {
    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}
