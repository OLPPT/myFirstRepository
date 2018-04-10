package spittr.data;

import spittr.Spittle;

import java.util.List;

/**
 * Created by OL-PC on 2018/03/26.
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long id);
}
