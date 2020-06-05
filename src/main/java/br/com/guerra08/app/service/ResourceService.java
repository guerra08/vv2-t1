package br.com.guerra08.app.service;

import br.com.guerra08.app.model.Resource;
import br.com.guerra08.app.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService implements IResourceService{

    @Autowired
    private ResourceRepository repository;

    @Override
    public List<Resource> findAll() {
        return (List<Resource>) repository.findAll();
    }

}
