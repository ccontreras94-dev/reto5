package com.mintic.reto4.repository;

import com.mintic.reto4.model.Reservation;
import com.mintic.reto4.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation r){
        return reservationCrudRepository.save(r);
    }

    public void delete(Reservation r){
        reservationCrudRepository.delete(r);
    }

    public Optional<Reservation> getById(int id){
        return reservationCrudRepository.findById(id);
    }

    public List<Reservation> getDatesReport(Date inicio,Date fin){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(inicio,fin);
    }
    public List<Reservation> getStatusReport(String sts){
        return reservationCrudRepository.findAllByStatus(sts);
    }

    public List<Object[]> getTopClients(){
        return reservationCrudRepository.getTopClients();
    }

}
