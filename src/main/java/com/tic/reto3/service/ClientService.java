package com.tic.reto3.service;


import com.tic.reto3.entities.Client;
import com.tic.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getProduct(int id){
        return clientRepository.getClient(id);
    }
    public Client save(Client p){
        if (p.getIdClient()==null){
            return clientRepository.save(p);
        }else {
            Optional<Client> e = clientRepository.getClient(p.getIdClient());
            if (e.isPresent()){
                return p;
            }else {
                return clientRepository.save(p);
            }
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Client>p= clientRepository.getClient(id);
        if (p.isPresent()){
            clientRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }
}
