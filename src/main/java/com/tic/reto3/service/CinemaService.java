package com.tic.reto3.service;


import com.tic.reto3.entities.Cinema;
import com.tic.reto3.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public List<Cinema> getAll(){
        return cinemaRepository.getAll();
    }
    public Optional<Cinema> getCinema(int id){
        return cinemaRepository.getCinema(id);
    }
    public Cinema save(Cinema p){
        if (p.getId()==null){
            return cinemaRepository.save(p);
        } else {
            Optional<Cinema> e = cinemaRepository.getCinema(p.getId());
            if (e.isPresent()){
                return p;
            }else {
                return cinemaRepository.save(p);
            }
        }
    }
    public Cinema update(Cinema p){
        if (p.getId()!=null){
            Optional<Cinema> q = cinemaRepository.getCinema(p.getId());
            if (q.isPresent()){
                if (p.getName()!=null){
                    q.get().setName(p.getName());
                }
                if (p.getOwner()!=null){
                    q.get().setOwner(p.getOwner());
                }
                if (p.getDescription()!=null){
                    q.get().setDescription(p.getDescription());
                }
                if (p.getCategory()!=null){
                    q.get().setCategory(p.getCategory());
                }

                cinemaRepository.save(q.get());
                return q.get();
            }else {
                return p;
            }
        }else {
            return p;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Cinema>p= cinemaRepository.getCinema(id);
        if (p.isPresent()){
            cinemaRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }
}

