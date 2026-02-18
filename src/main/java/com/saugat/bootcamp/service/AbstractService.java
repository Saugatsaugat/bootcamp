//package com.saugat.bootcamp.service;
//
//import java.util.List;
//
//public abstract class AbstractService<T, ID> implements IService<T, ID> {
//
//    public abstract Object getRepository();
//
//    @Override
//    public T get(ID id) {
//        return getRepository().get(id);
//    }
//
//
//    @Override
//    public List<T> get() {
//        return repository.getAll();
//    }
//
//    @Override
//    public T create(T obj) {
//        return repository.create(obj);
//    }
//
//    @Override
//    public T edit(ID id, T obj) {
//        return repository.edit(id, obj);
//    }
//
//
//    @Override
//    public void delete(ID id) {
//        repository.delete(id);
//    }
//
//
//}
