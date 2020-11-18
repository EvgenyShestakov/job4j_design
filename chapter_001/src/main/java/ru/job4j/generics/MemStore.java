package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean flag = false;
        for (int index = 0; index < mem.size(); index++) {
            T t = mem.get(index);
            if (t.getId().equals(id)) {
                mem.set(index, model);
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Override
    public boolean delete(String id) {
        boolean flag = false;
        for (int index = 0; index < mem.size(); index++) {
            T t = mem.get(index);
            if (t.getId().equals(id)) {
                mem.remove(index);
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Override
    public T findById(String id) {
        T rsl = null;
        for (int index = 0; index < mem.size(); index++) {
            T t = mem.get(index);
            if (t.getId().equals(id)) {
                rsl = t;
                break;
            }
        }
        return rsl;

    }
}
