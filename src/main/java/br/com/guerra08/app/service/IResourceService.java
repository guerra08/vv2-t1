package br.com.guerra08.app.service;

import br.com.guerra08.app.model.Resource;

import java.util.List;

public interface IResourceService {

    List<Resource> findAll();
    List<Resource> findAllByType(int type);

}
